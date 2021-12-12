/*
 * Copyright (c) 2002, 2019, Oracle and/or its affiliates. All rights reserved.
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

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.SysexMessage;

/**
 * optimized FastSysexMessage that doesn't copy the array upon instantiation.
 *
 * @author Florian Bomers
 */
final class FastSysexMessage extends SysexMessage {

    FastSysexMessage(byte[] data) throws InvalidMidiDataException {
        super(data);
        MidiUtils.checkSysexStatus(data, data.length);
    }

    /**
     * The returned array may be larger than this message is.
     * Use getLength() to get the real length of the message.
     */
    byte[] getReadOnlyMessage() {
        return data;
    }

    // overwrite this method so that the original data array,
    // which is shared among all transmitters, cannot be modified
    @Override
    public void setMessage(byte[] data, int length) throws InvalidMidiDataException {
        MidiUtils.checkSysexStatus(data, length);
        this.length = length;
        this.data = new byte[this.length];
        System.arraycopy(data, 0, this.data, 0, length);
    }

} // class FastSysexMessage
