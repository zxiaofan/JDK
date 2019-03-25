/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import java.util.EnumSet;

import jdk.vm.ci.meta.DeoptimizationReason;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.OptimisticOptimizations.Optimization;
import org.graalvm.compiler.phases.tiers.HighTierContext;

public class ConditionalElimination02 extends JTTTest {

    private static Object o = null;

    private static class A {

        A(int y) {
            this.y = y;
        }

        int y;
    }

    public int test(A a, boolean isNull, boolean isVeryNull) {
        if (o == null) {
            if (!isNull) {
                if (o == null) {
                    return a.y;
                }
            }
            if (!isVeryNull) {
                if (o == null) {
                    return a.y;
                }
            }
        }
        return -1;
    }

    /**
     * These tests assume all code paths are reachable so disable profile based dead code removal.
     */
    @Override
    protected HighTierContext getDefaultHighTierContext() {
        return new HighTierContext(getProviders(), getDefaultGraphBuilderSuite(), OptimisticOptimizations.ALL.remove(Optimization.RemoveNeverExecutedCode));
    }

    @Test
    public void run0() throws Throwable {
        runTest(EnumSet.of(DeoptimizationReason.NullCheckException), "test", new A(5), false, false);
    }

    @Test
    public void run1() throws Throwable {
        runTest(EnumSet.of(DeoptimizationReason.NullCheckException), "test", new Object[]{null, true, true});
    }

}
