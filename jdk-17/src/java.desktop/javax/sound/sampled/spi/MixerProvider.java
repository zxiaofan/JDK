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

package javax.sound.sampled.spi;

import java.util.Arrays;

import javax.sound.sampled.Mixer;

/**
 * A provider or factory for a particular mixer type. This mechanism allows the
 * implementation to determine how resources are managed in creation /
 * management of a mixer.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public abstract class MixerProvider {

    /**
     * Constructor for subclasses to call.
     */
    protected MixerProvider() {}

    /**
     * Indicates whether the mixer provider supports the mixer represented by
     * the specified mixer info object.
     * <p>
     * The full set of mixer info objects that represent the mixers supported by
     * this {@code MixerProvider} may be obtained through the
     * {@code getMixerInfo} method.
     *
     * @param  info an info object that describes the mixer for which support is
     *         queried
     * @return {@code true} if the specified mixer is supported, otherwise
     *         {@code false}
     * @throws NullPointerException if {@code info} is {@code null}
     * @see #getMixerInfo()
     */
    public boolean isMixerSupported(final Mixer.Info info) {
        return Arrays.stream(getMixerInfo()).anyMatch(info::equals);
    }

    /**
     * Obtains the set of info objects representing the mixer or mixers provided
     * by this MixerProvider.
     * <p>
     * The {@code isMixerSupported} method returns {@code true} for all the info
     * objects returned by this method. The corresponding mixer instances for
     * the info objects are returned by the {@code getMixer} method.
     *
     * @return a set of mixer info objects
     * @see #getMixer(Mixer.Info)
     * @see #isMixerSupported(Mixer.Info)
     */
    public abstract Mixer.Info[] getMixerInfo();

    /**
     * Obtains an instance of the mixer represented by the info object. If
     * {@code null} is passed, then the default mixer will be returned.
     * <p>
     * The full set of the mixer info objects that represent the mixers
     * supported by this {@code MixerProvider} may be obtained through the
     * {@code getMixerInfo} method. Use the {@code isMixerSupported} method to
     * test whether this {@code MixerProvider} supports a particular mixer.
     *
     * @param  info an info object that describes the desired mixer, or
     *         {@code null} for the default mixer
     * @return mixer instance
     * @throws IllegalArgumentException if the info object specified does not
     *         match the info object for a mixer supported by this
     *         {@code MixerProvider}, or if this {@code MixerProvider} does not
     *         have default mixer, but default mixer has been requested
     * @see #getMixerInfo()
     * @see #isMixerSupported(Mixer.Info)
     */
    public abstract Mixer getMixer(Mixer.Info info);
}
