/*
 *  Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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

import jdk.incubator.foreign.*;
import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.VM;
import sun.invoke.util.Wrapper;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.util.Optional;
import java.util.function.Supplier;

import static sun.security.action.GetPropertyAction.*;

/**
 * This class contains misc helper functions to support creation of memory segments.
 */
public final class Utils {
    // used when testing invoke exact behavior of memory access handles
    private static final boolean SHOULD_ADAPT_HANDLES
        = Boolean.parseBoolean(privilegedGetProperty("jdk.internal.foreign.SHOULD_ADAPT_HANDLES", "true"));

    private static final MethodHandle SEGMENT_FILTER;
    public static final MethodHandle MH_bitsToBytesOrThrowForOffset;

    public static final Supplier<RuntimeException> bitsToBytesThrowOffset
        = () -> new UnsupportedOperationException("Cannot compute byte offset; bit offset is not a multiple of 8");

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            SEGMENT_FILTER = lookup.findStatic(Utils.class, "filterSegment",
                    MethodType.methodType(MemorySegmentProxy.class, MemorySegment.class));
            MH_bitsToBytesOrThrowForOffset = MethodHandles.insertArguments(
                lookup.findStatic(Utils.class, "bitsToBytesOrThrow",
                    MethodType.methodType(long.class, long.class, Supplier.class)),
                1,
                bitsToBytesThrowOffset);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static long alignUp(long n, long alignment) {
        return (n + alignment - 1) & -alignment;
    }

    public static MemoryAddress alignUp(MemoryAddress ma, long alignment) {
        long offset = ma.toRawLongValue();
        return ma.addOffset(alignUp(offset, alignment) - offset);
    }

    public static MemorySegment alignUp(MemorySegment ms, long alignment) {
        long offset = ms.address().toRawLongValue();
        return ms.asSlice(alignUp(offset, alignment) - offset);
    }

    public static long bitsToBytesOrThrow(long bits, Supplier<RuntimeException> exFactory) {
        if (bits % 8 == 0) {
            return bits / 8;
        } else {
            throw exFactory.get();
        }
    }

    public static VarHandle fixUpVarHandle(VarHandle handle) {
        // This adaptation is required, otherwise the memory access var handle will have type MemorySegmentProxy,
        // and not MemorySegment (which the user expects), which causes performance issues with asType() adaptations.
        return SHOULD_ADAPT_HANDLES
            ? MemoryHandles.filterCoordinates(handle, 0, SEGMENT_FILTER)
            : handle;
    }

    private static MemorySegmentProxy filterSegment(MemorySegment segment) {
        return (AbstractMemorySegmentImpl)segment;
    }

    public static void checkPrimitiveCarrierCompat(Class<?> carrier, MemoryLayout layout) {
        checkLayoutType(layout, ValueLayout.class);
        if (!isValidPrimitiveCarrier(carrier))
            throw new IllegalArgumentException("Unsupported carrier: " + carrier);
        if (Wrapper.forPrimitiveType(carrier).bitWidth() != layout.bitSize())
            throw new IllegalArgumentException("Carrier size mismatch: " + carrier + " != " + layout);
    }

    public static boolean isValidPrimitiveCarrier(Class<?> carrier) {
        return carrier == byte.class
            || carrier == short.class
            || carrier == char.class
            || carrier == int.class
            || carrier == long.class
            || carrier == float.class
            || carrier == double.class;
    }

    public static void checkLayoutType(MemoryLayout layout, Class<? extends MemoryLayout> layoutType) {
        if (!layoutType.isInstance(layout))
            throw new IllegalArgumentException("Expected a " + layoutType.getSimpleName() + ": " + layout);
    }
}
