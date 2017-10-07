/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

import java.nio.ByteBuffer;

/**
 * This interface describes a video image as received by the media stack. It is
 * generally just a wrapper/shim for VideoDataBuffer to avoid dependency issues.
 */
public interface MediaFrame {
    /**
     * @param plane the numeric index of the plane, for chunky formats pass zero
     * @return the {@code ByteBuffer} for the specified plane or null for
     * non-existent planes
     */
    public ByteBuffer getBufferForPlane(int plane);

    /**
     * @return {@link PixelFormat} describing how pixels are stored in this
     * frame's buffer
     */
    public PixelFormat getPixelFormat();

    /**
     * @return width in pixels of the video image contained in this frame
     */
    public int getWidth();

    /**
     * @return height in pixels of the video image contained in this frame
     */
    public int getHeight();

    /**
     * @return width in pixels of the video image as produced by the video
     * decoder
     */
    public int getEncodedWidth();

    /**
     * @return height in pixels of the video image as produced by the video
     * decoder
     */
    public int getEncodedHeight();

    /**
     * @return the number of component planes, for packed formats this will
     * always be one
     */
    public int planeCount();

    /**
     * The plane line stride is the number of bytes between two consecutive
     * lines in the buffer. This number will vary depending on the frame's
     * {@code PixelFormat} and decoder output.
     * @return int array containing the line stride for each plane
     */
    public int[] planeStrides();

    /**
     * The plane line stride is the number of bytes between two consecutive
     * lines in the buffer. This number will vary depending on the frame's
     * {@code PixelFormat} and decoder output.
     * @param planeIndex which plane to get the stride for, valid range is zero
     * to {@link #planeCount() planeCount()} non-inclusive
     * @return the line stride for the specified plane
     */
    public int strideForPlane(int planeIndex);

    /**
     * Converts the video frame to a different video format.
     * @param fmt The new video pixel format, if the same format is specified then
     * the same frame will be returned. If a conversion is unsupported then this
     * will return null. The converted frame must be released when you're done
     * with it by calling {@link #releaseFrame} or it will leak.
     * @return valid MediaFrame in the specified format, or null if it cannot be
     * converted
     */
    public MediaFrame convertToFormat(PixelFormat fmt);

    /**
     * This method will prevent the frame from being deallocated or recycled. It
     * is very important to balance the use of this method by calling releaseFrame
     * when you're done with it otherwise the memory occupied by the frame will
     * never be released which could lead to out of memory conditions.
     */
    public void holdFrame();

    /**
     * When you're finished with a video frame, call this to allow the media
     * subsystem to deallocate or recycle the frame immediately.
     */
    public void releaseFrame();
}
