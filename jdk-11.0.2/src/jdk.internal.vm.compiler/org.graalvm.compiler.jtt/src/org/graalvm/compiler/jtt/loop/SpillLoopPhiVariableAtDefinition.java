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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.jtt.JTTTest;

public class SpillLoopPhiVariableAtDefinition extends JTTTest {

    public static int test(int arg) {
        int count = arg;
        for (int i = 0; i < arg; i++) {
            GraalDirectives.bindToRegister(count);
            GraalDirectives.spillRegisters();
            GraalDirectives.bindToRegister(count);
            if (i == 0) {
                GraalDirectives.spillRegisters();
                continue;
            }
            GraalDirectives.spillRegisters();
            count++;
        }
        return count;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 25);
    }

}
