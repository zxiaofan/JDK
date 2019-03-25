/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Soundfont modulator container.
 *
 * @author Karl Helgason
 */
public final class SF2Modulator {

    public static final int SOURCE_NONE = 0;
    public static final int SOURCE_NOTE_ON_VELOCITY = 2;
    public static final int SOURCE_NOTE_ON_KEYNUMBER = 3;
    public static final int SOURCE_POLY_PRESSURE = 10;
    public static final int SOURCE_CHANNEL_PRESSURE = 13;
    public static final int SOURCE_PITCH_WHEEL = 14;
    public static final int SOURCE_PITCH_SENSITIVITY = 16;
    public static final int SOURCE_MIDI_CONTROL = 128 * 1;
    public static final int SOURCE_DIRECTION_MIN_MAX = 256 * 0;
    public static final int SOURCE_DIRECTION_MAX_MIN = 256 * 1;
    public static final int SOURCE_POLARITY_UNIPOLAR = 512 * 0;
    public static final int SOURCE_POLARITY_BIPOLAR = 512 * 1;
    public static final int SOURCE_TYPE_LINEAR = 1024 * 0;
    public static final int SOURCE_TYPE_CONCAVE = 1024 * 1;
    public static final int SOURCE_TYPE_CONVEX = 1024 * 2;
    public static final int SOURCE_TYPE_SWITCH = 1024 * 3;
    public static final int TRANSFORM_LINEAR = 0;
    public static final int TRANSFORM_ABSOLUTE = 2;
    int sourceOperator;
    int destinationOperator;
    short amount;
    int amountSourceOperator;
    int transportOperator;

    public short getAmount() {
        return amount;
    }

    public void setAmount(short amount) {
        this.amount = amount;
    }

    public int getAmountSourceOperator() {
        return amountSourceOperator;
    }

    public void setAmountSourceOperator(int amountSourceOperator) {
        this.amountSourceOperator = amountSourceOperator;
    }

    public int getTransportOperator() {
        return transportOperator;
    }

    public void setTransportOperator(int transportOperator) {
        this.transportOperator = transportOperator;
    }

    public int getDestinationOperator() {
        return destinationOperator;
    }

    public void setDestinationOperator(int destinationOperator) {
        this.destinationOperator = destinationOperator;
    }

    public int getSourceOperator() {
        return sourceOperator;
    }

    public void setSourceOperator(int sourceOperator) {
        this.sourceOperator = sourceOperator;
    }
}
