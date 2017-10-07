/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.encoding.policy;

import static com.sun.xml.internal.ws.encoding.policy.EncodingConstants.OPTIMIZED_MIME_SERIALIZATION_ASSERTION;
import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.policy.AssertionSet;
import com.sun.xml.internal.ws.policy.Policy;
import com.sun.xml.internal.ws.policy.PolicyAssertion;
import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.PolicyMap;
import com.sun.xml.internal.ws.policy.PolicySubject;
import com.sun.xml.internal.ws.policy.jaxws.spi.PolicyMapConfigurator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import com.sun.xml.internal.ws.policy.subject.WsdlBindingSubject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import javax.xml.namespace.QName;
import javax.xml.ws.soap.MTOMFeature;

/**
 * Generate an MTOM policy if MTOM was enabled.
 *
 * @author Jakub Podlesak (japod at sun.com)
 * @author Fabian Ritzmann
 */
public class MtomPolicyMapConfigurator implements PolicyMapConfigurator {

    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(MtomPolicyMapConfigurator.class);

    static class MtomAssertion extends PolicyAssertion {

        private static final AssertionData mtomData;
        static {
            mtomData= AssertionData.createAssertionData(OPTIMIZED_MIME_SERIALIZATION_ASSERTION);
            //JAX-WS MTOMFeature does n't currently capture if MTOM is required/optional.
            //JAX-WS accepts both normal messages and XOP encoded messages. Using wsp:Optional=true represents that behavior.
            //Moreover, this allows interoperability with non-MTOM aware clients.
            //See https://wsit.dev.java.net/issues/show_bug.cgi?id=1062
            mtomData.setOptionalAttribute(true);
        }

        MtomAssertion() {
            super(mtomData, null, null);

        }
    }

    /**
     * Generates an MTOM policy if MTOM is enabled.
     *
     * <ol>
     * <li>If MTOM is enabled
     * <ol>
     * <li>If MTOM policy does not already exist, generate
     * <li>Otherwise do nothing
     * </ol>
     * <li>Otherwise, do nothing (that implies that we do not remove any MTOM policies if MTOM is disabled)
     * </ol>
     *
     */
    public Collection<PolicySubject> update(PolicyMap policyMap, SEIModel model, WSBinding wsBinding) throws PolicyException {
        LOGGER.entering(policyMap, model, wsBinding);

        Collection<PolicySubject> subjects = new ArrayList<PolicySubject>();
        if (policyMap != null) {
            final MTOMFeature mtomFeature = wsBinding.getFeature(MTOMFeature.class);
            if (LOGGER.isLoggable(Level.FINEST)) {
                LOGGER.finest("mtomFeature = " + mtomFeature);
            }
            if ((mtomFeature != null) && mtomFeature.isEnabled()) {
                final QName bindingName = model.getBoundPortTypeName();
                final WsdlBindingSubject wsdlSubject = WsdlBindingSubject.createBindingSubject(bindingName);
                final Policy mtomPolicy = createMtomPolicy(bindingName);
                final PolicySubject mtomPolicySubject = new PolicySubject(wsdlSubject, mtomPolicy);
                subjects.add(mtomPolicySubject);
                if (LOGGER.isLoggable(Level.FINEST)) {
                    LOGGER.fine("Added MTOM policy with ID \"" + mtomPolicy.getIdOrName() + "\" to binding element \"" + bindingName + "\"");
                }
            }
        } // endif policy map not null

        LOGGER.exiting(subjects);
        return subjects;
    }


    /**
     * Create a policy with an MTOM assertion.
     *
     * @param model The binding element name. Used to generate a (locally) unique ID for the policy.
     * @return The policy.
     */
    private Policy createMtomPolicy(final QName bindingName) {
        ArrayList<AssertionSet> assertionSets = new ArrayList<AssertionSet>(1);
        ArrayList<PolicyAssertion> assertions = new ArrayList<PolicyAssertion>(1);
        assertions.add(new MtomAssertion());
        assertionSets.add(AssertionSet.createAssertionSet(assertions));
        return Policy.createPolicy(null, bindingName.getLocalPart() + "_MTOM_Policy", assertionSets);
    }

}
