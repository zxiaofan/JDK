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

import javax.sound.midi.MidiChannel;

/**
 * ModelChannelMixer is used to process channel voice mix output before going
 * to master output.<br>
 * It can be used to:<br>
 * <ul>
 *   <li>Implement non-voice oriented instruments.</li>
 *   <li>Add insert effect to instruments; for example distortion effect.</li>
 * </ui>
 * <p>
 * <b>Warning! Classes that implements ModelChannelMixer must be thread-safe.</b>
 *
 * @author Karl Helgason
 */
public interface ModelChannelMixer extends MidiChannel {

    // Used to process input audio from voices mix.
    boolean process(float[][] buffer, int offset, int len);

    // Is used to trigger that this mixer is not be used
    // and it should fade out.
    void stop();
}
