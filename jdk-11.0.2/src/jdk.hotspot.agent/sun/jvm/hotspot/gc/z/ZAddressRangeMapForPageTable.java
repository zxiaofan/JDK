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
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZAddressRangeMapForPageTable  extends VMObject {
    private static AddressField mapField;

    private static long AddressRangeShift = ZGlobals.ZPageSizeMinShift;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZAddressRangeMapForPageTable");

        mapField = type.getAddressField("_map");
    }

    public ZAddressRangeMapForPageTable(Address addr) {
        super(addr);
    }

    private Address map() {
        return mapField.getValue(addr);
    }

    private long index_for_addr(Address addr) {
        long index = ZAddress.offset(addr) >> AddressRangeShift;

        return index;
    }

    Address get(Address addr) {
        long index = index_for_addr(addr);

        return map().getAddressAt(index * VM.getVM().getBytesPerLong());
    }
}
