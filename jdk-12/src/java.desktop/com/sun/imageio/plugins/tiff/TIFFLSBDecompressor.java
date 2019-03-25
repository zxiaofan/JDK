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

public class TIFFLSBDecompressor extends TIFFDecompressor {

    /**
     * Table for flipping bytes from LSB-to-MSB to MSB-to-LSB.
     */
    private static final byte[] flipTable = TIFFFaxDecompressor.flipTable;

    public TIFFLSBDecompressor() {}

    public void decodeRaw(byte[] b,
                          int dstOffset,
                          int bitsPerPixel,
                          int scanlineStride) throws IOException {
        stream.seek(offset);

        int bytesPerRow = (srcWidth*bitsPerPixel + 7)/8;
        if(bytesPerRow == scanlineStride) {
            int numBytes = bytesPerRow*srcHeight;
            stream.readFully(b, dstOffset, numBytes);
            int xMax = dstOffset + numBytes;
            for (int x = dstOffset; x < xMax; x++) {
                b[x] = flipTable[b[x]&0xff];
            }
        } else {
            for (int y = 0; y < srcHeight; y++) {
                stream.readFully(b, dstOffset, bytesPerRow);
                int xMax = dstOffset + bytesPerRow;
                for (int x = dstOffset; x < xMax; x++) {
                    b[x] = flipTable[b[x]&0xff];
                }
                dstOffset += scanlineStride;
            }
        }
    }
}
