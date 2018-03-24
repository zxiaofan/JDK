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
import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Contains static methods for policy alternative selection. Given policy map is changed so that
 * each effective policy contains at most one policy alternative. Uses domain
 * specific @see com.sun.xml.internal.ws.policy.spi.PolicySelector
 * to find out whether particular policy assertion is actually supported.
 *
 * If you are using JAX-WS, use the com.sun.xml.internal.ws.api.policy.AlternativeSelector
 * instead of this class.
 *
 * @author Jakub Podlesak (jakub.podlesak at sun.com)
 * @author Fabian Ritzmann
 */
public class EffectiveAlternativeSelector {
    private enum AlternativeFitness {
        UNEVALUATED {
            AlternativeFitness combine(final Fitness assertionFitness) {
                switch (assertionFitness) {
                    case UNKNOWN:
                        return UNKNOWN;
                    case UNSUPPORTED:
                        return UNSUPPORTED;
                    case SUPPORTED:
                        return SUPPORTED;
                    case INVALID:
                        return INVALID;
                    default:
                        return UNEVALUATED;
                }
            }
        },
        INVALID {
            AlternativeFitness combine(final Fitness assertionFitness) {
                return INVALID;
            }
        },
        UNKNOWN {
            AlternativeFitness combine(final Fitness assertionFitness) {
                switch (assertionFitness) {
                    case UNKNOWN:
                        return UNKNOWN;
                    case UNSUPPORTED:
                        return UNSUPPORTED;
                    case SUPPORTED:
                        return PARTIALLY_SUPPORTED;
                    case INVALID:
                        return INVALID;
                    default:
                        return UNEVALUATED;
                }
            }
        },
        UNSUPPORTED {
            AlternativeFitness combine(final Fitness assertionFitness) {
                switch (assertionFitness) {
                    case UNKNOWN:
                    case UNSUPPORTED:
                        return UNSUPPORTED;
                    case SUPPORTED:
                        return PARTIALLY_SUPPORTED;
                    case INVALID:
                        return INVALID;
                    default:
                        return UNEVALUATED;
                }
            }
        },
        PARTIALLY_SUPPORTED {
            AlternativeFitness combine(final Fitness assertionFitness) {
                switch (assertionFitness) {
                    case UNKNOWN:
                    case UNSUPPORTED:
                    case SUPPORTED:
                        return PARTIALLY_SUPPORTED;
                    case INVALID:
                        return INVALID;
                    default:
                        return UNEVALUATED;
                }
            }
        },
        SUPPORTED_EMPTY {
            AlternativeFitness combine(final Fitness assertionFitness) {
                // will not localize - this exception may not occur if there is no programatic error in this class
                throw new UnsupportedOperationException("Combine operation was called unexpectedly on 'SUPPORTED_EMPTY' alternative fitness enumeration state.");
            }
        },
        SUPPORTED {
            AlternativeFitness combine(final Fitness assertionFitness) {
                switch (assertionFitness) {
                    case UNKNOWN:
                    case UNSUPPORTED:
                        return PARTIALLY_SUPPORTED;
                    case SUPPORTED:
                        return SUPPORTED;
                    case INVALID:
                        return INVALID;
                    default:
                        return UNEVALUATED;
                }
            }
        };

        abstract AlternativeFitness combine(Fitness assertionFitness);
    }

    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(EffectiveAlternativeSelector.class);

    /**
     * Does the selection for policy map bound to given modifier.
     *
     * If you are using JAX-WS, use the com.sun.xml.internal.ws.api.policy.AlternativeSelector
     * instead of this class.
     *
     * @param modifier Holds the policy map
     * @throws PolicyException Most likely an internal error if a policy could not be read or set on the policy map
     * @see EffectivePolicyModifier which the map is bound to
     */
    public static void doSelection(final EffectivePolicyModifier modifier) throws PolicyException {
        final AssertionValidationProcessor validationProcessor = AssertionValidationProcessor.getInstance();
        selectAlternatives(modifier, validationProcessor);
    }

    /**
     * This method is intended to be called by extension classes that need to
     * override the behavior of {@link #doSelection}.
     *
     * @param modifier
     * @param validationProcessor
     * @throws PolicyException
     */
    protected static void selectAlternatives(final EffectivePolicyModifier modifier,
            final AssertionValidationProcessor validationProcessor)
            throws PolicyException {
        final PolicyMap map = modifier.getMap();
        for (PolicyMapKey mapKey : map.getAllServiceScopeKeys()) {
            final Policy oldPolicy = map.getServiceEffectivePolicy(mapKey);
            modifier.setNewEffectivePolicyForServiceScope(mapKey, selectBestAlternative(oldPolicy, validationProcessor));
        }
        for (PolicyMapKey mapKey : map.getAllEndpointScopeKeys()) {
            final Policy oldPolicy = map.getEndpointEffectivePolicy(mapKey);
            modifier.setNewEffectivePolicyForEndpointScope(mapKey, selectBestAlternative(oldPolicy, validationProcessor));
        }
        for (PolicyMapKey mapKey : map.getAllOperationScopeKeys()) {
            final Policy oldPolicy = map.getOperationEffectivePolicy(mapKey);
            modifier.setNewEffectivePolicyForOperationScope(mapKey, selectBestAlternative(oldPolicy, validationProcessor));
        }
        for (PolicyMapKey mapKey : map.getAllInputMessageScopeKeys()) {
            final Policy oldPolicy = map.getInputMessageEffectivePolicy(mapKey);
            modifier.setNewEffectivePolicyForInputMessageScope(mapKey, selectBestAlternative(oldPolicy, validationProcessor));
        }
        for (PolicyMapKey mapKey : map.getAllOutputMessageScopeKeys()) {
            final Policy oldPolicy = map.getOutputMessageEffectivePolicy(mapKey);
            modifier.setNewEffectivePolicyForOutputMessageScope(mapKey, selectBestAlternative(oldPolicy, validationProcessor));
        }
        for (PolicyMapKey mapKey : map.getAllFaultMessageScopeKeys()) {
            final Policy oldPolicy = map.getFaultMessageEffectivePolicy(mapKey);
            modifier.setNewEffectivePolicyForFaultMessageScope(mapKey, selectBestAlternative(oldPolicy, validationProcessor));
        }
    }

    private static Policy selectBestAlternative(final Policy policy, final AssertionValidationProcessor validationProcessor) throws PolicyException {
        AssertionSet bestAlternative = null;
        AlternativeFitness bestAlternativeFitness = AlternativeFitness.UNEVALUATED;
        for (AssertionSet alternative : policy) {
            AlternativeFitness alternativeFitness = (alternative.isEmpty()) ? AlternativeFitness.SUPPORTED_EMPTY : AlternativeFitness.UNEVALUATED;
            for ( PolicyAssertion assertion : alternative ) {

                final Fitness assertionFitness = validationProcessor.validateClientSide(assertion);
                switch(assertionFitness) {
                    case UNKNOWN:
                    case UNSUPPORTED:
                    case INVALID:
                        LOGGER.warning(LocalizationMessages.WSP_0075_PROBLEMATIC_ASSERTION_STATE(assertion.getName(), assertionFitness));
                        break;
                    default:
                        break;
                }

                alternativeFitness = alternativeFitness.combine(assertionFitness);
            }

            if (bestAlternativeFitness.compareTo(alternativeFitness) < 0) {
                // better alternative found
                bestAlternative = alternative;
                bestAlternativeFitness = alternativeFitness;
            }

            if (bestAlternativeFitness == AlternativeFitness.SUPPORTED) {
                // all assertions supported by at least one selector
                break;
            }
        }

        switch (bestAlternativeFitness) {
            case INVALID:
                throw LOGGER.logSevereException(new PolicyException(LocalizationMessages.WSP_0053_INVALID_CLIENT_SIDE_ALTERNATIVE()));
            case UNKNOWN:
            case UNSUPPORTED:
            case PARTIALLY_SUPPORTED:
                LOGGER.warning(LocalizationMessages.WSP_0019_SUBOPTIMAL_ALTERNATIVE_SELECTED(bestAlternativeFitness));
                break;
            default:
                break;
        }

        Collection<AssertionSet> alternativeSet = null;
        if (bestAlternative != null) {
            // return a policy containing just the picked alternative
            alternativeSet = new LinkedList<AssertionSet>();
            alternativeSet.add(bestAlternative);
        }
        return Policy.createPolicy(policy.getNamespaceVersion(), policy.getName(), policy.getId(), alternativeSet);
    }
}
