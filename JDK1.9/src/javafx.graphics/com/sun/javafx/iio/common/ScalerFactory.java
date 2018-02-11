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

package com.sun.javafx.iio.common;

/**
 * Factory class for creating <code>PushbroomScaler</code> instances.
 */
public class ScalerFactory {
    private ScalerFactory() {}

    /**
     * Instantiates a new <code>PushbroomScaler</code> object.
     *
     * @param sourceWidth The source image width
     * @param sourceHeight The source image height
     * @param numBands The number of components per pixel in the images
     * @param destWidth The destination image width
     * @param destHeight The destination image height
     * @throws IllegalArgumentException if any of the integral parameters is non-positive.
     */
    public static PushbroomScaler createScaler(int sourceWidth, int sourceHeight, int numBands,
            int destWidth, int destHeight, boolean isSmooth) {
        if (sourceWidth <= 0 || sourceHeight <= 0 || numBands <= 0 ||
                destWidth <= 0 || destHeight <= 0) {
            throw new IllegalArgumentException();
        }

        PushbroomScaler scaler = null;

        boolean isMagnifying = destWidth > sourceWidth || destHeight > sourceHeight;

        if (isMagnifying) {
            if (isSmooth) {
                // RT-27408
                // TODO: bpb 2009-10-05 Need SmoothMagnifier class; use RoughScaler for now.
                scaler = new RoughScaler(sourceWidth, sourceHeight, numBands,
                        destWidth, destHeight);
            } else {
                scaler = new RoughScaler(sourceWidth, sourceHeight, numBands,
                        destWidth, destHeight);
            }
        } else { // minifying
            if (isSmooth) {
                scaler = new SmoothMinifier(sourceWidth, sourceHeight, numBands,
                        destWidth, destHeight);
            } else {
                scaler = new RoughScaler(sourceWidth, sourceHeight, numBands,
                        destWidth, destHeight);
            }
        }

        return scaler;
    }
}
