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
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZPageTable extends VMObject {
    private static long mapFieldOffset;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPageTable");

        mapFieldOffset = type.getAddressField("_map").getOffset();
    }

    public ZPageTable(Address addr) {
        super(addr);
    }

    private ZAddressRangeMapForPageTable map() {
        return (ZAddressRangeMapForPageTable)VMObjectFactory.newObject(ZAddressRangeMapForPageTable.class, addr.addOffsetTo(mapFieldOffset));
    }

    private ZPageTableEntry getEntry(Address o) {
        return new ZPageTableEntry(map().get(o));
    }

    ZPage get(Address o) {
        return getEntry(o).page();
    }

    boolean is_relocating(Address o) {
        return getEntry(o).relocating();
    }
}
