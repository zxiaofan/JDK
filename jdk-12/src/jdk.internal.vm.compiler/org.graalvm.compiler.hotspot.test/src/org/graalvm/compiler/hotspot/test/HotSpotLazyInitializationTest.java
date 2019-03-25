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


package org.graalvm.compiler.hotspot.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.hotspot.meta.HotSpotClassInitializationPlugin;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class HotSpotLazyInitializationTest extends GraalCompilerTest {

    HotSpotClassInitializationPlugin classInitPlugin = new HotSpotClassInitializationPlugin();

    @Override
    protected Plugins getDefaultGraphBuilderPlugins() {
        Plugins plugins = super.getDefaultGraphBuilderPlugins();
        plugins.setClassInitializationPlugin(classInitPlugin);
        return plugins;
    }

    static boolean initializerRun = false;

    static class X {
        static {
            initializerRun = true;
        }

        static void foo() {
        }
    }

    public static void invokeStatic() {
        X.foo();
    }

    // If constant pool can do eager resolve without eager initialization, then fail if the compiler
    // causes the static initializer to run.
    private void test(String name) {
        ResolvedJavaMethod method = getResolvedJavaMethod(name);
        Assume.assumeTrue("skipping for old JVMCI", classInitPlugin.supportsLazyInitialization(method.getConstantPool()));
        parseEager(method, AllowAssumptions.NO);
        Assert.assertFalse(initializerRun);
    }

    @Test
    public void test1() {
        test("invokeStatic");
    }

}
