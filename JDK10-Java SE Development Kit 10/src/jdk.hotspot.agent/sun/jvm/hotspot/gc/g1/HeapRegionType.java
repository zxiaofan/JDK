/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

// Mirror class for HeapRegionType. Currently we don't actually include
// any of its fields but only iterate over it.

public class HeapRegionType extends VMObject {

    private static int freeTag;
    private static int youngMask;
    private static int humongousMask;
    private static int pinnedMask;
    private static int oldMask;
    private static CIntegerField tagField;
    private int tag;

    static {
        VM.registerVMInitializedObserver(new Observer() {
                public void update(Observable o, Object data) {
                    initialize(VM.getVM().getTypeDataBase());
                }
        });
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("HeapRegionType");

        tagField = type.getCIntegerField("_tag");

        freeTag = db.lookupIntConstant("HeapRegionType::FreeTag");
        youngMask = db.lookupIntConstant("HeapRegionType::YoungMask");
        humongousMask = db.lookupIntConstant("HeapRegionType::HumongousMask");
        pinnedMask = db.lookupIntConstant("HeapRegionType::PinnedMask");
        oldMask = db.lookupIntConstant("HeapRegionType::OldMask");
    }

    public boolean isFree() {
        return tagField.getValue(addr) == freeTag;
    }

    public boolean isYoung() {
        return (tagField.getValue(addr) & youngMask) != 0;
    }

    public boolean isHumongous() {
        return (tagField.getValue(addr) & humongousMask) != 0;
    }

    public boolean isPinned() {
        return (tagField.getValue(addr) & pinnedMask) != 0;
    }

    public boolean isOld() {
        return (tagField.getValue(addr) & oldMask) != 0;
    }

    public HeapRegionType(Address addr) {
        super(addr);
    }
}
