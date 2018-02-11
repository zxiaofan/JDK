/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.jgss;

/**
 * Attribute types that can be specified as an argument of
 * {@link com.sun.security.jgss.ExtendedGSSContext#inquireSecContext}
 */
public enum InquireType {
    /**
     * Attribute type for retrieving the session key of an established
     * Kerberos 5 security context. The returned object is an instance of
     * {@link java.security.Key}, which has the following properties:
     *    <ul>
     *    <li>Algorithm: enctype as a string, where
     *        enctype is defined in RFC 3961, section 8.
     *    <li>Format: "RAW"
     *    <li>Encoded form: the raw key bytes, not in any ASN.1 encoding
     *    </ul>
     * @deprecated as of 9, replaced by {@link #KRB5_GET_SESSION_KEY_EX}
     * which returns an instance of
     * {@link javax.security.auth.kerberos.EncryptionKey}
     * that implements the {@link javax.crypto.SecretKey} interface and
     * has similar methods with {@link javax.security.auth.kerberos.KerberosKey}.
     */
    @Deprecated
    KRB5_GET_SESSION_KEY,
    /**
     * Attribute type for retrieving the session key of an
     * established Kerberos 5 security context. The return value is an
     * instance of {@link javax.security.auth.kerberos.EncryptionKey}.
     *
     * @since 9
     */
    KRB5_GET_SESSION_KEY_EX,
    /**
     * Attribute type for retrieving the service ticket flags of an
     * established Kerberos 5 security context. The returned object is
     * a boolean array for the service ticket flags, which is long enough
     * to contain all true bits. This means if the user wants to get the
     * <em>n</em>'th bit but the length of the returned array is less than
     * <em>n</em>, it is regarded as false.
     */
    KRB5_GET_TKT_FLAGS,
    /**
     * Attribute type for retrieving the authorization data in the
     * service ticket of an established Kerberos 5 security context.
     * Only supported on the acceptor side.
     */
    KRB5_GET_AUTHZ_DATA,
    /**
     * Attribute type for retrieving the authtime in the service ticket
     * of an established Kerberos 5 security context. The returned object
     * is a String object in the standard KerberosTime format defined in
     * RFC 4120 Section 5.2.3.
     */
    KRB5_GET_AUTHTIME,
    /**
     * Attribute type for retrieving the KRB_CRED message that an initiator
     * is about to send to an acceptor. The return type is an instance of
     * {@link javax.security.auth.kerberos.KerberosCredMessage}.
     *
     * @since 9
     */
    KRB5_GET_KRB_CRED,
}
