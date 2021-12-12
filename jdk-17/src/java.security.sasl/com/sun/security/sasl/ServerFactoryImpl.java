/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.sasl;

import javax.security.sasl.*;
import com.sun.security.sasl.util.PolicyUtils;

import java.util.Map;
import javax.security.auth.callback.CallbackHandler;

/**
 * Server factory for CRAM-MD5.
 *
 * Requires the following callback to be satisfied by callback handler
 * when using CRAM-MD5.
 * - AuthorizeCallback (to get canonicalized authzid)
 *
 * @author Rosanna Lee
 */
public final class ServerFactoryImpl implements SaslServerFactory {
    private static final String[] myMechs = {
        "CRAM-MD5", //
    };

    private static final int[] mechPolicies = {
        PolicyUtils.NOPLAINTEXT|PolicyUtils.NOANONYMOUS,      // CRAM-MD5
    };

    private static final int CRAMMD5 = 0;

    public ServerFactoryImpl() {
    }

    public SaslServer createSaslServer(String mech,
        String protocol,
        String serverName,
        Map<String,?> props,
        CallbackHandler cbh) throws SaslException {

        if (mech.equals(myMechs[CRAMMD5])
            && PolicyUtils.checkPolicy(mechPolicies[CRAMMD5], props)) {

            if (cbh == null) {
                throw new SaslException(
            "Callback handler with support for AuthorizeCallback required");
            }
            return new CramMD5Server(protocol, serverName, props, cbh);
        }
        return null;
    };

    public String[] getMechanismNames(Map<String,?> props) {
        return PolicyUtils.filterMechs(myMechs, mechPolicies, props);
    }
}
