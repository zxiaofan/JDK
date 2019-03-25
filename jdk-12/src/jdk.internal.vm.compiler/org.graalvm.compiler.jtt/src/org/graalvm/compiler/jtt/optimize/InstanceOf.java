/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.java.InstanceOfNode;
import org.junit.Test;

/**
 * A few tests of expected simplifications by {@link InstanceOfNode#implies(boolean, LogicNode)}.
 */
public class InstanceOf extends JTTTest {

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }

    public boolean testSnippet1(Object o) {
        if (o instanceof B) {
            if (o instanceof A) {
                return true;
            }
        }
        return false;
    }

    public boolean testSnippet2(Object o) {
        if (o instanceof A) {
            return true;
        } else {
            return o instanceof B;
        }
    }

    @Test
    public void test1() {
        runTest("testSnippet1", new A());
        runTest("testSnippet1", new B());
        runTest("testSnippet1", new C());
    }

    @Test
    public void test2() {
        runTest("testSnippet2", new A());
        runTest("testSnippet2", new B());
        runTest("testSnippet2", new C());
    }
}
