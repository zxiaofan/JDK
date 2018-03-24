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

/**
 * An interface defining methods which may be used to monitor image loading.
 */
public interface ImageLoadListener {
    /**
     * Receives updates of progress in image loading.
     *
     * @param loader the <code>ImageLoader</code> used to load the image.
     * @param percentageComplete the percentage <code>[0.0,100.0]</code>
     * of image data loaded.
     */
    void imageLoadProgress(ImageLoader loader, float percentageComplete);

    /**
     * Invoked if a warning occurs.
     *
     * @param loader the <code>ImageLoader</code> used to load the image.
     * @param message a message indicating the nature of the error.
     */
    public void imageLoadWarning(ImageLoader loader, String message);

    /**
     * Invoked when the meta data of the loading image is ready.
     *
     * @param loader the <code>ImageLoader</code> used to load the image.
     * @param metadata of the image.
     */
    public void imageLoadMetaData(ImageLoader loader, ImageMetadata metadata);

}
