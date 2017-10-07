/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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
class RSAKeyPair {

    private final RSAPrivateKey privateKey;

    private final RSAPublicKey publicKey;

    /**
     * Construct an RSAKeyPair object.
     */
    RSAKeyPair(long hCryptProv, long hCryptKey, int keyLength)
    {
        Key.NativeHandles handles = new Key.NativeHandles(hCryptProv, hCryptKey);
        privateKey = new RSAPrivateKey(handles, keyLength);
        publicKey = new RSAPublicKey(handles, keyLength);
    }

    public RSAPrivateKey getPrivate() {
        return privateKey;
    }

    public RSAPublicKey getPublic() {
        return publicKey;
    }
}
