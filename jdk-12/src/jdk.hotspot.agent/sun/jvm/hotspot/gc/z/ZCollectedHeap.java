/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.io.PrintStream;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.gc.shared.CollectedHeap;
import sun.jvm.hotspot.gc.shared.CollectedHeapName;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

// Mirror class for ZCollectedHeap.

public class ZCollectedHeap extends CollectedHeap {

    private static long zHeapFieldOffset;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZCollectedHeap");

        zHeapFieldOffset = type.getAddressField("_heap").getOffset();
    }

    public ZHeap heap() {
        Address heapAddr = addr.addOffsetTo(zHeapFieldOffset);
        return (ZHeap)VMObjectFactory.newObject(ZHeap.class, heapAddr);
    }

    @Override
    public CollectedHeapName kind() {
        return CollectedHeapName.Z;
    }

    @Override
    public void printOn(PrintStream tty) {
        heap().printOn(tty);
    }

    public ZCollectedHeap(Address addr) {
        super(addr);
    }

    public OopHandle oop_load_at(OopHandle handle, long offset) {
        assert(!VM.getVM().isCompressedOopsEnabled());

        Address oopAddress = handle.getAddressAt(offset);

        oopAddress = ZBarrier.weak_barrier(oopAddress);
        if (oopAddress == null) {
            return null;
        }

        return oopAddress.addOffsetToAsOopHandle(0);
    }

    public String oopAddressDescription(OopHandle handle) {
        Address origOop = ZOop.to_address(handle);
        Address loadBarrieredOop = ZBarrier.weak_barrier(origOop);
        if (!origOop.equals(loadBarrieredOop)) {
            return origOop + " (" + loadBarrieredOop.toString() + ")";
        } else {
            return handle.toString();
        }
    }
}
