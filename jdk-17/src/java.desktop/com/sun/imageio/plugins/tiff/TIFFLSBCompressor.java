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

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.io.IOException;

/**
 * Uncompressed data with LSB-to-MSB fill order.
 */
public class TIFFLSBCompressor extends TIFFCompressor {

    public TIFFLSBCompressor() {
        super("", BaselineTIFFTagSet.COMPRESSION_NONE, true);
    }

    public int encode(byte[] b, int off,
                      int width, int height,
                      int[] bitsPerSample,
                      int scanlineStride) throws IOException {
        int bitsPerPixel = 0;
        for (int i = 0; i < bitsPerSample.length; i++) {
            bitsPerPixel += bitsPerSample[i];
        }
        int bytesPerRow = (bitsPerPixel*width + 7)/8;
        byte[] compData = new byte[bytesPerRow];
        byte[] flipTable = TIFFFaxDecompressor.flipTable;
        for (int row = 0; row < height; row++) {
            System.arraycopy(b, off, compData, 0, bytesPerRow);
            for(int j = 0; j < bytesPerRow; j++) {
                compData[j] = flipTable[compData[j]&0xff];
            }
            stream.write(compData, 0, bytesPerRow);
            off += scanlineStride;
        }
        return height*bytesPerRow;
    }
}
