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
 */

package jdk.tools.jaotc.binformat.macho;

import java.nio.ByteBuffer;

import jdk.tools.jaotc.binformat.macho.MachO.reloc_info;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

final class MachORelocEntry {
    private final ByteBuffer entry;

    MachORelocEntry(int offset, int symno, int pcrel, int length, int isextern, int type) {

        entry = MachOByteBuffer.allocate(reloc_info.totalsize);

        entry.putInt(reloc_info.r_address.off, offset);

        // Encode and store the relocation entry bitfields
        // @formatter:off
        entry.putInt(reloc_info.r_relocinfo.off,
            ((symno    & reloc_info.REL_SYMNUM_MASK) << reloc_info.REL_SYMNUM_SHIFT) |
            ((pcrel    & reloc_info.REL_PCREL_MASK)  << reloc_info.REL_PCREL_SHIFT)  |
            ((length   & reloc_info.REL_LENGTH_MASK) << reloc_info.REL_LENGTH_SHIFT) |
            ((isextern & reloc_info.REL_EXTERN_MASK) << reloc_info.REL_EXTERN_SHIFT) |
            ((type     & reloc_info.REL_TYPE_MASK)   << reloc_info.REL_TYPE_SHIFT));
        // @formatter:on
    }

    byte[] getArray() {
        return entry.array();
    }
}
