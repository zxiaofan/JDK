/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.security.util;

import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import java.util.*;

import jdk.internal.util.StaticProperty;
import sun.security.x509.X509CertImpl;

/**
 * A utility class to check if a certificate is untrusted. This is an internal
 * mechanism that explicitly marks a certificate as untrusted, normally in the
 * case that a certificate is known to be used for malicious reasons.
 *
 * <b>Attention</b>: This check is NOT meant to replace the standard PKI-defined
 * validation check, neither is it used as an alternative to CRL.
 */
public final class UntrustedCertificates {

    private static final Debug debug = Debug.getInstance("certpath");
    private static final String ALGORITHM_KEY = "Algorithm";

    private static final Properties props = new Properties();
    private static final String algorithm;

    static {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                File f = new File(StaticProperty.javaHome(),
                        "lib/security/blacklisted.certs");
                try (FileInputStream fin = new FileInputStream(f)) {
                    props.load(fin);
                    // It's said that the fingerprint could contain colons
                    for (Map.Entry<Object,Object> e: props.entrySet()) {
                        e.setValue(stripColons(e.getValue()));
                    }
                } catch (IOException fnfe) {
                    if (debug != null) {
                        debug.println("Error parsing blacklisted.certs");
                    }
                }
                return null;
            }
        });
        algorithm = props.getProperty(ALGORITHM_KEY);
    }

    private static String stripColons(Object input) {
        String s = (String)input;
        char[] letters = s.toCharArray();
        int pos = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != ':') {
                if (i != pos) {
                    letters[pos] = letters[i];
                }
                pos++;
            }
        }
        if (pos == letters.length) return s;
        else return new String(letters, 0, pos);
    }
    /**
     * Checks if a certificate is untrusted.
     *
     * @param cert the certificate to check
     * @return true if the certificate is untrusted.
     */
    public static boolean isUntrusted(X509Certificate cert) {
        if (algorithm == null) {
            return false;
        }
        String key;
        if (cert instanceof X509CertImpl) {
            key = ((X509CertImpl)cert).getFingerprint(algorithm);
        } else {
            try {
                key = new X509CertImpl(cert.getEncoded()).getFingerprint(algorithm);
            } catch (CertificateException cee) {
                return false;
            }
        }
        return props.containsKey(key);
    }

    private UntrustedCertificates() {}
}
