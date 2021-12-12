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
 * CK_TLS12_MASTER_KEY_DERIVE_PARAMS from PKCS#11 v2.40.
 */
public class CK_TLS12_MASTER_KEY_DERIVE_PARAMS {

    /**
     * <B>PKCS#11:</B>
     * <PRE>
     *   CK_SSL3_RANDOM_DATA RandomInfo;
     * </PRE>
     */
    public CK_SSL3_RANDOM_DATA RandomInfo;

    /**
     * <B>PKCS#11:</B>
     * <PRE>
     *   CK_VERSION_PTR pVersion;
     * </PRE>
     */
    public CK_VERSION pVersion;

    /**
     * <B>PKCS#11:</B>
     * <PRE>
     *   CK_MECHANISM_TYPE prfHashMechanism;
     * </PRE>
     */
    public long prfHashMechanism;

    public CK_TLS12_MASTER_KEY_DERIVE_PARAMS(
            CK_SSL3_RANDOM_DATA random, CK_VERSION version,
            long prfHashMechanism) {
        RandomInfo = random;
        pVersion = version;
        this.prfHashMechanism = prfHashMechanism;
    }

}
