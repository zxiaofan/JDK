/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.jtt;

import org.junit.Test;

import org.graalvm.compiler.lir.gen.LIRGeneratorTool;

import jdk.vm.ci.meta.Value;

public class LIRTestTest extends LIRTest {
    private static final LIRTestSpecification stackCopy = new LIRTestSpecification() {
        @Override
        public void generate(LIRGeneratorTool gen, Value a, Value b) {
            setOutput("a", a);
            setOutput("b", b);
            setResult(a);
        }
    };

    @SuppressWarnings("unused")
    @LIRIntrinsic
    public static int copyInt(LIRTestSpecification spec, int a, int b) {
        return a;
    }

    public static int[] testGetOutput(int a, int b, int[] out) {
        out[0] = copyInt(stackCopy, a, b);
        out[1] = getOutput(stackCopy, "a", a);
        out[2] = getOutput(stackCopy, "b", b);
        return out;
    }

    @Test
    public void runInt() throws Throwable {
        runTest("testGetOutput", Integer.MIN_VALUE, 0, supply(() -> new int[3]));
        runTest("testGetOutput", -1, Integer.MAX_VALUE, supply(() -> new int[3]));
        runTest("testGetOutput", 0, 42, supply(() -> new int[3]));
        runTest("testGetOutput", 1, -0xFFAA44, supply(() -> new int[3]));
        runTest("testGetOutput", Integer.MAX_VALUE, -42, supply(() -> new int[3]));
    }
}
