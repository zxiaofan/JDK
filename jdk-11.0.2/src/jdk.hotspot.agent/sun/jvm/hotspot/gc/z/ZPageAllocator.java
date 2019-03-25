/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

// Mirror class for ZPageAllocator

public class ZPageAllocator extends VMObject {

    private static AddressField physicalField;
    private static CIntegerField usedField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPageAllocator");

        physicalField = type.getAddressField("_physical");
        usedField = type.getCIntegerField("_used");
    }

    private ZPhysicalMemoryManager physical() {
      Address physicalAddr = physicalField.getValue(addr);
      return (ZPhysicalMemoryManager)VMObjectFactory.newObject(ZPhysicalMemoryManager.class, physicalAddr);
    }

    public long maxCapacity() {
        return physical().maxCapacity();
    }

    public long capacity() {
        return physical().capacity();
    }

    public long used() {
        return usedField.getValue(addr);
    }

    public ZPageAllocator(Address addr) {
        super(addr);
    }
}
