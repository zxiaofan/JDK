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

package sun.security.rsa;

import java.util.*;

import java.security.*;

import static sun.security.util.SecurityConstants.PROVIDER_VER;

/**
 * Provider class for the RSA signature provider. Supports RSA keyfactory,
 * keypair generation, and RSA signatures.
 *
 * @since   1.5
 * @author  Andreas Sterbenz
 */
public final class SunRsaSign extends Provider {

    @java.io.Serial
    private static final long serialVersionUID = 866040293550393045L;

    @SuppressWarnings("removal")
    public SunRsaSign() {
        super("SunRsaSign", PROVIDER_VER, "Sun RSA signature provider");

        Provider p = this;
        Iterator<Provider.Service> serviceIter = new SunRsaSignEntries(p).iterator();

        if (System.getSecurityManager() == null) {
            putEntries(serviceIter);
        } else {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                @Override
                public Void run() {
                    putEntries(serviceIter);
                    return null;
                }
            });
        }
    }
    void putEntries(Iterator<Provider.Service> i) {
        while (i.hasNext()) {
            putService(i.next());
        }
    }
}
