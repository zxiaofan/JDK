/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.stackslotalloc;

import org.graalvm.compiler.debug.CounterKey;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.lir.VirtualStackSlot;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;

import jdk.vm.ci.code.StackSlot;

/**
 * A stack slot allocator is responsible for translating {@link VirtualStackSlot virtual} stack
 * slots into {@link StackSlot real} stack slots. This includes changing all occurrences of
 * {@link VirtualStackSlot} in the {@link LIRGenerationResult#getLIR() LIR} to {@link StackSlot}.
 */
public final class StackSlotAllocatorUtil {
    /**
     * The number of allocated stack slots.
     */
    public static CounterKey allocatedSlots = DebugContext.counter("StackSlotAllocator[allocatedSlots]");
    /**
     * The number of reused stack slots.
     */
    public static CounterKey reusedSlots = DebugContext.counter("StackSlotAllocator[reusedSlots]");
    /**
     * The size (in bytes) required for all allocated stack slots. Note that this number corresponds
     * to the actual frame size and might include alignment.
     */
    public static CounterKey allocatedFramesize = DebugContext.counter("StackSlotAllocator[AllocatedFramesize]");
    /** The size (in bytes) required for all virtual stack slots. */
    public static CounterKey virtualFramesize = DebugContext.counter("StackSlotAllocator[VirtualFramesize]");
}
