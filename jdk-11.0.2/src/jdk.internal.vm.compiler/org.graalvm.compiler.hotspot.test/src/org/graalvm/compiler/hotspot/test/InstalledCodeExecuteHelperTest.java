/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static java.lang.reflect.Modifier.isStatic;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.Builder;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.junit.Assert;
import org.junit.Test;

import jdk.vm.ci.code.InvalidInstalledCodeException;
import jdk.vm.ci.hotspot.HotSpotInstalledCode;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class InstalledCodeExecuteHelperTest extends GraalCompilerTest {

    private static final int ITERATIONS = 100000;
    Object[] argsToBind;

    @Test
    public void test1() throws InvalidInstalledCodeException {
        final ResolvedJavaMethod fooMethod = getResolvedJavaMethod("foo");
        final HotSpotInstalledCode fooCode = (HotSpotInstalledCode) getCode(fooMethod);

        argsToBind = new Object[]{fooCode};

        final ResolvedJavaMethod benchmarkMethod = getResolvedJavaMethod("benchmark");
        final HotSpotInstalledCode installedBenchmarkCode = (HotSpotInstalledCode) getCode(benchmarkMethod);

        Assert.assertEquals(Integer.valueOf(42), benchmark(fooCode));

        Assert.assertEquals(Integer.valueOf(42), installedBenchmarkCode.executeVarargs(argsToBind[0]));

    }

    public static Integer benchmark(HotSpotInstalledCode code) throws InvalidInstalledCodeException {
        int val = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < ITERATIONS; i++) {
                val = (Integer) code.executeVarargs();
            }
        }
        return val;
    }

    public static Integer foo() {
        return 42;
    }

    @Override
    protected StructuredGraph parse(Builder builder, PhaseSuite<HighTierContext> graphBuilderSuite) {
        StructuredGraph graph = super.parse(builder, graphBuilderSuite);
        if (argsToBind != null) {
            ResolvedJavaMethod m = graph.method();
            Object receiver = isStatic(m.getModifiers()) ? null : this;
            Object[] args = argsWithReceiver(receiver, argsToBind);
            JavaType[] parameterTypes = m.toParameterTypes();
            assert parameterTypes.length == args.length;
            for (int i = 0; i < argsToBind.length; i++) {
                ParameterNode param = graph.getParameter(i);
                JavaConstant c = getSnippetReflection().forBoxed(parameterTypes[i].getJavaKind(), argsToBind[i]);
                ConstantNode replacement = ConstantNode.forConstant(c, getMetaAccess(), graph);
                param.replaceAtUsages(replacement);
            }
        }
        return graph;
    }
}
