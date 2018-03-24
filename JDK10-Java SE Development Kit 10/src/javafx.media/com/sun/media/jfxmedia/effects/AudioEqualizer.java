/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmedia.effects;

/**
 * Provides a master audio equalizer with up to 15 bands.  Each band can have the center frequency,
 * bandwidth, and gain set.
 */
public interface AudioEqualizer
{
    /**
     * The maximum number of bands the equalizer can control.
     */
    public static final int MAX_NUM_BANDS = 64;

    /**
     * Returns whether equalization was enabled or not.
     *
     * @return boolean value
     */
    public boolean getEnabled();

    /**
     * Turns on or off audio equalization.
     *
     * @param bEnable boolean value
     */
    public void setEnabled(boolean bEnable);

    /**
     * Adds a band to the equalizer.
     *
     * @param centerFrequency
     * @param bandwidth
     * @param gain
     * @return instance of EqualizerBand if the band was added, null if a band with the
     * <code>centerFrequency</code> already exists.
     * @throws IllegalArgumentException if <code>centerFrequency</code> or <code>bandwidth</code> are < 0.0.
     */
    public EqualizerBand addBand(double centerFrequency, double bandwidth, double gain);

    /**
     * Removes an equalizer band with the specified center frequency.
     *
     * @param centerFrequency
     * @return true if the band was found and removed.  false otherwise
     * @throws IllegalArgumentException if <code>centerFrequency</code> is
     * negative.
     */
    public boolean removeBand(double centerFrequency);
}
