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

import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.types.Field;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZGlobals {
    private static Field instanceField;

    // Global phase state
    public static int ZPhaseRelocate;

    public static byte ZPageTypeSmall;
    public static byte ZPageTypeMedium;
    public static byte ZPageTypeLarge;

    // Granule size shift
    public static long ZGranuleSizeShift;

    // Page size shifts
    public static long ZPageSizeSmallShift;
    public static long ZPageSizeMediumShift;

    // Object alignment shifts
    public static int  ZObjectAlignmentMediumShift;
    public static int  ZObjectAlignmentLargeShift;

    // Pointer part of address
    public static long ZAddressOffsetShift;

    // Pointer part of address
    public static long ZAddressOffsetBits;
    public static long ZAddressOffsetMax;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZGlobalsForVMStructs");

        instanceField = type.getField("_instance_p");

        ZPhaseRelocate = db.lookupIntConstant("ZPhaseRelocate").intValue();

        ZPageTypeSmall = db.lookupIntConstant("ZPageTypeSmall").byteValue();
        ZPageTypeMedium = db.lookupIntConstant("ZPageTypeMedium").byteValue();
        ZPageTypeLarge = db.lookupIntConstant("ZPageTypeLarge").byteValue();

        ZGranuleSizeShift = db.lookupLongConstant("ZGranuleSizeShift").longValue();

        ZPageSizeSmallShift = db.lookupLongConstant("ZPageSizeSmallShift").longValue();
        ZPageSizeMediumShift = db.lookupLongConstant("ZPageSizeMediumShift").longValue();

        ZObjectAlignmentMediumShift = db.lookupIntConstant("ZObjectAlignmentMediumShift").intValue();
        ZObjectAlignmentLargeShift = db.lookupIntConstant("ZObjectAlignmentLargeShift").intValue();;

        ZAddressOffsetShift = db.lookupLongConstant("ZAddressOffsetShift").longValue();

        ZAddressOffsetBits = db.lookupLongConstant("ZAddressOffsetBits").longValue();
        ZAddressOffsetMax  = db.lookupLongConstant("ZAddressOffsetMax").longValue();
    }

    private static ZGlobalsForVMStructs instance() {
        return new ZGlobalsForVMStructs(instanceField.getAddress());
    }

    public static int ZGlobalPhase() {
        return instance().ZGlobalPhase();
    }

    public static int ZGlobalSeqNum() {
        return instance().ZGlobalSeqNum();
    }

    public static long ZAddressOffsetMask() {
        return instance().ZAddressOffsetMask();
    }

    public static long ZAddressMetadataMask() {
        return instance().ZAddressMetadataMask();
    }

    public static long ZAddressMetadataFinalizable() {
        return instance().ZAddressMetadataFinalizable();
    }

    public static long ZAddressGoodMask() {
        return instance().ZAddressGoodMask();
    }

    public static long ZAddressBadMask() {
        return instance().ZAddressBadMask();
    }

    public static long ZAddressWeakBadMask() {
        return instance().ZAddressWeakBadMask();
    }

    public static int ZObjectAlignmentSmallShift() {
        return instance().ZObjectAlignmentSmallShift();
    }

    public static int ZObjectAlignmentSmall() {
        return instance().ZObjectAlignmentSmall();
    }
}
