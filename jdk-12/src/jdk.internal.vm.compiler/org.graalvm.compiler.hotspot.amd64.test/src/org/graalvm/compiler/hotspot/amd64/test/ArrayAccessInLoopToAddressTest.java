/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64.test;

import jdk.vm.ci.hotspot.HotSpotSpeculationLog;
import jdk.vm.ci.meta.SpeculationLog;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.junit.Test;

public class ArrayAccessInLoopToAddressTest extends GraalCompilerTest {

    public static int positiveInductionVariable(short[] array) {
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sum += array[i + 1];
        }
        return sum;
    }

    @Test
    public void testPositiveInductionVariable() {
        test("positiveInductionVariable", new short[]{1, 3, 7, 9});
    }

    public static int negativeInductionVariable(short[] array) {
        int sum = 0;
        for (int i = -array.length; i < array.length - 4; i++) {
            sum += array[i + 4];
        }
        return sum;
    }

    @Test
    public void testNegativeInductionVariable() {
        test("negativeInductionVariable", new short[]{1, 3, 7, 9});
    }

    @Override
    protected SpeculationLog getSpeculationLog() {
        return new HotSpotSpeculationLog();
    }

}
