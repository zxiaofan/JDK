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

package jdk.tools.jaotc.binformat.elf;

import java.nio.ByteBuffer;

import jdk.tools.jaotc.binformat.elf.Elf.Elf64_Rela;
import jdk.tools.jaotc.binformat.elf.ElfByteBuffer;

final class ElfRelocEntry {
    private final ByteBuffer entry;

    ElfRelocEntry(int offset, int symno, int type, int addend) {

        entry = ElfByteBuffer.allocate(Elf64_Rela.totalsize);

        entry.putLong(Elf64_Rela.r_offset.off, offset);
        entry.putLong(Elf64_Rela.r_info.off, Elf64_Rela.ELF64_R_INFO(symno, type));
        entry.putLong(Elf64_Rela.r_addend.off, addend);
    }

    byte[] getArray() {
        return entry.array();
    }
}
