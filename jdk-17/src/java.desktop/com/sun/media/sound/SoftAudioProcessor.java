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
 * Audio processor interface.
 *
 * @author Karl Helgason
 */
public interface SoftAudioProcessor {

    void globalParameterControlChange(int[] slothpath, long param, long value);

    void init(float samplerate, float controlrate);

    void setInput(int pin, SoftAudioBuffer input);

    void setOutput(int pin, SoftAudioBuffer output);

    void setMixMode(boolean mix);

    void processAudio();

    void processControlLogic();
}
