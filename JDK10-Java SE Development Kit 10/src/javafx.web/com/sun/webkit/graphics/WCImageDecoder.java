/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.graphics;


public abstract class WCImageDecoder {

    /**
     * Receives a portion of image data.
     *
     * @param data  a portion of image data,
     *              or {@code null} if all data received
     */
    protected abstract void addImageData(byte[] data);

    /**
     * Returns image size.
     */
    protected abstract int[] getImageSize();

    /**
     * Returns a number of frames of the decoded image.
     *
     * @return  a number of image frames
     */
    protected abstract int getFrameCount();

    /**
     * Returns image frame at the specified index.
     * @param index frame index
     */
    protected abstract WCImageFrame getFrame(int index);

    /**
     * Returns frame duration in ms
     * @param index frame index
     */
    protected abstract int getFrameDuration(int index);

    /**
     * Returns frame size, array[0] represents width and array[1]
     * represents height.
     * @param index frame index
     */
    protected abstract int[] getFrameSize(int index);

    /**
     * Returns whether the frame is complete or partial
     * @param index frame index
     */
    protected abstract boolean getFrameCompleteStatus(int index);

    protected abstract void loadFromResource(String name);

    protected abstract void destroy();

    protected abstract String getFilenameExtension();

}
