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

import jdk.internal.access.foreign.MemoryAddressProxy;
import jdk.internal.vm.annotation.ForceInline;

import java.util.Objects;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

// -- This file was mechanically generated: Do not edit! -- //

final class MemoryAccessVarHandleIntHelper {

    static final boolean BE = UNSAFE.isBigEndian();

    static final int VM_ALIGN = Integer.BYTES - 1;

    @ForceInline
    static int convEndian(boolean big, int n) {
        return big == BE ? n : Integer.reverseBytes(n);
    }

    @ForceInline
    static MemoryAddressProxy checkAddress(Object obb, long offset, long length, boolean ro) {
        MemoryAddressProxy oo = (MemoryAddressProxy)Objects.requireNonNull(obb);
        oo.checkAccess(offset, length, ro);
        return oo;
    }
    
    @ForceInline
    static long offset(MemoryAddressProxy bb, long offset, long alignmentMask) {
        long address = offsetNoVMAlignCheck(bb, offset, alignmentMask);
        if ((address & VM_ALIGN) != 0) {
            throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
        }
        return address;
    }

    @ForceInline
    static long offsetNoVMAlignCheck(MemoryAddressProxy bb, long offset, long alignmentMask) {
        long base = bb.unsafeGetOffset();
        long address = base + offset;
        //note: the offset portion has already been aligned-checked, by construction
        if ((base & alignmentMask) != 0) {
            throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
        }
        return address;
    }
    
    @ForceInline
    static int get0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return UNSAFE.getIntUnaligned(
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(bb, base, handle.alignmentMask),
                handle.be);
    }

    @ForceInline
    static void set0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putIntUnaligned(
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(bb, base, handle.alignmentMask),
                value,
                handle.be);
    }

    @ForceInline
    static int getVolatile0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getIntVolatile(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putIntVolatile(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static int getAcquire0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getIntAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putIntRelease(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static int getOpaque0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getIntOpaque(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putIntOpaque(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static boolean compareAndSet0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.compareAndSetInt(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static int compareAndExchange0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.compareAndExchangeInt(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static int compareAndExchangeAcquire0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.compareAndExchangeIntAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static int compareAndExchangeRelease0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.compareAndExchangeIntRelease(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static boolean weakCompareAndSetPlain0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetIntPlain(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSet0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetInt(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetAcquire0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetIntAcquire(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetRelease0(VarHandle ob, Object obb, long base, int expected, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetIntRelease(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static int getAndSet0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.getAndSetInt(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static int getAndSetAcquire0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.getAndSetIntAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static int getAndSetRelease0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.getAndSetIntRelease(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static int getAndAdd0(VarHandle ob, Object obb, long base, int delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndAddInt(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static int getAndAddAcquire0(VarHandle ob, Object obb, long base, int delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndAddIntAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static int getAndAddRelease0(VarHandle ob, Object obb, long base, int delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndAddIntRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static int getAndAddConvEndianWithCAS(MemoryAddressProxy bb, long offset, int delta) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getIntVolatile(base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue + delta)));
        return expectedValue;
    }

    @ForceInline
    static int getAndBitwiseOr0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseOrInt(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseOrRelease0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseOrIntRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseOrAcquire0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseOrIntAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseOrConvEndianWithCAS(MemoryAddressProxy bb, long offset, int value) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getIntVolatile(base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue | value)));
        return expectedValue;
    }

    @ForceInline
    static int getAndBitwiseAnd0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseAndInt(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseAndRelease0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseAndIntRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseAndAcquire0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseAndIntAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseAndConvEndianWithCAS(MemoryAddressProxy bb, long offset, int value) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getIntVolatile(base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue & value)));
        return expectedValue;
    }


    @ForceInline
    static int getAndBitwiseXor0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseXorInt(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseXorRelease0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseXorIntRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseXorAcquire0(VarHandle ob, Object obb, long base, int value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseXorIntAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static int getAndBitwiseXorConvEndianWithCAS(MemoryAddressProxy bb, long offset, int value) {
        int nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getIntVolatile(base, offset);
            expectedValue = Integer.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                nativeExpectedValue, Integer.reverseBytes(expectedValue ^ value)));
        return expectedValue;
    }
}
