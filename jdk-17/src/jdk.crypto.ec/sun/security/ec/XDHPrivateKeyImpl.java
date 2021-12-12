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

        DerValue val = new DerValue(DerValue.tag_OctetString, k);
        try {
            this.key = val.toByteArray();
        } catch (IOException ex) {
            throw new AssertionError("Should not happen", ex);
        } finally {
            val.clear();
        }
        checkLength(params);
    }

    XDHPrivateKeyImpl(byte[] encoded) throws InvalidKeyException {
        super(encoded);
        XECParameters params = XECParameters.get(
            InvalidKeyException::new, algid);
        paramSpec = new NamedParameterSpec(params.getName());
        try {
            DerInputStream derStream = new DerInputStream(key);
            k = derStream.getOctetString();
        } catch (IOException ex) {
            throw new InvalidKeyException(ex);
        }
        checkLength(params);
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

