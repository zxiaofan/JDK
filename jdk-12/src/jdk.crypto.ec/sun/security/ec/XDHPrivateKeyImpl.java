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

package sun.security.ec;

import java.io.*;
import java.security.interfaces.XECPrivateKey;
import java.util.Optional;
import java.security.*;
import java.security.spec.*;

import sun.security.pkcs.PKCS8Key;
import sun.security.x509.AlgorithmId;
import sun.security.util.*;

public final class XDHPrivateKeyImpl extends PKCS8Key implements XECPrivateKey {

    private static final long serialVersionUID = 1L;

    private final AlgorithmParameterSpec paramSpec;
    private byte[] k;

    XDHPrivateKeyImpl(XECParameters params, byte[] k)
        throws InvalidKeyException {

        this.paramSpec = new NamedParameterSpec(params.getName());
        this.k = k.clone();

        this.algid = new AlgorithmId(params.getOid());
        encodeKey();

        checkLength(params);
    }

    XDHPrivateKeyImpl(byte[] encoded) throws InvalidKeyException {

        decode(encoded);
        XECParameters params = XECParameters.get(
            InvalidKeyException::new, algid);
        paramSpec = new NamedParameterSpec(params.getName());
        decodeKey();

        checkLength(params);
    }

    private void decodeKey() throws InvalidKeyException {
        try {
            DerInputStream derStream = new DerInputStream(key);
            k = derStream.getOctetString();
        } catch (IOException ex) {
            throw new InvalidKeyException(ex);
        }
    }

    private void encodeKey() {
        DerOutputStream derKey = new DerOutputStream();
        try {
            derKey.putOctetString(k);
            this.key = derKey.toByteArray();
        } catch (IOException ex) {
            throw new ProviderException(ex);
        }
    }

    void checkLength(XECParameters params) throws InvalidKeyException {

        if (params.getBytes() != this.k.length) {
            throw new InvalidKeyException(
                "key length must be " + params.getBytes());
        }
    }

    public byte[] getK() {
        return k.clone();
    }

    @Override
    public String getAlgorithm() {
        return "XDH";
    }

    @Override
    public AlgorithmParameterSpec getParams() {
        return paramSpec;
    }

    @Override
    public Optional<byte[]> getScalar() {
        return Optional.of(getK());
    }
}

