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

import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * A policy scope is a collection of equally ranked elements or subjects that
 * hold policies
 *
 * @author Fabian Ritzmann
 */
final class PolicyScope {
    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(PolicyScope.class);

    private final List<PolicySubject> subjects = new LinkedList<PolicySubject>();

    PolicyScope(final List<PolicySubject> initialSubjects) {
        if (initialSubjects != null && !initialSubjects.isEmpty()) {
            this.subjects.addAll(initialSubjects);
        }
    }

    void attach(final PolicySubject subject) {
        if (subject == null) {
            throw LOGGER.logSevereException(new IllegalArgumentException(LocalizationMessages.WSP_0020_SUBJECT_PARAM_MUST_NOT_BE_NULL()));
        }

        subjects.add(subject);
    }

    void dettachAllSubjects() {
        subjects.clear();
    }

    /**
     * Returns all policies of the scope merged into one policy
     *
     * @return effective policy of the scope
     */
    Policy getEffectivePolicy(final PolicyMerger merger) throws PolicyException {
        final LinkedList<Policy> policies = new LinkedList<Policy>();
        for (PolicySubject subject : subjects) {
            policies.add(subject.getEffectivePolicy(merger));
        }
        return merger.merge(policies);
    }

    /**
     * Returns all subjects contained by this scope
     *
     * @return The subjects contained by this scope
     */
    Collection<PolicySubject> getPolicySubjects() {
        return this.subjects;
    }


    /**
     * An {@code Object.toString()} method override.
     */
    @Override
    public String toString() {
        return toString(0, new StringBuffer()).toString();
    }

    /**
     * A helper method that appends indented string representation of this instance to the input string buffer.
     *
     * @param indentLevel indentation level to be used.
     * @param buffer buffer to be used for appending string representation of this instance
     * @return modified buffer containing new string representation of the instance
     */
    StringBuffer toString(final int indentLevel, final StringBuffer buffer) {
        final String indent = PolicyUtils.Text.createIndent(indentLevel);

        buffer.append(indent).append("policy scope {").append(PolicyUtils.Text.NEW_LINE);
        for (PolicySubject policySubject : subjects) {
            policySubject.toString(indentLevel + 1, buffer).append(PolicyUtils.Text.NEW_LINE);
        }
        buffer.append(indent).append('}');

        return buffer;
    }
}
