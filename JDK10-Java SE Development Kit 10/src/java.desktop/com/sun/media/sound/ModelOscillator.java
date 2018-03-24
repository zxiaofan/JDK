/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

/**
 * This interface is used for oscillators.
 * See example in ModelDefaultOscillator which is a wavetable oscillator.
 *
 * @author Karl Helgason
 */
public interface ModelOscillator {

    int getChannels();

    /**
     * Attenuation is in cB.
     * @return
     */
    float getAttenuation();

    ModelOscillatorStream open(float samplerate);
}
