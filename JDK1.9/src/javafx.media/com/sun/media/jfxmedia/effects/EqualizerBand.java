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
 * EqualizerBand represents a single band in AudioEqualizer.  EqualizerBand can specify the center
 * frequency, bandwidth, and gain on the band.
 *
 * @see AudioEqualizer
 */
public interface EqualizerBand
{
    /**
     * Minimum possible gain.
     */
    public static final double MIN_GAIN = -24.0;

    /**
     * Maximum possible gain.
     */
    public static final double MAX_GAIN = 12.0;

    /**
     * Gets the center frequency of this band.  Half of the bandwidth is to the left of this frequncy
     * and half is to the right.
     *
     * @return float value
     */
    public double getCenterFrequency();

    /**
     * Sets the center frequency of this band.  Half of the bandwidth is to the left of this frequncy
     * and half is to the right.
     *
     * @param centerFrequency float value
     */
    public void setCenterFrequency(double centerFrequency);

    /**
     * Gets the bandwith (of frequencies) of this band.
     *
     * @return float value
     */
    public double getBandwidth();

    /**
     * Sets the bandwidth of this band.
     *
     * @param bandwidth float value
     */
    public void setBandwidth(double bandwidth);

    /**
     * Gets the gain value for this bandwidth.  Gains are in decibels.
     *
     * @return float value for dB
     */
    public double getGain();

    /**
     * Sets the gain value for this bandwidth.  Gains are in decibels.
     *
     * @param gain float value in dB
     * @throws IllegalArgumentException if <code>gain</code> is outside of the
     * platform possible range. For example GStreamer based equalizer gain values
     * must be in [-24.0; 12.0] interval.
     */
    public void setGain(double gain);
}
