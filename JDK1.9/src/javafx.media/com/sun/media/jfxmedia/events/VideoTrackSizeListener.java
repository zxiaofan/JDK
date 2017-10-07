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
 * The listener interface for receiving notifications that the video frame
 * dimensions have changed.
 */
public interface VideoTrackSizeListener {

    /**
     * The size notification indicates the dimension of the video has changed.
     *
     * @param width The new width of the video frames.
     * @param height The new height of the video frames.
     */
    public void onSizeChanged(int width, int height);

}
