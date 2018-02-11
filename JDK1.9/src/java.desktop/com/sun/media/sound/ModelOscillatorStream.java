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

import java.io.IOException;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.VoiceStatus;

/**
 * This interface is used for audio streams from ModelOscillator.
 *
 * @author Karl Helgason
 */
public interface ModelOscillatorStream {

    void setPitch(float pitch); // Pitch is in cents!

    void noteOn(MidiChannel channel, VoiceStatus voice, int noteNumber,
                int velocity);

    void noteOff(int velocity);

    int read(float[][] buffer, int offset, int len) throws IOException;

    void close() throws IOException;
}
