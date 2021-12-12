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

import java.util.Comparator;

import javax.sound.midi.Instrument;
import javax.sound.midi.Patch;

/**
 * Instrument comparator class.
 * Used to order instrument by program, bank, percussion.
 *
 * @author Karl Helgason
 */
public final class ModelInstrumentComparator implements Comparator<Instrument> {

    @Override
    public int compare(Instrument arg0, Instrument arg1) {
        Patch p0 = arg0.getPatch();
        Patch p1 = arg1.getPatch();
        int a = p0.getBank() * 128 + p0.getProgram();
        int b = p1.getBank() * 128 + p1.getProgram();
        if (p0 instanceof ModelPatch) {
            a += ((ModelPatch)p0).isPercussion() ? 2097152 : 0;
        }
        if (p1 instanceof ModelPatch) {
            b += ((ModelPatch)p1).isPercussion() ? 2097152 : 0;
        }
        return a - b;
    }
}
