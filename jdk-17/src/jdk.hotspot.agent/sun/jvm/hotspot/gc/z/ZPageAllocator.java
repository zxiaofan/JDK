/*
 * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
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

// Mirror class for ZPageAllocator

public class ZPageAllocator extends VMObject {

    private static CIntegerField maxCapacityField;
    private static CIntegerField capacityField;
    private static CIntegerField usedField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPageAllocator");

        maxCapacityField = type.getCIntegerField("_max_capacity");
        capacityField = type.getCIntegerField("_capacity");
        usedField = type.getCIntegerField("_used");
    }

    public long maxCapacity() {
        return maxCapacityField.getValue(addr);
    }

    public long capacity() {
        return capacityField.getValue(addr);
    }

    public long used() {
        return usedField.getValue(addr);
    }

    public ZPageAllocator(Address addr) {
        super(addr);
    }
}
