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

package sun.security.provider.certpath.ldap;

import java.util.HashMap;
import java.util.List;
import java.security.*;
import java.security.cert.CertStoreParameters;
import static sun.security.util.SecurityConstants.PROVIDER_VER;

/**
 * Provider class for the JdkLDAP provider.
 * Supports LDAP cert store.
 *
 * @since   9
 */
public final class JdkLDAP extends Provider {

    private static final long serialVersionUID = -2279741232933606418L;

    private static final class ProviderService extends Provider.Service {
        ProviderService(Provider p, String type, String algo, String cn,
            List<String> aliases, HashMap<String, String> attrs) {
            super(p, type, algo, cn, aliases, attrs);
        }

        @Override
        public Object newInstance(Object ctrParamObj)
            throws NoSuchAlgorithmException {
            String type = getType();
            String algo = getAlgorithm();
            if (type.equals("CertStore") && algo.equals("LDAP")) {
                if (ctrParamObj != null &&
                    !(ctrParamObj instanceof CertStoreParameters)) {
                    throw new InvalidParameterException
                    ("constructorParameter must be instanceof CertStoreParameters");
                }
                try {
                    return new LDAPCertStore((CertStoreParameters) ctrParamObj);
                } catch (Exception ex) {
                    throw new NoSuchAlgorithmException("Error constructing " +
                        type + " for " + algo + " using JdkLDAP", ex);
                }
            }
            throw new ProviderException("No impl for " + algo + " " + type);
        }
    }

    @SuppressWarnings("removal")
    public JdkLDAP() {
        super("JdkLDAP", PROVIDER_VER, "JdkLDAP Provider (implements LDAP CertStore)");

        final Provider p = this;
        PrivilegedAction<Void> pa = () -> {
            HashMap<String, String> attrs = new HashMap<>(2);
            attrs.put("LDAPSchema", "RFC2587");
            attrs.put("ImplementedIn", "Software");

            /*
             * CertStore
             * attrs: LDAPSchema, ImplementedIn
             */
            putService(new ProviderService(p, "CertStore",
                       "LDAP", "sun.security.provider.certpath.ldap.LDAPCertStore",
                       null, attrs));
            return null;
        };
        AccessController.doPrivileged(pa);
    }
}
