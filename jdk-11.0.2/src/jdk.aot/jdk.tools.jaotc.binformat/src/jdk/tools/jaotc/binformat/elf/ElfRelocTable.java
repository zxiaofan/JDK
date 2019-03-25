/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.nio.ByteBuffer;

import jdk.tools.jaotc.binformat.elf.ElfRelocEntry;
import jdk.tools.jaotc.binformat.elf.Elf.Elf64_Rela;
import jdk.tools.jaotc.binformat.elf.ElfByteBuffer;

final class ElfRelocTable {
    private final ArrayList<ArrayList<ElfRelocEntry>> relocEntries;

    ElfRelocTable(int numsects) {
        relocEntries = new ArrayList<>(numsects);
        for (int i = 0; i < numsects; i++) {
            relocEntries.add(new ArrayList<ElfRelocEntry>());
        }
    }

    void createRelocationEntry(int sectindex, int offset, int symno, int type, int addend) {
        ElfRelocEntry entry = new ElfRelocEntry(offset, symno, type, addend);
        relocEntries.get(sectindex).add(entry);
    }

    int getNumRelocs(int section_index) {
        return relocEntries.get(section_index).size();
    }

    // Return the relocation entries for a single section
    // or null if no entries added to section
    byte[] getRelocData(int section_index) {
        ArrayList<ElfRelocEntry> entryList = relocEntries.get(section_index);

        if (entryList.size() == 0) {
            return null;
        }
        ByteBuffer relocData = ElfByteBuffer.allocate(entryList.size() * Elf64_Rela.totalsize);

        // Copy each entry to a single ByteBuffer
        for (int i = 0; i < entryList.size(); i++) {
            ElfRelocEntry entry = entryList.get(i);
            relocData.put(entry.getArray());
        }

        return (relocData.array());
    }
}
