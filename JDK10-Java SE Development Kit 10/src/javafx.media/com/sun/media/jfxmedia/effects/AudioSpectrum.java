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

public interface AudioSpectrum {
    /**
     * Returns whether audio spectrum is enabled or not.
     *
     * @return boolean value
     */
    public boolean getEnabled();

    /**
     * Turns on or off audio spectrum support.
     *
     * @param enable boolean value
     */
    public void setEnabled(boolean enabled);

    /**
     * Gets the number of bands in the audio spectrum
     *
     * @return int value
     */
    public int getBandCount();

    /**
     * Sets the number of bands in the audio spectrum
     *
     * @param bands integer value
     */
    public void setBandCount(int bands);

    /**
     * Returns the interval between <code>AudioSpectrumEvent<code>s in seconds.
     *
     * @return double value
     */
    public double getInterval();

    /**
     * Set the interval between <code>AudioSpectrumEvent<code>s in seconds.
     *
     * @param interval double value
     */
    public void setInterval(double interval);

    /**
     * Returns sensitivity threshold in dB. All lower values will be set to this.
     *
     * @return int value
     */
    public int getSensitivityThreshold();

    /**
     * Sets sensitivity threshold in dB. All lower values will be set to this.
     * Allowed values: <= 0
     *
     * @param threshold int value
     */
    public void setSensitivityThreshold(int threshold);

    /**
     * Returns an array of the last available magnitudes. The size of the array equals
     * the number of bands set by the {@link #setBandCount(int) setBandCount(int)} method.
     * A newly created array contains {@link Float#NEGATIVE_INFINITY Float.NEGATIVE_INFINITY}
     * values. When the number of bands is 0 this method returns an empty array.
     * If a non-null array large enough to hold the values is passed in, it will
     * be used; otherwise a newly allocated array will be returned.
     *
     * @param magnitudes An optionally preallocated double array.
     * @return array of float values.
     */
    public float[] getMagnitudes(float[] magnitudes);

    /**
     * Returns an array of the last available phases. The size of the array equals
     * the number of bands set by the {@link #setBandCount(int) setBandCount(int)}
     * method. A newly created array contains 0.0 values. When the number of bands
     * is 0 this method returns an empty array. If a non-null array large enough
     * to hold the values is passed in, it will be used; otherwise a newly
     * allocated array will be returned.
     *
     * @param phases An optionally preallocated double array.
     * @return array of float values.
     */
    public float[] getPhases(float[] phases);
}
