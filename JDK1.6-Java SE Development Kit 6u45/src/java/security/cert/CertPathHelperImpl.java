/*
 * %W% %E%
 *
 * Copyright (c) 2006, 2009, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security.cert;

import java.util.*;

import javax.security.auth.x500.X500Principal;

import sun.security.provider.certpath.CertPathHelper;

import sun.security.x509.GeneralNameInterface;

/**
 * Helper class that allows the Sun CertPath provider to access
 * implementation dependent APIs in CertPath framework.
 *
 * @author Andreas Sterbenz
 * @version %I%, %G%
 */
class CertPathHelperImpl extends CertPathHelper {
    
    private CertPathHelperImpl() {
	// empty
    }
    
    /**
     * Initialize the helper framework. This method must be called from 
     * the static initializer of each class that is the target of one of 
     * the methods in this class. This ensures that the helper if initialized
     * prior to a tunneled call from the Sun provider.
     */
    synchronized static void initialize() {
	if (CertPathHelper.instance == null) {
	    CertPathHelper.instance = new CertPathHelperImpl();
	}
    }
    
    protected void implSetSubject(X509CertSelector sel, X500Principal subject) {
	sel.setSubject(subject);
    }

    protected X500Principal implGetSubject(X509CertSelector sel) {
	return sel.getSubject();
    }
    
    protected void implSetIssuer(X509CertSelector sel, X500Principal issuer) {
	sel.setIssuer(issuer);
    }

    protected X500Principal implGetIssuer(X509CertSelector sel) {
	return sel.getIssuer();
    }
    
    protected X500Principal implGetCA(TrustAnchor anchor) {
	return anchor.getCA();
    }
    
    protected void implSetPathToNames(X509CertSelector sel, 
	    Set<GeneralNameInterface> names) {
	sel.setPathToNamesInternal(names);
    }

    protected void implAddIssuer(X509CRLSelector sel, X500Principal name) {
	sel.addIssuer(name);
    }

    protected Collection<X500Principal> implGetIssuers(X509CRLSelector sel) {
	return sel.getIssuers();
    }

    protected void implSetDateAndTime(X509CRLSelector sel, Date date, long skew) {
        sel.setDateAndTime(date, skew);
    }
}

