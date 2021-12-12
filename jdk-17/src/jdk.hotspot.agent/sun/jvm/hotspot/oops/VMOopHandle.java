/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class VMOopHandle extends VMObject {
    private static AddressField objField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("OopHandle");

        objField = type.getAddressField("_obj");
    }

    public VMOopHandle(Address addr) {
        super(addr);
    }

    public Address getObj() {
        return objField.getValue(addr);
    }

    public Instance resolve() {
        Address handle = getObj();
        if (handle != null) {
          // Load through the handle
          OopHandle refs = VM.getVM().getUniverse().heap().oop_load_in_native(handle);
          return (Instance)VM.getVM().getObjectHeap().newOop(refs);
        }
        return null;
    }
}
