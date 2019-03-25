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

import jdk.tools.jaotc.binformat.NativeSymbol;
import jdk.tools.jaotc.binformat.pecoff.PECoff.IMAGE_SYMBOL;
import jdk.tools.jaotc.binformat.pecoff.PECoffByteBuffer;

final class PECoffSymbol extends NativeSymbol {
    private final ByteBuffer sym;

    PECoffSymbol(int symbolindex, int strindex, byte type, byte storageclass, byte sectindex, long offset) {
        super(symbolindex);
        sym = PECoffByteBuffer.allocate(IMAGE_SYMBOL.totalsize);

        // We don't use short names
        sym.putInt(IMAGE_SYMBOL.Short.off, 0);

        sym.putInt(IMAGE_SYMBOL.Long.off, strindex);
        sym.putInt(IMAGE_SYMBOL.Value.off, (int) offset);

        // Section indexes start at 1 but we manage the index internally
        // as 0 relative except in this structure
        sym.putChar(IMAGE_SYMBOL.SectionNumber.off, (char) (sectindex + 1));

        sym.putChar(IMAGE_SYMBOL.Type.off, (char) type);
        sym.put(IMAGE_SYMBOL.StorageClass.off, storageclass);
        sym.put(IMAGE_SYMBOL.NumberOfAuxSymbols.off, (byte) 0);
    }

    byte[] getArray() {
        return sym.array();
    }
}
