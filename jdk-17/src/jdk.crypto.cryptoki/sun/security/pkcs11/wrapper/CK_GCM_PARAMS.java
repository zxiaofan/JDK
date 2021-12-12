/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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
 * the CKM_AES_GCM mechanism as defined in CK_GCM_PARAMS structure.<p>
 * <B>PKCS#11 structure:</B>
 * <PRE>
 * typedef struct CK_GCM_PARAMS {
 *    CK_BYTE_PTR       pIv;
 *    CK_ULONG          ulIvLen;
 *    CK_BYTE_PTR       pAAD;
 *    CK_ULONG          ulAADLen;
 *    CK_ULONG          ulTagBits;
 * } CK_GCM_PARAMS;
 * </PRE>
 *
 * @since   10
 */
public class CK_GCM_PARAMS {

    private final byte[] iv;
    private final byte[] aad;
    private final long tagBits;

    public CK_GCM_PARAMS(int tagLenInBits, byte[] iv, byte[] aad) {
        this.iv = iv;
        this.aad = aad;
        this.tagBits = tagLenInBits;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Constants.INDENT);
        sb.append("iv: ");
        sb.append(Functions.toHexString(iv));
        sb.append(Constants.NEWLINE);

        sb.append(Constants.INDENT);
        sb.append("aad: ");
        sb.append(Functions.toHexString(aad));
        sb.append(Constants.NEWLINE);

        sb.append(Constants.INDENT);
        sb.append("tagLen(in bits): ");
        sb.append(tagBits);

        return sb.toString();
    }
}
