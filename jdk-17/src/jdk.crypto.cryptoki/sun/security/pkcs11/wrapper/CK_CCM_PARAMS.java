/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
 * the CKM_AES_CCM mechanism as defined in CK_CCM_PARAMS structure.<p>
 * <B>PKCS#11 structure:</B>
 * <PRE>
 * typedef struct CK_CCM_PARAMS {
 *   CK_ULONG ulDataLen;
 *   CK_BYTE_PTR pNonce;
 *   CK_ULONG ulNonceLen;
 *   CK_BYTE_PTR pAAD;
 *   CK_ULONG ulAADLen;
 *   CK_ULONG ulMACLen;
 * } CK_CCM_PARAMS;
 * </PRE>
 *
 * @since   13
 */
public class CK_CCM_PARAMS {

    private final long dataLen;
    private final byte[] nonce;
    private final byte[] aad;
    private final long macLen;

    public CK_CCM_PARAMS(int tagLen, byte[] iv, byte[] aad, int dataLen) {
        this.dataLen = dataLen;
        this.nonce = iv;
        this.aad = aad;
        this.macLen = tagLen;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Constants.INDENT);
        sb.append("ulDataLen: ");
        sb.append(dataLen);
        sb.append(Constants.NEWLINE);

        sb.append(Constants.INDENT);
        sb.append("iv: ");
        sb.append(Functions.toHexString(nonce));
        sb.append(Constants.NEWLINE);

        sb.append(Constants.INDENT);
        sb.append("aad: ");
        sb.append(Functions.toHexString(aad));
        sb.append(Constants.NEWLINE);

        sb.append(Constants.INDENT);
        sb.append("tagLen: ");
        sb.append(macLen);

        return sb.toString();
    }
}
