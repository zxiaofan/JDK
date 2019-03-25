/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Assert;
import org.junit.Test;

import static org.graalvm.compiler.core.common.GraalOptions.MaximumInliningSize;
import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.options.OptionValues;

public class GuardMovement extends JTTTest {

    private static int staticValue;

    private static class A {
        int x;
        int y;
    }

    public int foo(A a) {
        Assert.assertNotEquals("a cannot be null, because a field of a is accessed before the call", a, null);
        return 42;
    }

    @SuppressWarnings("all")
    public int test(A a) {

        int value;
        int result = 0;

        // Use a condition that folds after floating guards and before guard lowering.
        // After disabling PEA and read elimination, the following condition does the trick.
        if (staticValue == staticValue) {
            // Access a.x to generate a null checked value.
            value = a.x;
            result = foo(a);
        }

        // Access a.y to generate another null checked value.
        return result + a.y;
    }

    @Test
    public void run0() throws Throwable {
        OptionValues options = new OptionValues(getInitialOptions(), MaximumInliningSize, -1, GraalOptions.TrivialInliningSize, -1, GraalOptions.PartialEscapeAnalysis, false,
                        GraalOptions.OptReadElimination, false);
        runTest(options, "test", new A());
        runTest(options, "test", new Object[]{null});
    }
}
