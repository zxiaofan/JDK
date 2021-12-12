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

import javax.sound.sampled.Mixer;
import javax.sound.sampled.spi.MixerProvider;

/**
 * Port provider.
 *
 * @author Florian Bomers
 */
public final class PortMixerProvider extends MixerProvider {

    /**
     * Set of info objects for all port input devices on the system.
     */
    private static PortMixerInfo[] infos;

    /**
     * Set of all port input devices on the system.
     */
    private static PortMixer[] devices;

    static {
        // initialize
        Platform.initialize();
    }

    /**
     * Required public no-arg constructor.
     */
    public PortMixerProvider() {
        synchronized (PortMixerProvider.class) {
            if (Platform.isPortsEnabled()) {
                init();
            } else {
                infos = new PortMixerInfo[0];
                devices = new PortMixer[0];
            }
        }
    }

    private static void init() {
        // get the number of input devices
        int numDevices = nGetNumDevices();

        if (infos == null || infos.length != numDevices) {
            // initialize the arrays
            infos = new PortMixerInfo[numDevices];
            devices = new PortMixer[numDevices];

            // fill in the info objects now.
            // we'll fill in the device objects as they're requested.
            for (int i = 0; i < infos.length; i++) {
                infos[i] = nNewPortMixerInfo(i);
            }
        }
    }

    @Override
    public Mixer.Info[] getMixerInfo() {
        synchronized (PortMixerProvider.class) {
            Mixer.Info[] localArray = new Mixer.Info[infos.length];
            System.arraycopy(infos, 0, localArray, 0, infos.length);
            return localArray;
        }
    }

    @Override
    public Mixer getMixer(Mixer.Info info) {
        synchronized (PortMixerProvider.class) {
            for (int i = 0; i < infos.length; i++) {
                if (infos[i].equals(info)) {
                    return getDevice(infos[i]);
                }
            }
        }
        throw new IllegalArgumentException(
                String.format("Mixer %s not supported by this provider", info));
    }

    private static Mixer getDevice(PortMixerInfo info) {
        int index = info.getIndex();
        if (devices[index] == null) {
            devices[index] = new PortMixer(info);
        }
        return devices[index];
    }

    /**
     * Info class for PortMixers.  Adds an index value for
     * making native references to a particular device.
     * This constructor is called from native.
     */
    static final class PortMixerInfo extends Mixer.Info {
        private final int index;

        private PortMixerInfo(int index, String name, String vendor, String description, String version) {
            super("Port " + name, vendor, description, version);
            this.index = index;
        }

        int getIndex() {
            return index;
        }

    } // class PortMixerInfo

    private static native int nGetNumDevices();
    private static native PortMixerInfo nNewPortMixerInfo(int mixerIndex);
}
