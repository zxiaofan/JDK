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
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

// Mirror class for ZHeap

public class ZHeap extends VMObject {

    private static long pageAllocatorFieldOffset;
    private static long pageTableFieldOffset;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZHeap");

        pageAllocatorFieldOffset = type.getAddressField("_page_allocator").getOffset();
        pageTableFieldOffset = type.getAddressField("_pagetable").getOffset();
    }

    public ZHeap(Address addr) {
        super(addr);
    }

    private ZPageAllocator pageAllocator() {
        Address pageAllocatorAddr = addr.addOffsetTo(pageAllocatorFieldOffset);
        return (ZPageAllocator)VMObjectFactory.newObject(ZPageAllocator.class, pageAllocatorAddr);
    }

    ZPageTable pageTable() {
        return (ZPageTable)VMObjectFactory.newObject(ZPageTable.class, addr.addOffsetTo(pageTableFieldOffset));
    }

    public long maxCapacity() {
        return pageAllocator().maxCapacity();
    }

    public long capacity() {
        return pageAllocator().capacity();
    }

    public long used() {
        return pageAllocator().used();
    }

    boolean is_relocating(Address o) {
        return pageTable().is_relocating(o);
    }

    Address forward_object(Address addr) {
        ZPage page = pageTable().get(addr);
        return page.forward_object(addr);
    }

    Address relocate_object(Address addr) {
        ZPage page = pageTable().get(addr);
        return page.relocate_object(addr);
    }

    public void printOn(PrintStream tty) {
        tty.print(" ZHeap          ");
        tty.print("used " + (used() / 1024 / 1024) + "M, ");
        tty.print("capacity " + (capacity() / 1024 / 1024) + "M, ");
        tty.println("max capacity " + (maxCapacity() / 1024 / 1024) + "M");
    }
}
