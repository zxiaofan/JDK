/*
 * Copyright (c) 2017, 2019, Red Hat, Inc. All rights reserved.
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

package sun.jvm.hotspot.gc.shenandoah;

import sun.jvm.hotspot.gc.shared.CollectedHeap;
import sun.jvm.hotspot.gc.shared.CollectedHeapName;
import sun.jvm.hotspot.gc.shared.LiveRegionsClosure;
import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;
import sun.jvm.hotspot.memory.MemRegion;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.utilities.BitMapInterface;

import java.io.PrintStream;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ShenandoahHeap extends CollectedHeap {
    static private CIntegerField numRegions;
    static private CIntegerField used;
    static private CIntegerField committed;
    static private AddressField  regions;
    static private CIntegerField logMinObjAlignmentInBytes;

    static private long regionPtrFieldSize;
    static {
        VM.registerVMInitializedObserver(new Observer() {
            public void update(Observable o, Object data) {
                initialize(VM.getVM().getTypeDataBase());
            }
        });
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ShenandoahHeap");
        numRegions = type.getCIntegerField("_num_regions");
        used = type.getCIntegerField("_used");
        committed = type.getCIntegerField("_committed");
        regions = type.getAddressField("_regions");
        logMinObjAlignmentInBytes = type.getCIntegerField("_log_min_obj_alignment_in_bytes");

        Type regionPtrType = db.lookupType("ShenandoahHeapRegion*");
        regionPtrFieldSize = regionPtrType.getSize();
    }

    public ShenandoahHeap(Address addr) {
        super(addr);
    }

    @Override
    public CollectedHeapName kind() {
        return CollectedHeapName.SHENANDOAH;
    }

    public long numOfRegions() {
        return numRegions.getValue(addr);
    }

    @Override
    public long capacity() {
        return numOfRegions() * ShenandoahHeapRegion.regionSizeBytes();
    }

    @Override
    public long used() {
        return used.getValue(addr);
    }

    public long committed() {
        return committed.getValue(addr);
    }

    public int getLogMinObjAlignmentInBytes() {
        return logMinObjAlignmentInBytes.getJInt(addr);
    }

    public ShenandoahHeapRegion getRegion(long index) {
        if (index < numOfRegions()) {
            Address arrayAddr = regions.getValue(addr);
            Address regAddr = arrayAddr.getAddressAt(index * regionPtrFieldSize);
            ShenandoahHeapRegion region = VMObjectFactory.newObject(ShenandoahHeapRegion.class, regAddr);
            region.setHeap(this);
            return region;
        }
        return null;
    }

    public ShenandoahHeapRegion regionAtOffset(long offset) {
        long index = offset >>> ShenandoahHeapRegion.regionSizeBytesShift();
        if (index < 0 || index >= numOfRegions()) {
            throw new RuntimeException("Invalid offset: " + offset);
        }
        return getRegion(index);
    }

    @Override
    public void liveRegionsIterate(LiveRegionsClosure closure) {
        for (long index = 0; index < numOfRegions(); index ++) {
            ShenandoahHeapRegion region = getRegion(index);
            closure.doLiveRegions(region);
        }
    }

    @Override
    public void printOn(PrintStream tty) {
        MemRegion mr = reservedRegion();
        tty.print("Shenandoah heap");
        tty.print(" [" + mr.start() + ", " + mr.end() + "]");
        tty.println(" region size " + ShenandoahHeapRegion.regionSizeBytes() / 1024 + " K");
    }

    @Override
    public BitMapInterface createBitMap(long bits) {
        return new ShenandoahBitMap(this);
    }

}
