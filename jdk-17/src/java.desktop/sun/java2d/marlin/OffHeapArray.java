/*
 * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.marlin;

import static sun.java2d.marlin.MarlinConst.LOG_UNSAFE_MALLOC;
import jdk.internal.misc.Unsafe;
import jdk.internal.ref.CleanerFactory;

/**
 *
 */
final class OffHeapArray  {

    // unsafe reference
    static final Unsafe UNSAFE;
    // size of int / float
    static final int SIZE_INT;

    static {
        UNSAFE   = Unsafe.getUnsafe();
        SIZE_INT = Unsafe.ARRAY_INT_INDEX_SCALE;
    }

    /* members */
    long address;
    long length;
    int  used;

    OffHeapArray(final Object parent, final long len) {
        // note: may throw OOME:
        this.address = UNSAFE.allocateMemory(len);
        this.length  = len;
        this.used    = 0;
        if (LOG_UNSAFE_MALLOC) {
            MarlinUtils.logInfo(System.currentTimeMillis()
                                + ": OffHeapArray.allocateMemory =   "
                                + len + " to addr = " + this.address);
        }

        // Register a cleaning function to ensure freeing off-heap memory:
        CleanerFactory.cleaner().register(parent, () -> this.free());
    }

    /*
     * As realloc may change the address, updating address is MANDATORY
     * @param len new array length
     * @throws OutOfMemoryError if the allocation is refused by the system
     */
    void resize(final long len) {
        // note: may throw OOME:
        this.address = UNSAFE.reallocateMemory(address, len);
        this.length  = len;
        if (LOG_UNSAFE_MALLOC) {
            MarlinUtils.logInfo(System.currentTimeMillis()
                                + ": OffHeapArray.reallocateMemory = "
                                + len + " to addr = " + this.address);
        }
    }

    void free() {
        UNSAFE.freeMemory(this.address);
        if (LOG_UNSAFE_MALLOC) {
            MarlinUtils.logInfo(System.currentTimeMillis()
                                + ": OffHeapArray.freeMemory =       "
                                + this.length
                                + " at addr = " + this.address);
        }
        this.address = 0L;
    }

    void fill(final byte val) {
        UNSAFE.setMemory(this.address, this.length, val);
    }
}
