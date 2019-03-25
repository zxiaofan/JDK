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

public class TIFFNullCompressor extends TIFFCompressor {

    public TIFFNullCompressor() {
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
        int numBytes = height*bytesPerRow;

        if(bytesPerRow == scanlineStride) {
            stream.write(b, off, numBytes);
        } else {
            for (int row = 0; row < height; row++) {
                stream.write(b, off, bytesPerRow);
                off += scanlineStride;
            }
        }

        return numBytes;
    }
}
