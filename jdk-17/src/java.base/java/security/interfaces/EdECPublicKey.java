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
package java.security.interfaces;

import java.security.PublicKey;
import java.security.spec.EdECPoint;

/**
 * An interface for an elliptic curve public key as defined by
 * <a href="https://tools.ietf.org/html/rfc8032">RFC 8032: Edwards-Curve
 * Digital Signature Algorithm (EdDSA)</a>. These keys are distinct from the
 * keys represented by {@code ECPublicKey}, and they are intended for use with
 * algorithms based on RFC 8032 such as the EdDSA {@code Signature} algorithm.
 * <p>
 * An Edwards-Curve public key is a point on the curve, which is represented using an
 * EdECPoint.
 *
 * @since 15
 */
public interface EdECPublicKey extends EdECKey, PublicKey {

    /**
     * Get the point representing the public key.
     *
     * @return the {@code EdECPoint} representing the public key.
     */
    EdECPoint getPoint();
}
