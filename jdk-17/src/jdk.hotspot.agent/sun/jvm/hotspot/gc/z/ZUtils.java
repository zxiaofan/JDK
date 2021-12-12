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

class ZUtils {
    static Address longToAddress(long value) {
        return VM.getVM().getDebugger().newAddress(value);
    }

    static long alignUp(long size, long alignment) {
        long mask = alignment - 1;
        long adjusted = size + mask;
        return adjusted & ~mask;
    }
}
