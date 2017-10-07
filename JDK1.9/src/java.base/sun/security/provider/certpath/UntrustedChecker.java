/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.provider.certpath;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.cert.CertPathValidatorException;
import java.security.cert.PKIXCertPathChecker;
import java.util.Set;
import java.util.Collection;
import sun.security.util.Debug;
import sun.security.util.UntrustedCertificates;

/**
 * A <code>PKIXCertPathChecker</code> implementation to check whether a
 * specified certificate is distrusted.
 *
 * @see PKIXCertPathChecker
 * @see PKIXParameters
 */
public final class UntrustedChecker extends PKIXCertPathChecker {

    private static final Debug debug = Debug.getInstance("certpath");

    /**
     * Default Constructor
     */
    public UntrustedChecker() {
        // blank
    }

    @Override
    public void init(boolean forward) throws CertPathValidatorException {
        // Note that this class supports both forward and reverse modes.
    }

    @Override
    public boolean isForwardCheckingSupported() {
        // Note that this class supports both forward and reverse modes.
        return true;
    }

    @Override
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override
    public void check(Certificate cert,
            Collection<String> unresolvedCritExts)
            throws CertPathValidatorException {

        X509Certificate currCert = (X509Certificate)cert;

        if (UntrustedCertificates.isUntrusted(currCert)) {
            if (debug != null) {
                debug.println("UntrustedChecker: untrusted certificate " +
                        currCert.getSubjectX500Principal());
            }

            throw new CertPathValidatorException(
                "Untrusted certificate: " + currCert.getSubjectX500Principal());
        }
    }
}

