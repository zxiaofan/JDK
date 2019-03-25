/*
 * Copyright (c) 2018, Red Hat, Inc.
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

package sun.security.pkcs11.wrapper;

/**
 * CK_TLS_MAC_PARAMS from PKCS#11 v2.40.
 */
public class CK_TLS_MAC_PARAMS {

    /**
     * <B>PKCS#11:</B>
     * <PRE>
     *   CK_MECHANISM_TYPE prfMechanism;
     * </PRE>
     */
    public long prfMechanism;

    /**
     * <B>PKCS#11:</B>
     * <PRE>
     *   CK_ULONG ulMacLength;
     * </PRE>
     */
    public long ulMacLength;

    /**
     * <B>PKCS#11:</B>
     * <PRE>
     *   CK_ULONG ulServerOrClient;
     * </PRE>
     */
    public long ulServerOrClient;

    public CK_TLS_MAC_PARAMS(long prfMechanism,
            long ulMacLength, long ulServerOrClient) {
        this.prfMechanism = prfMechanism;
        this.ulMacLength = ulMacLength;
        this.ulServerOrClient = ulServerOrClient;
    }

}
