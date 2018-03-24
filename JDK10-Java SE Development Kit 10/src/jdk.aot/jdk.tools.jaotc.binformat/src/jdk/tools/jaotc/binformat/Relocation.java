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

public final class Relocation {

    public enum RelocType {
        UNDEFINED,
        JAVA_CALL_INDIRECT,
        JAVA_CALL_DIRECT,
        FOREIGN_CALL_INDIRECT_GOT, // Call to address in GOT cell
        STUB_CALL_DIRECT,
        METASPACE_GOT_REFERENCE,
        EXTERNAL_GOT_TO_PLT,
        EXTERNAL_PLT_TO_GOT
    }

    private final RelocType type;

    /**
     * Byte offset from the beginning of the file affected by relocation.
     */
    private final int offset;

    /**
     * Size of relocation.
     */
    private final int size;

    /**
     * Symbol associated with this relocation.
     */
    private final Symbol symbol;

    /**
     * Section this relocation entry modifies.
     */
    private final ByteContainer section;

    public Relocation(int offset, RelocType type, int size, ByteContainer section, Symbol sym) {
        if (sym == null) {
            throw new InternalError("must have symbol");
        }
        this.offset = offset;
        this.type = type;
        this.size = size;
        this.symbol = sym;
        this.section = section;
        section.setHasRelocations();
    }

    public RelocType getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public ByteContainer getSection() {
        return section;
    }

}
