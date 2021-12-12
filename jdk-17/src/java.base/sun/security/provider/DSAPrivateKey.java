/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.provider;

import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.AlgorithmParameters;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.interfaces.DSAParams;
import java.util.Arrays;

import sun.security.x509.AlgIdDSA;
import sun.security.pkcs.PKCS8Key;
import sun.security.util.DerValue;
import sun.security.util.DerInputStream;

/**
 * A PKCS#8 private key for the Digital Signature Algorithm.
 *
 * @author Benjamin Renaud
 *
 *
 * @see DSAPublicKey
 * @see AlgIdDSA
 * @see DSA
 */

public final class DSAPrivateKey extends PKCS8Key
        implements java.security.interfaces.DSAPrivateKey, Serializable {

    /** use serialVersionUID from JDK 1.1. for interoperability */
    @java.io.Serial
    private static final long serialVersionUID = -3244453684193605938L;

    /* the private key */
    private BigInteger x;

    /**
     * Make a DSA private key out of a private key and three parameters.
     */
    public DSAPrivateKey(BigInteger x, BigInteger p,
                         BigInteger q, BigInteger g) {
        this.x = x;
        algid = new AlgIdDSA(p, q, g);

        try {
            byte[] xbytes = x.toByteArray();
            DerValue val = new DerValue(DerValue.tag_Integer, xbytes);
            key = val.toByteArray();
            val.clear();
            Arrays.fill(xbytes, (byte)0);
        } catch (IOException e) {
            throw new AssertionError("Should not happen", e);
        }
    }

    /**
     * Make a DSA private key from its DER encoding (PKCS #8).
     */
    public DSAPrivateKey(byte[] encoded) throws InvalidKeyException {
        super(encoded);
        try {
            DerInputStream in = new DerInputStream(key);
            x = in.getBigInteger();
        } catch (IOException e) {
            throw new InvalidKeyException(e.getMessage(), e);
        }
    }

    /**
     * Returns the DSA parameters associated with this key, or null if the
     * parameters could not be parsed.
     */
    public DSAParams getParams() {
        try {
            if (algid instanceof DSAParams) {
                return (DSAParams)algid;
            } else {
                DSAParameterSpec paramSpec;
                AlgorithmParameters algParams = algid.getParameters();
                if (algParams == null) {
                    return null;
                }
                paramSpec = algParams.getParameterSpec(DSAParameterSpec.class);
                return paramSpec;
            }
        } catch (InvalidParameterSpecException e) {
            return null;
        }
    }

    /**
     * Get the raw private key, x, without the parameters.
     */
    public BigInteger getX() {
        return x;
    }
}
