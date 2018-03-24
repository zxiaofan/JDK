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

import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.PolicyMap;
import com.sun.xml.internal.ws.policy.PolicyMapExtender;
import com.sun.xml.internal.ws.policy.PolicyMapKey;
import com.sun.xml.internal.ws.policy.PolicySubject;
import com.sun.xml.internal.ws.policy.sourcemodel.PolicySourceModel;

import java.util.Collection;
import java.util.Map;
import javax.xml.namespace.QName;

/**
 *
 * @author Jakub Podlesak (jakub.podlesak at sun.com)
 */
final class BuilderHandlerServiceScope extends BuilderHandler{
    private final QName service;

    /**
     * Creates a new instance of BuilderHandlerServiceScope
     */
    BuilderHandlerServiceScope(
            Collection<String> policyURIs, Map<String,PolicySourceModel> policyStore, Object policySubject, QName service) {

        super(policyURIs, policyStore, policySubject);
        this.service = service;
    }

    protected void doPopulate(final PolicyMapExtender policyMapExtender) throws PolicyException{
        final PolicyMapKey mapKey = PolicyMap.createWsdlServiceScopeKey(service);
        for (PolicySubject subject : getPolicySubjects()) {
            policyMapExtender.putServiceSubject(mapKey, subject);
        }
    }

    @Override
    public String toString() {
        return service.toString();
    }
}
