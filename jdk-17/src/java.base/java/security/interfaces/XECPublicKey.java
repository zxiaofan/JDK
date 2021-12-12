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
package java.security.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/**
 * An interface for an elliptic curve public key as defined by RFC 7748.
 * These keys are distinct from the keys represented by {@code ECPublicKey},
 * and they are intended for use with algorithms based on RFC 7748 such as the
 * XDH {@code KeyAgreement} algorithm.
 *
 * An XEC public key is a particular point on the curve, which is represented
 * using only its u-coordinate as described in RFC 7748. A u-coordinate is an
 * element of the field of integers modulo some value that is determined by
 * the algorithm parameters. This field element is represented by a BigInteger
 * which may hold any value. That is, the BigInteger is not restricted to the
 * range of canonical field elements.
 *
 * @since 11
 */
public interface XECPublicKey extends XECKey, PublicKey {

    /**
     * Get the u coordinate of the point.
     *
     * @return the u-coordinate, represented using a BigInteger which may hold
     *          any value
     */
    BigInteger getU();

}

