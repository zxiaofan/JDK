/*
 *  Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
 *
 */
package jdk.internal.foreign;

import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.internal.foreign.abi.SharedUtils;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;

public abstract non-sealed class AbstractCLinker implements CLinker {

    public final MethodHandle downcallHandle(Addressable symbol, MethodType type, FunctionDescriptor function) {
        SharedUtils.checkSymbol(symbol);
        return MethodHandles.insertArguments(downcallHandle(type, function), 0, symbol);
    }

    public final MethodHandle downcallHandle(Addressable symbol, SegmentAllocator allocator, MethodType type, FunctionDescriptor function) {
        SharedUtils.checkSymbol(symbol);
        Objects.requireNonNull(allocator);
        MethodHandle downcall = MethodHandles.insertArguments(downcallHandle(type, function), 0, symbol);
        if (type.returnType().equals(MemorySegment.class)) {
            downcall = MethodHandles.insertArguments(downcall, 0, allocator);
        }
        return downcall;
    }
}
