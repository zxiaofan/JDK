/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.junit.Test;

public class ConditionalEliminationTest12 extends ConditionalEliminationTestBase {

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }

    static class D extends C {

    }

    @SuppressWarnings({"static-method", "unused"})
    private int referenceMethod(Object a) {
        if (a instanceof A) {
            if (a instanceof C) {
                return 1;
            } else {
                GraalDirectives.deoptimizeAndInvalidate();
            }
        }
        return 0;
    }

    @SuppressWarnings({"static-method", "unused"})
    private int testMethod(Object a) {
        if (a instanceof A) {
            if (a instanceof C) {
                if (a instanceof B) {
                    B b = (B) a;
                    if (b instanceof C) {
                        return 1;
                    } else {
                        GraalDirectives.deoptimizeAndInvalidate();
                    }
                }
            } else {
                GraalDirectives.deoptimizeAndInvalidate();
            }
        }
        return 0;
    }

    @SuppressWarnings("unused")
    @Test
    public void testFloatingGuards() {
        // Make sure class D is loaded.
        D d = new D();
        testConditionalElimination("testMethod", "referenceMethod");
    }
}
