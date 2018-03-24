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

package com.sun.xml.internal.ws.config.management.policy;

import com.sun.xml.internal.ws.api.config.management.policy.ManagedClientAssertion;
import com.sun.xml.internal.ws.api.config.management.policy.ManagedServiceAssertion;
import com.sun.xml.internal.ws.policy.PolicyAssertion;
import com.sun.xml.internal.ws.policy.PolicyConstants;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;

import javax.xml.namespace.QName;

/**
 * Validate the ManagedService and ManagedClient policy assertions.
 *
 * @author Fabian Ritzmann
 */
public class ManagementPolicyValidator implements PolicyAssertionValidator {

    public Fitness validateClientSide(PolicyAssertion assertion) {
        final QName assertionName = assertion.getName();
        if (ManagedClientAssertion.MANAGED_CLIENT_QNAME.equals(assertionName)) {
            return Fitness.SUPPORTED;
        }
        else if (ManagedServiceAssertion.MANAGED_SERVICE_QNAME.equals(assertionName)) {
            return Fitness.UNSUPPORTED;
        }
        else {
            return Fitness.UNKNOWN;
        }
    }

    public Fitness validateServerSide(PolicyAssertion assertion) {
        final QName assertionName = assertion.getName();
        if (ManagedServiceAssertion.MANAGED_SERVICE_QNAME.equals(assertionName)) {
            return Fitness.SUPPORTED;
        }
        else if (ManagedClientAssertion.MANAGED_CLIENT_QNAME.equals(assertionName)) {
            return Fitness.UNSUPPORTED;
        }
        else {
            return Fitness.UNKNOWN;
        }
    }

    public String[] declareSupportedDomains() {
        return new String[] { PolicyConstants.SUN_MANAGEMENT_NAMESPACE };
    }

}
