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

import com.sun.media.jfxmedia.effects.AudioEqualizer;
import com.sun.media.jfxmedia.effects.EqualizerBand;

final class NativeAudioEqualizer implements AudioEqualizer {
    /**
     * Handle to the native equalizer.
     */
    private final long nativeRef;

    //**************************************************************************
    //***** Constructors
    //**************************************************************************

    /**
     * Constructor.
     * @param nativeRef A reference to the native component.
     */
    NativeAudioEqualizer(long nativeRef) {
        if (nativeRef == 0) {
            throw new IllegalArgumentException("Invalid native media reference");
        }

        this.nativeRef = nativeRef;
    }

    //**************************************************************************
    //***** Public functions
    //**************************************************************************

    @Override
    public boolean getEnabled() {
        return nativeGetEnabled(nativeRef);
    }

    @Override
    public void setEnabled(boolean enable) {
        nativeSetEnabled(nativeRef, enable);
    }

    @Override
    public EqualizerBand addBand(double centerFrequency, double bandwidth, double gain) {
        return (nativeGetNumBands(nativeRef) >= MAX_NUM_BANDS &&
                gain >= EqualizerBand.MIN_GAIN && gain <= EqualizerBand.MAX_GAIN) ?
                null : nativeAddBand(nativeRef, centerFrequency, bandwidth, gain);
    }

    @Override
    public boolean removeBand(double centerFrequency) {
        return (centerFrequency > 0) ? nativeRemoveBand(nativeRef, centerFrequency) : false;
    }

    //**************************************************************************
    //***** JNI methods
    //**************************************************************************
    private native boolean nativeGetEnabled(long nativeRef);
    private native void nativeSetEnabled(long nativeRef, boolean enable);
    private native int nativeGetNumBands(long nativeRef);
    private native EqualizerBand nativeAddBand(long nativeRef,
                                               double centerFrequency, double bandwidth,
                                               double gain);
    private native boolean nativeRemoveBand(long nativeRef, double centerFrequency);
}
