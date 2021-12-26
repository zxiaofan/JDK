/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package java.lang.invoke;

import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.ScopedMemoryAccess;
import jdk.internal.vm.annotation.ForceInline;

import java.lang.ref.Reference;

import java.util.Objects;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

// -- This file was mechanically generated: Do not edit! -- //

final class MemoryAccessVarHandleLongHelper extends MemoryAccessVarHandleBase {

    static final boolean BE = UNSAFE.isBigEndian();

    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    static final int VM_ALIGN = Long.BYTES - 1;

    static final VarForm FORM = new VarForm(MemoryAccessVarHandleLongHelper.class, MemorySegmentProxy.class, long.class, long.class);

    MemoryAccessVarHandleLongHelper(boolean skipAlignmentMaskCheck, boolean be, long length, long alignmentMask, boolean exact) {
        super(FORM, skipAlignmentMaskCheck, be, length, alignmentMask, exact);
    }

    @Override
    final MethodType accessModeTypeUncached(VarHandle.AccessType accessType) {
        return accessType.accessModeType(MemorySegmentProxy.class, long.class, long.class);
    }

    @Override
    public MemoryAccessVarHandleLongHelper withInvokeExactBehavior() {
        return hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleLongHelper(skipAlignmentMaskCheck, be, length, alignmentMask, true);
    }

    @Override
    public MemoryAccessVarHandleLongHelper withInvokeBehavior() {
        return !hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleLongHelper(skipAlignmentMaskCheck, be, length, alignmentMask, false);
    }

    @ForceInline
    static long convEndian(boolean big, long n) {
        return big == BE ? n : Long.reverseBytes(n);
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
    static long get(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return SCOPED_MEMORY_ACCESS.getLongUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                handle.be);
    }

    @ForceInline
    static void set(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                value,
                handle.be);
    }

    @ForceInline
    static long getVolatile(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getLongVolatile(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongVolatile(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static long getAcquire(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getLongAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static long getOpaque(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getLongOpaque(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putLongOpaque(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static boolean compareAndSet(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.compareAndSetLong(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static long compareAndExchange(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeLong(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static long compareAndExchangeAcquire(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeLongAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static long compareAndExchangeRelease(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeLongRelease(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static boolean weakCompareAndSetPlain(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongPlain(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSet(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetAcquire(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongAcquire(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetRelease(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static long getAndSet(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetLong(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static long getAndSetAcquire(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetLongAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static long getAndSetRelease(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetLongRelease(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static long getAndAdd(VarHandle ob, Object obb, long base, long delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndAddLong(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static long getAndAddAcquire(VarHandle ob, Object obb, long base, long delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndAddLongAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static long getAndAddRelease(VarHandle ob, Object obb, long base, long delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndAddLongRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static long getAndAddConvEndianWithCAS(MemorySegmentProxy bb, long offset, long delta) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getLongVolatile(bb.scope(),base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(bb.scope(),base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue + delta)));
        return expectedValue;
    }

    @ForceInline
    static long getAndBitwiseOr(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseOrLong(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseOrRelease(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseOrLongRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseOrAcquire(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseOrLongAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseOrConvEndianWithCAS(MemorySegmentProxy bb, long offset, long value) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getLongVolatile(bb.scope(),base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(bb.scope(),base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue | value)));
        return expectedValue;
    }

    @ForceInline
    static long getAndBitwiseAnd(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseAndLong(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseAndRelease(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseAndLongRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseAndAcquire(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseAndLongAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseAndConvEndianWithCAS(MemorySegmentProxy bb, long offset, long value) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getLongVolatile(bb.scope(),base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(bb.scope(),base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue & value)));
        return expectedValue;
    }


    @ForceInline
    static long getAndBitwiseXor(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseXorLong(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseXorRelease(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseXorLongRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseXorAcquire(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseXorLongAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseXorConvEndianWithCAS(MemorySegmentProxy bb, long offset, long value) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getLongVolatile(bb.scope(),base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(bb.scope(),base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue ^ value)));
        return expectedValue;
    }
}
