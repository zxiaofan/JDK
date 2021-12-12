/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.ec;

import java.math.BigInteger;
import java.security.KeyPairGeneratorSpi;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.NamedParameterSpec;
import java.util.Arrays;

import sun.security.jca.JCAUtil;

/**
 * Key pair generator for the XDH key agreement algorithm.
 */
public class XDHKeyPairGenerator extends KeyPairGeneratorSpi {

    private static final NamedParameterSpec DEFAULT_PARAM_SPEC
        = NamedParameterSpec.X25519;

    private SecureRandom random = null;
    private XECOperations ops = null;
    private XECParameters lockedParams = null;

    XDHKeyPairGenerator() {
        tryInitialize(DEFAULT_PARAM_SPEC);
    }

    private XDHKeyPairGenerator(NamedParameterSpec paramSpec) {
        tryInitialize(paramSpec);
        lockedParams = ops.getParameters();
    }

    private void tryInitialize(NamedParameterSpec paramSpec) {
        try {
            initialize(paramSpec, null);
        } catch (InvalidAlgorithmParameterException ex) {
            String name = paramSpec.getName();
            throw new ProviderException(name + " not supported");
        }
    }

    @Override
    public void initialize(int keySize, SecureRandom random) {

        XECParameters params = XECParameters.getBySize(
            InvalidParameterException::new, keySize);

        initializeImpl(params, random);
    }

    @Override
    public void initialize(AlgorithmParameterSpec params, SecureRandom random)
            throws InvalidAlgorithmParameterException {

        XECParameters xecParams = XECParameters.get(
            InvalidAlgorithmParameterException::new, params);

        initializeImpl(xecParams, random);
    }

    private void initializeImpl(XECParameters params, SecureRandom random) {

        if (lockedParams != null && lockedParams != params) {
            throw new InvalidParameterException("Parameters must be " +
                lockedParams.getName());
        }

        this.ops = new XECOperations(params);
        this.random = random == null ? JCAUtil.getSecureRandom() : random;
    }


    @Override
    public KeyPair generateKeyPair() {

        byte[] privateKey = ops.generatePrivate(random);
        // computePublic may modify the private key, so clone it first
        byte[] cloned = privateKey.clone();
        BigInteger publicKey = ops.computePublic(cloned);
        Arrays.fill(cloned, (byte)0);

        try {
            return new KeyPair(
                new XDHPublicKeyImpl(ops.getParameters(), publicKey),
                new XDHPrivateKeyImpl(ops.getParameters(), privateKey)
            );
        } catch (InvalidKeyException ex) {
            throw new ProviderException(ex);
        } finally {
            Arrays.fill(privateKey, (byte)0);
        }
    }

    static class X25519 extends XDHKeyPairGenerator {

        public X25519() {
            super(NamedParameterSpec.X25519);
        }
    }

    static class X448 extends XDHKeyPairGenerator {

        public X448() {
            super(NamedParameterSpec.X448);
        }
    }
}
