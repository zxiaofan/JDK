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


package org.graalvm.compiler.jtt.backend;

import static org.graalvm.compiler.api.directives.GraalDirectives.LIKELY_PROBABILITY;
import static org.graalvm.compiler.api.directives.GraalDirectives.injectBranchProbability;
import static org.graalvm.compiler.core.common.GraalOptions.MaximumInliningSize;
import java.lang.reflect.Method;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.options.OptionValues;

public class ConstantPhiTest extends JTTTest {

    public static int test(int i, int x) throws Throwable {
        int r;
        if (injectBranchProbability(LIKELY_PROBABILITY, i < 0)) {
            r = 42;
        } else {
            r = x;
        }
        destroyCallerSavedValues();
        return r;
    }

    protected static void destroyCallerSavedValues() throws Throwable {
        Class<ConstantPhiTest> c = ConstantPhiTest.class;
        Method m = c.getMethod("destroyCallerSavedValues0");
        m.invoke(null);
    }

    public static void destroyCallerSavedValues0() {
    }

    @Test
    @SuppressWarnings("try")
    public void run0() {
        runTest(new OptionValues(getInitialOptions(), MaximumInliningSize, -1), "test", 0, 0xDEADDEAD);
    }

    @Test
    @SuppressWarnings("try")
    public void run1() {
        runTest(new OptionValues(getInitialOptions(), MaximumInliningSize, -1), "test", -1, 0xDEADDEAD);
    }

    @Test
    @SuppressWarnings("try")
    public void run2() {
        runTest(new OptionValues(getInitialOptions(), MaximumInliningSize, -1), "test", 1, 0xDEADDEAD);
    }
}
