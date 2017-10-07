/*
 * Copyright (c) 2002, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.validator;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Enumeration;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import java.security.cert.Certificate;

/**
 * Collection of static utility methods related to trust anchor KeyStores.
 *
 * @author Andreas Sterbenz
 */
public final class TrustStoreUtil {

    private TrustStoreUtil() {
        // empty
    }

    /**
     * Return an unmodifiable Set with all trusted X509Certificates contained
     * in the specified KeyStore.
     */
    public static Set<X509Certificate> getTrustedCerts(KeyStore ks) {
        Set<X509Certificate> set = new HashSet<>();
        try {
            for (Enumeration<String> e = ks.aliases(); e.hasMoreElements(); ) {
                String alias = e.nextElement();
                if (ks.isCertificateEntry(alias)) {
                    Certificate cert = ks.getCertificate(alias);
                    if (cert instanceof X509Certificate) {
                        set.add((X509Certificate)cert);
                    }
                } else if (ks.isKeyEntry(alias)) {
                    Certificate[] certs = ks.getCertificateChain(alias);
                    if ((certs != null) && (certs.length > 0) &&
                            (certs[0] instanceof X509Certificate)) {
                        set.add((X509Certificate)certs[0]);
                    }
                }
            }
        } catch (KeyStoreException e) {
            // ignore
            //
            // This should be rare, but better to log this in the future.
        }

        return Collections.unmodifiableSet(set);
    }
}
