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

import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.tiff.BaselineTIFFTagSet;

/**
 * A {@code TIFFCompressor} for the JPEG variant of Exif.
 */
public class TIFFExifJPEGCompressor extends TIFFBaseJPEGCompressor {
    public TIFFExifJPEGCompressor(ImageWriteParam param) {
        super(TIFFImageWriter.EXIF_JPEG_COMPRESSION_TYPE,
              BaselineTIFFTagSet.COMPRESSION_OLD_JPEG,
              false,
              param);
    }

    public void setMetadata(IIOMetadata metadata) {
        // Set the metadata.
        super.setMetadata(metadata);

        // Initialize the JPEG writer and writeparam.
        initJPEGWriter(false, // No stream metadata (not writing abbreviated)
                       true); // Yes image metadata (remove APPn markers)
    }
}
