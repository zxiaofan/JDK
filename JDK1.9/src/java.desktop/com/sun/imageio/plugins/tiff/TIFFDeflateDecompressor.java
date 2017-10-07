/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import javax.imageio.IIOException;
import javax.imageio.plugins.tiff.BaselineTIFFTagSet;

public class TIFFDeflateDecompressor extends TIFFDecompressor {

    Inflater inflater = null;
    int predictor;

    public TIFFDeflateDecompressor(int predictor) throws IIOException {
        inflater = new Inflater();

        if (predictor != BaselineTIFFTagSet.PREDICTOR_NONE &&
            predictor !=
            BaselineTIFFTagSet.PREDICTOR_HORIZONTAL_DIFFERENCING) {
            throw new IIOException("Illegal value for Predictor in " +
                                   "TIFF file");
        }

        this.predictor = predictor;
    }

    public synchronized void decodeRaw(byte[] b,
                                       int dstOffset,
                                       int bitsPerPixel,
                                       int scanlineStride) throws IOException {

        // Check bitsPerSample.
        if (predictor ==
            BaselineTIFFTagSet.PREDICTOR_HORIZONTAL_DIFFERENCING) {
            int len = bitsPerSample.length;
            for(int i = 0; i < len; i++) {
                if(bitsPerSample[i] != 8) {
                    throw new IIOException
                        (bitsPerSample[i] + "-bit samples "+
                         "are not supported for Horizontal "+
                         "differencing Predictor");
                }
            }
        }

        // Seek to current tile data offset.
        stream.seek(offset);

        // Read the deflated data.
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

        // Set the input to the Inflater.
        inflater.setInput(srcData);

        // Inflate the data.
        try {
            inflater.inflate(buf, bufOffset, bytesPerRow*srcHeight);
        } catch(DataFormatException dfe) {
            throw new IIOException("Error inflating data",
                                   dfe);
        }

        // Reset the Inflater.
        inflater.reset();

        if (predictor ==
            BaselineTIFFTagSet.PREDICTOR_HORIZONTAL_DIFFERENCING) {
            int step = planar || samplesPerPixel == 1 ? 1 : samplesPerPixel;
            int samplesPerRow = step * srcWidth;

            int off = bufOffset + step;
            for (int j = 0; j < srcHeight; j++) {
                int count = off;
                for (int i = step; i < samplesPerRow; i++) {
                    buf[count] += buf[count - step];
                    count++;
                }
                off += samplesPerRow;
            }
        }

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
