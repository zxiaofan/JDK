/*
 * Copyright (c) 1999, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * A {@code Transmitter} sends {@link MidiEvent} objects to one or more
 * {@link Receiver Receivers}. Common MIDI transmitters include sequencers and
 * MIDI input ports.
 *
 * @author Kara Kytle
 * @see Receiver
 */
public interface Transmitter extends AutoCloseable {

    /**
     * Sets the receiver to which this transmitter will deliver MIDI messages.
     * If a receiver is currently set, it is replaced with this one.
     *
     * @param  receiver the desired receiver
     */
    void setReceiver(Receiver receiver);

    /**
     * Obtains the current receiver to which this transmitter will deliver MIDI
     * messages.
     *
     * @return the current receiver. If no receiver is currently set, returns
     *         {@code null}.
     */
    Receiver getReceiver();

    /**
     * Indicates that the application has finished using the transmitter, and
     * that limited resources it requires may be released or made available.
     * <p>
     * If the creation of this {@code Transmitter} resulted in implicitly
     * opening the underlying device, the device is implicitly closed by this
     * method. This is true unless the device is kept open by other
     * {@code Receiver} or {@code Transmitter} instances that opened the device
     * implicitly, and unless the device has been opened explicitly. If the
     * device this {@code Transmitter} is retrieved from is closed explicitly by
     * calling {@link MidiDevice#close MidiDevice.close}, the
     * {@code Transmitter} is closed, too. For a detailed description of
     * open/close behaviour see the class description of
     * {@link MidiDevice MidiDevice}.
     *
     * @see MidiSystem#getTransmitter
     */
    @Override
    void close();
}
