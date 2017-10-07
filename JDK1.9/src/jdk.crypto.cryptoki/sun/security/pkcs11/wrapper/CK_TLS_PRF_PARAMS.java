/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
 * CK_TLS_PRF_PARAMS from PKCS#11 v2.20.
 *
 * @author  Andreas Sterbenz
 * @since   1.6
 */
public class CK_TLS_PRF_PARAMS {

    public byte[] pSeed;
    public byte[] pLabel;
    public byte[] pOutput;

    public CK_TLS_PRF_PARAMS(byte[] pSeed, byte[] pLabel, byte[] pOutput) {
        this.pSeed = pSeed;
        this.pLabel = pLabel;
        this.pOutput = pOutput;
    }

}
