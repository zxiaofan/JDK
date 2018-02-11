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
 * A listener interface for monitoring the video frame rate.
 */
public interface VideoFrameRateListener {
    /**
     * The video frame rate in frames per second.
     *
     * @param videoFrameRate The video frame rate in frames per second.
     */
    public void onFrameRateChanged(double videoFrameRate);
}
