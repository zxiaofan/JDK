/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.rsa;

import java.io.IOException;
import java.math.BigInteger;

import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.interfaces.*;

import sun.security.util.*;
import sun.security.x509.AlgorithmId;
import sun.security.pkcs.PKCS8Key;

/**
 * RSA private key implementation for "RSA", "RSASSA-PSS" algorithms in non-CRT
 * form (modulus, private exponent only). For CRT private keys, see
 * RSAPrivateCrtKeyImpl. We need separate classes to ensure correct behavior
 * in instanceof checks, etc.
 *
 * Note: RSA keys must be at least 512 bits long
 *
 * @see RSAPrivateCrtKeyImpl
 * @see RSAKeyFactory
 *
 * @since   1.5
 * @author  Andreas Sterbenz
 */
public final class RSAPrivateKeyImpl extends PKCS8Key implements RSAPrivateKey {

    private static final long serialVersionUID = -33106691987952810L;

    private final BigInteger n;         // modulus
    private final BigInteger d;         // private exponent

    // optional parameters associated with this RSA key
    // specified in the encoding of its AlgorithmId.
    // must be null for "RSA" keys.
    private final AlgorithmParameterSpec keyParams;

    /**
     * Construct a key from its components. Used by the
     * RSAKeyFactory and the RSAKeyPairGenerator.
     */
    RSAPrivateKeyImpl(AlgorithmId rsaId, BigInteger n, BigInteger d)
            throws InvalidKeyException {
        RSAKeyFactory.checkRSAProviderKeyLengths(n.bitLength(), null);

        this.n = n;
        this.d = d;
        this.keyParams = RSAUtil.getParamSpec(rsaId);

        // generate the encoding
        algid = rsaId;
        try {
            DerOutputStream out = new DerOutputStream();
            out.putInteger(0); // version must be 0
            out.putInteger(n);
            out.putInteger(0);
            out.putInteger(d);
            out.putInteger(0);
            out.putInteger(0);
            out.putInteger(0);
            out.putInteger(0);
            out.putInteger(0);
            DerValue val =
                new DerValue(DerValue.tag_Sequence, out.toByteArray());
            key = val.toByteArray();
        } catch (IOException exc) {
            // should never occur
            throw new InvalidKeyException(exc);
        }
    }

    // see JCA doc
    @Override
    public String getAlgorithm() {
        return algid.getName();
    }

    // see JCA doc
    @Override
    public BigInteger getModulus() {
        return n;
    }

    // see JCA doc
    @Override
    public BigInteger getPrivateExponent() {
        return d;
    }

    // see JCA doc
    @Override
    public AlgorithmParameterSpec getParams() {
        return keyParams;
    }

    // return a string representation of this key for debugging
    @Override
    public String toString() {
        return "Sun " + getAlgorithm() + " private key, " + n.bitLength()
               + " bits" + "\n  params: " + keyParams + "\n  modulus: " + n
               + "\n  private exponent: " + d;
    }
}
