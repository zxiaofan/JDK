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
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.runtime.VM;

class ZOop {
    private static final long MSB = ~0L ^ (~0L >>> 1);

    private static Address msbAddress() {
        return VM.getVM().getUniverse().heap().start().orWithMask(MSB).andWithMask(MSB);
    }

    static Address to_address(long value) {
        // If the value of an Address becomes 0, null is returned instead of an Address.
        // Start with a one-bit address and as a last step, remove that bit.
        Address oneAddress = msbAddress();
        return oneAddress.orWithMask(value).xorWithMask(ZAddress.as_long(oneAddress));
    }

    static Address to_address(OopHandle oop) {
        return to_address(ZAddress.as_long(oop));
    }
}
