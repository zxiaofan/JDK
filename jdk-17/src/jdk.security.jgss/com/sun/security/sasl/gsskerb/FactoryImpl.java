/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.sasl.gsskerb;

import javax.security.sasl.*;
import com.sun.security.sasl.util.PolicyUtils;

import java.util.Map;
import javax.security.auth.callback.CallbackHandler;

/**
 * Client/server factory for GSSAPI (Kerberos V5) SASL client/server mechs.
 * See GssKrb5Client/GssKrb5Server for input requirements.
 *
 * @author Rosanna Lee
 */
public final class FactoryImpl implements SaslClientFactory, SaslServerFactory {
    private static final String[] myMechs = {
        "GSSAPI"};

    private static final int[] mechPolicies = {
        PolicyUtils.NOPLAINTEXT|PolicyUtils.NOANONYMOUS|PolicyUtils.NOACTIVE
    };

    private static final int GSS_KERB_V5 = 0;

    public FactoryImpl() {
    }

    public SaslClient createSaslClient(String[] mechs,
        String authorizationId,
        String protocol,
        String serverName,
        Map<String,?> props,
        CallbackHandler cbh) throws SaslException {

            for (int i = 0; i < mechs.length; i++) {
                if (mechs[i].equals(myMechs[GSS_KERB_V5])
                    && PolicyUtils.checkPolicy(mechPolicies[GSS_KERB_V5], props)) {
                    return new GssKrb5Client(
                        authorizationId,
                        protocol,
                        serverName,
                        props,
                        cbh);
                }
            }
            return null;
    };

    public SaslServer createSaslServer(String mech,
        String protocol,
        String serverName,
        Map<String,?> props,
        CallbackHandler cbh) throws SaslException {
            if (mech.equals(myMechs[GSS_KERB_V5])
                && PolicyUtils.checkPolicy(mechPolicies[GSS_KERB_V5], props)) {
                if (cbh == null) {
                    throw new SaslException(
                "Callback handler with support for AuthorizeCallback required");
                }
                return new GssKrb5Server(
                    protocol,
                    serverName,
                    props,
                    cbh);
            }
            return null;
    };

    public String[] getMechanismNames(Map<String,?> props) {
        return PolicyUtils.filterMechs(myMechs, mechPolicies, props);
    }
}
