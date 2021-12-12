/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.g1;

import java.util.Iterator;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

// Mirror class for HeapRegionManager.

public class HeapRegionManager extends VMObject {
    // G1HeapRegionTable _regions
    static private long regionsFieldOffset;

    static {
        VM.registerVMInitializedObserver(new Observer() {
                public void update(Observable o, Object data) {
                    initialize(VM.getVM().getTypeDataBase());
                }
            });
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("HeapRegionManager");

        regionsFieldOffset = type.getField("_regions").getOffset();
    }

    private G1HeapRegionTable regions() {
        Address regionsAddr = addr.addOffsetTo(regionsFieldOffset);
        return (G1HeapRegionTable) VMObjectFactory.newObject(G1HeapRegionTable.class,
                                                             regionsAddr);
    }

    public long capacity() {
        return length() * HeapRegion.grainBytes();
    }

    public long length() {
        return regions().length();
    }

    public Iterator<HeapRegion> heapRegionIterator() {
        return regions().heapRegionIterator(length());
    }

    public HeapRegionManager(Address addr) {
        super(addr);
    }

    public HeapRegion getByAddress(Address addr) {
      return regions().getByAddress(addr);
    }
}
