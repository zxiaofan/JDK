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


package org.graalvm.compiler.nodes.test;

import java.lang.reflect.Constructor;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.junit.Test;

public class StaticFieldAccessTest extends GraalCompilerTest {

    static StaticFieldAccessTest tester;

    public static class Inner {
        static Object o;

        static {
            Constructor<?>[] c = Inner.class.getConstructors();
            if (c.length != 1) {
                throw new InternalError("can't find single constructor");
            }
            tester.parse(tester.builder(tester.asResolvedJavaMethod(c[0]), AllowAssumptions.YES), tester.getDebugGraphBuilderSuite());
        }

        public Inner(Object o) {
            Inner.o = o;
        }
    }

    @Test
    public void test() {
        tester = this;
    }
}
