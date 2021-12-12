/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.util.HexFormat;

/**
 * This class represents the necessary parameters required by the
 * CKM_CHACHA20_POLY1305 and CKM_SALSA20_POLY1305 mechanisms as defined in
 * CK_SALSA20_CHACHA20_POLY1305_PARAMS structure.<p>
 * <B>PKCS#11 structure:</B>
 * <PRE>
 * typedef struct CK_SALSA20_CHACHA20_POLY1305_PARAMS {
 *   CK_BYTE_PTR  pNonce;
 *   CK_ULONG     ulNonceLen;
 *   CK_BYTE_PTR  pAAD;
 *   CK_ULONG     ulAADLen;
 * } CK_SALSA20_CHACHA20_POLY1305_PARAMS;
 * </PRE>
 *
 * @since   17
 */
public class CK_SALSA20_CHACHA20_POLY1305_PARAMS {

    private final byte[] nonce;
    private final byte[] aad;

    public CK_SALSA20_CHACHA20_POLY1305_PARAMS(byte[] nonce, byte[] aad) {
        this.nonce = nonce;
        this.aad = aad;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Constants.INDENT);
        sb.append("Nonce: ");
        sb.append((nonce == null? "null" :
            "0x" + HexFormat.of().formatHex(nonce)));
        sb.append(Constants.NEWLINE);
        sb.append(Constants.INDENT);
        sb.append("AAD: ");
        sb.append((aad == null? "null" : "0x" + HexFormat.of().formatHex(aad)));
        return sb.toString();
    }
}
