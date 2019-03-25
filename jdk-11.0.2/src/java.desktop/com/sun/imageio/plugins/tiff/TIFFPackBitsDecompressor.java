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

public class TIFFPackBitsDecompressor extends TIFFDecompressor {

    public TIFFPackBitsDecompressor() {
    }

    public int decode(byte[] srcData, int srcOffset,
                      byte[] dstData, int dstOffset)
        throws IOException {

        int srcIndex = srcOffset;
        int dstIndex = dstOffset;

        int dstArraySize = dstData.length;
        int srcArraySize = srcData.length;
        try {
            while (dstIndex < dstArraySize && srcIndex < srcArraySize) {
                byte b = srcData[srcIndex++];

                if (b >= 0 && b <= 127) {
                    // Literal run packet

                    for (int i = 0; i < b + 1; i++) {
                        dstData[dstIndex++] = srcData[srcIndex++];
                    }
                } else if (b <= -1 && b >= -127) {
                    // 2-byte encoded run packet
                    byte repeat = srcData[srcIndex++];
                    for (int i = 0; i < (-b + 1); i++) {
                        dstData[dstIndex++] = repeat;
                    }
                } else {
                    // No-op packet, do nothing
                    ++srcIndex;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            if(reader instanceof TIFFImageReader) {
                ((TIFFImageReader)reader).forwardWarningMessage
                    ("ArrayIndexOutOfBoundsException ignored in TIFFPackBitsDecompressor.decode()");
            }
        }

        return dstIndex - dstOffset;
    }

    public void decodeRaw(byte[] b,
                          int dstOffset,
                          int bitsPerPixel,
                          int scanlineStride) throws IOException {
        stream.seek(offset);

        byte[] srcData = new byte[byteCount];
        stream.readFully(srcData);

        int bytesPerRow = (srcWidth*bitsPerPixel + 7)/8;
        byte[] buf;
        int bufOffset;
        if(bytesPerRow == scanlineStride) {
            buf = b;
            bufOffset = dstOffset;
        } else {
            buf = new byte[bytesPerRow*srcHeight];
            bufOffset = 0;
        }

        decode(srcData, 0, buf, bufOffset);

        if(bytesPerRow != scanlineStride) {
            int off = 0;
            for (int y = 0; y < srcHeight; y++) {
                System.arraycopy(buf, off, b, dstOffset, bytesPerRow);
                off += bytesPerRow;
                dstOffset += scanlineStride;
            }
        }
    }
}
