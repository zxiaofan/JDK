/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64.test;

import static org.graalvm.compiler.core.common.GraalOptions.OptImplicitNullChecks;

import org.graalvm.compiler.hotspot.test.HotSpotGraalCompilerTest;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Assume;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Ensures that frame omission works in cases where it is expected to.
 */
public class CompressedNullCheckTest extends HotSpotGraalCompilerTest {

    private static final class Container {
        Integer i;
    }

    public static void testSnippet(Container c) {
        c.i.intValue();
    }

    @SuppressWarnings("try")
    private void testImplicit(Integer i) {
        Assume.assumeTrue(runtime().getVMConfig().useCompressedOops);

        Container c = new Container();
        c.i = i;

        ResolvedJavaMethod method = getResolvedJavaMethod("testSnippet");
        Result expect = executeExpected(method, null, c);

        // make sure we don't get a profile that removes the implicit null check
        method.reprofile();

        OptionValues options = new OptionValues(getInitialOptions(), OptImplicitNullChecks, true);
        Result actual = executeActual(options, method, null, c);
        assertEquals(expect, actual);
    }

    @SuppressWarnings("try")
    private void testExplicit(Integer i) {
        Assume.assumeTrue(runtime().getVMConfig().useCompressedOops);

        Container c = new Container();
        c.i = i;

        test(new OptionValues(getInitialOptions(), OptImplicitNullChecks, false), "testSnippet", c);
    }

    @Test
    public void implicit() {
        testImplicit(new Integer(1));
    }

    @Test
    public void implicitNull() {
        testImplicit(null);
    }

    @Test
    public void explicit() {
        testExplicit(new Integer(1));
    }

    @Test
    public void explicitNull() {
        testExplicit(null);
    }
}
