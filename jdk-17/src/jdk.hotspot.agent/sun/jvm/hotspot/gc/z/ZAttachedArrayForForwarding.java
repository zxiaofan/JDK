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
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZAttachedArrayForForwarding extends VMObject {
    private static CIntegerField lengthField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZAttachedArrayForForwarding");

        lengthField = type.getCIntegerField("_length");
    }

    public ZAttachedArrayForForwarding(Address addr) {
        super(addr);
    }

    public long length() {
        return lengthField.getValue(addr);
    }

    // ObjectT: ZForwarding
    //  ArrayT: ZForwardingEntry
    //
    // template <typename ObjectT, typename ArrayT>
    // inline size_t ZAttachedArray<ObjectT, ArrayT>::object_size()
    private long objectSize() {
        return ZUtils.alignUp(ZForwarding.getSize(), ZForwardingEntry.getSize());
    }

    // ArrayT* operator()(const ObjectT* obj) const
    public ZForwardingEntry get(ZForwarding obj) {
        Address o = obj.getAddress().addOffsetTo(objectSize());
        return VMObjectFactory.newObject(ZForwardingEntry.class, o);
    }
}
