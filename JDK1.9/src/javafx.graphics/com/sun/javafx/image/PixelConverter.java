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

package com.sun.javafx.image;

import java.nio.Buffer;

public interface PixelConverter<T extends Buffer, U extends Buffer> {
    /**
     * Copies a rectangular region of data from the source buffer to the
     * destination buffer using the following relationship:
     * <pre>
     * for each xy : 0 <= x,y < w,h {
     *     int srcpos = y * srcscanelems + x * srcelemsperpixel + srcoff;
     *     int dstpos = y * dstscanelems + x * dstelemsperpixel + dstoff;
     *     for each j : 0 <= j < srcelemsperpixel {
     *         load data from srcbuf.get(srcpos + j);
     *     }
     *     convert data to destination pixel format
     *     for each k : 0 <= k < dstelemsperpixel {
     *         store data into dstbuf.put(dstpos + k, pixel data);
     *     }
     * }
     * </pre>
     *
     * @param srcbuf the nio buffer containing the source data
     * @param srcoff the absolute location in the buffer of the first source pixel data
     * @param srcscanelems number of buffer elements between rows of data in the source
     * @param dstbuf the nio buffer containing the destination data
     * @param dstoff the absolute location in the buffer of the first destination pixel data
     * @param dstscanelems number of buffer elements between rows of data in the destination
     * @param w the number of pixels to process across before moving to the next row
     * @param h the number of rows of pixels to process
     */
    public void convert(T srcbuf, int srcoff, int srcscanelems,
                        U dstbuf, int dstoff, int dstscanelems,
                        int w, int h);

    public PixelGetter<T> getGetter();
    public PixelSetter<U> getSetter();
}
