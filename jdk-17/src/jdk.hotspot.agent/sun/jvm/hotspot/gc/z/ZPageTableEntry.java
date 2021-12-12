/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.runtime.VMObjectFactory;

class ZPageTableEntry {
    Address entry;

    ZPageTableEntry(Address address) {
        entry = address;
    }

    ZPage page() {
        return (ZPage)VMObjectFactory.newObject(ZPage.class, zPageBits());
    }

    private Address zPageBits() {
        return entry.andWithMask(~1L);
    }

    boolean relocating() {
        return (entry.asLongValue() & 1) == 1;
    }

    boolean isEmpty() {
        return entry == null || zPageBits() == null;
    }
}
