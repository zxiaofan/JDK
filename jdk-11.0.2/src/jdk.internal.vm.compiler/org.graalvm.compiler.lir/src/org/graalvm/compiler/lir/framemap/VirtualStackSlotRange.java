/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.lir.framemap;

import java.util.BitSet;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.VirtualStackSlot;

import jdk.vm.ci.code.TargetDescription;

/**
 * Represents a {@link #getSlots() numbered} range of {@link VirtualStackSlot virtual stack slot} of
 * size {@link TargetDescription#wordSize}.
 */
public class VirtualStackSlotRange extends VirtualStackSlot {

    private final BitSet objects;
    private final int slots;

    public VirtualStackSlotRange(int id, int slots, BitSet objects, LIRKind kind) {
        super(id, kind);
        this.slots = slots;
        this.objects = (BitSet) objects.clone();
    }

    public int getSlots() {
        return slots;
    }

    public BitSet getObjects() {
        return (BitSet) objects.clone();
    }

}
