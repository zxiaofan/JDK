/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.java.BytecodeParserOptions;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Assert;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Tests that the defaults for {@link GraalOptions#TrivialInliningSize} and
 * {@link BytecodeParserOptions#InlineDuringParsingMaxDepth} prevent explosive graph growth for code
 * with small recursive methods.
 */
public class TrivialInliningExplosionTest extends GraalCompilerTest {

    public static void trivial() {
        trivial();
        trivial();
        trivial();
    }

    public static void main() {
        trivial();
        trivial();
        trivial();
        trivial();
        trivial();
        trivial();
        trivial();
        trivial();
        trivial();
    }

    private int afterParseSize;

    @Override
    protected StructuredGraph parseForCompile(ResolvedJavaMethod method, CompilationIdentifier compilationId, OptionValues options) {
        final StructuredGraph graph = super.parseForCompile(method, compilationId, options);
        this.afterParseSize = graph.getNodeCount();
        return graph;
    }

    @Test
    public void test() {
        ResolvedJavaMethod methodm0 = getResolvedJavaMethod("trivial");
        Assert.assertTrue(methodm0.getCodeSize() <= GraalOptions.TrivialInliningSize.getValue(getInitialOptions()));
        test("main");
        int afterCompileSize = lastCompiledGraph.getNodeCount();

        // The values of afterParseSize and afterCompileSize when this
        // test was written were 3223 and 3505 respectively.
        Assert.assertTrue(afterParseSize < 4000);
        Assert.assertTrue(afterCompileSize < 4000);

    }
}
