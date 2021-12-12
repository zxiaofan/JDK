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
 * A class representing elliptic curve public keys as defined in
 * <a href="https://tools.ietf.org/html/rfc8032">RFC 8032: Edwards-Curve
 * Digital Signature Algorithm (EdDSA)</a>, including the curve and other
 * algorithm parameters. The public key is a point on the curve, which is
 * represented using an {@code EdECPoint}.
 *
 * @since 15
 */
public final class EdECPublicKeySpec implements KeySpec {

    private final NamedParameterSpec params;
    private final EdECPoint point;

    /**
     * Construct a public key spec using the supplied parameters and
     * point.
     *
     * @param params the algorithm parameters.
     * @param point the point representing the public key.
     *
     * @throws NullPointerException if {@code params} or {@code point}
     *                              is null.
     */
    public EdECPublicKeySpec(NamedParameterSpec params, EdECPoint point) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(point, "point must not be null");

        this.params = params;
        this.point = point;
    }

    /**
     * Get the algorithm parameters that define the curve and other settings.
     *
     * @return the parameters.
     */
    public NamedParameterSpec getParams() {
        return params;
    }

    /**
     * Get the point representing the public key.
     *
     * @return the {@code EdECPoint} representing the public key.
     */
    public EdECPoint getPoint() {
        return point;
    }
}
