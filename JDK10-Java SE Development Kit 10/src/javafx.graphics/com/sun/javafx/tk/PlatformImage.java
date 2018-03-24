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

package com.sun.javafx.tk;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;

/**
 * Common interface to all toolkit-specific objects used to store image
 * data for a javafx.image.Image object.
 */
public interface PlatformImage {
    /**
     * Gets the scale representing how large an area a 72DPI virtual
     * pixel covers in terms of the pixels of this image.
     * A 72DPI platform image would return 1.0f.
     * A 144DPI platform image would return 2.0f.
     *
     * @return the number of actual image pixels per 72DPI virtual pixel
     */
    public float getPixelScale();

    /**
     * @param x X coordinate of pixel
     * @param y Y coordinate of pixel
     * @return the non-premultiplied pixel in integer ARGB component ordering.
     */
    public int getArgb(int x, int y);

    /**
     * @param x X coordinate of pixel
     * @param y Y coordinate of pixel
     * @param argbpre non-premultiplied pixel data to store in integer ARGB
     *  component ordering
     */
    public void setArgb(int x, int y, int argb);

    /**
     * @return the PixelFormat to use for the pixel data transfer methods
     * getPixels() and setPixels().
     */
    public PixelFormat getPlatformPixelFormat();

    public boolean isWritable();
    public PlatformImage promoteToWritableImage();

    public <T extends Buffer> void getPixels(int x, int y, int w, int h,
                                             WritablePixelFormat<T> pixelformat,
                                             T pixels, int scanlineElems);

    public void getPixels(int x, int y, int w, int h,
                          WritablePixelFormat<ByteBuffer> pixelformat,
                          byte pixels[], int offset, int scanlineBytes);

    public void getPixels(int x, int y, int w, int h,
                          WritablePixelFormat<IntBuffer> pixelformat,
                          int pixels[], int offset, int scanlineInts);

    public <T extends Buffer> void setPixels(int x, int y, int w, int h,
                                             PixelFormat<T> pixelformat,
                                             T pixels, int scanlineBytes);

    public void setPixels(int x, int y, int w, int h,
                          PixelFormat<ByteBuffer> pixelformat,
                          byte pixels[], int offset, int scanlineBytes);

    public void setPixels(int x, int y, int w, int h,
                          PixelFormat<IntBuffer> pixelformat,
                          int pixels[], int offset, int scanlineInts);

    public void setPixels(int dstx, int dsty, int w, int h,
                          PixelReader reader, int srcx, int srcy);
}
