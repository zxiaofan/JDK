/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
 * A class representing elliptic curve private keys as defined in
 * <a href="https://tools.ietf.org/html/rfc8032">RFC 8032: Edwards-Curve
 * Digital Signature Algorithm (EdDSA)</a>, including the curve and other
 * algorithm parameters. The private key is a bit string represented using
 * a byte array. This class only supports bit string lengths that are a
 * multiple of 8.
 *
 * @since 15
 */
public final class EdECPrivateKeySpec implements KeySpec {

    private final NamedParameterSpec params;
    private final byte[] bytes;

    /**
     * Construct a private key spec using the supplied parameters and
     * bit string.
     *
     * @param params the algorithm parameters.
     * @param bytes the key as a byte array. This array is copied
     *              to protect against subsequent modification.
     *
     * @throws NullPointerException if {@code params} or {@code bytes}
     *                              is null.
     */
    public EdECPrivateKeySpec(NamedParameterSpec params, byte[] bytes) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(bytes, "bytes must not be null");

        this.params = params;
        this.bytes = bytes.clone();
    }

    /**
     * Get the algorithm parameters that define the curve and other settings.
     *
     * @return the algorithm parameters.
     */
    public NamedParameterSpec getParams() {
        return params;
    }

    /**
     * Get the byte array representing the private key. A new copy of the array
     * is returned each time this method is called.
     *
     * @return the private key as a byte array.
     */
    public byte[] getBytes() {
        return bytes.clone();
    }
}
