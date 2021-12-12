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

import java.security.PrivateKey;
import java.util.Optional;

/**
 * An interface for an elliptic curve private key as defined by
 * <a href="https://tools.ietf.org/html/rfc8032">RFC 8032: Edwards-Curve
 * Digital Signature Algorithm (EdDSA)</a>. These keys are distinct from the
 * keys represented by {@code ECPrivateKey}, and they are intended for use
 * with algorithms based on RFC 8032 such as the EdDSA {@code Signature}
 * algorithm.
 * <p>
 * An Edwards-Curve private key is a bit string. This interface only supports bit
 * string lengths that are a multiple of 8, and the key is represented using
 * a byte array.
 *
 * @since 15
 */
public interface EdECPrivateKey extends EdECKey, PrivateKey {

    /**
     * Get a copy of the byte array representing the private key. This method
     * may return an empty {@code Optional} if the implementation is not
     * willing to produce the private key value.
     *
     * @return an {@code Optional} containing the private key byte array.
     * If the key is not available, then an empty {@code Optional}.
     */
    Optional<byte[]> getBytes();
}
