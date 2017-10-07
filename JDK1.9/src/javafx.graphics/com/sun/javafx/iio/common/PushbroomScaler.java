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

import java.nio.ByteBuffer;

/**
 * An interface describing an implementation of scaling for sources acquired
 * line-by-line as for a pushbroom scanner.
 */
public interface PushbroomScaler {
    /**
     * Retrieves the destination buffer.
     *
     * @return The destination buffer.
     */
    public ByteBuffer getDestination();

    /**
     * Push one scanline of source pixels into the scaling engine.
     *
     * @param scanline One scanline of source data.
     * @param off The offset into the buffer.
     * @throws IllegalArgumentException if <code>off&nbsp;&lt;&nbsp;0</code>.
     * @return Whether the destination image is complete.
     */
    public boolean putSourceScanline(byte[] scanline, int off);
}
