/*
 * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Iterator;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.gc.shared.CollectedHeap;
import sun.jvm.hotspot.gc.shared.CollectedHeapName;
import sun.jvm.hotspot.gc.shared.LiveRegionsClosure;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;
import sun.jvm.hotspot.utilities.BitMapInterface;

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

    @Override
    public long capacity() {
        return heap().capacity();
    }

    @Override
    public long used() {
        return heap().used();
    }

    @Override
    public boolean isInReserved(Address a) {
        return heap().isIn(a);
    }

    private OopHandle oop_load_barrier(Address oopAddress) {
        oopAddress = ZBarrier.weak_barrier(oopAddress);
        if (oopAddress == null) {
            return null;
        }

        return oopAddress.addOffsetToAsOopHandle(0);
    }

    @Override
    public OopHandle oop_load_at(OopHandle handle, long offset) {
        assert(!VM.getVM().isCompressedOopsEnabled());

        Address oopAddress = handle.getAddressAt(offset);

        return oop_load_barrier(oopAddress);
    }

    // addr can be either in heap or in native
    @Override
    public OopHandle oop_load_in_native(Address addr) {
        Address oopAddress = addr.getAddressAt(0);
        return oop_load_barrier(oopAddress);
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

    @Override
    public void liveRegionsIterate(LiveRegionsClosure closure) {
        Iterator<ZPage> iter = heap().pageTable().activePagesIterator();
        while (iter.hasNext()) {
            ZPage page = iter.next();
            closure.doLiveRegions(page);
        }
    }

    @Override
    public BitMapInterface createBitMap(long size) {
        // Ignores the size
        return new ZExternalBitMap(this);
    }
}
