/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.bytecode;

/**
 * A utility for processing {@link Bytecodes#LOOKUPSWITCH} bytecodes.
 */
public class BytecodeLookupSwitch extends BytecodeSwitch {

    private static final int OFFSET_TO_NUMBER_PAIRS = 4;
    private static final int OFFSET_TO_FIRST_PAIR_MATCH = 8;
    private static final int OFFSET_TO_FIRST_PAIR_OFFSET = 12;
    private static final int PAIR_SIZE = 8;

    /**
     * Constructor for a {@link BytecodeStream}.
     *
     * @param stream the {@code BytecodeStream} containing the switch instruction
     * @param bci the index in the stream of the switch instruction
     */
    public BytecodeLookupSwitch(BytecodeStream stream, int bci) {
        super(stream, bci);
    }

    @Override
    public int offsetAt(int i) {
        return stream.readInt(alignedBci + OFFSET_TO_FIRST_PAIR_OFFSET + PAIR_SIZE * i);
    }

    @Override
    public int keyAt(int i) {
        return stream.readInt(alignedBci + OFFSET_TO_FIRST_PAIR_MATCH + PAIR_SIZE * i);
    }

    @Override
    public int numberOfCases() {
        return stream.readInt(alignedBci + OFFSET_TO_NUMBER_PAIRS);
    }

    @Override
    public int size() {
        return alignedBci + OFFSET_TO_FIRST_PAIR_MATCH + PAIR_SIZE * numberOfCases() - bci;
    }
}
