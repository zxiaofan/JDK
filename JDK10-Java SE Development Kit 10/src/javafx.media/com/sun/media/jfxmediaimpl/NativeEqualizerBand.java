/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmediaimpl;

import com.sun.media.jfxmedia.effects.EqualizerBand;

final class NativeEqualizerBand implements EqualizerBand {

    private final long bandRef; // Native band backend

    private NativeEqualizerBand(long bandRef) {
        if (bandRef != 0) {
            this.bandRef = bandRef;
        } else {
            throw new IllegalArgumentException("bandRef == 0");
        }
    }

    @Override
    public double getCenterFrequency() {
        return nativeGetCenterFrequency(bandRef);
    }

    @Override
    public void setCenterFrequency(double centerFrequency) {
        nativeSetCenterFrequency(bandRef, centerFrequency);
    }

    @Override
    public double getBandwidth() {
        return nativeGetBandwidth(bandRef);
    }

    @Override
    public void setBandwidth(double bandwidth) {
        nativeSetBandwidth(bandRef, bandwidth);
    }

    @Override
    public double getGain() {
        return nativeGetGain(bandRef);
    }

    @Override
    public void setGain(double gain) {
        if (gain >= MIN_GAIN && gain <= MAX_GAIN) {
            nativeSetGain(bandRef, gain);
        }
    }

    //**************************************************************************
    //***** JNI methods
    //**************************************************************************
    private native double nativeGetCenterFrequency(long bandRef);
    private native void   nativeSetCenterFrequency(long bandRef, double centerFrequency);
    private native double nativeGetBandwidth(long bandRef);
    private native void   nativeSetBandwidth(long bandRef, double bandwidth);
    private native double nativeGetGain(long bandRef);
    private native void   nativeSetGain(long bandRef, double gain);
}
