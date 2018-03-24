/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.iio.ios;

import com.sun.javafx.iio.ImageFormatDescription;
import com.sun.javafx.iio.ImageLoader;
import com.sun.javafx.iio.ImageLoaderFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * A factory which creates a loader for images on iOS platform.
 */
public class IosImageLoaderFactory implements ImageLoaderFactory {

    private static IosImageLoaderFactory theInstance;

    private IosImageLoaderFactory() {};

    /**
     * Returns an instance of IosImageLoaderFactory
     *
     * @return an instance of IosImageLoaderFactory
     */
    public static final synchronized IosImageLoaderFactory getInstance() {
        if (theInstance == null) {
            theInstance = new IosImageLoaderFactory();
        }
        return theInstance;
    }

    /**
     * @inheritDoc
     */
    public ImageFormatDescription getFormatDescription() {
        return IosDescriptor.getInstance();
    }

    /**
     * @inheritDoc
     */
    public ImageLoader createImageLoader(final InputStream input) throws IOException {
        return new IosImageLoader(input, IosDescriptor.getInstance());
    }

    /**
     * Creates a loader for the specified input URL.
     *
     * @param input a URL containing an image in the supported format.
     * @return a loader capable of loading and decoding an image from the supplied URL.
     * @throws <IOException> if there is an error creating the loader.
     */
    public ImageLoader createImageLoader(final String input) throws IOException {
        return new IosImageLoader(input, IosDescriptor.getInstance());
    }
}
