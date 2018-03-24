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

}
