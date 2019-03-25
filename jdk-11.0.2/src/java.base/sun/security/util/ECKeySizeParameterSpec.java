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

import java.security.spec.AlgorithmParameterSpec;

import sun.security.util.ObjectIdentifier;

/**
 * This immutable class is used when randomly generating a key pair and the
 * consumer only specifies the length of the key and therefore a curve for that
 * key size must be picked from a the list of supported curves using this spec.
 *
 * @see AlgorithmParameterSpec
 * @see ECGenParameterSpec
 */
public class ECKeySizeParameterSpec implements AlgorithmParameterSpec {

    private int keySize;

    /**
     * Creates a parameter specification for EC curve
     * generation using a standard (or predefined) key size
     * <code>keySize</code> in order to generate the corresponding
     * (precomputed) elliptic curve.
     * <p>
     * Note, if the curve of the specified length is not supported,
     * <code>AlgorithmParameters.init</code> will throw an exception.
     *
     * @param keySize the key size of the curve to lookup
     */
    public ECKeySizeParameterSpec(int keySize) {
        this.keySize = keySize;
    }

    /**
     * Returns the key size of this spec.
     *
     * @return the standard or predefined key size.
     */
    public int getKeySize() {
        return keySize;
    }
}
