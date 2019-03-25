/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;
import org.graalvm.compiler.nodes.extended.BytecodeExceptionNode.BytecodeExceptionKind;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class NullBytecodeExceptionTest extends BytecodeExceptionTest {

    private static class Exceptions {

        private static Object obj = null;

        public static void throwNull() {
            obj.toString();
        }
    }

    @Override
    protected void registerInvocationPlugins(InvocationPlugins invocationPlugins) {
        invocationPlugins.register(new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver) {
                return throwBytecodeException(b, BytecodeExceptionKind.NULL_POINTER);
            }
        }, Exceptions.class, "throwNull");
        super.registerInvocationPlugins(invocationPlugins);
    }

    public static void nullSnippet() {
        Exceptions.throwNull();
    }

    @Test
    public void testNullPointerException() {
        test("nullSnippet");
    }
}
