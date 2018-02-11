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
 * The listener interface for receiving video renderer events.
 */
public interface VideoRendererListener {
    /**
     * Notifies the listener that a new frame is available for rendering.
     *
     * @param event The event.
     */
    public void videoFrameUpdated(NewFrameEvent event);

    /**
     * Notifies the listener that it needs to release video frames.
     *
     */
    public void releaseVideoFrames();
}
