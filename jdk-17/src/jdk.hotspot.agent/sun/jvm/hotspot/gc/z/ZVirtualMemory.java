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
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZVirtualMemory extends VMObject {
    private static CIntegerField startField;
    private static CIntegerField endField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZVirtualMemory");

        startField = type.getCIntegerField("_start");
        endField = type.getCIntegerField("_end");
    }

    public ZVirtualMemory(Address addr) {
        super(addr);
    }

    long start() {
        return startField.getJLong(addr);
    }

    long end() {
        return endField.getJLong(addr);
    }
}
