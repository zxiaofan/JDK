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

final class MemoryAccessVarHandleLongHelper {

    static final boolean BE = UNSAFE.isBigEndian();

    static final int VM_ALIGN = Long.BYTES - 1;

    @ForceInline
    static long convEndian(boolean big, long n) {
        return big == BE ? n : Long.reverseBytes(n);
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
    static long get0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return UNSAFE.getLongUnaligned(
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(bb, base, handle.alignmentMask),
                handle.be);
    }

    @ForceInline
    static void set0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putLongUnaligned(
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(bb, base, handle.alignmentMask),
                value,
                handle.be);
    }

    @ForceInline
    static long getVolatile0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getLongVolatile(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putLongVolatile(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static long getAcquire0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getLongAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putLongRelease(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static long getOpaque0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getLongOpaque(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putLongOpaque(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static boolean compareAndSet0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.compareAndSetLong(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static long compareAndExchange0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.compareAndExchangeLong(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static long compareAndExchangeAcquire0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.compareAndExchangeLongAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static long compareAndExchangeRelease0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.compareAndExchangeLongRelease(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, expected), convEndian(handle.be, value)));
    }

    @ForceInline
    static boolean weakCompareAndSetPlain0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetLongPlain(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSet0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetLong(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetAcquire0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetLongAcquire(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static boolean weakCompareAndSetRelease0(VarHandle ob, Object obb, long base, long expected, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return UNSAFE.weakCompareAndSetLongRelease(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, expected), convEndian(handle.be, value));
    }

    @ForceInline
    static long getAndSet0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.getAndSetLong(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static long getAndSetAcquire0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.getAndSetLongAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static long getAndSetRelease0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        return convEndian(handle.be,
                          UNSAFE.getAndSetLongRelease(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask),
                                  convEndian(handle.be, value)));
    }

    @ForceInline
    static long getAndAdd0(VarHandle ob, Object obb, long base, long delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndAddLong(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static long getAndAddAcquire0(VarHandle ob, Object obb, long base, long delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndAddLongAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static long getAndAddRelease0(VarHandle ob, Object obb, long base, long delta) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndAddLongRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    delta);
        } else {
            return getAndAddConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), delta);
        }
    }

    @ForceInline
    static long getAndAddConvEndianWithCAS(MemoryAddressProxy bb, long offset, long delta) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getLongVolatile(base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetLong(base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue + delta)));
        return expectedValue;
    }

    @ForceInline
    static long getAndBitwiseOr0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseOrLong(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseOrRelease0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseOrLongRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseOrAcquire0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseOrLongAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseOrConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseOrConvEndianWithCAS(MemoryAddressProxy bb, long offset, long value) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getLongVolatile(base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetLong(base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue | value)));
        return expectedValue;
    }

    @ForceInline
    static long getAndBitwiseAnd0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseAndLong(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseAndRelease0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseAndLongRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseAndAcquire0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseAndLongAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseAndConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseAndConvEndianWithCAS(MemoryAddressProxy bb, long offset, long value) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getLongVolatile(base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetLong(base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue & value)));
        return expectedValue;
    }


    @ForceInline
    static long getAndBitwiseXor0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseXorLong(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseXorRelease0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseXorLongRelease(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseXorAcquire0(VarHandle ob, Object obb, long base, long value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        if (handle.be == BE) {
            return UNSAFE.getAndBitwiseXorLongAcquire(
                    bb.unsafeGetBase(),
                    offset(bb, base, handle.alignmentMask),
                    value);
        } else {
            return getAndBitwiseXorConvEndianWithCAS(bb, offset(bb, base, handle.alignmentMask), value);
        }
    }

    @ForceInline
    static long getAndBitwiseXorConvEndianWithCAS(MemoryAddressProxy bb, long offset, long value) {
        long nativeExpectedValue, expectedValue;
        Object base = bb.unsafeGetBase();
        do {
            nativeExpectedValue = UNSAFE.getLongVolatile(base, offset);
            expectedValue = Long.reverseBytes(nativeExpectedValue);
        } while (!UNSAFE.weakCompareAndSetLong(base, offset,
                nativeExpectedValue, Long.reverseBytes(expectedValue ^ value)));
        return expectedValue;
    }
}
