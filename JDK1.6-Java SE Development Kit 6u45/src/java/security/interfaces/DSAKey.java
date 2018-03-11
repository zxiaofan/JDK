/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
 
package java.security.interfaces;

/**
 * The interface to a DSA public or private key. DSA (Digital Signature
 * Algorithm) is defined in NIST's FIPS-186.
 *
 * @see DSAParams
 * @see java.security.Key
 * @see java.security.Signature
 * 
 * @version %I% %E%
 * @author Benjamin Renaud 
 * @author Josh Bloch 
 */
public interface DSAKey {

    /**
     * Returns the DSA-specific key parameters. These parameters are
     * never secret.
     *
     * @return the DSA-specific key parameters.
     * 
     * @see DSAParams
     */
    public DSAParams getParams();
}
