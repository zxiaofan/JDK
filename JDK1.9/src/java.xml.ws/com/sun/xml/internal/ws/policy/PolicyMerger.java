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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.NamespaceVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Merge policies and return the effective policy.
 *
 * WS-PolicyAttachment defines a merge algorithm for WSDL 1.1 policy attachments.
 */
public final class PolicyMerger {
    private static final PolicyMerger merger = new PolicyMerger();

    /**
     * This private constructor is to avoid direct class instantiation from outsied of the package
     */
    private PolicyMerger() {
        // nothing to instantiate
    }

    /**
     * Factory method for obtaining thread-safe policy merger instance.
     *
     * @return policy merger instance.
     */
    public static PolicyMerger getMerger() {
        return merger;
    }

    /**
     * Takes collection of policies and merges them into a single policy using algorithm described in
     * WS-PolicyAttachment specification. None of the original policies in the collection are modified in
     * any way.
     *
     * The newly created policy has an ID that is a concatentation of all merged policy IDs.
     *
     * @param policies collection of policies to be merged. The collection must not contain '{@code null}' elements!
     * @return merged policy containing combination of policy alternatives stored in all input policies.
     *         If provided collection of policies is {@code null} or empty, returns {@code null}. If provided
     *         collection of policies contains only single policy, the policy is returned.
     */
    public Policy merge(final Collection<Policy> policies) {
        if (policies == null || policies.isEmpty()) {
            return null;
        } else if (policies.size() == 1) {
            return policies.iterator().next();
        }

        final Collection<Collection<AssertionSet>> alternativeSets = new LinkedList<Collection<AssertionSet>>();
        final StringBuilder id = new StringBuilder();
        NamespaceVersion mergedVersion = policies.iterator().next().getNamespaceVersion();
        for (Policy policy : policies) {
            alternativeSets.add(policy.getContent());
            if (mergedVersion.compareTo(policy.getNamespaceVersion()) < 0) {
                mergedVersion = policy.getNamespaceVersion();
            }
            final String policyId = policy.getId();
            if (policyId != null) {
                if (id.length() > 0) {
                    id.append('-');
                }
                id.append(policyId);
            }
        }

        final Collection<Collection<AssertionSet>> combinedAlternatives = PolicyUtils.Collections.combine(null, alternativeSets, false);

        if (combinedAlternatives == null || combinedAlternatives.isEmpty()) {
            return Policy.createNullPolicy(mergedVersion, null, id.length() == 0 ? null : id.toString());
        } else {
            final Collection<AssertionSet> mergedSetList = new ArrayList<AssertionSet>(combinedAlternatives.size());
            for (Collection<AssertionSet> toBeMerged : combinedAlternatives) {
                mergedSetList.add(AssertionSet.createMergedAssertionSet(toBeMerged));
            }
            return Policy.createPolicy(mergedVersion, null, id.length() == 0 ? null : id.toString(), mergedSetList);
        }
    }
}
