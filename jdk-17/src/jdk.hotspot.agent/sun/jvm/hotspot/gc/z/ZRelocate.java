/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021, NTT DATA.
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

public class ZRelocate  extends VMObject {

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZRelocate");
    }

    public ZRelocate(Address addr) {
        super(addr);
    }

    private long forwardingIndex(ZForwarding forwarding, Address from) {
        long fromOffset = ZAddress.offset(from);
        return (fromOffset - forwarding.start()) >>> forwarding.objectAlignmentShift();
    }

    private Address forwardingFind(ZForwarding forwarding, Address from) {
        long fromIndex = forwardingIndex(forwarding, from);
        ZForwardingEntry entry = forwarding.find(fromIndex);
        return entry.populated() ? ZAddress.good(VM.getVM().getDebugger().newAddress(entry.toOffset())) : null;
    }

    public Address forwardObject(ZForwarding forwarding, Address from) {
        return forwardingFind(forwarding, from);
    }

    public Address relocateObject(ZForwarding forwarding, Address o) {
        Address toAddr = forwardingFind(forwarding, o);
        if (toAddr != null) {
            // Already relocated.
            return toAddr;
        } else {
            // Return original address because it is not yet relocated.
            return o;
        }
    }
}
