/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmedia.track;

/**
 * The dimensions of a video frame (width x height).
 */
public class VideoResolution {
    /**
     * The video frame width.
     */
    public int width;

    /**
     * The video frame height.
     */
    public int height;

    /**
     * Constructor.
     *
     * @param width The video width in pixels.
     * @param height The video height in pixels.
     * @throws IllegalArgumentException if <code>width</code> or <code>height</code> is
     * non-positive.
     */
    public VideoResolution(int width, int height) {
        if (width <= 0)
            throw new IllegalArgumentException("width <= 0");
        if (height <= 0)
            throw new IllegalArgumentException("height <= 0");
        this.width = width;
        this.height = height;
    }

    /**
     * Retrieve the video frame width.
     */
    public int getWidth() {
        return width;
    }

    /**
     *  Retrieve the video frame height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Write the dimensions to a <code>String</code>.
     */
    public String toString() {
        return "VideoResolution {width: "+width+" height: "+height+"}";
    }
}
