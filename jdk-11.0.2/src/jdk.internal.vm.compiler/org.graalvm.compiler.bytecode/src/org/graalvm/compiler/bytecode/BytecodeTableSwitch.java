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
 * A utility for processing {@link Bytecodes#TABLESWITCH} bytecodes.
 */
public class BytecodeTableSwitch extends BytecodeSwitch {

    private static final int OFFSET_TO_LOW_KEY = 4;
    private static final int OFFSET_TO_HIGH_KEY = 8;
    private static final int OFFSET_TO_FIRST_JUMP_OFFSET = 12;
    private static final int JUMP_OFFSET_SIZE = 4;

    /**
     * Constructor for a {@link BytecodeStream}.
     *
     * @param stream the {@code BytecodeStream} containing the switch instruction
     * @param bci the index in the stream of the switch instruction
     */
    public BytecodeTableSwitch(BytecodeStream stream, int bci) {
        super(stream, bci);
    }

    /**
     * Gets the low key of the table switch.
     *
     * @return the low key
     */
    public int lowKey() {
        return stream.readInt(alignedBci + OFFSET_TO_LOW_KEY);
    }

    /**
     * Gets the high key of the table switch.
     *
     * @return the high key
     */
    public int highKey() {
        return stream.readInt(alignedBci + OFFSET_TO_HIGH_KEY);
    }

    @Override
    public int keyAt(int i) {
        return lowKey() + i;
    }

    @Override
    public int offsetAt(int i) {
        return stream.readInt(alignedBci + OFFSET_TO_FIRST_JUMP_OFFSET + JUMP_OFFSET_SIZE * i);
    }

    @Override
    public int numberOfCases() {
        return highKey() - lowKey() + 1;
    }

    @Override
    public int size() {
        return alignedBci + OFFSET_TO_FIRST_JUMP_OFFSET + JUMP_OFFSET_SIZE * numberOfCases() - bci;
    }
}
