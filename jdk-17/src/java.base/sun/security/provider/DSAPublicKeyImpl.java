/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.math.BigInteger;
import java.security.KeyRep;
import java.security.InvalidKeyException;

/**
 * An X.509 public key for the Digital Signature Algorithm.
 *
 * The difference between DSAPublicKeyImpl and DSAPublicKey is that
 * DSAPublicKeyImpl calls writeReplace with KeyRep, and DSAPublicKey
 * calls writeObject.
 *
 * See the comments in DSAKeyFactory, 4532506, and 6232513.
 *
 */

public final class DSAPublicKeyImpl extends DSAPublicKey {

    @java.io.Serial
    private static final long serialVersionUID = 7819830118247182730L;

    /**
     * Make a DSA public key out of a public key and three parameters.
     * The p, q, and g parameters may be null, but if so, parameters will need
     * to be supplied from some other source before this key can be used in
     * cryptographic operations.  PKIX RFC2459bis explicitly allows DSA public
     * keys without parameters, where the parameters are provided in the
     * issuer's DSA public key.
     *
     * @param y the actual key bits
     * @param p DSA parameter p, may be null if all of p, q, and g are null.
     * @param q DSA parameter q, may be null if all of p, q, and g are null.
     * @param g DSA parameter g, may be null if all of p, q, and g are null.
     */
    public DSAPublicKeyImpl(BigInteger y, BigInteger p, BigInteger q,
                        BigInteger g)
                throws InvalidKeyException {
        super(y, p, q, g);
    }

    /**
     * Make a DSA public key from its DER encoding (X.509).
     */
    public DSAPublicKeyImpl(byte[] encoded) throws InvalidKeyException {
        super(encoded);
    }

    @java.io.Serial
    protected Object writeReplace() throws java.io.ObjectStreamException {
        return new KeyRep(KeyRep.Type.PUBLIC,
                        getAlgorithm(),
                        getFormat(),
                        getEncoded());
    }
}
