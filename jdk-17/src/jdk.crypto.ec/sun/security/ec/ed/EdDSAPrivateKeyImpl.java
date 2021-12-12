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

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.ProviderException;
import java.security.interfaces.EdECPrivateKey;
import java.util.Optional;
import java.security.spec.NamedParameterSpec;

import sun.security.pkcs.PKCS8Key;
import sun.security.x509.AlgorithmId;
import sun.security.util.*;

public final class EdDSAPrivateKeyImpl
        extends PKCS8Key implements EdECPrivateKey {

    private static final long serialVersionUID = 1L;

    private final NamedParameterSpec paramSpec;
    private byte[] h;

    EdDSAPrivateKeyImpl(EdDSAParameters params, byte[] h)
            throws InvalidKeyException {

        this.paramSpec = new NamedParameterSpec(params.getName());
        this.algid = new AlgorithmId(params.getOid());
        this.h = h.clone();

        DerValue val = new DerValue(DerValue.tag_OctetString, h);
        try {
            this.key = val.toByteArray();
        } catch (IOException ex) {
            throw new AssertionError("Should not happen", ex);
        } finally {
            val.clear();
        }
        checkLength(params);
    }

    EdDSAPrivateKeyImpl(byte[] encoded) throws InvalidKeyException {

        super(encoded);
        EdDSAParameters params = EdDSAParameters.get(
            InvalidKeyException::new, algid);
        paramSpec = new NamedParameterSpec(params.getName());

        try {
            DerInputStream derStream = new DerInputStream(key);
            h = derStream.getOctetString();
        } catch (IOException ex) {
            throw new InvalidKeyException(ex);
        }
        checkLength(params);
    }

    void checkLength(EdDSAParameters params) throws InvalidKeyException {

        if (params.getKeyLength() != this.h.length) {
            throw new InvalidKeyException("key length is " + this.h.length +
                ", key length must be " + params.getKeyLength());
        }
    }

    public byte[] getKey() {
        return h.clone();
    }

    @Override
    public String getAlgorithm() {
        return "EdDSA";
    }

    @Override
    public NamedParameterSpec getParams() {
        return paramSpec;
    }

    @Override
    public Optional<byte[]> getBytes() {
        return Optional.of(getKey());
    }
}
