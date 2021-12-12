/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package java.security.spec;

import java.util.Objects;

/**
 * A class representing elliptic curve private keys as defined in RFC 7748,
 * including the curve and other algorithm parameters. The private key is
 * represented as an encoded scalar value. The decoding procedure defined in
 * the RFC includes an operation that forces certain bits of the key to either
 * 1 or 0. This operation is known as "pruning" or "clamping" the private key.
 * All arrays in this spec are unpruned, and implementations will need to prune
 * the array before using it in any numerical operations.
 *
 * @since 11
 */
public class XECPrivateKeySpec implements KeySpec {

    private final AlgorithmParameterSpec params;
    private final byte[] scalar;

    /**
     * Construct a private key spec using the supplied parameters and
     * encoded scalar value.
     *
     * @param params the algorithm parameters
     * @param scalar the unpruned encoded scalar value. This array is copied
     *               to protect against subsequent modification.
     *
     * @throws NullPointerException if {@code params} or {@code scalar}
     *                              is null.
     */
    public XECPrivateKeySpec(AlgorithmParameterSpec params, byte[] scalar) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(scalar, "scalar must not be null");

        this.params = params;
        this.scalar = scalar.clone();
    }

    /**
     * Get the algorithm parameters that define the curve and other settings.
     *
     * @return the algorithm parameters
     */
    public AlgorithmParameterSpec getParams() {
        return params;
    }

    /**
     * Get the scalar value encoded as an unpruned byte array. A new copy of
     * the array is returned each time this method is called.
     *
     * @return the unpruned encoded scalar value
     */
    public byte[] getScalar() {
        return scalar.clone();
    }
}
