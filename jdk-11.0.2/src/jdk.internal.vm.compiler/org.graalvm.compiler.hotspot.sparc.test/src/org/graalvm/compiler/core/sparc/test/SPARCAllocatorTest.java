/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.test.backend.AllocatorTest;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotBackend;
import org.junit.Before;
import org.junit.Test;

import jdk.vm.ci.sparc.SPARC;

public class SPARCAllocatorTest extends AllocatorTest {

    private final GraalHotSpotVMConfig config = ((HotSpotBackend) getBackend()).getRuntime().getVMConfig();

    @Before
    public void checkSPARC() {
        assumeTrue("skipping SPARC specific test", getTarget().arch instanceof SPARC);
        assumeTrue("RegisterPressure is set -> skip", RegisterPressure.getValue(getInitialOptions()) == null);
        assumeTrue("TraceRA is set -> skip", !TraceRA.getValue(getInitialOptions()));
    }

    @Test
    public void test1() {
        testAllocation("test1snippet", config.threadLocalHandshakes ? 1 : 2, 0, 0);
    }

    public static long test1snippet(long x) {
        return x + 41;
    }

    @Test
    public void test2() {
        testAllocation("test2snippet", config.threadLocalHandshakes ? 1 : 2, 0, 0);
    }

    public static long test2snippet(long x) {
        return x * 41;
    }

    @Test
    public void test3() {
        testAllocation("test3snippet", config.threadLocalHandshakes ? 3 : 4, 0, 0);
    }

    public static long test3snippet(long x) {
        return x / 41 + x % 41;
    }

}
