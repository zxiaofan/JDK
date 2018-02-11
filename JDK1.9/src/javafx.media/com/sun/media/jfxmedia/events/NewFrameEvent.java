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

import com.sun.media.jfxmedia.control.VideoDataBuffer;

/**
 * Event indicating that a new video frame has been decoded.
 */
public class NewFrameEvent extends PlayerEvent {

    private VideoDataBuffer frameData;

    /**
     * The constructor for the <code>VideoDataBuffer</code>.
     *
     * @param buffer The video frame.
     * @throws IllegalArgumentException if <code>buffer</code> is
     * <code>null</code>.
     */
    public NewFrameEvent(VideoDataBuffer buffer) {
        if (buffer == null) {
            throw new IllegalArgumentException("buffer == null!");
        }
        frameData = buffer;
    }

    /**
     * The video buffer.
     *
     * @return The event's data.
     */
    public VideoDataBuffer getFrameData() {
        return frameData;
    }
}
