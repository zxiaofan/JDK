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

import com.sun.imageio.plugins.common.LZWCompressor;
import java.io.IOException;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.plugins.tiff.BaselineTIFFTagSet;

/**
 * LZW Compressor.
 */
public class TIFFLZWCompressor extends TIFFCompressor {

    private final int predictor;

    public TIFFLZWCompressor(int predictorValue) {
        super("LZW", BaselineTIFFTagSet.COMPRESSION_LZW, true);
        this.predictor = predictorValue;
    }

    public void setStream(ImageOutputStream stream) {
        super.setStream(stream);
    }

    public int encode(byte[] b, int off,
                      int width, int height,
                      int[] bitsPerSample,
                      int scanlineStride) throws IOException {

        LZWCompressor lzwCompressor = new LZWCompressor(stream, 8, true);

        int samplesPerPixel = bitsPerSample.length;
        int bitsPerPixel = 0;
        for (int i = 0; i < samplesPerPixel; i++) {
            bitsPerPixel += bitsPerSample[i];
        }
        int bytesPerRow = (bitsPerPixel*width + 7)/8;

        long initialStreamPosition = stream.getStreamPosition();

        boolean usePredictor =
            predictor == BaselineTIFFTagSet.PREDICTOR_HORIZONTAL_DIFFERENCING;

        if(bytesPerRow == scanlineStride && !usePredictor) {
            lzwCompressor.compress(b, off, bytesPerRow*height);
        } else {
            byte[] rowBuf = usePredictor ? new byte[bytesPerRow] : null;
            for(int i = 0; i < height; i++) {
                if(usePredictor) {
                    // Cannot modify b[] in place as it might be a data
                    // array from the image being written so make a copy.
                    System.arraycopy(b, off, rowBuf, 0, bytesPerRow);
                    for(int j = bytesPerRow - 1; j >= samplesPerPixel; j--) {
                        rowBuf[j] -= rowBuf[j - samplesPerPixel];
                    }
                    lzwCompressor.compress(rowBuf, 0, bytesPerRow);
                } else {
                    lzwCompressor.compress(b, off, bytesPerRow);
                }
                off += scanlineStride;
            }
        }

        lzwCompressor.flush();

        int bytesWritten =
            (int)(stream.getStreamPosition() - initialStreamPosition);

        return bytesWritten;
    }
}
