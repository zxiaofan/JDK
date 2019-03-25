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
import java.util.ArrayList;

import jdk.tools.jaotc.binformat.elf.Elf.Elf64_Sym;
import jdk.tools.jaotc.binformat.elf.ElfSymbol;
import jdk.tools.jaotc.binformat.elf.ElfByteBuffer;

final class ElfSymtab {

    private final ArrayList<ElfSymbol> localSymbols = new ArrayList<>();
    private final ArrayList<ElfSymbol> globalSymbols = new ArrayList<>();

    /**
     * number of symbols added
     */
    private int symbolCount;

    /**
     * String holding symbol table strings
     */
    private final StringBuilder strTabContent = new StringBuilder();

    /**
     * Keeps track of bytes in string table since strTabContent.length() is number of chars, not
     * bytes.
     */
    private int strTabNrOfBytes = 0;

    ElfSymtab() {
        symbolCount = 0;
    }

    ElfSymbol addSymbolEntry(String name, byte type, byte bind, byte secHdrIndex, long offset, long size) {
        // Get the current symbol index and append symbol name to string table.
        int index;
        ElfSymbol sym;

        if (name.isEmpty()) {
            index = 0;
            strTabContent.append('\0');
            strTabNrOfBytes += 1;
            sym = new ElfSymbol(symbolCount, index, type, bind, secHdrIndex, offset, size);
            localSymbols.add(sym);
        } else {
            // We can't trust strTabContent.length() since that is
            // chars (UTF16), keep track of bytes on our own.
            index = strTabNrOfBytes;
            // strTabContent.append("_").append(name).append('\0');
            strTabContent.append(name).append('\0');
            // + 1 for null, + 1 for "_"
            // strTabNrOfBytes += (name.getBytes().length + 1 + 1);
            strTabNrOfBytes += (name.getBytes().length + 1);

            sym = new ElfSymbol(symbolCount, index, type, bind, secHdrIndex, offset, size);
            if ((bind & Elf64_Sym.STB_GLOBAL) != 0)
                globalSymbols.add(sym);
            else
                localSymbols.add(sym);
        }
        symbolCount++;
        return (sym);
    }

    // Update the symbol indexes once all symbols have been added.
    // This is required since we'll be reordering the symbols in the
    // file to be in the order of Local then global.
    void updateIndexes() {
        int index = 0;

        // Update the local symbol indexes
        for (int i = 0; i < localSymbols.size(); i++) {
            ElfSymbol sym = localSymbols.get(i);
            sym.setIndex(index++);
        }

        // Update the global symbol indexes
        for (int i = 0; i < globalSymbols.size(); i++) {
            ElfSymbol sym = globalSymbols.get(i);
            sym.setIndex(index++);
        }
    }

    int getNumLocalSyms() {
        return localSymbols.size();
    }

    int getNumGlobalSyms() {
        return globalSymbols.size();
    }

    // Create a single byte array that contains the symbol table entries
    byte[] getSymtabArray() {
        ByteBuffer symtabData = ElfByteBuffer.allocate(symbolCount * Elf64_Sym.totalsize);
        byte[] retarray;

        updateIndexes();

        // Add the local symbols
        for (int i = 0; i < localSymbols.size(); i++) {
            ElfSymbol sym = localSymbols.get(i);
            byte[] arr = sym.getArray();
            symtabData.put(arr);
        }
        // Add the global symbols
        for (int i = 0; i < globalSymbols.size(); i++) {
            ElfSymbol sym = globalSymbols.get(i);
            byte[] arr = sym.getArray();
            symtabData.put(arr);
        }
        retarray = symtabData.array();

        return (retarray);
    }

    // Return the string table array
    byte[] getStrtabArray() {
        byte[] strs = strTabContent.toString().getBytes();
        return (strs);
    }
}
