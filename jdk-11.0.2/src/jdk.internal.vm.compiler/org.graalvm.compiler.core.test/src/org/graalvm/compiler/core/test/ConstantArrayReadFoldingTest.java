/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

public class ConstantArrayReadFoldingTest extends GraalCompilerTest {

    enum E {
        A(0.001),
        B(0.01),
        C(0.5),
        D(2.0),
        E(3.0),
        F(4.0),
        G(5.0);

        public final double ceiling;
        public double weight;

        E(double ceiling) {
            this.ceiling = ceiling;
        }
    }

    public Object test1Snippet(double value) {
        for (E kind : E.values()) {
            if (value <= kind.ceiling) {
                return kind;
            }
        }
        throw new IllegalArgumentException();
    }

    @Test
    public void test1() {
        test("test1Snippet", 1.0);
        test("test1Snippet", 2.0);
    }

}
