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

package com.sun.javafx.iio.jpeg;

import com.sun.javafx.iio.ImageFormatDescription;
import com.sun.javafx.iio.ImageLoader;
import com.sun.javafx.iio.ImageLoaderFactory;
import java.io.IOException;
import java.io.InputStream;

public class JPEGImageLoaderFactory implements ImageLoaderFactory {
    private static final JPEGImageLoaderFactory theInstance =
            new JPEGImageLoaderFactory();

    private JPEGImageLoaderFactory() {}

    public static final ImageLoaderFactory getInstance() {
        return theInstance;
    }

    public ImageFormatDescription getFormatDescription() {
        return JPEGDescriptor.getInstance();
    }

    public ImageLoader createImageLoader(InputStream input) throws IOException {
        return new JPEGImageLoader(input);
    }
}
