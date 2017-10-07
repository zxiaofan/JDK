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
 * The class serves as a policy map mutator that allows for replacement of current effective policies
 * stored in the policy map with new effective policy provided by the mutator user.
 *
 * @author Marek Potociar (marek.potociar@sun.com)
 */
public final class EffectivePolicyModifier extends PolicyMapMutator {
    public static EffectivePolicyModifier createEffectivePolicyModifier() {
        return new EffectivePolicyModifier();
    }

    /**
     * Ensures that direct instantiation is not possible from outside of the class
     */
    private EffectivePolicyModifier() {
        // no initialization required
    }

    /**
     * Replaces current effective policy on the service scope (identified by a {@code key} parameter) with the new efective
     * policy provided as a second input parameter. If no policy was defined for the presented key, the new policy is simply
     * stored with the key.
     *
     * @param key identifier of the scope the effective policy should be replaced with the new one. Must not be {@code null}.
     * @param newEffectivePolicy the new policy to replace the old effective policy of the scope. Must not be {@code null}.
     *
     * @throws IllegalArgumentException in case any of the input parameters is {@code null}
     */
    public void setNewEffectivePolicyForServiceScope(
            final PolicyMapKey key, final Policy newEffectivePolicy) {
        getMap().setNewEffectivePolicyForScope(PolicyMap.ScopeType.SERVICE, key, newEffectivePolicy);
    }

    /**
     * Replaces current effective policy on the endpoint scope (identified by a {@code key} parameter) with the new efective
     * policy provided as a second input parameter.
     *
     * @param key identifier of the scope the effective policy should be replaced with the new one. Must not be {@code null}.
     * @param newEffectivePolicy the new policy to replace the old effective policy of the scope. Must not be {@code null}.
     *
     * @throws IllegalArgumentException in case any of the input parameters is {@code null}
     */
    public void setNewEffectivePolicyForEndpointScope(
            final PolicyMapKey key, final Policy newEffectivePolicy) {
        getMap().setNewEffectivePolicyForScope(PolicyMap.ScopeType.ENDPOINT, key, newEffectivePolicy);
    }

    /**
     * Replaces current effective policy on the operation scope (identified by a {@code key} parameter) with the new efective
     * policy provided as a second input parameter. If no policy was defined for the presented key, the new policy is simply
     * stored with the key.
     *
     * @param key identifier of the scope the effective policy should be replaced with the new one. Must not be {@code null}.
     * @param newEffectivePolicy the new policy to replace the old effective policy of the scope. Must not be {@code null}.
     *
     * @throws IllegalArgumentException in case any of the input parameters is {@code null}
     */
    public void setNewEffectivePolicyForOperationScope(
            final PolicyMapKey key, final Policy newEffectivePolicy) {
        getMap().setNewEffectivePolicyForScope(PolicyMap.ScopeType.OPERATION, key, newEffectivePolicy);
    }

    /**
     * Replaces current effective policy on the input message scope (identified by a {@code key} parameter) with the new efective
     * policy provided as a second input parameter. If no policy was defined for the presented key, the new policy is simply
     * stored with the key.
     *
     * @param key identifier of the scope the effective policy should be replaced with the new one. Must not be {@code null}.
     * @param newEffectivePolicy the new policy to replace the old effective policy of the scope. Must not be {@code null}.
     *
     * @throws IllegalArgumentException in case any of the input parameters is {@code null}
     */
    public void setNewEffectivePolicyForInputMessageScope(
            final PolicyMapKey key, final Policy newEffectivePolicy) {
        getMap().setNewEffectivePolicyForScope(PolicyMap.ScopeType.INPUT_MESSAGE, key, newEffectivePolicy);
    }

    /**
     * Replaces current effective policy on the output message scope (identified by a {@code key} parameter) with the new efective
     * policy provided as a second input parameter. If no policy was defined for the presented key, the new policy is simply
     * stored with the key.
     *
     * @param key identifier of the scope the effective policy should be replaced with the new one. Must not be {@code null}.
     * @param newEffectivePolicy the new policy to replace the old effective policy of the scope. Must not be {@code null}.
     *
     * @throws IllegalArgumentException in case any of the input parameters is {@code null}
     */
    public void setNewEffectivePolicyForOutputMessageScope(
            final PolicyMapKey key, final Policy newEffectivePolicy) {
        getMap().setNewEffectivePolicyForScope(PolicyMap.ScopeType.OUTPUT_MESSAGE, key, newEffectivePolicy);
    }

    /**
     * Replaces current effective policy on the fault message scope (identified by a {@code key} parameter) with the new efective
     * policy provided as a second input parameter. If no policy was defined for the presented key, the new policy is simply
     * stored with the key.
     *
     * @param key identifier of the scope the effective policy should be replaced with the new one. Must not be {@code null}.
     * @param newEffectivePolicy the new policy to replace the old effective policy of the scope. Must not be {@code null}.
     *
     * @throws IllegalArgumentException in case any of the input parameters is {@code null}
     */
    public void setNewEffectivePolicyForFaultMessageScope(
            final PolicyMapKey key, final Policy newEffectivePolicy) {
        getMap().setNewEffectivePolicyForScope(PolicyMap.ScopeType.FAULT_MESSAGE, key, newEffectivePolicy);
    }
}
