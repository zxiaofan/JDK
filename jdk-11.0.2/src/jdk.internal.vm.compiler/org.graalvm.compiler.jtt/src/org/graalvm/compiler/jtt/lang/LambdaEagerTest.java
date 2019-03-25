/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.lang;

import static org.graalvm.compiler.core.common.GraalOptions.InlineEverything;

import java.util.EnumSet;
import java.util.function.IntBinaryOperator;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Test;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.DeoptimizationReason;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class LambdaEagerTest extends GraalCompilerTest {

    private static final EnumSet<DeoptimizationReason> UNRESOLVED_UNREACHED = EnumSet.of(DeoptimizationReason.Unresolved, DeoptimizationReason.UnreachedCode);

    private static int doBinary(IntBinaryOperator op, int x, int y) {
        return op.applyAsInt(x, y);
    }

    private static int add(int x, int y) {
        return x + y;
    }

    public static int nonCapturing(int x, int y) {
        return doBinary((a, b) -> a + b, x, y);
    }

    public static int nonCapturing2(int x, int y) {
        return doBinary(LambdaEagerTest::add, x, y);
    }

    public static int capturing(int x, int y, int z) {
        return doBinary((a, b) -> a + b - z, x, y);
    }

    @Test
    public void testEagerResolveNonCapturing01() {
        Result expected = new Result(3, null);
        testAgainstExpected(getResolvedJavaMethod("nonCapturing"), expected, UNRESOLVED_UNREACHED, 1, 2);
    }

    @Test
    public void testEagerResolveNonCapturing02() {
        Result expected = new Result(3, null);
        testAgainstExpected(getResolvedJavaMethod("nonCapturing2"), expected, UNRESOLVED_UNREACHED, 1, 2);
    }

    @Test
    public void testEagerResolveCapturing() {
        Result expected = new Result(0, null);
        testAgainstExpected(getResolvedJavaMethod("capturing"), expected, UNRESOLVED_UNREACHED, 1, 2, 3);
    }

    @Override
    @SuppressWarnings("try")
    protected InstalledCode getCode(ResolvedJavaMethod installedCodeOwner, StructuredGraph graph, boolean forceCompile, boolean installAsDefault, OptionValues options) {
        assert graph == null;
        return super.getCode(installedCodeOwner, graph, forceCompile, installAsDefault, new OptionValues(options, InlineEverything, true));
    }
}
