/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.junit.Assert;
import org.junit.Test;

import jdk.vm.ci.meta.ProfilingInfo;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Test on-stack-replacement with Graal. The test manually triggers a Graal OSR-compilation which is
 * later invoked when hitting the backedge counter overflow.
 */
public class GraalOSRTest extends GraalOSRTestBase {

    @Test
    public void testOSR01() {
        try {
            testOSR(getInitialOptions(), "testReduceLoop");
        } catch (Throwable t) {
            Assert.assertEquals("OSR compilation without OSR entry loop.", t.getMessage());
        }
    }

    @Test
    public void testOSR02() {
        testOSR(getInitialOptions(), "testSequentialLoop");
    }

    @Test
    public void testOSR03() {
        testOSR(getInitialOptions(), "testNonReduceLoop");
    }

    static int limit = 10000;

    public static int sideEffect;

    public static ReturnValue testReduceLoop() {
        for (int i = 0; i < limit * limit; i++) {
            GraalDirectives.blackhole(i);
            if (GraalDirectives.inCompiledCode()) {
                return ReturnValue.SUCCESS;
            }
        }
        return ReturnValue.FAILURE;
    }

    public static ReturnValue testSequentialLoop() {
        ReturnValue ret = ReturnValue.FAILURE;
        for (int i = 1; i < limit * limit; i++) {
            GraalDirectives.blackhole(i);
            if (i % 7 == 0) {
                ret = ReturnValue.SUCCESS;
            }
        }
        GraalDirectives.controlFlowAnchor();
        if (sideEffect == 123) {
            return ReturnValue.SIDE;
        }
        for (int i = 1; i < limit * limit; i++) {
            GraalDirectives.blackhole(i);
            if (i % 33 == 0) {
                ret = ReturnValue.SUCCESS;
            }
        }
        GraalDirectives.controlFlowAnchor();
        return ret;
    }

    public static ReturnValue testNonReduceLoop() {
        ReturnValue ret = ReturnValue.FAILURE;
        for (int i = 0; i < limit * limit; i++) {
            GraalDirectives.blackhole(i);
            if (i % 33 == 0) {
                ret = ReturnValue.SUCCESS;
            }
        }
        GraalDirectives.controlFlowAnchor();
        return ret;
    }

    @Test
    public void testOSR04() {
        testFunnyOSR("testDoWhile", GraalOSRTest::testDoWhile);
    }

    @Test
    public void testOSR05() {
        testFunnyOSR("testDoWhileLocked", GraalOSRTest::testDoWhileLocked);
    }

    /**
     * Because of a bug in C1 profile collection HotSpot can sometimes request an OSR compilation
     * for a backedge which isn't ever taken. This test synthetically creates that situation.
     */
    private void testFunnyOSR(String name, Runnable warmup) {
        ResolvedJavaMethod method = getResolvedJavaMethod(name);
        int iterations = 0;
        while (true) {
            ProfilingInfo profilingInfo = method.getProfilingInfo();
            if (profilingInfo.isMature()) {
                break;
            }

            warmup.run();
            if (iterations++ % 1000 == 0) {
                System.err.print('.');
            }
            if (iterations > 200000) {
                throw new AssertionError("no profile");
            }
        }
        compileOSR(getInitialOptions(), method);
        Result result = executeExpected(method, null);
        checkResult(result);
    }

    private static boolean repeatLoop;

    public static ReturnValue testDoWhile() {
        do {
            sideEffect++;
        } while (repeatLoop);
        return ReturnValue.SUCCESS;
    }

    public static synchronized ReturnValue testDoWhileLocked() {
        // synchronized (GraalOSRTest.class) {
        do {
            sideEffect++;
        } while (repeatLoop);
        // }
        return ReturnValue.SUCCESS;
    }
}
