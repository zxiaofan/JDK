/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.ec.ed;

import java.security.KeyFactorySpi;
import java.security.Key;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.InvalidKeyException;
import java.security.ProviderException;
import java.security.interfaces.*;
import java.security.spec.*;
import java.util.Arrays;
import java.util.function.Function;

public class EdDSAKeyFactory extends KeyFactorySpi {

    private EdDSAParameters lockedParams = null;

    public EdDSAKeyFactory() {
        // do nothing
    }

    protected EdDSAKeyFactory(NamedParameterSpec paramSpec) {
        lockedParams = EdDSAParameters.get(ProviderException::new, paramSpec);
    }

    @Override
    protected Key engineTranslateKey(Key key) throws InvalidKeyException {

        if (key == null) {
            throw new InvalidKeyException("Key must not be null");
        }

        if (key instanceof EdECKey) {
            EdECKey edKey = (EdECKey) key;
            EdDSAParameters params = EdDSAParameters.get(
                InvalidKeyException::new, edKey.getParams());
            checkLockedParams(InvalidKeyException::new, params);

            if (edKey instanceof EdECPublicKey) {
                EdECPublicKey publicKey = (EdECPublicKey) edKey;
                return new EdDSAPublicKeyImpl(params, publicKey.getPoint());
            } else if (edKey instanceof EdECPrivateKey) {
                EdECPrivateKey privateKey = (EdECPrivateKey) edKey;
                byte[] privateKeyBytes = privateKey.getBytes().orElseThrow(
                    () -> new InvalidKeyException("No private key data"));
                return new EdDSAPrivateKeyImpl(params, privateKeyBytes);
            } else {
                throw new InvalidKeyException("Unsupported EdECKey subclass");
            }
        } else if (key instanceof PublicKey &&
                   key.getFormat().equals("X.509")) {
            EdDSAPublicKeyImpl result =
                new EdDSAPublicKeyImpl(key.getEncoded());
            checkLockedParams(InvalidKeyException::new, result.getParams());
            return result;
        } else if (key instanceof PrivateKey &&
                   key.getFormat().equals("PKCS#8")) {
            byte[] encoded = key.getEncoded();
            try {
                EdDSAPrivateKeyImpl result =
                        new EdDSAPrivateKeyImpl(encoded);
                checkLockedParams(InvalidKeyException::new, result.getParams());
                return result;
            } finally {
                Arrays.fill(encoded, (byte)0);
            }
        } else {
            throw new InvalidKeyException("Unsupported key type or format");
        }
    }

    private
    <T extends Throwable>
    void checkLockedParams(Function<String, T> exception,
                           NamedParameterSpec spec) throws T {

        EdDSAParameters params = EdDSAParameters.get(exception, spec);
        checkLockedParams(exception, params);
    }

    private
    <T extends Throwable>
    void checkLockedParams(Function<String, T> exception,
                           EdDSAParameters params) throws T {

        if (lockedParams != null && lockedParams != params) {
            throw exception.apply("Parameters must be " +
                lockedParams.getName());
        }
    }

    @Override
    protected PublicKey engineGeneratePublic(KeySpec keySpec)
        throws InvalidKeySpecException {

        try {
             return generatePublicImpl(keySpec);
        } catch (InvalidKeyException ex) {
            throw new InvalidKeySpecException(ex);
        }
    }

    @Override
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec)
        throws InvalidKeySpecException {

        try {
            return generatePrivateImpl(keySpec);
        } catch (InvalidKeyException ex) {
            throw new InvalidKeySpecException(ex);
        }
    }


    private PublicKey generatePublicImpl(KeySpec keySpec)
        throws InvalidKeyException, InvalidKeySpecException {

        if (keySpec instanceof X509EncodedKeySpec) {
            X509EncodedKeySpec x509Spec = (X509EncodedKeySpec) keySpec;
            EdDSAPublicKeyImpl result =
                new EdDSAPublicKeyImpl(x509Spec.getEncoded());
            checkLockedParams(InvalidKeySpecException::new,
                result.getParams());
            return result;
        } else if (keySpec instanceof EdECPublicKeySpec) {
            EdECPublicKeySpec publicKeySpec = (EdECPublicKeySpec) keySpec;
            EdDSAParameters params = EdDSAParameters.get(
                InvalidKeySpecException::new, publicKeySpec.getParams());
            checkLockedParams(InvalidKeySpecException::new, params);
            return new EdDSAPublicKeyImpl(params, publicKeySpec.getPoint());
        } else {
            throw new InvalidKeySpecException(
                "Only X509EncodedKeySpec and EdECPublicKeySpec are supported");
        }
    }

    private PrivateKey generatePrivateImpl(KeySpec keySpec)
        throws InvalidKeyException, InvalidKeySpecException {

        if (keySpec instanceof PKCS8EncodedKeySpec) {
            PKCS8EncodedKeySpec pkcsSpec = (PKCS8EncodedKeySpec) keySpec;
            byte[] encoded = pkcsSpec.getEncoded();
            try {
                EdDSAPrivateKeyImpl result =
                        new EdDSAPrivateKeyImpl(encoded);
                checkLockedParams(InvalidKeySpecException::new,
                        result.getParams());
                return result;
            } finally {
                Arrays.fill(encoded, (byte) 0);
            }
        } else if (keySpec instanceof EdECPrivateKeySpec) {
            EdECPrivateKeySpec privateKeySpec = (EdECPrivateKeySpec) keySpec;
            EdDSAParameters params = EdDSAParameters.get(
                InvalidKeySpecException::new, privateKeySpec.getParams());
            checkLockedParams(InvalidKeySpecException::new, params);
            byte[] bytes = privateKeySpec.getBytes();
            try {
                return new EdDSAPrivateKeyImpl(params, bytes);
            } finally {
                Arrays.fill(bytes, (byte)0);
            }
        } else {
            throw new InvalidKeySpecException(
                "Only PKCS8EncodedKeySpec and EdECPrivateKeySpec supported");
        }
    }

    protected <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> keySpec)
            throws InvalidKeySpecException {

        if (key instanceof EdECPublicKey) {
            checkLockedParams(InvalidKeySpecException::new,
                ((EdECPublicKey) key).getParams());

            if (keySpec.isAssignableFrom(X509EncodedKeySpec.class)) {
                if (!key.getFormat().equals("X.509")) {
                    throw new InvalidKeySpecException("Format is not X.509");
                }
                return keySpec.cast(new X509EncodedKeySpec(key.getEncoded()));
            } else if (keySpec.isAssignableFrom(EdECPublicKeySpec.class)) {
                EdECPublicKey edKey = (EdECPublicKey) key;
                return keySpec.cast(
                    new EdECPublicKeySpec(edKey.getParams(), edKey.getPoint()));
            } else {
                throw new InvalidKeySpecException(
                    "KeySpec must be X509EncodedKeySpec or EdECPublicKeySpec");
            }
        } else if (key instanceof EdECPrivateKey) {
            checkLockedParams(InvalidKeySpecException::new,
                ((EdECPrivateKey) key).getParams());

            if (keySpec.isAssignableFrom(PKCS8EncodedKeySpec.class)) {
                if (!key.getFormat().equals("PKCS#8")) {
                    throw new InvalidKeySpecException("Format is not PKCS#8");
                }
                byte[] encoded = key.getEncoded();
                try {
                    return keySpec.cast(new PKCS8EncodedKeySpec(encoded));
                } finally {
                    Arrays.fill(encoded, (byte)0);
                }
            } else if (keySpec.isAssignableFrom(EdECPrivateKeySpec.class)) {
                EdECPrivateKey edKey = (EdECPrivateKey) key;
                byte[] scalar = edKey.getBytes().orElseThrow(
                    () -> new InvalidKeySpecException("No private key value")
                );
                try {
                    return keySpec.cast(
                            new EdECPrivateKeySpec(edKey.getParams(), scalar));
                } finally {
                    Arrays.fill(scalar, (byte)0);
                }
            } else {
                throw new InvalidKeySpecException
                ("KeySpec must be PKCS8EncodedKeySpec or EdECPrivateKeySpec");
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key type");
        }
    }

    public static class Ed25519 extends EdDSAKeyFactory {

        public Ed25519() {
            super(NamedParameterSpec.ED25519);
        }
    }

    public static class Ed448 extends EdDSAKeyFactory {

        public Ed448() {
            super(NamedParameterSpec.ED448);
        }
    }
}
