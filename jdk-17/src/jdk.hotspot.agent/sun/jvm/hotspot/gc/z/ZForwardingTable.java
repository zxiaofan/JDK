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
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZForwardingTable extends VMObject {
    private static long mapFieldOffset;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZForwardingTable");

        mapFieldOffset = type.getAddressField("_map").getOffset();
    }

    public ZForwardingTable(Address addr) {
        super(addr);
    }

    private ZGranuleMapForForwarding map() {
        return VMObjectFactory.newObject(ZGranuleMapForForwarding.class, addr.addOffsetTo(mapFieldOffset));
    }

    public ZForwarding get(Address o) {
        return VMObjectFactory.newObject(ZForwarding.class, map().get(ZAddress.offset(o)));
    }
}
