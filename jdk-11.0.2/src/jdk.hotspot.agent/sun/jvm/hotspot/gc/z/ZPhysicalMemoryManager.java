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
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

// Mirror class for ZPhysicalMemoryManager

public class ZPhysicalMemoryManager extends VMObject {

    private static CIntegerField capacityField;

    private static CIntegerField maxCapacityField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPhysicalMemoryManager");

        capacityField = type.getCIntegerField("_capacity");
        maxCapacityField = type.getCIntegerField("_max_capacity");
    }

    public long capacity() {
        return capacityField.getValue(addr);
    }

    public long maxCapacity() {
        return maxCapacityField.getValue(addr);
    }

    public ZPhysicalMemoryManager(Address addr) {
        super(addr);
    }
}
