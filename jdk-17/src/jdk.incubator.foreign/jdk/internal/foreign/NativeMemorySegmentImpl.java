/*
 *  Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.internal.misc.Unsafe;
import jdk.internal.misc.VM;
import jdk.internal.vm.annotation.ForceInline;
import sun.security.action.GetBooleanAction;

import java.nio.ByteBuffer;

/**
 * Implementation for native memory segments. A native memory segment is essentially a wrapper around
 * a native long address.
 */
public class NativeMemorySegmentImpl extends AbstractMemorySegmentImpl {

    public static final MemorySegment EVERYTHING = makeNativeSegmentUnchecked(MemoryAddress.NULL, Long.MAX_VALUE, null, ResourceScopeImpl.GLOBAL);

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static final SegmentAllocator IMPLICIT_ALLOCATOR = (size, align) -> MemorySegment.allocateNative(size, align, ResourceScope.newImplicitScope());

    // The maximum alignment supported by malloc - typically 16 on
    // 64-bit platforms and 8 on 32-bit platforms.
    private static final long MAX_MALLOC_ALIGN = Unsafe.ADDRESS_SIZE == 4 ? 8 : 16;

    private static final boolean skipZeroMemory = GetBooleanAction.privilegedGetProperty("jdk.internal.foreign.skipZeroMemory");

    final long min;

    @ForceInline
    NativeMemorySegmentImpl(long min, long length, int mask, ResourceScopeImpl scope) {
        super(length, mask, scope);
        this.min = min;
    }

    @Override
    NativeMemorySegmentImpl dup(long offset, long size, int mask, ResourceScopeImpl scope) {
        return new NativeMemorySegmentImpl(min + offset, size, mask, scope);
    }

    @Override
    ByteBuffer makeByteBuffer() {
        return nioAccess.newDirectByteBuffer(min(), (int) this.length, null,
                scope == ResourceScopeImpl.GLOBAL ? null : this);
    }

    @Override
    public boolean isNative() {
        return true;
    }

    @Override
    long min() {
        return min;
    }

    @Override
    Object base() {
        return null;
    }

    // factories

    public static MemorySegment makeNativeSegment(long bytesSize, long alignmentBytes, ResourceScopeImpl scope) {
        scope.checkValidStateSlow();
        if (VM.isDirectMemoryPageAligned()) {
            alignmentBytes = Math.max(alignmentBytes, nioAccess.pageSize());
        }
        long alignedSize = alignmentBytes > MAX_MALLOC_ALIGN ?
                bytesSize + (alignmentBytes - 1) :
                bytesSize;

        nioAccess.reserveMemory(alignedSize, bytesSize);

        long buf = unsafe.allocateMemory(alignedSize);
        if (!skipZeroMemory) {
            unsafe.setMemory(buf, alignedSize, (byte)0);
        }
        long alignedBuf = Utils.alignUp(buf, alignmentBytes);
        AbstractMemorySegmentImpl segment = new NativeMemorySegmentImpl(buf, alignedSize,
                defaultAccessModes(alignedSize), scope);
        scope.addOrCleanupIfFail(new ResourceScopeImpl.ResourceList.ResourceCleanup() {
            @Override
            public void cleanup() {
                unsafe.freeMemory(buf);
                nioAccess.unreserveMemory(alignedSize, bytesSize);
            }
        });
        if (alignedSize != bytesSize) {
            long delta = alignedBuf - buf;
            segment = segment.asSlice(delta, bytesSize);
        }
        return segment;
    }

    public static MemorySegment makeNativeSegmentUnchecked(MemoryAddress min, long bytesSize, Runnable cleanupAction, ResourceScopeImpl scope) {
        scope.checkValidStateSlow();
        AbstractMemorySegmentImpl segment = new NativeMemorySegmentImpl(min.toRawLongValue(), bytesSize, defaultAccessModes(bytesSize), scope);
        if (cleanupAction != null) {
            scope.addCloseAction(cleanupAction);
        }
        return segment;
    }
}
