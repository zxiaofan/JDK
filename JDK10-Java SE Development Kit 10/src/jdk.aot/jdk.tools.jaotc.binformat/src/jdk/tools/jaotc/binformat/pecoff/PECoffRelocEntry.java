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

package jdk.tools.jaotc.binformat.pecoff;

import java.nio.ByteBuffer;

import jdk.tools.jaotc.binformat.pecoff.PECoff.IMAGE_RELOCATION;
import jdk.tools.jaotc.binformat.pecoff.PECoffByteBuffer;

final class PECoffRelocEntry {
    private final ByteBuffer entry;

    PECoffRelocEntry(int offset, int symno, int type) {

        entry = PECoffByteBuffer.allocate(IMAGE_RELOCATION.totalsize);

        entry.putInt(IMAGE_RELOCATION.VirtualAddress.off, offset);
        entry.putInt(IMAGE_RELOCATION.SymbolTableIndex.off, symno);
        entry.putChar(IMAGE_RELOCATION.Type.off, (char) type);
    }

    byte[] getArray() {
        return entry.array();
    }
}
