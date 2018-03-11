/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.security.spec;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * This immutable class defines an elliptic curve (EC) prime 
 * finite field.
 *
 * @see ECField
 *
 * @author Valerie Peng
 * @version %I%, %G%
 *
 * @since 1.5
 */
public class ECFieldFp implements ECField {

    private BigInteger p;

    /**
     * Creates an elliptic curve prime finite field 
     * with the specified prime <code>p</code>.
     * @param p the prime.
     * @exception NullPointerException if <code>p</code> is null.
     * @exception IllegalArgumentException if <code>p</code>
     * is not positive.
     */ 
    public ECFieldFp(BigInteger p) {
	if (p.signum() != 1) {
	    throw new IllegalArgumentException("p is not positive");
	}
	this.p = p;
    }

    /**
     * Returns the field size in bits which is size of prime p
     * for this prime finite field.
     * @return the field size in bits.
     */
    public int getFieldSize() {
	return p.bitLength();
    };

    /**
     * Returns the prime <code>p</code> of this prime finite field.
     * @return the prime.
     */     
    public BigInteger getP() {
	return p;
    }
	
    /**
     * Compares this prime finite field for equality with the
     * specified object. 
     * @param obj the object to be compared.
     * @return true if <code>obj</code> is an instance
     * of ECFieldFp and the prime value match, false otherwise.
     */
    public boolean equals(Object obj) {
	if (this == obj)  return true;
	if (obj instanceof ECFieldFp) {
	    return (p.equals(((ECFieldFp)obj).p));
	} 
	return false;
    }
	 
    /**
     * Returns a hash code value for this prime finite field.
     * @return a hash code value.
     */
    public int hashCode() {
	return p.hashCode();
    }
}
