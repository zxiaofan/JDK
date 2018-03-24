/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.sparc.test;

import static org.graalvm.compiler.core.common.GraalOptions.RegisterPressure;
import static org.graalvm.compiler.core.common.GraalOptions.TraceRA;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import org.graalvm.compiler.core.test.backend.AllocatorTest;

import jdk.vm.ci.sparc.SPARC;

public class SPARCAllocatorTest extends AllocatorTest {

    @Before
    public void checkSPARC() {
        assumeTrue("skipping SPARC specific test", getTarget().arch instanceof SPARC);
        assumeTrue("RegisterPressure is set -> skip", RegisterPressure.getValue(getInitialOptions()) == null);
        assumeTrue("TraceRA is set -> skip", !TraceRA.getValue(getInitialOptions()));
    }

    @Test
    public void test1() {
        testAllocation("test1snippet", 2, 0, 0);
    }

    public static long test1snippet(long x) {
        return x + 41;
    }

    @Test
    public void test2() {
        testAllocation("test2snippet", 2, 0, 0);
    }

    public static long test2snippet(long x) {
        return x * 41;
    }

    @Test
    public void test3() {
        testAllocation("test3snippet", 4, 0, 0);
    }

    public static long test3snippet(long x) {
        return x / 41 + x % 41;
    }

}
