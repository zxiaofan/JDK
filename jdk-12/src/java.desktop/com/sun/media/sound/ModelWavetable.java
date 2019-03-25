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
 * This is a wavetable oscillator interface.
 *
 * @author Karl Helgason
 */
public interface ModelWavetable extends ModelOscillator {

    int LOOP_TYPE_OFF = 0;
    int LOOP_TYPE_FORWARD = 1;
    int LOOP_TYPE_RELEASE = 2;
    int LOOP_TYPE_PINGPONG = 4;
    int LOOP_TYPE_REVERSE = 8;

    AudioFloatInputStream openStream();

    float getLoopLength();

    float getLoopStart();

    int getLoopType();

    float getPitchcorrection();
}
