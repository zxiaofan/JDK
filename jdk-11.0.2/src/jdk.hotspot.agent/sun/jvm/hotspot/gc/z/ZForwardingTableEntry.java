/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

class ZForwardingTableEntry {
    private Address entry;

    ZForwardingTableEntry(Address addr) {
        entry = addr;
    }

    private static long empty() {
        return ~0L;
    }

    boolean is_empty() {
        return entry.asLongValue() == empty();
    }

    Address to_offset() {
        return entry.andWithMask((1L << 42) - 1);
    }

    long from_index() {
        return entry.asLongValue() >>> 42;
    }

    public String toString() {
        return entry + " - from_index: " + from_index() + " to_offset: " + to_offset();
    }
}
