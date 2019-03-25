/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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
import javax.sound.sampled.Mixer.Info;
import javax.sound.sampled.spi.MixerProvider;

/**
 * Provider for software audio mixer.
 *
 * @author Karl Helgason
 */
public final class SoftMixingMixerProvider extends MixerProvider {

    static SoftMixingMixer globalmixer = null;

    static Thread lockthread = null;

    static final Object mutex = new Object();

    @Override
    public Mixer getMixer(Info info) {
        if (!(info == null || info == SoftMixingMixer.info)) {
            throw new IllegalArgumentException("Mixer " + info.toString()
                    + " not supported by this provider.");
        }
        synchronized (mutex) {
            if (lockthread != null)
                if (Thread.currentThread() == lockthread)
                    throw new IllegalArgumentException("Mixer "
                            + info.toString()
                            + " not supported by this provider.");
            if (globalmixer == null)
                globalmixer = new SoftMixingMixer();
            return globalmixer;
        }
    }

    @Override
    public Info[] getMixerInfo() {
        return new Info[] { SoftMixingMixer.info };
    }
}
