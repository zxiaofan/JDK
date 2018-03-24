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
 * The listener interface for receiving notifications when a marker has been
 * encountered in the media stream.
 */
public interface MarkerListener {
    /**
     * The marker notification indicates a marker, embedded or programmatically inserted, has been
     * reached during playback.
     *
     * @param evt
     */
    public void onMarker(MarkerEvent evt);
}
