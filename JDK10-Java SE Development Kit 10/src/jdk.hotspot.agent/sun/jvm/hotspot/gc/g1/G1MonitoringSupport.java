/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Observable;
import java.util.Observer;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

// Mirror class for G1MonitoringSupport.

public class G1MonitoringSupport extends VMObject {
    // size_t _eden_committed;
    static private CIntegerField edenCommittedField;
    // size_t _eden_used;
    static private CIntegerField edenUsedField;
    // size_t _survivor_committed;
    static private CIntegerField survivorCommittedField;
    // size_t _survivor_used;
    static private CIntegerField survivorUsedField;
    // size_t _old_committed;
    static private CIntegerField oldCommittedField;
    // size_t _old_used;
    static private CIntegerField oldUsedField;

    static {
        VM.registerVMInitializedObserver(new Observer() {
                public void update(Observable o, Object data) {
                    initialize(VM.getVM().getTypeDataBase());
                }
            });
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("G1MonitoringSupport");

        edenCommittedField = type.getCIntegerField("_eden_committed");
        edenUsedField = type.getCIntegerField("_eden_used");
        survivorCommittedField = type.getCIntegerField("_survivor_committed");
        survivorUsedField = type.getCIntegerField("_survivor_used");
        oldCommittedField = type.getCIntegerField("_old_committed");
        oldUsedField = type.getCIntegerField("_old_used");
    }

    public long edenCommitted() {
        return edenCommittedField.getValue(addr);
    }

    public long edenUsed() {
        return edenUsedField.getValue(addr);
    }

    public long edenRegionNum() {
        return edenUsed() / HeapRegion.grainBytes();
    }

    public long survivorCommitted() {
        return survivorCommittedField.getValue(addr);
    }

    public long survivorUsed() {
        return survivorUsedField.getValue(addr);
    }

    public long survivorRegionNum() {
        return survivorUsed() / HeapRegion.grainBytes();
    }

    public long oldCommitted() {
        return oldCommittedField.getValue(addr);
    }

    public long oldUsed() {
        return oldUsedField.getValue(addr);
    }

    public G1MonitoringSupport(Address addr) {
        super(addr);
    }
}
