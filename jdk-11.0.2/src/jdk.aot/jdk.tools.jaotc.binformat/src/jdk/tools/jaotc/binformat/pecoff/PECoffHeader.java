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

import jdk.tools.jaotc.binformat.pecoff.PECoff.IMAGE_FILE_HEADER;
import jdk.tools.jaotc.binformat.pecoff.PECoffByteBuffer;

final class PECoffHeader {
    private final ByteBuffer header;

    PECoffHeader() {
        header = PECoffByteBuffer.allocate(IMAGE_FILE_HEADER.totalsize);

        header.putChar(IMAGE_FILE_HEADER.Machine.off, IMAGE_FILE_HEADER.IMAGE_FILE_MACHINE_AMD64);
        header.putInt(IMAGE_FILE_HEADER.TimeDateStamp.off, (int) (System.currentTimeMillis() / 1000));
        header.putInt(IMAGE_FILE_HEADER.PointerToSymbolTable.off, 0);
        header.putInt(IMAGE_FILE_HEADER.NumberOfSymbols.off, 0);
        header.putChar(IMAGE_FILE_HEADER.SizeOfOptionalHeader.off, (char) 0);
        header.putChar(IMAGE_FILE_HEADER.Characteristics.off, (char) 0);

    }

    // Update header with the number of total sections
    void setSectionCount(int count) {
        header.putChar(IMAGE_FILE_HEADER.NumberOfSections.off, (char) count);
    }

    // Update header with the number of total symbols
    void setSymbolCount(int count) {
        header.putInt(IMAGE_FILE_HEADER.NumberOfSymbols.off, count);
    }

    // Update header with the offset of symbol table
    void setSymbolOff(int offset) {
        header.putInt(IMAGE_FILE_HEADER.PointerToSymbolTable.off, offset);
    }

    byte[] getArray() {
        return header.array();
    }
}
