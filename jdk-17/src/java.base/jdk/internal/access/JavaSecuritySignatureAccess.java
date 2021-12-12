/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

public interface JavaSecuritySignatureAccess {

    void initVerify(Signature s, PublicKey publicKey, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    void initVerify(Signature s, java.security.cert.Certificate certificate,
             AlgorithmParameterSpec params)
             throws InvalidKeyException, InvalidAlgorithmParameterException;

    void initSign(Signature s, PrivateKey privateKey,
             AlgorithmParameterSpec params, SecureRandom random)
             throws InvalidKeyException, InvalidAlgorithmParameterException;
}
