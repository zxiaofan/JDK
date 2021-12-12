/*
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.security.ProviderException;
import static sun.security.util.SecurityConstants.PROVIDER_VER;


/**
 * The JdkSASL provider class -
 * provides client and server support for GSSAPI/Kerberos v5
 */

public final class JdkSASL extends Provider {

    private static final long serialVersionUID = 8622590901641830849L;

    private static final String info = "JDK SASL provider" +
        "(implements client and server mechanisms for GSSAPI)";

    private static final class ProviderService extends Provider.Service {

        ProviderService(Provider p, String type, String algo, String cn) {
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
            // GSSAPI uses same impl class for client and server
            try {
                if (algo.equals("GSSAPI")) {
                    return new com.sun.security.sasl.gsskerb.FactoryImpl();
                }
            } catch (Exception ex) {
                throw new NoSuchAlgorithmException("Error constructing " +
                     type + " for " + algo + " using JdkSASL", ex);
            }
            throw new ProviderException("No impl for " + algo +
                " " + type);
        }
    }

    @SuppressWarnings("removal")
    public JdkSASL() {
        super("JdkSASL", PROVIDER_VER, info);

        final Provider p = this;
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                putService(new ProviderService(p, "SaslClientFactory",
                           "GSSAPI", "com.sun.security.sasl.gsskerb.FactoryImpl"));
                putService(new ProviderService(p, "SaslServerFactory",
                           "GSSAPI", "com.sun.security.sasl.gsskerb.FactoryImpl"));
                return null;
            }
        });
    }
}
