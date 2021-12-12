/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.EdDSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/**
 * This AlgorithmParametersSpi only supports NamedParameterSpec.
 * EdDSAParameterSpec is not support because there is not ASN.1 format
 */

public class EdDSAAlgorithmParameters extends AlgorithmParametersSpi {

    EdDSAParameterSpec edspec;

    // If no curve is provide, wait engineInit() to provide one.
    public EdDSAAlgorithmParameters() {
    }

    /**
     * NamedParameterSpec can only be used if curve was not specified
     * as part of getInstance(EdDSA).  If the curve was used, engineInit will
     * throws an exception for being already initialized.
     * EdDSAParameterSpec is not support because there is not ASN.1 format
     *
     * @param paramSpec NamedParameterSpec curve.
     *
     * @throws InvalidParameterSpecException
     */
    @Override
    protected void engineInit(AlgorithmParameterSpec paramSpec)
            throws InvalidParameterSpecException {
        if (paramSpec instanceof EdDSAParameterSpec) {
            edspec = (EdDSAParameterSpec)paramSpec;
            return;
        }
        throw new InvalidParameterSpecException(
                "Unknown AlgorithmParameterSpec");
    }

    @Override
    protected void engineInit(byte[] params) throws IOException {
        throw new IOException(
                "EdDSA does not support parameters as a byte array.");
    }

    @Override
    protected void engineInit(byte[] params, String format) throws IOException {
        engineInit(params);
    }

    @Override
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(
            Class<T> paramSpec) throws InvalidParameterSpecException {

        if (paramSpec.isAssignableFrom(ECParameterSpec.class)) {
            return paramSpec.cast(edspec);
        }
        throw new InvalidParameterSpecException(
                "Only EDDSAParameterSpec supported.");
    }

    @Override
    protected byte[] engineGetEncoded() throws IOException {
        throw new IOException(
                "EdDSA does not support parameters as a byte array.");
    }

    @Override
    protected byte[] engineGetEncoded(String format) throws IOException {
        throw new IOException(
                "EdDSA does not support parameters as a byte array.");
    }

    @Override
    protected String engineToString() {
        return edspec.toString();
    }
}
