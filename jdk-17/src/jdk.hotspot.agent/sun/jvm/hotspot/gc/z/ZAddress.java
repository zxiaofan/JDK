/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.gc.z;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;

class ZAddress {
    static long as_long(Address value) {
        if (value == null) {
            return 0;
        }
        return value.asLongValue();
    };

    static boolean is_null(Address value) {
        return value == null;
    }

    static boolean is_weak_bad(Address value) {
        return (as_long(value) & ZGlobals.ZAddressWeakBadMask()) != 0L;
    }

    static boolean is_weak_good(Address value) {
        return !is_weak_bad(value) && !is_null(value);
    }

    static boolean is_weak_good_or_null(Address value) {
        return !is_weak_bad(value);
    }

    static long offset(Address address) {
        return as_long(address) & ZGlobals.ZAddressOffsetMask();
    }

    static Address good(Address value) {
        return VM.getVM().getDebugger().newAddress(offset(value) | ZGlobals.ZAddressGoodMask());
    }

    static Address good_or_null(Address value) {
        return is_null(value) ? value : good(value);
    }

    private static boolean isPowerOf2(long value) {
        return (value != 0L) && ((value & (value - 1)) == 0L);
    }

    static boolean isIn(Address addr) {
        long value = as_long(addr);
        if (!isPowerOf2(value & ~ZGlobals.ZAddressOffsetMask())) {
            return false;
        }
        return (value & (ZGlobals.ZAddressMetadataMask() & ~ZGlobals.ZAddressMetadataFinalizable())) != 0L;
    }
}
