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
/*
 */


package org.graalvm.compiler.core.test;

import org.junit.Test;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.core.phases.HighTier;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.tiers.Suites;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public final class DontReuseArgumentSpaceTest extends GraalCompilerTest {

    @Override
    @SuppressWarnings("try")
    protected Suites createSuites(OptionValues options) {
        return super.createSuites(new OptionValues(options, HighTier.Options.Inline, false));
    }

    @BytecodeParserNeverInline
    public static int killArguments(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
        return a + b + c + d + e + f + g + h + i + j;
    }

    @BytecodeParserNeverInline
    public static int callTwice(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
        /*
         * Call the same method twice so the arguments are in the same place each time and might
         * appear to be redundant moves.
         */
        killArguments(a, b, c, d, e, f, g, h, i, j);
        return killArguments(a, b, c, d, e, f, g, h, i, j);
    }

    @Test
    public void run0() throws Throwable {
        /*
         * Exercise the methods once so everything is resolved
         */
        callTwice(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*
         * Create a standalone compile of killArguments. This test assumes that zapping of argument
         * space is being performed by the backend.
         */
        ResolvedJavaMethod javaMethod = getResolvedJavaMethod("killArguments");
        StructuredGraph graph = parseEager(javaMethod, AllowAssumptions.YES);
        CompilationResult compilationResult = compile(javaMethod, graph);
        DebugContext debug = getDebugContext();
        getBackend().createDefaultInstalledCode(debug, javaMethod, compilationResult);

        test("callTwice", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
