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

/**
 * The class provides methods to extend policy map content with new policies
 *
 * @author Marek Potociar (marek.potociar@sun.com)
 */
public final class PolicyMapExtender extends PolicyMapMutator {

    /**
     * This constructor is private to prevent direct instantiation from outside of the class
     */
    private PolicyMapExtender() {
        // nothing to initialize
    }

    public static PolicyMapExtender createPolicyMapExtender() {
        return new PolicyMapExtender();
    }

    public void putServiceSubject(final PolicyMapKey key, final PolicySubject subject) {
        getMap().putSubject(PolicyMap.ScopeType.SERVICE, key, subject);
    }

    public void putEndpointSubject(final PolicyMapKey key, final PolicySubject subject) {
        getMap().putSubject(PolicyMap.ScopeType.ENDPOINT, key, subject);
    }

    public void putOperationSubject(final PolicyMapKey key, final PolicySubject subject) {
        getMap().putSubject(PolicyMap.ScopeType.OPERATION, key, subject);
    }

    public void putInputMessageSubject(final PolicyMapKey key, final PolicySubject subject) {
        getMap().putSubject(PolicyMap.ScopeType.INPUT_MESSAGE, key, subject);
    }

    public void putOutputMessageSubject(final PolicyMapKey key, final PolicySubject subject) {
        getMap().putSubject(PolicyMap.ScopeType.OUTPUT_MESSAGE, key, subject);
    }

    public void putFaultMessageSubject(final PolicyMapKey key, final PolicySubject subject) {
        getMap().putSubject(PolicyMap.ScopeType.FAULT_MESSAGE, key, subject);
    }

}
