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
 * Notifications of updates to time-related playback parameters are sent here.
 */
public interface PlayerTimeListener {

    /**
     * Invoked when there is an update to the duration estimate.
     *
     * @param duration the duration in seconds.
     */
    public void onDurationChanged(double duration);
}
