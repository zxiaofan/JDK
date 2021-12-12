/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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
package java.lang.invoke;

import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.ScopedMemoryAccess;
import jdk.internal.vm.annotation.ForceInline;

import java.lang.ref.Reference;

import java.util.Objects;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

// -- This file was mechanically generated: Do not edit! -- //

final class MemoryAccessVarHandleDoubleHelper extends MemoryAccessVarHandleBase {

    static final boolean BE = UNSAFE.isBigEndian();

    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    static final int VM_ALIGN = Double.BYTES - 1;

    static final VarForm FORM = new VarForm(MemoryAccessVarHandleDoubleHelper.class, MemorySegmentProxy.class, double.class, long.class);

    MemoryAccessVarHandleDoubleHelper(boolean skipAlignmentMaskCheck, boolean be, long length, long alignmentMask, boolean exact) {
        super(FORM, skipAlignmentMaskCheck, be, length, alignmentMask, exact);
    }

    @Override
    final MethodType accessModeTypeUncached(VarHandle.AccessType accessType) {
        return accessType.accessModeType(MemorySegmentProxy.class, double.class, long.class);
    }

    @Override
    public MemoryAccessVarHandleDoubleHelper withInvokeExactBehavior() {
        return hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleDoubleHelper(skipAlignmentMaskCheck, be, length, alignmentMask, true);
    }

    @Override
    public MemoryAccessVarHandleDoubleHelper withInvokeBehavior() {
        return !hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleDoubleHelper(skipAlignmentMaskCheck, be, length, alignmentMask, false);
    }

    @ForceInline
    static long convEndian(boolean big, double v) {
        long rv = Double.doubleToRawLongBits(v);
        return big == BE ? rv : Long.reverseBytes(rv);
    }

    @ForceInline
    static double convEndian(boolean big, long rv) {
        rv = big == BE ? rv : Long.reverseBytes(rv);
        return Double.longBitsToDouble(rv);
    }

    @ForceInline
    static MemorySegmentProxy checkAddress(Object obb, long offset, long length, boolean ro) {
        MemorySegmentProxy oo = (MemorySegmentProxy)Objects.requireNonNull(obb);
        oo.checkAccess(offset, length, ro);
        return oo;
    }

    @ForceInline
    static long offset(boolean skipAlignmentMaskCheck, MemorySegmentProxy bb, long offset, long alignmentMask) {
        long address = offsetNoVMAlignCheck(skipAlignmentMaskCheck, bb, offset, alignmentMask);
        if ((address & VM_ALIGN) != 0) {
            throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
        }
        return address;
    }

    @ForceInline
    static long offsetNoVMAlignCheck(boolean skipAlignmentMaskCheck, MemorySegmentProxy bb, long offset, long alignmentMask) {
        long base = bb.unsafeGetOffset();
        long address = base + offset;
        if (skipAlignmentMaskCheck) {
            //note: the offset portion has already been aligned-checked, by construction
            if ((base & alignmentMask) != 0) {
                throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
            }
        } else {
            if ((address & alignmentMask) != 0) {
                throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
            }
        }
        return address;
    }

    @ForceInline
    static double get(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        long rawValue = SCOPED_MEMORY_ACCESS.getLongUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                handle.be);
        return Double.longBitsToDouble(rawValue);
    }

    @ForceInline
    static void set(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                Double.doubleToRawLongBits(value),
                handle.be);
    }

    @ForceInline
    static double getVolatile(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getLongVolatile(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongVolatile(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static double getAcquire(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getLongAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static double getOpaque(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getLongOpaque(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongOpaque(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static boolean compareAndSet(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.compareAndSetLong(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static double compareAndExchange(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeLong(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static double compareAndExchangeAcquire(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeLongAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static double compareAndExchangeRelease(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeLongRelease(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static boolean weakCompareAndSetPlain(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongPlain(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSet(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetAcquire(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongAcquire(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetRelease(VarHandle ob, Object obb, long base, double expected, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static double getAndSet(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetLong(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static double getAndSetAcquire(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetLongAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static double getAndSetRelease(VarHandle ob, Object obb, long base, double value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetLongRelease(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }
}
