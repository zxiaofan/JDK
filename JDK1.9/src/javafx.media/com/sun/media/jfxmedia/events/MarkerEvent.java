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
 * The MarkerEvent is returned on marker notifications to a PlayerStateListener.
 * Markers may be embedded in the media source or programmatically inserted.
 *
 * @see com.sun.media.jfxmedia.Media#addMarker(java.lang.String, double)
 * @see com.sun.media.jfxmedia.events.PlayerStateListener
 */
public class MarkerEvent extends PlayerEvent
{
    private String markerName;
    private double presentationTime;

    /** Constructor.
     *
     * @param name The name of the marker.
     * @param time The presentation (stream) time of the marker.
     * @throws IllegalArgumentException if <code>name</code> is <code>null</code>
     * or <code>time&lt;0.0</code>.
     */
    public MarkerEvent(String name, double time) {
        if (name == null) {
            throw new IllegalArgumentException("name == null!");
        } else if (time < 0.0) {
            throw new IllegalArgumentException("time < 0.0!");
        }

        this.markerName = name;
        this.presentationTime = time;
    }

    /**
     * Returns the marker name.
     *
     * @return The marker name
     */
    public String getMarkerName()
    {
        return this.markerName;
    }

    /**
     * Returns the presentation time of the Marker.
     *
     * @return The marker time
     */
    public double getPresentationTime()
    {
        return this.presentationTime;
    }
}
