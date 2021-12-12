/*
 * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
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

import javax.sound.midi.MidiDevice;

/**
 * MIDI output device provider.
 *
 * @author Kara Kytle
 * @author Florian Bomers
 */
public final class MidiOutDeviceProvider extends AbstractMidiDeviceProvider {

    /** Cache of info objects for all MIDI output devices on the system. */
    private static Info[] infos = null;

    /** Cache of open MIDI output devices on the system. */
    private static MidiDevice[] devices = null;

    private static final boolean enabled;

    static {
        // initialize
        Platform.initialize();
        enabled = Platform.isMidiIOEnabled();
    }

    /**
     * Required public no-arg constructor.
     */
    public MidiOutDeviceProvider() {
    }

    @Override
    AbstractMidiDeviceProvider.Info createInfo(int index) {
        if (!enabled) {
            return null;
        }
        return new MidiOutDeviceInfo(index, MidiOutDeviceProvider.class);
    }

    @Override
    MidiDevice createDevice(AbstractMidiDeviceProvider.Info info) {
        if (enabled && (info instanceof MidiOutDeviceInfo)) {
            return new MidiOutDevice(info);
        }
        return null;
    }

    @Override
    int getNumDevices() {
        if (!enabled) {
            return 0;
        }
        return nGetNumDevices();
    }

    @Override
    MidiDevice[] getDeviceCache() { return devices; }
    @Override
    void setDeviceCache(MidiDevice[] devices) { MidiOutDeviceProvider.devices = devices; }
    @Override
    Info[] getInfoCache() { return infos; }
    @Override
    void setInfoCache(Info[] infos) { MidiOutDeviceProvider.infos = infos; }

    /**
     * Info class for MidiOutDevices.  Adds the
     * provider's Class to keep the provider class from being
     * unloaded.  Otherwise, at least on JDK1.1.7 and 1.1.8,
     * the provider class can be unloaded.  Then, then the provider
     * is next invoked, the static block is executed again and a new
     * instance of the device object is created.  Even though the
     * previous instance may still exist and be open / in use / etc.,
     * the new instance will not reflect that state...
     */
    static final class MidiOutDeviceInfo extends AbstractMidiDeviceProvider.Info {
        private final Class<?> providerClass;

        private MidiOutDeviceInfo(int index, Class<?> providerClass) {
            super(nGetName(index), nGetVendor(index), nGetDescription(index), nGetVersion(index), index);
            this.providerClass = providerClass;
        }

    } // class MidiOutDeviceInfo

    private static native int nGetNumDevices();
    private static native String nGetName(int index);
    private static native String nGetVendor(int index);
    private static native String nGetDescription(int index);
    private static native String nGetVersion(int index);
}
