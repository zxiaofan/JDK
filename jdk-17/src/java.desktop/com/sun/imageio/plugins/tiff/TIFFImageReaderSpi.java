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
import java.util.Locale;
import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.stream.ImageInputStream;

public class TIFFImageReaderSpi extends ImageReaderSpi {

    private boolean registered = false;

    public TIFFImageReaderSpi() {
        super("Oracle Corporation",
              "1.0",
              new String[] {"tif", "TIF", "tiff", "TIFF"},
              new String[] {"tif", "tiff"},
              new String[] {"image/tiff"},
              "com.sun.imageio.plugins.tiff.TIFFImageReader",
              new Class<?>[] { ImageInputStream.class },
              new String[] {"com.sun.imageio.plugins.tiff.TIFFImageWriterSpi"},
              false,
              TIFFStreamMetadata.NATIVE_METADATA_FORMAT_NAME,
              "com.sun.imageio.plugins.tiff.TIFFStreamMetadataFormat",
              null, null,
              true,
              TIFFImageMetadata.NATIVE_METADATA_FORMAT_NAME,
              "com.sun.imageio.plugins.tiff.TIFFImageMetadataFormat",
              null, null
              );
    }

    public String getDescription(Locale locale) {
        return "Standard TIFF image reader";
    }

    public boolean canDecodeInput(Object input) throws IOException {
        if (!(input instanceof ImageInputStream)) {
            return false;
        }

        ImageInputStream stream = (ImageInputStream)input;
        byte[] b = new byte[4];
        stream.mark();
        stream.readFully(b);
        stream.reset();

        return ((b[0] == (byte)0x49 && b[1] == (byte)0x49 &&
                 b[2] == (byte)0x2a && b[3] == (byte)0x00) ||
                (b[0] == (byte)0x4d && b[1] == (byte)0x4d &&
                 b[2] == (byte)0x00 && b[3] == (byte)0x2a));
    }

    public ImageReader createReaderInstance(Object extension) {
        return new TIFFImageReader(this);
    }

    public void onRegistration(ServiceRegistry registry,
                               Class<?> category) {
        if (registered) {
            return;
        }

        registered = true;
    }
}
