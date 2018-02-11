/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
 * This class represents the necessary parameters required by
 * the CKM_AES_CTR mechanism as defined in CK_AES_CTR_PARAMS structure.<p>
 * <B>PKCS#11 structure:</B>
 * <PRE>
 * typedef struct CK_AES_CTR_PARAMS {
 *   CK_ULONG ulCounterBits;
 *   CK_BYTE cb[16];
 * } CK_AES_CTR_PARAMS;
 * </PRE>
 *
 * @author Yu-Ching Valerie Peng
 * @since   1.7
 */
public class CK_AES_CTR_PARAMS {

    private final long ulCounterBits;
    private final byte[] cb;

    public CK_AES_CTR_PARAMS(byte[] cb) {
        ulCounterBits = 128;
        this.cb = cb.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Constants.INDENT);
        sb.append("ulCounterBits: ");
        sb.append(ulCounterBits);
        sb.append(Constants.NEWLINE);

        sb.append(Constants.INDENT);
        sb.append("cb: ");
        sb.append(Functions.toHexString(cb));

        return sb.toString();
    }
}
