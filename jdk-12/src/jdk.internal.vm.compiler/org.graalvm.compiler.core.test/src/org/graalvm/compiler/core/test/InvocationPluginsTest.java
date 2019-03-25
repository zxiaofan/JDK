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


package org.graalvm.compiler.core.test;

import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin.Receiver;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.LateRegistration;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.Registration;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class InvocationPluginsTest extends GraalCompilerTest {

    private static void assertNotIsEmpty(InvocationPlugins invocationPlugins) {
        InvocationPlugins childInvocationPlugins = new InvocationPlugins(invocationPlugins);
        assertFalse(invocationPlugins.isEmpty());
        assertFalse(childInvocationPlugins.isEmpty());

        invocationPlugins.closeRegistration();
        assertFalse(invocationPlugins.isEmpty());
        assertFalse(childInvocationPlugins.isEmpty());
    }

    @Test
    public void testIsEmptyWithNormalRegistration() {
        InvocationPlugins invocationPlugins = new InvocationPlugins();
        assertTrue(invocationPlugins.isEmpty());

        Registration r = new Registration(invocationPlugins, Class.class);
        r.register1("isAnonymousClass", Receiver.class, new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver) {
                return false;
            }
        });

        assertNotIsEmpty(invocationPlugins);
    }

    @Test
    public void testIsEmptyWithDeferredRegistration() {
        InvocationPlugins invocationPlugins = new InvocationPlugins();
        assertTrue(invocationPlugins.isEmpty());
        invocationPlugins.defer(new Runnable() {

            @Override
            public void run() {
                Registration r = new Registration(invocationPlugins, Class.class);
                r.register1("isAnonymousClass", Receiver.class, new InvocationPlugin() {
                    @Override
                    public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver) {
                        return false;
                    }
                });
            }
        });

        assertNotIsEmpty(invocationPlugins);
    }

    @Test
    public void testIsEmptyWithLateRegistration() {
        InvocationPlugins invocationPlugins = new InvocationPlugins();
        assertTrue(invocationPlugins.isEmpty());

        try (LateRegistration lr = new LateRegistration(invocationPlugins, Class.class)) {
            lr.register(new InvocationPlugin() {
                @Override
                public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver) {
                    return false;
                }
            }, "isAnonymousClass", Receiver.class);
        }
        assertNotIsEmpty(invocationPlugins);
    }
}
