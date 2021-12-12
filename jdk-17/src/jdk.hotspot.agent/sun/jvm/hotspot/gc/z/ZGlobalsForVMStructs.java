/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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

class ZGlobalsForVMStructs extends VMObject {
    private static AddressField ZGlobalPhaseField;
    private static AddressField ZGlobalSeqNumField;
    private static AddressField ZAddressOffsetMaskField;
    private static AddressField ZAddressMetadataMaskField;
    private static AddressField ZAddressMetadataFinalizableField;
    private static AddressField ZAddressGoodMaskField;
    private static AddressField ZAddressBadMaskField;
    private static AddressField ZAddressWeakBadMaskField;
    private static AddressField ZObjectAlignmentSmallShiftField;
    private static AddressField ZObjectAlignmentSmallField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZGlobalsForVMStructs");

        ZGlobalPhaseField = type.getAddressField("_ZGlobalPhase");
        ZGlobalSeqNumField = type.getAddressField("_ZGlobalSeqNum");
        ZAddressOffsetMaskField = type.getAddressField("_ZAddressOffsetMask");
        ZAddressMetadataMaskField = type.getAddressField("_ZAddressMetadataMask");
        ZAddressMetadataFinalizableField = type.getAddressField("_ZAddressMetadataFinalizable");
        ZAddressGoodMaskField = type.getAddressField("_ZAddressGoodMask");
        ZAddressBadMaskField = type.getAddressField("_ZAddressBadMask");
        ZAddressWeakBadMaskField = type.getAddressField("_ZAddressWeakBadMask");
        ZObjectAlignmentSmallShiftField = type.getAddressField("_ZObjectAlignmentSmallShift");
        ZObjectAlignmentSmallField = type.getAddressField("_ZObjectAlignmentSmall");
    }

    ZGlobalsForVMStructs(Address addr) {
        super(addr);
    }

    int ZGlobalPhase() {
        return ZGlobalPhaseField.getValue(addr).getJIntAt(0);
    }

    int ZGlobalSeqNum() {
        return ZGlobalSeqNumField.getValue(addr).getJIntAt(0);
    }

    long ZAddressOffsetMask() {
        return ZAddressOffsetMaskField.getValue(addr).getJLongAt(0);
    }

    long ZAddressMetadataMask() {
        return ZAddressMetadataMaskField.getValue(addr).getJLongAt(0);
    }

    long ZAddressMetadataFinalizable() {
        return ZAddressMetadataFinalizableField.getValue(addr).getJLongAt(0);
    }

    long ZAddressGoodMask() {
        return ZAddressGoodMaskField.getValue(addr).getJLongAt(0);
    }

    long ZAddressBadMask() {
        return ZAddressBadMaskField.getValue(addr).getJLongAt(0);
    }

    long ZAddressWeakBadMask() {
        return ZAddressWeakBadMaskField.getValue(addr).getJLongAt(0);
    }

    int ZObjectAlignmentSmallShift() {
        return ZObjectAlignmentSmallShiftField.getValue(addr).getJIntAt(0);
    }

    int ZObjectAlignmentSmall() {
        return ZObjectAlignmentSmallField.getValue(addr).getJIntAt(0);
    }
}
