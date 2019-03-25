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

package jdk.tools.jaotc.binformat;

public final class GotSymbol extends Symbol {

    private static final int GOT_SIZE = 8;

    public int getIndex() {
        int offset = getOffset();
        assert (offset % GOT_SIZE) == 0 : "got cells should be aligned: " + offset;
        return offset / GOT_SIZE;
    }

    /**
     * Create GOT symbol info.
     *
     * @param type type of the symbol (UNDEFINED, FUNC, etc)
     * @param binding binding of the symbol (LOCAL, GLOBAL, ...)
     * @param container section in which this symbol is "defined"
     * @param name name of the symbol
     */
    public GotSymbol(Kind type, Binding binding, ByteContainer container, String name) {
        this(container.getByteStreamSize(), type, binding, container, name);
        container.appendBytes(new byte[GOT_SIZE], 0, GOT_SIZE);
    }

    /**
     * Create GOT symbol info.
     *
     * @param offset section offset for the defined symbol
     * @param type type of the symbol (UNDEFINED, FUNC, etc)
     * @param binding binding of the symbol (LOCAL, GLOBAL, ...)
     * @param sec section in which this symbol is "defined"
     * @param name name of the symbol
     */
    public GotSymbol(int offset, Kind type, Binding binding, ByteContainer sec, String name) {
        super(offset, type, binding, sec, GOT_SIZE, name);
    }

}
