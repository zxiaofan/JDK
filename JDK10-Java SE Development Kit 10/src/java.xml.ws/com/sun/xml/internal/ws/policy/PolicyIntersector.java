/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.xml.internal.ws.policy;

import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;
import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.NamespaceVersion;
import java.util.ArrayList;

/**
 * The instance of this class is intended to provide policy intersection mechanism.
 *
 * @author Marek Potociar (marek.potociar@sun.com)
 */
public final class PolicyIntersector {
    static enum CompatibilityMode {
        STRICT,
        LAX
    }

    private static final PolicyIntersector STRICT_INTERSECTOR = new PolicyIntersector(CompatibilityMode.STRICT);
    private static final PolicyIntersector LAX_INTERSECTOR = new PolicyIntersector(CompatibilityMode.LAX);
    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(PolicyIntersector.class);

    private CompatibilityMode mode;

    /**
     * Prevents direct instantiation of this class from outside
     * @param intersectionMode intersection mode
     */
    private PolicyIntersector(CompatibilityMode intersectionMode) {
        this.mode = intersectionMode;
    }

    /**
     * Returns a strict policy intersector that can be used to intersect group of policies.
     *
     * @return policy intersector instance.
     */
    public static PolicyIntersector createStrictPolicyIntersector() {
        return PolicyIntersector.STRICT_INTERSECTOR;
    }

    /**
     * Returns a strict policy intersector that can be used to intersect group of policies.
     *
     * @return policy intersector instance.
     */
    public static PolicyIntersector createLaxPolicyIntersector() {
        return PolicyIntersector.LAX_INTERSECTOR;
    }

    /**
     * Performs intersection on the input collection of policies and returns the resulting (intersected) policy. If input policy
     * collection contains only a single policy instance, no intersection is performed and the instance is directly returned
     * as a method call result.
     *
     * @param policies collection of policies to be intersected. Must not be {@code null} nor empty, otherwise exception is thrown.
     * @return intersected policy as a result of perfromed policy intersection. A {@code null} value is never returned.
     *
     * @throws IllegalArgumentException in case {@code policies} argument is either {@code null} or empty collection.
     */
    public Policy intersect(final Policy... policies) {
        if (policies == null || policies.length == 0) {
            throw LOGGER.logSevereException(new IllegalArgumentException(LocalizationMessages.WSP_0056_NEITHER_NULL_NOR_EMPTY_POLICY_COLLECTION_EXPECTED()));
        } else if (policies.length == 1) {
            return policies[0];
        }

        // check for "null" and "empty" policy: if such policy is found return "null" policy,
        // or if all policies are "empty", return "empty" policy
        boolean found = false;
        boolean allPoliciesEmpty = true;
        NamespaceVersion latestVersion = null;
        for (Policy tested : policies) {
            if (tested.isEmpty()) {
                found = true;
            } else {
                if (tested.isNull()) {
                    found = true;
                }
                allPoliciesEmpty = false;
            }
            if (latestVersion == null) {
                latestVersion = tested.getNamespaceVersion();
            } else if (latestVersion.compareTo(tested.getNamespaceVersion()) < 0) {
                latestVersion = tested.getNamespaceVersion();
            }

            if (found && !allPoliciesEmpty) {
                return Policy.createNullPolicy(latestVersion, null, null);
            }
        }
        latestVersion = (latestVersion != null) ? latestVersion : NamespaceVersion.getLatestVersion();
        if (allPoliciesEmpty) {
            return Policy.createEmptyPolicy(latestVersion, null, null);
        }

        // simple tests didn't lead to final answer => let's performe some intersecting ;)
        final List<AssertionSet> finalAlternatives = new LinkedList<AssertionSet>(policies[0].getContent());
        final Queue<AssertionSet> testedAlternatives = new LinkedList<AssertionSet>();
        final List<AssertionSet> alternativesToMerge = new ArrayList<AssertionSet>(2);
        for (int i = 1; i < policies.length; i++) {
            final Collection<AssertionSet> currentAlternatives = policies[i].getContent();

            testedAlternatives.clear();
            testedAlternatives.addAll(finalAlternatives);
            finalAlternatives.clear();

            AssertionSet testedAlternative;
            while ((testedAlternative = testedAlternatives.poll()) != null) {
                for (AssertionSet currentAlternative : currentAlternatives) {
                    if (testedAlternative.isCompatibleWith(currentAlternative, this.mode)) {
                        alternativesToMerge.add(testedAlternative);
                        alternativesToMerge.add(currentAlternative);
                        finalAlternatives.add(AssertionSet.createMergedAssertionSet(alternativesToMerge));
                        alternativesToMerge.clear();
                    }
                }
            }
        }

        return Policy.createPolicy(latestVersion, null, null, finalAlternatives);
    }
}
