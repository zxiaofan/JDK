/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Date;
import java.util.Set;

import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509CRLSelector;

import sun.security.x509.GeneralNameInterface;

/**
 * Helper class that allows access to JDK specific known-public methods in the
 * java.security.cert package. It relies on a subclass in the
 * java.security.cert packages that is initialized before any of these methods
 * are called (achieved via static initializers).
 *
 * The methods are made available in this fashion for performance reasons.
 *
 * @author Andreas Sterbenz
 */
public abstract class CertPathHelper {

    /**
     * Object used to tunnel the calls. Initialized by CertPathHelperImpl.
     */
    protected static CertPathHelper instance;

    protected CertPathHelper() {
        // empty
    }

    protected abstract void implSetPathToNames(X509CertSelector sel,
            Set<GeneralNameInterface> names);

    protected abstract void implSetDateAndTime(X509CRLSelector sel, Date date, long skew);

    protected abstract boolean implIsJdkCA(TrustAnchor anchor);

    static void setPathToNames(X509CertSelector sel,
            Set<GeneralNameInterface> names) {
        instance.implSetPathToNames(sel, names);
    }

    public static void setDateAndTime(X509CRLSelector sel, Date date, long skew) {
        instance.implSetDateAndTime(sel, date, skew);
    }

    public static boolean isJdkCA(TrustAnchor anchor) {
        return (anchor == null) ? false : instance.implIsJdkCA(anchor);
    }
}
