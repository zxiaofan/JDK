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


package org.graalvm.compiler.api.directives.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.OptimisticOptimizations.Optimization;
import org.graalvm.compiler.phases.tiers.HighTierContext;

/**
 * Tests for {@link GraalDirectives#blackhole}.
 *
 * There are two snippets for each kind:
 * <ul>
 * <li>blackhole&lt;Kind&gt;Snippet verifies that dead code elimination is prevented by the
 * blackhole directive.
 * <li>&lt;kind&gt;Snippet verifies that dead code elimination does happen if the blackhole
 * directive is not there.
 * </ul>
 *
 */
public class BlackholeDirectiveTest extends GraalCompilerTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    private @interface BlackholeSnippet {
        boolean expectParameterUsage();
    }

    @BlackholeSnippet(expectParameterUsage = false)
    public static int booleanSnippet(int arg) {
        boolean b = arg > 3;
        if (b) {
            return 1;
        } else {
            return 1;
        }
    }

    @BlackholeSnippet(expectParameterUsage = true)
    public static int blackholeBooleanSnippet(int arg) {
        boolean b = arg > 3;
        GraalDirectives.blackhole(b);
        if (b) {
            return 1;
        } else {
            return 1;
        }
    }

    @Test
    public void testBoolean() {
        test("booleanSnippet", 5);
        test("blackholeBooleanSnippet", 5);
    }

    @BlackholeSnippet(expectParameterUsage = false)
    public static int intSnippet(int arg) {
        int x = 42 + arg;
        return x - arg;
    }

    @BlackholeSnippet(expectParameterUsage = true)
    public static int blackholeIntSnippet(int arg) {
        int x = 42 + arg;
        GraalDirectives.blackhole(x);
        return x - arg;
    }

    @Test
    public void testInt() {
        test("intSnippet", 17);
        test("blackholeIntSnippet", 17);
    }

    private static class Dummy {
        private int x = 42;
    }

    @BlackholeSnippet(expectParameterUsage = false)
    public static int objectSnippet(int arg) {
        Dummy obj = new Dummy();
        int ret = obj.x;
        obj.x = arg;
        return ret;
    }

    @BlackholeSnippet(expectParameterUsage = true)
    public static int blackholeObjectSnippet(int arg) {
        Dummy obj = new Dummy();
        int ret = obj.x;
        obj.x = arg;
        GraalDirectives.blackhole(obj);
        return ret;
    }

    @Test
    public void testObject() {
        test("objectSnippet", 37);
        test("blackholeObjectSnippet", 37);
    }

    @Override
    protected HighTierContext getDefaultHighTierContext() {
        return new HighTierContext(getProviders(), getDefaultGraphBuilderSuite(), OptimisticOptimizations.ALL.remove(Optimization.RemoveNeverExecutedCode));
    }

    @Override
    protected boolean checkLowTierGraph(StructuredGraph graph) {
        BlackholeSnippet snippet = graph.method().getAnnotation(BlackholeSnippet.class);
        ParameterNode arg = graph.getParameter(0);
        if (snippet.expectParameterUsage()) {
            Assert.assertNotNull("couldn't find ParameterNode(0)", arg);
            Assert.assertFalse("expected usages of " + arg, arg.hasNoUsages());
        } else {
            Assert.assertTrue("expected no usages of ParameterNode", arg == null || arg.hasNoUsages());
        }
        return true;
    }
}
