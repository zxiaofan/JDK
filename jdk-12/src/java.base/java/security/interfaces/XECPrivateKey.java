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

import java.security.PrivateKey;
import java.util.Optional;

/**
 * An interface for an elliptic curve private key as defined by RFC 7748.
 * These keys are distinct from the keys represented by {@code ECPrivateKey},
 * and they are intended for use with algorithms based on RFC 7748 such as the
 * XDH {@code KeyAgreement} algorithm.
 *
 * An XEC private key is an encoded scalar value as described in RFC 7748.
 * The decoding procedure defined in this RFC includes an operation that forces
 * certain bits of the key to either 1 or 0. This operation is known as
 * "pruning" or "clamping" the private key. Arrays returned by this interface
 * are unpruned, and implementations will need to prune the array before
 * using it in any numerical operations.
 *
 * @since 11
 */
public interface XECPrivateKey extends XECKey, PrivateKey {

    /**
     * Get the scalar value encoded as an unpruned byte array. A new copy of
     * the array is returned each time this method is called.
     *
     * @return the unpruned encoded scalar value, or an empty Optional if the
     *     scalar cannot be extracted (e.g. if the provider is a hardware token
     *     and the private key is not allowed to leave the crypto boundary).
     */
    Optional<byte[]> getScalar();
}

