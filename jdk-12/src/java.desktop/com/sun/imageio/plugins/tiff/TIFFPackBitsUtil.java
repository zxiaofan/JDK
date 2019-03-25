/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.imageio.plugins.tiff;

import java.io.IOException;

public class TIFFPackBitsUtil {

    byte[] dstData = new byte[8192];
    int dstIndex = 0;

    public TIFFPackBitsUtil() {
    }

    private void ensureCapacity(int bytesToAdd) {
        if (dstIndex + bytesToAdd > dstData.length) {
            byte[] newDstData = new byte[Math.max((int)(dstData.length*1.2f),
                                                  dstIndex + bytesToAdd)];
            System.arraycopy(dstData, 0, newDstData, 0, dstData.length);
            dstData = newDstData;
        }
    }

    public byte[] decode(byte[] srcData) throws IOException {
        int inIndex = 0;
        while (inIndex < srcData.length) {
            byte b = srcData[inIndex++];

            if (b >= 0 && b <= 127) {
                // Literal run packet

                ensureCapacity(b + 1);
                for (int i = 0; i < b + 1; i++) {
                    dstData[dstIndex++] = srcData[inIndex++];
                }
            } else if (b <= -1 && b >= -127) {
                // 2-byte encoded run packet
                byte repeat = srcData[inIndex++];
                ensureCapacity(-b + 1);
                for (int i = 0; i < (-b + 1); i++) {
                    dstData[dstIndex++] = repeat;
                }
            } else {
                // No-op packet, do nothing
                ++inIndex;
            }
        }

        byte[] newDstData = new byte[dstIndex];
        System.arraycopy(dstData, 0, newDstData, 0, dstIndex);
        return newDstData;
    }
}
