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


package org.graalvm.compiler.core.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class EnumValuesTest extends GraalCompilerTest {

    private static final int NANOS_INDEX = Arrays.asList(TimeUnit.values()).indexOf(TimeUnit.NANOSECONDS);

    @SuppressWarnings("unused")
    public static void iterateUnits() {
        for (TimeUnit unit : TimeUnit.values()) {
            // nop
        }
    }

    public static void empty() {
    }

    @Test
    public void test0() {
        assertEquals(getFinalGraph("empty"), getFinalGraph("iterateUnits"));
    }

    public static TimeUnit getNanosValues() {
        return TimeUnit.values()[NANOS_INDEX];
    }

    public static TimeUnit getNanos() {
        return TimeUnit.NANOSECONDS;
    }

    @Test
    public void test1() {
        assertEquals(getFinalGraph("getNanos"), getFinalGraph("getNanosValues"));
    }
}
