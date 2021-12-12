/*
 * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.midi.spi;

import java.util.Arrays;

import javax.sound.midi.MidiDevice;

/**
 * A {@code MidiDeviceProvider} is a factory or provider for a particular type
 * of MIDI device. This mechanism allows the implementation to determine how
 * resources are managed in the creation and management of a device.
 *
 * @author Kara Kytle
 */
public abstract class MidiDeviceProvider {

    /**
     * Constructor for subclasses to call.
     */
    protected MidiDeviceProvider() {}

    /**
     * Indicates whether the device provider supports the device represented by
     * the specified device info object.
     *
     * @param  info an info object that describes the device for which support
     *         is queried
     * @return {@code true} if the specified device is supported, otherwise
     *         {@code false}
     * @throws NullPointerException if {@code info} is {@code null}
     */
    public boolean isDeviceSupported(final MidiDevice.Info info) {
        return Arrays.stream(getDeviceInfo()).anyMatch(info::equals);
    }

    /**
     * Obtains the set of info objects representing the device or devices
     * provided by this {@code MidiDeviceProvider}.
     *
     * @return set of device info objects
     */
    public abstract MidiDevice.Info[] getDeviceInfo();

    /**
     * Obtains an instance of the device represented by the info object.
     *
     * @param  info an info object that describes the desired device
     * @return device instance
     * @throws IllegalArgumentException if the info object specified does not
     *         match the info object for a device supported by this
     *         {@code MidiDeviceProvider}
     * @throws NullPointerException if {@code info} is {@code null}
     */
    public abstract MidiDevice getDevice(MidiDevice.Info info);
}
