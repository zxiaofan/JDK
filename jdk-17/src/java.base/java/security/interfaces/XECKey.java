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

import java.security.spec.AlgorithmParameterSpec;

/**
 * An interface for an elliptic curve public/private key as defined by
 * RFC 7748. These keys are distinct from the keys represented by
 * {@code ECKey}, and they are intended for use with algorithms based on RFC
 * 7748 such as the XDH {@code KeyAgreement} algorithm. This interface allows
 * access to the algorithm parameters associated with the key.
 *
 * @since 11
 */
public interface XECKey {
    /**
     * Returns the algorithm parameters associated
     * with the key.
     *
     * @return the associated algorithm parameters
     */
    AlgorithmParameterSpec getParams();
}

