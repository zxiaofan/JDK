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

package com.sun.media.jfxmedia.control;

import com.sun.media.jfxmedia.events.VideoFrameRateListener;
import com.sun.media.jfxmedia.events.VideoRendererListener;

/**
 * This interface is supported by the player to support video rendering.
 * It provides methods for registering listeners for getting media frames
 * and a notification mechanism for when new data is available.
 */
public interface VideoRenderControl {
    /**
     * Adds the listener to the player's videoUpdate. The listener
     * will be called whenever a new frame of video is ready to be
     * painted or fetched by getData()
     * @param listener the object which provides the VideoUpdateListener
     * callback interface
     */
    public void addVideoRendererListener(VideoRendererListener listener);

    /**
     * Removes the listener from the player.
     * @param listener to be removed from the player
     */
    public void removeVideoRendererListener(VideoRendererListener listener);

    /**
     * Adds the listener to the player's <code>VideoRenderControl</code>. The
     * listener will be invoked when there is a significant change in the
     * decoded video frame rate.
     *
     * @param listener
     */
    public void addVideoFrameRateListener(VideoFrameRateListener listener);

    /**
     * Remove the listener from the player's <code>VideoRenderControl</code>.
     *
     * @param listener
     */
    public void removeVideoFrameRateListener(VideoFrameRateListener listener);

    /**
     * Gets the width of a video frame
     *
     * @return An integer value for the width.
     */
    public int getFrameWidth();

    /**
     * Gets the height of a video frame
     *
     * @return An integer value for the height.
     */
    public int getFrameHeight();
}
