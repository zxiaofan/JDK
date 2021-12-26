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

final class MemoryAccessVarHandleIntHelper extends MemoryAccessVarHandleBase {

    static final boolean BE = UNSAFE.isBigEndian();

    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    static final int VM_ALIGN = Integer.BYTES - 1;

    static final VarForm FORM = new VarForm(MemoryAccessVarHandleIntHelper.class, MemorySegmentProxy.class, int.class, long.class);

    MemoryAccessVarHandleIntHelper(boolean skipAlignmentMaskCheck, boolean be, long length, long alignmentMask, boolean exact) {
        super(FORM, skipAlignmentMaskCheck, be, length, alignmentMask, exact);
    }

    @Override
    final MethodType accessModeTypeUncached(VarHandle.AccessType accessType) {
        return accessType.accessModeType(MemorySegmentProxy.class, int.class, long.class);
    }

    @Override
    public MemoryAccessVarHandleIntHelper withInvokeExactBehavior() {
        return hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleIntHelper(skipAlignmentMaskCheck, be, length, alignmentMask, true);
    }

    @Override
    public MemoryAccessVarHandleIntHelper withInvokeBehavior() {
        return !hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleIntHelper(skipAlignmentMaskCheck, be, length, alignmentMask, false);
    }

    @ForceInline
    static int convEndian(boolean big, int n) {
        return big == BE ? n : Integer.reverseBytes(n);
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
    static int get(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return SCOPED_MEMORY_ACCESS.getIntUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                handle.be);
    }

    @ForceInline
    static void set(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putIntUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                value,
                handle.be);
    }

    @ForceInline
    static int getVolatile(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getIntVolatile(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putIntVolatile(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static int getAcquire(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getIntAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putIntRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static int getOpaque(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getIntOpaque(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putIntOpaque(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static boolean compareAndSet(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.compareAndSetInt(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static int compareAndExchange(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeInt(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static int compareAndExchangeAcquire(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeIntAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static int compareAndExchangeRelease(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.compareAndExchangeIntRelease(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static boolean weakCompareAndSetPlain(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetIntPlain(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSet(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetInt(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetAcquire(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetIntAcquire(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetRelease(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return SCOPED_MEMORY_ACCESS.weakCompareAndSetIntRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static int getAndSet(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetInt(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static int getAndSetAcquire(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetIntAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static int getAndSetRelease(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getAndSetIntRelease(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static int getAndAdd(VarHandle ob, Object obb, long base, int delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndAddInt(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static int getAndAddAcquire(VarHandle ob, Object obb, long base, int delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndAddIntAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static int getAndAddRelease(VarHandle ob, Object obb, long base, int delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndAddIntRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static int getAndAddConvEndianWithCAS(MemorySegmentProxy bb, long offset, int delta) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(bb.scope(),base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetInt(bb.scope(),base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue + delta)));
        return expectedValue;
    }

    @ForceInline
    static int getAndBitwiseOr(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseOrInt(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseOrRelease(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseOrIntRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseOrAcquire(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseOrIntAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseOrConvEndianWithCAS(MemorySegmentProxy bb, long offset, int value) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(bb.scope(),base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetInt(bb.scope(),base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue | value)));
        return expectedValue;
    }

    @ForceInline
    static int getAndBitwiseAnd(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseAndInt(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseAndRelease(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseAndIntRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseAndAcquire(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseAndIntAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseAndConvEndianWithCAS(MemorySegmentProxy bb, long offset, int value) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(bb.scope(),base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetInt(bb.scope(),base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue & value)));
        return expectedValue;
    }


    @ForceInline
    static int getAndBitwiseXor(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseXorInt(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseXorRelease(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseXorIntRelease(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseXorAcquire(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return SCOPED_MEMORY_ACCESS.getAndBitwiseXorIntAcquire(bb.scope(),
                    bb.unsafeGetBase(),
                    offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseXorConvEndianWithCAS(MemorySegmentProxy bb, long offset, int value) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(bb.scope(),base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!SCOPED_MEMORY_ACCESS.weakCompareAndSetInt(bb.scope(),base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue ^ value)));
        return expectedValue;
    }
}
