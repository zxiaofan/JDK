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

import com.sun.media.jfxmedia.effects.AudioSpectrum;

public class AudioSpectrumEvent extends PlayerEvent {
    private AudioSpectrum source;
    private double        timestamp;
    private double        duration;

    public AudioSpectrumEvent(AudioSpectrum source, double timestamp, double duration) {
        this.source = source;
        this.timestamp = timestamp;
        this.duration = duration;
    }

    public final AudioSpectrum getSource() {
        return source;
    }

    public final double getTimestamp() {
        return timestamp;
    }

    public final double getDuration() {
        return duration;
    }
}
