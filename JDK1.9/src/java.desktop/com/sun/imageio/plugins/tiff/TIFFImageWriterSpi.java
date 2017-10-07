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

import java.util.Locale;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.stream.ImageOutputStream;

public class TIFFImageWriterSpi extends ImageWriterSpi {

    private boolean registered = false;

    public TIFFImageWriterSpi() {
        super("Oracle Corporation",
              "1.0",
              new String[] {"tif", "TIF", "tiff", "TIFF"},
              new String[] {"tif", "tiff"},
              new String[] {"image/tiff"},
              "com.sun.imageio.plugins.tiff.TIFFImageWriter",
              new Class<?>[] {ImageOutputStream.class},
              new String[] {"com.sun.imageio.plugins.tiff.TIFFImageReaderSpi"},
              false,
              TIFFStreamMetadata.NATIVE_METADATA_FORMAT_NAME,
              "com.sun.imageio.plugins.tiff.TIFFStreamMetadataFormat",
              null, null,
              false,
              TIFFImageMetadata.NATIVE_METADATA_FORMAT_NAME,
              "com.sun.imageio.plugins.tiff.TIFFImageMetadataFormat",
              null, null
              );
    }

    public boolean canEncodeImage(ImageTypeSpecifier type) {
        return true;
    }

    public String getDescription(Locale locale) {
        return "Standard TIFF image writer";
    }

    public ImageWriter createWriterInstance(Object extension) {
        return new TIFFImageWriter(this);
    }

    public void onRegistration(ServiceRegistry registry,
                               Class<?> category) {
        if (registered) {
            return;
        }

        registered = true;
    }
}
