/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.effect;

/**
 *  Dirty bits for the Effect class
 */
public enum EffectDirtyBits {
    // flag which tells that the effect needs to be synchronized in next pulse
    EFFECT_DIRTY,

    // "toggle bit", every change of this bit signalizes change of effect bounds
    // This is NOT a dirty flag! Bounds may have changed even if this is 0
    BOUNDS_CHANGED;

    private int mask;

    private EffectDirtyBits() {
        mask = 1 << ordinal();
    }

    public final int getMask() {
        return mask;
    }

    public static boolean isSet(int value, EffectDirtyBits dirtyBit) {
        return (value & dirtyBit.getMask()) != 0;
    }
}
