/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.security.ProviderException;
import static sun.security.util.SecurityConstants.PROVIDER_VER;

/**
 * The SASL provider.
 * Provides client support for
 * - EXTERNAL
 * - PLAIN
 * - CRAM-MD5
 * - DIGEST-MD5
 * - NTLM
 * And server support for
 * - CRAM-MD5
 * - DIGEST-MD5
 * - NTLM
 */

public final class Provider extends java.security.Provider {

    private static final long serialVersionUID = 8622598936488630849L;

    private static final String info = "Sun SASL provider" +
        "(implements client mechanisms for: " +
        "DIGEST-MD5, EXTERNAL, PLAIN, CRAM-MD5, NTLM;" +
        " server mechanisms for: DIGEST-MD5, CRAM-MD5, NTLM)";

    private static final class ProviderService
        extends java.security.Provider.Service {
        ProviderService(java.security.Provider p, String type, String algo,
            String cn) {
            super(p, type, algo, cn, null, null);
        }

        @Override
        public Object newInstance(Object ctrParamObj)
            throws NoSuchAlgorithmException {
            String type = getType();
            if (ctrParamObj != null) {
                throw new InvalidParameterException
                    ("constructorParameter not used with " + type + " engines");
            }

            String algo = getAlgorithm();
            try {
                // DIGEST-MD5, NTLM uses same impl class for client and server
                if (algo.equals("DIGEST-MD5")) {
                    return new com.sun.security.sasl.digest.FactoryImpl();
                }
                if (algo.equals("NTLM")) {
                    return new com.sun.security.sasl.ntlm.FactoryImpl();
                }
                if (type.equals("SaslClientFactory")) {
                    if (algo.equals("EXTERNAL") || algo.equals("PLAIN") ||
                        algo.equals("CRAM-MD5")) {
                        return new com.sun.security.sasl.ClientFactoryImpl();
                    }
                } else if (type.equals("SaslServerFactory")) {
                    if (algo.equals("CRAM-MD5")) {
                        return new com.sun.security.sasl.ServerFactoryImpl();
                    }
                }
            } catch (Exception ex) {
                throw new NoSuchAlgorithmException("Error constructing " +
                    type + " for " + algo + " using SunSASL", ex);
            }
            throw new ProviderException("No impl for " + algo +
                " " + type);
        }
    }

    @SuppressWarnings("removal")
    public Provider() {
        super("SunSASL", PROVIDER_VER, info);

        final Provider p = this;
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                // Client mechanisms
                putService(new ProviderService(p, "SaslClientFactory",
                           "DIGEST-MD5", "com.sun.security.sasl.digest.FactoryImpl"));
                putService(new ProviderService(p, "SaslClientFactory",
                           "NTLM", "com.sun.security.sasl.ntlm.FactoryImpl"));
                putService(new ProviderService(p, "SaslClientFactory",
                           "EXTERNAL", "com.sun.security.sasl.ClientFactoryImpl"));
                putService(new ProviderService(p, "SaslClientFactory",
                           "PLAIN", "com.sun.security.sasl.ClientFactoryImpl"));
                putService(new ProviderService(p, "SaslClientFactory",
                           "CRAM-MD5", "com.sun.security.sasl.ClientFactoryImpl"));

                // Server mechanisms
                putService(new ProviderService(p, "SaslServerFactory",
                           "CRAM-MD5", "com.sun.security.sasl.ServerFactoryImpl"));
                putService(new ProviderService(p, "SaslServerFactory",
                           "DIGEST-MD5", "com.sun.security.sasl.digest.FactoryImpl"));
                putService(new ProviderService(p, "SaslServerFactory",
                           "NTLM", "com.sun.security.sasl.ntlm.FactoryImpl"));
                return null;
            }
        });
    }
}
