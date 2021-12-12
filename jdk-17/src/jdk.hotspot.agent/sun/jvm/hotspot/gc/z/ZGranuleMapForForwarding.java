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

public class ZGranuleMapForForwarding  extends VMObject {
    private static AddressField mapField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZGranuleMapForForwarding");

        mapField = type.getAddressField("_map");
    }

    public ZGranuleMapForForwarding(Address addr) {
        super(addr);
    }

    private Address map() {
        return mapField.getValue(addr);
    }

    public long size() {
        return ZGlobals.ZAddressOffsetMax >> ZGlobals.ZGranuleSizeShift;
    }

    private long index_for_offset(long offset) {
        long index = offset >>> ZGlobals.ZGranuleSizeShift;

        return index;
    }

    Address at(long index) {
        return map().getAddressAt(index * VM.getVM().getAddressSize());
    }

    Address get(long offset) {
        long index = index_for_offset(offset);
        return at(index);
    }

    public class Iterator {
        private long next = 0;

        boolean hasNext() {
            return next < size();
        }

        Address next() {
            if (next >= size()) {
                throw new RuntimeException("OOIBE");
            }

            return at(next++);
        }
    }
}
