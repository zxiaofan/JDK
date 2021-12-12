/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021, NTT DATA.
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
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZForwardingEntry extends VMObject {
    private static Type type;
    private static CIntegerField entryField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        type = db.lookupType("ZForwardingEntry");

        entryField = type.getCIntegerField("_entry");
    }

    public static long getSize() {
        return type.getSize();
    }

    public ZForwardingEntry(Address addr) {
        super(addr);
    }

    public long entry() {
        return entryField.getValue(addr);
    }

    // typedef ZBitField<uint64_t, bool,   0,   1> field_populated
    private boolean fieldPopulatedDecode(long value) {
        long FieldMask = (1L << 1) - 1;
        int FieldShift = 1;
        int ValueShift = 0;
        return (((value >>> FieldShift) & FieldMask) << ValueShift) != 0L;
    }

    // typedef ZBitField<uint64_t, size_t, 1,  45> field_to_offset;
    private long fieldToOffsetDecode(long value) {
        long FieldMask = (1L << 45) - 1;
        int FieldShift = 1;
        int ValueShift = 0;
        return ((value >>> FieldShift) & FieldMask) << ValueShift;
    }

    // typedef ZBitField<uint64_t, size_t, 46, 18> field_from_index;
    private long fieldFromIndexDecode(long value) {
        long FieldMask = (1L << 18) - 1;
        int FieldShift = 46;
        int ValueShift = 0;
        return ((value >>> FieldShift) & FieldMask) << ValueShift;
    }

    public boolean populated() {
        return fieldPopulatedDecode(entry());
    }

    public long toOffset() {
        return fieldToOffsetDecode(entry());
    }

    public long fromIndex() {
        return fieldFromIndexDecode(entry());
    }
}
