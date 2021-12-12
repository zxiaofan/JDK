/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.mscapi;

/**
 * The handle for an RSA public/private keypair using the Microsoft Crypto API.
 *
 * @since 1.6
 */
class CKeyPair {

    private final CPrivateKey privateKey;

    private final CPublicKey publicKey;

    /**
     * This method is called by native codes in security.cpp.
     */
    CKeyPair(String alg, long hCryptProv, long hCryptKey, int keyLength) {
        CKey.NativeHandles handles = new CKey.NativeHandles(hCryptProv, hCryptKey);
        privateKey = CPrivateKey.of(alg, handles, keyLength);
        publicKey = CPublicKey.of(alg, handles, keyLength);
    }

    public CPrivateKey getPrivate() {
        return privateKey;
    }

    public CPublicKey getPublic() {
        return publicKey;
    }
}
