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

package com.sun.xml.internal.ws.policy.jaxws;

import com.sun.xml.internal.ws.api.policy.ModelTranslator;
import com.sun.xml.internal.ws.policy.Policy;
import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.PolicyMapExtender;
import com.sun.xml.internal.ws.policy.PolicySubject;
import com.sun.xml.internal.ws.resources.PolicyMessages;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import com.sun.xml.internal.ws.policy.sourcemodel.PolicySourceModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Jakub Podlesak (jakub.podlesak at sun.com)
 */
abstract class BuilderHandler{

    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(BuilderHandler.class);

    Map<String,PolicySourceModel> policyStore;
    Collection<String> policyURIs;
    Object policySubject;

    /**
     * Creates a new instance of BuilderHandler
     */
    BuilderHandler(Collection<String> policyURIs, Map<String,PolicySourceModel> policyStore, Object policySubject) {
        this.policyStore = policyStore;
        this.policyURIs = policyURIs;
        this.policySubject = policySubject;
    }

    final void populate(final PolicyMapExtender policyMapExtender) throws PolicyException {
        if (null == policyMapExtender) {
            throw LOGGER.logSevereException(new PolicyException(PolicyMessages.WSP_1006_POLICY_MAP_EXTENDER_CAN_NOT_BE_NULL()));
        }

        doPopulate(policyMapExtender);
    }

    protected abstract void doPopulate(final PolicyMapExtender policyMapExtender) throws PolicyException;

    final Collection<Policy> getPolicies() throws PolicyException {
        if (null == policyURIs) {
            throw LOGGER.logSevereException(new PolicyException(PolicyMessages.WSP_1004_POLICY_URIS_CAN_NOT_BE_NULL()));
        }
        if (null == policyStore) {
            throw LOGGER.logSevereException(new PolicyException(PolicyMessages.WSP_1010_NO_POLICIES_DEFINED()));
        }

        final Collection<Policy> result = new ArrayList<Policy>(policyURIs.size());

        for (String policyURI : policyURIs) {
            final PolicySourceModel sourceModel = policyStore.get(policyURI);
            if (sourceModel == null) {
                throw LOGGER.logSevereException(new PolicyException(PolicyMessages.WSP_1005_POLICY_REFERENCE_DOES_NOT_EXIST(policyURI)));
            } else {
                result.add(ModelTranslator.getTranslator().translate(sourceModel));
            }
        }

        return result;
    }

    final Collection<PolicySubject> getPolicySubjects() throws PolicyException {
        final Collection<Policy> policies = getPolicies();
        final Collection<PolicySubject> result =  new ArrayList<PolicySubject>(policies.size());
        for (Policy policy : policies) {
            result.add(new PolicySubject(policySubject, policy));
        }
        return result;
    }
}
