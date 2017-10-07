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

package com.sun.media.jfxmedia.events;

/**
 * Event class for buffering progress notification.
 */
public class BufferProgressEvent extends PlayerEvent {

    private double  duration;
    private long    start;
    private long    stop;
    private long    position;

    /**
     * Constructor. The state is set to
     * {@link PlayerStateEvent.PlayerState#STALLED}
     *
     * @param start Start position of the buffer
     * @param size Total size of the buffer in bytes
     * @param fill Number of bytes loaded
     */
    public BufferProgressEvent(double duration, long start, long stop, long position) {
        this.duration = duration;
        this.start = start;
        this.stop = stop;
        this.position = position;
    }

    public double getDuration()
    {
        return duration;
    }

    /**
     * Get buffer start position in bytes.
     * @return The buffer start position.
     */
    public long getBufferStart()
    {
        return start;
    }

    /**
     * Gets the stop position of the buffer size in bytes.
     *
     * @return The buffer stop position.
     */
    public long getBufferStop()
    {
        return stop;
    }

    /**
     * Get the total bytes loaded in the buffer from the 0 position.
     *
     * @return The number of bytes loaded.
     */
    public long getBufferPosition()
    {
        return position;
    }
}
