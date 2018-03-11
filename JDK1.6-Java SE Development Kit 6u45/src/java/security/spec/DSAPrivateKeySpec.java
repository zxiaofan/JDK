/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security.spec;

import java.math.BigInteger;

/**
 * This class specifies a DSA private key with its associated parameters.
 *
 * @author Jan Luehe
 *
 * @version %I%, %G%
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see KeySpec
 * @see DSAPublicKeySpec
 * @see PKCS8EncodedKeySpec
 *
 * @since 1.2
 */

public class DSAPrivateKeySpec implements KeySpec {

    private BigInteger x;
    private BigInteger p;
    private BigInteger q;
    private BigInteger g;

    /**
     * Creates a new DSAPrivateKeySpec with the specified parameter values.
     * 
     * @param x the private key.
     * 
     * @param p the prime.
     * 
     * @param q the sub-prime.
     * 
     * @param g the base.
     */
    public DSAPrivateKeySpec(BigInteger x, BigInteger p, BigInteger q,
			     BigInteger g) {
	this.x = x;
	this.p = p;
	this.q = q;
	this.g = g;
    }

    /**
     * Returns the private key <code>x</code>.
     *
     * @return the private key <code>x</code>.
     */
    public BigInteger getX() {
	return this.x;
    }

    /**
     * Returns the prime <code>p</code>.
     *
     * @return the prime <code>p</code>.
     */
    public BigInteger getP() {
	return this.p;
    }

    /**
     * Returns the sub-prime <code>q</code>.
     *
     * @return the sub-prime <code>q</code>.
     */
    public BigInteger getQ() {
	return this.q;
    }

    /**
     * Returns the base <code>g</code>.
     *
     * @return the base <code>g</code>.
     */
    public BigInteger getG() {
	return this.g;
    }
}
