/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.BytecodeExceptionNode.BytecodeExceptionKind;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;

import jdk.vm.ci.meta.ResolvedJavaMethod;

@RunWith(Parameterized.class)
public class IndexOobBytecodeExceptionTest extends BytecodeExceptionTest {

    private static class Exceptions {

        private static Object[] empty = new Object[0];

        public static void throwOutOfBounds(int idx, int length) {
            GraalDirectives.blackhole(empty[idx]);
            GraalDirectives.blackhole(length);
        }
    }

    @Override
    protected void registerInvocationPlugins(InvocationPlugins invocationPlugins) {
        invocationPlugins.register(new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver, ValueNode idx, ValueNode length) {
                return throwBytecodeException(b, BytecodeExceptionKind.OUT_OF_BOUNDS, idx, length);
            }
        }, Exceptions.class, "throwOutOfBounds", int.class, int.class);
        super.registerInvocationPlugins(invocationPlugins);
    }

    public static void oobSnippet(int idx, int length) {
        Exceptions.throwOutOfBounds(idx, length);
    }

    @Parameter public int index;

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        int[] values = {Integer.MIN_VALUE, -42, -1, 0, 1, 42, Integer.MAX_VALUE};

        ArrayList<Object[]> ret = new ArrayList<>(values.length);
        for (int i : values) {
            ret.add(new Object[]{i});
        }
        return ret;
    }

    @Test
    public void testOutOfBoundsException() {
        test("oobSnippet", index, Exceptions.empty.length);
    }
}
