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

import java.math.BigInteger;
import java.util.Objects;

/**
 * A class representing elliptic curve public keys as defined in RFC 7748,
 * including the curve and other algorithm parameters. The public key is a
 * particular point on the curve, which is represented using only its
 * u-coordinate. A u-coordinate is an element of the field of integers modulo
 * some value that is determined by the algorithm parameters. This field
 * element is represented by a BigInteger which may hold any value. That is,
 * the BigInteger is not restricted to the range of canonical field elements.
 *
 * @since 11
 */
public class XECPublicKeySpec implements KeySpec {

    private final AlgorithmParameterSpec params;
    private final BigInteger u;

    /**
     * Construct a public key spec using the supplied parameters and
     * u coordinate.
     *
     * @param params the algorithm parameters
     * @param u the u-coordinate of the point, represented using a BigInteger
     *          which may hold any value
     *
     * @throws NullPointerException if {@code params} or {@code u}
     *                              is null.
     */
    public XECPublicKeySpec(AlgorithmParameterSpec params, BigInteger u) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(u, "u must not be null");

        this.params = params;
        this.u = u;
    }

    /**
     * Get the algorithm parameters that define the curve and other settings.
     *
     * @return the parameters
     */
    public AlgorithmParameterSpec getParams() {
        return params;
    }

    /**
     * Get the u coordinate of the point.
     *
     * @return the u-coordinate, represented using a BigInteger which may hold
     *          any value
     */
    public BigInteger getU() {
        return u;
    }
}
