/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.pkcs11;

import java.math.BigInteger;

import java.security.*;
import java.security.spec.*;

import javax.crypto.interfaces.*;
import javax.crypto.spec.*;

import static sun.security.pkcs11.TemplateManager.*;
import sun.security.pkcs11.wrapper.*;
import static sun.security.pkcs11.wrapper.PKCS11Constants.*;

/**
 * DH KeyFactory implementation.
 *
 * @author  Andreas Sterbenz
 * @since   1.5
 */
final class P11DHKeyFactory extends P11KeyFactory {

    P11DHKeyFactory(Token token, String algorithm) {
        super(token, algorithm);
    }

    PublicKey implTranslatePublicKey(PublicKey key) throws InvalidKeyException {
        try {
            if (key instanceof DHPublicKey) {
                DHPublicKey dhKey = (DHPublicKey)key;
                DHParameterSpec params = dhKey.getParams();
                return generatePublic(
                    dhKey.getY(),
                    params.getP(),
                    params.getG()
                );
            } else if ("X.509".equals(key.getFormat())) {
                // let SunJCE provider parse for us, then recurse
                try {
                    KeyFactory factory = implGetSoftwareFactory();
                    key = (PublicKey)factory.translateKey(key);
                    return implTranslatePublicKey(key);
                } catch (GeneralSecurityException e) {
                    throw new InvalidKeyException("Could not translate key", e);
                }
            } else {
                throw new InvalidKeyException("PublicKey must be instance "
                        + "of DHPublicKey or have X.509 encoding");
            }
        } catch (PKCS11Exception e) {
            throw new InvalidKeyException("Could not create DH public key", e);
        }
    }

    PrivateKey implTranslatePrivateKey(PrivateKey key)
            throws InvalidKeyException {
        try {
            if (key instanceof DHPrivateKey) {
                DHPrivateKey dhKey = (DHPrivateKey)key;
                DHParameterSpec params = dhKey.getParams();
                return generatePrivate(
                    dhKey.getX(),
                    params.getP(),
                    params.getG()
                );
            } else if ("PKCS#8".equals(key.getFormat())) {
                // let SunJCE provider parse for us, then recurse
                try {
                    KeyFactory factory = implGetSoftwareFactory();
                    key = (PrivateKey)factory.translateKey(key);
                    return implTranslatePrivateKey(key);
                } catch (GeneralSecurityException e) {
                    throw new InvalidKeyException("Could not translate key", e);
                }
            } else {
                throw new InvalidKeyException("PrivateKey must be instance "
                        + "of DHPrivateKey or have PKCS#8 encoding");
            }
        } catch (PKCS11Exception e) {
            throw new InvalidKeyException("Could not create DH private key", e);
        }
    }

    // see JCA spec
    protected PublicKey engineGeneratePublic(KeySpec keySpec)
            throws InvalidKeySpecException {
        token.ensureValid();
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                KeyFactory factory = implGetSoftwareFactory();
                PublicKey key = factory.generatePublic(keySpec);
                return implTranslatePublicKey(key);
            } catch (GeneralSecurityException e) {
                throw new InvalidKeySpecException
                        ("Could not create DH public key", e);
            }
        }
        if (keySpec instanceof DHPublicKeySpec == false) {
            throw new InvalidKeySpecException("Only DHPublicKeySpec and "
                + "X509EncodedKeySpec supported for DH public keys");
        }
        try {
            DHPublicKeySpec ds = (DHPublicKeySpec)keySpec;
            return generatePublic(
                ds.getY(),
                ds.getP(),
                ds.getG()
            );
        } catch (PKCS11Exception e) {
            throw new InvalidKeySpecException
                ("Could not create DH public key", e);
        }
    }

    // see JCA spec
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec)
            throws InvalidKeySpecException {
        token.ensureValid();
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                KeyFactory factory = implGetSoftwareFactory();
                PrivateKey key = factory.generatePrivate(keySpec);
                return implTranslatePrivateKey(key);
            } catch (GeneralSecurityException e) {
                throw new InvalidKeySpecException
                        ("Could not create DH private key", e);
            }
        }
        if (keySpec instanceof DHPrivateKeySpec == false) {
            throw new InvalidKeySpecException("Only DHPrivateKeySpec and "
                + "PKCS8EncodedKeySpec supported for DH private keys");
        }
        try {
            DHPrivateKeySpec ds = (DHPrivateKeySpec)keySpec;
            return generatePrivate(
                ds.getX(),
                ds.getP(),
                ds.getG()
            );
        } catch (PKCS11Exception e) {
            throw new InvalidKeySpecException
                ("Could not create DH private key", e);
        }
    }

    private PublicKey generatePublic(BigInteger y, BigInteger p, BigInteger g)
            throws PKCS11Exception {
        CK_ATTRIBUTE[] attributes = new CK_ATTRIBUTE[] {
            new CK_ATTRIBUTE(CKA_CLASS, CKO_PUBLIC_KEY),
            new CK_ATTRIBUTE(CKA_KEY_TYPE, CKK_DH),
            new CK_ATTRIBUTE(CKA_VALUE, y),
            new CK_ATTRIBUTE(CKA_PRIME, p),
            new CK_ATTRIBUTE(CKA_BASE, g),
        };
        attributes = token.getAttributes
                (O_IMPORT, CKO_PUBLIC_KEY, CKK_DH, attributes);
        Session session = null;
        try {
            session = token.getObjSession();
            long keyID = token.p11.C_CreateObject(session.id(), attributes);
            return P11Key.publicKey
                (session, keyID, "DH", p.bitLength(), attributes);
        } finally {
            token.releaseSession(session);
        }
    }

    private PrivateKey generatePrivate(BigInteger x, BigInteger p,
            BigInteger g) throws PKCS11Exception {
        CK_ATTRIBUTE[] attributes = new CK_ATTRIBUTE[] {
            new CK_ATTRIBUTE(CKA_CLASS, CKO_PRIVATE_KEY),
            new CK_ATTRIBUTE(CKA_KEY_TYPE, CKK_DH),
            new CK_ATTRIBUTE(CKA_VALUE, x),
            new CK_ATTRIBUTE(CKA_PRIME, p),
            new CK_ATTRIBUTE(CKA_BASE, g),
        };
        attributes = token.getAttributes
                (O_IMPORT, CKO_PRIVATE_KEY, CKK_DH, attributes);
        Session session = null;
        try {
            session = token.getObjSession();
            long keyID = token.p11.C_CreateObject(session.id(), attributes);
            return P11Key.privateKey
                (session, keyID, "DH", p.bitLength(), attributes);
        } finally {
            token.releaseSession(session);
        }
    }

    <T extends KeySpec> T implGetPublicKeySpec(P11Key key, Class<T> keySpec,
            Session[] session) throws PKCS11Exception, InvalidKeySpecException {
        if (keySpec.isAssignableFrom(DHPublicKeySpec.class)) {
            session[0] = token.getObjSession();
            CK_ATTRIBUTE[] attributes = new CK_ATTRIBUTE[] {
                new CK_ATTRIBUTE(CKA_VALUE),
                new CK_ATTRIBUTE(CKA_PRIME),
                new CK_ATTRIBUTE(CKA_BASE),
            };
            long keyID = key.getKeyID();
            try {
                token.p11.C_GetAttributeValue(session[0].id(), keyID, attributes);
            } finally {
                key.releaseKeyID();
            }
            KeySpec spec = new DHPublicKeySpec(
                attributes[0].getBigInteger(),
                attributes[1].getBigInteger(),
                attributes[2].getBigInteger()
            );
            return keySpec.cast(spec);
        } else { // X.509 handled in superclass
            throw new InvalidKeySpecException("Only DHPublicKeySpec and "
                + "X509EncodedKeySpec supported for DH public keys");
        }
    }

    <T extends KeySpec> T implGetPrivateKeySpec(P11Key key, Class<T> keySpec,
            Session[] session) throws PKCS11Exception, InvalidKeySpecException {
        if (keySpec.isAssignableFrom(DHPrivateKeySpec.class)) {
            session[0] = token.getObjSession();
            CK_ATTRIBUTE[] attributes = new CK_ATTRIBUTE[] {
                new CK_ATTRIBUTE(CKA_VALUE),
                new CK_ATTRIBUTE(CKA_PRIME),
                new CK_ATTRIBUTE(CKA_BASE),
            };
            long keyID = key.getKeyID();
            try {
                token.p11.C_GetAttributeValue(session[0].id(), keyID, attributes);
            } finally {
                key.releaseKeyID();
            }
            KeySpec spec = new DHPrivateKeySpec(
                attributes[0].getBigInteger(),
                attributes[1].getBigInteger(),
                attributes[2].getBigInteger()
            );
            return keySpec.cast(spec);
        } else { // PKCS#8 handled in superclass
            throw new InvalidKeySpecException("Only DHPrivateKeySpec "
                + "and PKCS8EncodedKeySpec supported for DH private keys");
        }
    }

    KeyFactory implGetSoftwareFactory() throws GeneralSecurityException {
        return KeyFactory.getInstance("DH", P11Util.getSunJceProvider());
    }

}
