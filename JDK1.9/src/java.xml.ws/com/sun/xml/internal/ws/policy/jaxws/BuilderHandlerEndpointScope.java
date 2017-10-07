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
final class BuilderHandlerEndpointScope extends BuilderHandler{
    private final QName service;
    private final QName port;

    /** Creates a new instance of WSDLServiceScopeBuilderHandler */
    BuilderHandlerEndpointScope(Collection<String> policyURIs, Map<String,PolicySourceModel> policyStore, Object policySubject, QName service, QName port) {

        super(policyURIs, policyStore, policySubject);
        this.service = service;
        this.port = port;
    }

    protected void doPopulate(final PolicyMapExtender policyMapExtender) throws PolicyException {
        final PolicyMapKey mapKey = PolicyMap.createWsdlEndpointScopeKey(service, port);
        for (PolicySubject subject : getPolicySubjects()) {
            policyMapExtender.putEndpointSubject(mapKey, subject);
        }
    }

    @Override
    public String toString() {
        return (new StringBuffer(service.toString())).append(":").append(port.toString()).toString();
    }
}
