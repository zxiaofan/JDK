/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package java.security.spec;

/**
 * This class represents the ASN.1 encoding of a public key,
 * encoded according to the ASN.1 type {@code SubjectPublicKeyInfo}.
 * The {@code SubjectPublicKeyInfo} syntax is defined in the X.509
 * standard as follows:
 *
 * <pre>
 * SubjectPublicKeyInfo ::= SEQUENCE {
 *   algorithm AlgorithmIdentifier,
 *   subjectPublicKey BIT STRING }
 * </pre>
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see KeySpec
 * @see EncodedKeySpec
 * @see PKCS8EncodedKeySpec
 *
 * @since 1.2
 */

public class X509EncodedKeySpec extends EncodedKeySpec {

    /**
     * Creates a new {@code X509EncodedKeySpec} with the given encoded key.
     *
     * @param encodedKey the key, which is assumed to be
     * encoded according to the X.509 standard. The contents of the
     * array are copied to protect against subsequent modification.
     * @throws NullPointerException if {@code encodedKey}
     * is null.
     */
    public X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
    }

    /**
     * Creates a new {@code X509EncodedKeySpec} with the given encoded key.
     * This constructor is useful when subsequent callers of the
     * {@code X509EncodedKeySpec} object might not know the algorithm
     * of the key.
     *
     * @param encodedKey the key, which is assumed to be
     * encoded according to the X.509 standard. The contents of the
     * array are copied to protect against subsequent modification.
     * @param algorithm the algorithm name of the encoded public key
     * See the KeyFactory section in the <a href=
     * "{@docRoot}/../specs/security/standard-names.html#keyfactory-algorithms">
     * Java Security Standard Algorithm Names Specification</a>
     * for information about standard algorithm names.
     * @throws NullPointerException if {@code encodedKey}
     * or {@code algorithm} is null.
     * @throws IllegalArgumentException if {@code algorithm} is
     * the empty string {@code ""}
     * @since 9
     */
    public X509EncodedKeySpec(byte[] encodedKey, String algorithm) {
        super(encodedKey, algorithm);
    }

    /**
     * Returns the key bytes, encoded according to the X.509 standard.
     *
     * @return the X.509 encoding of the key. Returns a new array
     * each time this method is called.
     */
    public byte[] getEncoded() {
        return super.getEncoded();
    }

    /**
     * Returns the name of the encoding format associated with this
     * key specification.
     *
     * @return the string {@code "X.509"}.
     */
    public final String getFormat() {
        return "X.509";
    }
}
