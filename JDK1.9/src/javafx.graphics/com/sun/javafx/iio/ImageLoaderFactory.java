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

package com.sun.javafx.iio;

import java.io.IOException;
import java.io.InputStream;

/**
 * A factory which creates a loader for images stored in a given format.
 */
public interface ImageLoaderFactory {
    /**
     * Gets a description of the image format for which this factory can create
     * loaders.
     *
     * @return a description of the image format handled by this factory.
     */
    ImageFormatDescription getFormatDescription();

    /**
     * Creates a loader for the specified stream. This stream must contain a
     * sequence of bytes stored in the format handled by this factory, and must
     * be positioned at the first byte of the signature for this format.
     *
     * @param input a stream containing an image in the supported format.
     * @return a loader capable of decoding the supplied stream into an image.
     * @throws <IOException> if there is an error creating the loader.
     */
    ImageLoader createImageLoader(InputStream input) throws IOException;
}
