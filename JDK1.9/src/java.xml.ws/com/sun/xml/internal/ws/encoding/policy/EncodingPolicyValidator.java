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

import com.sun.xml.internal.ws.policy. PolicyAssertion;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;
import java.util.ArrayList;
import javax.xml.namespace.QName;

import static com.sun.xml.internal.ws.encoding.policy.EncodingConstants.*;

/**
 *
 * @author Jakub Podlesak (jakub.podlesak at sun.com)
 */
public class EncodingPolicyValidator implements PolicyAssertionValidator {

    private static final ArrayList<QName> serverSideSupportedAssertions = new ArrayList<QName>(3);
    private static final ArrayList<QName> clientSideSupportedAssertions = new ArrayList<QName>(4);

    static {
        serverSideSupportedAssertions.add(OPTIMIZED_MIME_SERIALIZATION_ASSERTION);
        serverSideSupportedAssertions.add(UTF816FFFE_CHARACTER_ENCODING_ASSERTION);
        serverSideSupportedAssertions.add(OPTIMIZED_FI_SERIALIZATION_ASSERTION);

        clientSideSupportedAssertions.add(SELECT_OPTIMAL_ENCODING_ASSERTION);
        clientSideSupportedAssertions.addAll(serverSideSupportedAssertions);
    }

    /**
     * Creates a new instance of EncodingPolicyValidator
     */
    public EncodingPolicyValidator() {
    }

    public Fitness validateClientSide(PolicyAssertion assertion) {
        return clientSideSupportedAssertions.contains(assertion.getName()) ? Fitness.SUPPORTED : Fitness.UNKNOWN;
    }

    public Fitness validateServerSide(PolicyAssertion assertion) {
        QName assertionName = assertion.getName();
        if (serverSideSupportedAssertions.contains(assertionName)) {
            return Fitness.SUPPORTED;
        } else if (clientSideSupportedAssertions.contains(assertionName)) {
            return Fitness.UNSUPPORTED;
        } else {
            return Fitness.UNKNOWN;
        }
    }

    public String[] declareSupportedDomains() {
        return new String[] {OPTIMIZED_MIME_NS, ENCODING_NS, SUN_ENCODING_CLIENT_NS, SUN_FI_SERVICE_NS};
    }
}
