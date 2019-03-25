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
import javax.imageio.ImageWriteParam;

/**
 * Compressor for Deflate compression.
 */
public class TIFFDeflateCompressor extends TIFFDeflater {
    public TIFFDeflateCompressor(ImageWriteParam param, int predictor) {
        super("Deflate", BaselineTIFFTagSet.COMPRESSION_DEFLATE, param,
              predictor);
    }
}
