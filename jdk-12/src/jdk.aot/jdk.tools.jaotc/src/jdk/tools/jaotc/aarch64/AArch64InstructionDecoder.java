/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, Red Hat Inc. All rights reserved.
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



package jdk.tools.jaotc.aarch64;

import jdk.tools.jaotc.InstructionDecoder;

public final class AArch64InstructionDecoder extends InstructionDecoder {

    private int currentEndOfInstruction;

    public AArch64InstructionDecoder() {
    }

    @Override
    public int currentEndOfInstruction() {
        return currentEndOfInstruction;
    }

    @Override
    public void decodePosition(final byte[] code, int pcOffset) {
        currentEndOfInstruction = pcOffset + 4;
    }
}
