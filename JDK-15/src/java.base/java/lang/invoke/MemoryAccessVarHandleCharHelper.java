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

final class MemoryAccessVarHandleCharHelper {

    static final boolean BE = UNSAFE.isBigEndian();

    static final int VM_ALIGN = Character.BYTES - 1;

    @ForceInline
    static char convEndian(boolean big, char n) {
        return big == BE ? n : Character.reverseBytes(n);
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
    static char get0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return UNSAFE.getCharUnaligned(
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(bb, base, handle.alignmentMask),
                handle.be);
    }

    @ForceInline
    static void set0(VarHandle ob, Object obb, long base, char value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putCharUnaligned(
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(bb, base, handle.alignmentMask),
                value,
                handle.be);
    }

    @ForceInline
    static char getVolatile0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getCharVolatile(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile0(VarHandle ob, Object obb, long base, char value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putCharVolatile(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static char getAcquire0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getCharAcquire(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease0(VarHandle ob, Object obb, long base, char value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putCharRelease(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static char getOpaque0(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          UNSAFE.getCharOpaque(
                                  bb.unsafeGetBase(),
                                  offset(bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque0(VarHandle ob, Object obb, long base, char value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemoryAddressProxy bb = checkAddress(obb, base, handle.length, false);
        UNSAFE.putCharOpaque(
                bb.unsafeGetBase(),
                offset(bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }
}
