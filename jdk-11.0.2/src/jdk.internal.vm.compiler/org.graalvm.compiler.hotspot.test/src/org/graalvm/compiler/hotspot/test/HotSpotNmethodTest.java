/*
 * Copyright (c) 2013, 2013, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;

import jdk.vm.ci.code.InvalidInstalledCodeException;
import jdk.vm.ci.hotspot.HotSpotNmethod;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class HotSpotNmethodTest extends GraalCompilerTest {

    private static final int ITERATION_COUNT = 100000;

    @Test
    public void testInstallCodeInvalidation() {
        final ResolvedJavaMethod testJavaMethod = getResolvedJavaMethod("foo");
        final HotSpotNmethod nmethod = (HotSpotNmethod) getCode(testJavaMethod, parseEager("otherFoo", AllowAssumptions.YES));
        Assert.assertTrue(nmethod.isValid());
        Object result;
        try {
            result = nmethod.executeVarargs(null, "b", "c");
            assertDeepEquals(43, result);
        } catch (InvalidInstalledCodeException e) {
            Assert.fail("Code was invalidated");
        }
        Assert.assertTrue(nmethod.isValid());
        nmethod.invalidate();
        Assert.assertFalse(nmethod.isValid());
        try {
            result = nmethod.executeVarargs(null, null, null);
            Assert.fail("Code was not invalidated");
        } catch (InvalidInstalledCodeException e) {
        }
        Assert.assertFalse(nmethod.isValid());
    }

    @Test
    public void testInstallCodeInvalidationWhileRunning() {
        final ResolvedJavaMethod testJavaMethod = getResolvedJavaMethod("foo");
        final HotSpotNmethod nmethod = (HotSpotNmethod) getCode(testJavaMethod, parseEager("otherFoo", AllowAssumptions.YES));
        Object result;
        try {
            result = nmethod.executeVarargs(nmethod, null, null);
            assertDeepEquals(43, result);
        } catch (InvalidInstalledCodeException e) {
            Assert.fail("Code was invalidated");
        }
        Assert.assertFalse(nmethod.isValid());
    }

    @Test
    public void testInstalledCodeCalledFromCompiledCode() {
        final ResolvedJavaMethod testJavaMethod = getResolvedJavaMethod("foo");
        final HotSpotNmethod nmethod = (HotSpotNmethod) getCode(testJavaMethod, parseEager("otherFoo", AllowAssumptions.YES));
        Assert.assertTrue(nmethod.isValid());
        try {
            for (int i = 0; i < ITERATION_COUNT; ++i) {
                nmethod.executeVarargs(null, "b", "c");
            }
        } catch (InvalidInstalledCodeException e) {
            Assert.fail("Code was invalidated");
        }
    }

    @SuppressWarnings("unused")
    public static Object foo(HotSpotNmethod method, Object a2, Object a3) {
        return 42;
    }

    @SuppressWarnings("unused")
    public static Object otherFoo(HotSpotNmethod method, Object a2, Object a3) {
        if (method != null) {
            method.invalidate();
        }
        return 43;
    }
}
