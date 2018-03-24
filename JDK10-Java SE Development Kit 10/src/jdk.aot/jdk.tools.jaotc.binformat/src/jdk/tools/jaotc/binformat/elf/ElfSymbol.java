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

import jdk.tools.jaotc.binformat.NativeSymbol;
import jdk.tools.jaotc.binformat.elf.Elf.Elf64_Sym;
import jdk.tools.jaotc.binformat.elf.ElfByteBuffer;

final class ElfSymbol extends NativeSymbol {
    private final ByteBuffer sym;

    ElfSymbol(int symbolindex, int strindex, byte type, byte bind, byte sectindex, long offset, long size) {
        super(symbolindex);
        sym = ElfByteBuffer.allocate(Elf64_Sym.totalsize);

        sym.putInt(Elf64_Sym.st_name.off, strindex);
        sym.put(Elf64_Sym.st_info.off, Elf64_Sym.ELF64_ST_INFO(bind, type));
        sym.put(Elf64_Sym.st_other.off, (byte) 0);
        // Section indexes start at 1 but we manage the index internally
        // as 0 relative
        sym.putChar(Elf64_Sym.st_shndx.off, (char) (sectindex));
        sym.putLong(Elf64_Sym.st_value.off, offset);
        sym.putLong(Elf64_Sym.st_size.off, size);
    }

    byte[] getArray() {
        return sym.array();
    }
}
