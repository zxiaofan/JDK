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
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZPage extends VMObject {
    private static CIntegerField typeField;
    private static long virtualFieldOffset;
    private static long forwardingFieldOffset;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPage");

        typeField = type.getCIntegerField("_type");
        virtualFieldOffset = type.getField("_virtual").getOffset();
        forwardingFieldOffset = type.getField("_forwarding").getOffset();
    }

    public ZPage(Address addr) {
        super(addr);
    }

    private byte type() {
        return typeField.getJByte(addr);
    }

    private ZVirtualMemory virtual() {
        return (ZVirtualMemory)VMObjectFactory.newObject(ZVirtualMemory.class, addr.addOffsetTo(virtualFieldOffset));
    }

    private ZForwardingTable forwarding() {
        return (ZForwardingTable)VMObjectFactory.newObject(ZForwardingTable.class, addr.addOffsetTo(forwardingFieldOffset));
    }

    private long start() {
        return virtual().start();
    }

    Address forward_object(Address from) {
        // Lookup address in forwarding table
        long from_offset = ZAddress.offset(from);
        long from_index = (from_offset - start()) >> object_alignment_shift();
        ZForwardingTableEntry entry = forwarding().find(from_index);
        assert(!entry.is_empty());
        assert(entry.from_index() == from_index);

        return ZAddress.good(entry.to_offset());
    }

    Address relocate_object(Address from) {
        // Lookup address in forwarding table
        long from_offset = ZAddress.offset(from);
        long from_index = (from_offset - start()) >> object_alignment_shift();
        ZForwardingTableEntry entry = forwarding().find(from_index);
        if (!entry.is_empty() && entry.from_index() == from_index) {
          return ZAddress.good(entry.to_offset());
        }

        // There's no relocate operation in the SA.
        // Mimic object pinning and return the good view of the from object.
        return ZAddress.good(from);
    }


    long object_alignment_shift() {
        if (type() == ZGlobals.ZPageTypeSmall) {
            return ZGlobals.ZObjectAlignmentSmallShift();
        } else if (type() == ZGlobals.ZPageTypeMedium) {
            return ZGlobals.ZObjectAlignmentMediumShift;
        } else {
            assert(type() == ZGlobals.ZPageTypeLarge);
            return ZGlobals.ZObjectAlignmentLargeShift;
        }
    }
}
