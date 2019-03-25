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

import jdk.tools.jaotc.binformat.NativeSymbol;
import jdk.tools.jaotc.binformat.macho.MachO.nlist_64;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

final class MachOSymbol extends NativeSymbol {
    private final ByteBuffer sym;

    MachOSymbol(int symbolindex, int strindex, byte type, byte sectindex, long offset) {
        super(symbolindex);
        sym = MachOByteBuffer.allocate(nlist_64.totalsize);

        sym.putInt(nlist_64.n_strx.off, strindex);
        sym.put(nlist_64.n_type.off, type);
        // Section indexes start at 1 but we manage the index internally
        // as 0 relative
        sym.put(nlist_64.n_sect.off, (byte) (sectindex + 1));
        sym.putChar(nlist_64.n_desc.off, (char) 0);
        sym.putLong(nlist_64.n_value.off, offset);
    }

    byte[] getArray() {
        return sym.array();
    }
}
