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

package com.sun.xml.internal.ws.policy.subject;

import com.sun.xml.internal.ws.policy.PolicyMap;
import com.sun.xml.internal.ws.policy.PolicyMapKey;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import com.sun.xml.internal.ws.policy.subject.WsdlBindingSubject.WsdlMessageType;
import javax.xml.namespace.QName;

/**
 * Computes a PolicyMapKey instance for a given WsdlBindingSubject.
 *
 * @author Fabian Ritzmann
 */
public class PolicyMapKeyConverter {

    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(PolicyMapKeyConverter.class);

    private final QName serviceName;
    private final QName portName;

    public PolicyMapKeyConverter(QName serviceName, QName portName) {
        this.serviceName = serviceName;
        this.portName = portName;
    }

    public PolicyMapKey getPolicyMapKey(final WsdlBindingSubject subject) {
        LOGGER.entering(subject);

        PolicyMapKey key = null;
        if (subject.isBindingSubject()) {
            key = PolicyMap.createWsdlEndpointScopeKey(this.serviceName, this.portName);
        }
        else if (subject.isBindingOperationSubject()) {
            key = PolicyMap.createWsdlOperationScopeKey(this.serviceName, this.portName, subject.getName());
        }
        else if (subject.isBindingMessageSubject()) {
            if (subject.getMessageType() == WsdlMessageType.FAULT) {
                key = PolicyMap.createWsdlFaultMessageScopeKey(this.serviceName, this.portName,
                        subject.getParent().getName(), subject.getName());
            }
            else {
                key = PolicyMap.createWsdlMessageScopeKey(this.serviceName, this.portName, subject.getParent().getName());
            }
        }

        LOGGER.exiting(key);
        return key;
    }

}
