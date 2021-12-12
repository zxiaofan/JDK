/*
 * Copyright (c) 2004, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class PerfMemory {
    private static AddressField  startField;
    private static AddressField  endField;
    private static AddressField  topField;
    private static CIntegerField capacityField;
    private static AddressField  prologueField;
    private static CIntegerField initializedField;

    static {
        VM.registerVMInitializedObserver(new Observer() {
                public void update(Observable o, Object data) {
                    initialize(VM.getVM().getTypeDataBase());
                }
            });
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("PerfMemory");
        startField = type.getAddressField("_start");
        endField = type.getAddressField("_end");
        topField = type.getAddressField("_top");
        capacityField = type.getCIntegerField("_capacity");
        prologueField = type.getAddressField("_prologue");
        initializedField = type.getCIntegerField("_initialized");
    }

    // Accessors
    public static Address start() {
        return startField.getValue();
    }

    public static Address end() {
        return endField.getValue();
    }

    public static Address top() {
        return topField.getValue();
    }

    public static long capacity() {
        return capacityField.getValue();
    }

    public static boolean initialized() {
        return (initializedField.getValue()) != 0;
    }

    public static PerfDataPrologue prologue() {
        return (PerfDataPrologue) VMObjectFactory.newObject(
                   PerfDataPrologue.class, prologueField.getValue());
    }

    public static boolean contains(Address addr) {
        return start() != null &&
            addr.minus(start()) >= 0 &&
            end().minus(addr) > 0;
    }

    // an interface supplied to iterate PerfDataEntries
    public static interface PerfDataEntryVisitor {
        // returns false to stop the iteration
        public boolean visit(PerfDataEntry pde);
    }

    public static void iterate(PerfDataEntryVisitor visitor) {
        PerfDataPrologue header = prologue();
        int off = header.entryOffset();
        int num = header.numEntries();
        Address addr = header.getAddress();

        for (int i = 0; i < num; i++) {
            PerfDataEntry pde = (PerfDataEntry) VMObjectFactory.newObject(
                               PerfDataEntry.class, addr.addOffsetTo(off));
            off += pde.entryLength();
            if (visitor.visit(pde) == false) return;
        }
    }
}
