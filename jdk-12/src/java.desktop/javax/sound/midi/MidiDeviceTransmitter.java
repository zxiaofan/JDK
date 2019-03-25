/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.midi;

/**
 * {@code MidiDeviceTransmitter} is a {@code Transmitter} which represents a
 * MIDI input connector of a {@code MidiDevice} (see
 * {@link MidiDevice#getTransmitter()}).
 *
 * @since 1.7
 */
public interface MidiDeviceTransmitter extends Transmitter {

    /**
     * Obtains a {@code MidiDevice} object which is an owner of this
     * {@code Transmitter}.
     *
     * @return a {@code MidiDevice} object which is an owner of this
     *         {@code Transmitter}
     */
    MidiDevice getMidiDevice();
}
