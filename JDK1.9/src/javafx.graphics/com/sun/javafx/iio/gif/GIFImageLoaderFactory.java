/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.iio.gif;

import com.sun.javafx.iio.ImageFormatDescription;
import com.sun.javafx.iio.ImageLoader;
import com.sun.javafx.iio.ImageLoaderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class GIFImageLoaderFactory implements ImageLoaderFactory {

    private static final GIFImageLoaderFactory theInstance =
            new GIFImageLoaderFactory();

    private GIFImageLoaderFactory() {}

    public static final ImageLoaderFactory getInstance() {
        return theInstance;
    }

    public ImageFormatDescription getFormatDescription() {
        return GIFDescriptor.getInstance();
    }

    public ImageLoader createImageLoader(InputStream input) throws IOException {
        return new GIFImageLoader2(input);
    }
}
