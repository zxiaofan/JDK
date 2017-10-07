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
import com.sun.xml.internal.ws.policy.AssertionSet;
import com.sun.xml.internal.ws.policy.PolicyAssertion;
import com.sun.xml.internal.ws.policy.PolicyConstants;
import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionCreator;

import java.util.Collection;
import javax.xml.namespace.QName;

/**
 * Instantiates a PolicyAssertion of type ManagedServiceAssertion or ManagedClientAssertion.
 *
 * @author Fabian Ritzmann
 */
public class ManagementAssertionCreator implements PolicyAssertionCreator {

    public String[] getSupportedDomainNamespaceURIs() {
        return new String[] { PolicyConstants.SUN_MANAGEMENT_NAMESPACE };
    }

    public PolicyAssertion createAssertion(AssertionData data, Collection<PolicyAssertion> assertionParameters,
            AssertionSet nestedAlternative, PolicyAssertionCreator defaultCreator) throws AssertionCreationException {
        final QName name = data.getName();
        if (ManagedServiceAssertion.MANAGED_SERVICE_QNAME.equals(name)) {
            return new ManagedServiceAssertion(data, assertionParameters);
        }
        else if (ManagedClientAssertion.MANAGED_CLIENT_QNAME.equals(name)) {
            return new ManagedClientAssertion(data, assertionParameters);
        }
        else {
            return defaultCreator.createAssertion(data, assertionParameters, nestedAlternative, null);
        }
    }

}
