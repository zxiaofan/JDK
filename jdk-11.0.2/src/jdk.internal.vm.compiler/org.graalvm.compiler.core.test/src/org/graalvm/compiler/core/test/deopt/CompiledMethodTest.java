/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test.deopt;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.DeadCodeEliminationPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Assert;
import org.junit.Test;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.code.InvalidInstalledCodeException;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class CompiledMethodTest extends GraalCompilerTest {

    public static Object testMethod(Object arg1, Object arg2, Object arg3) {
        String res = arg1 + " " + arg2 + " " + arg3;
        return GraalDirectives.inCompiledCode() ? res : "interpreter";
    }

    Object f1;

    public Object testMethodVirtual(Object arg1, Object arg2, Object arg3) {
        return f1 + " " + arg1 + " " + arg2 + " " + arg3;
    }

    /**
     * Usages of the constant {@code " "} are replaced with the constant {@code "-"} and it is
     * verified that executing the compiled code produces a result that the preserves the node
     * replacement unless deoptimization occurs (e.g., due to -Xcomp causing profiles to be
     * missing).
     */
    @Test
    public void test1() {
        final ResolvedJavaMethod javaMethod = getResolvedJavaMethod("testMethod");
        final StructuredGraph graph = parseEager(javaMethod, AllowAssumptions.NO);
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        new DeadCodeEliminationPhase().apply(graph);

        for (ConstantNode node : ConstantNode.getConstantNodes(graph)) {
            if (node.getStackKind() == JavaKind.Object && " ".equals(getSnippetReflection().asObject(String.class, node.asJavaConstant()))) {
                node.replace(graph, ConstantNode.forConstant(getSnippetReflection().forObject("-"), getMetaAccess(), graph));
            }
        }

        InstalledCode compiledMethod = getCode(javaMethod, graph);
        try {
            Object result = compiledMethod.executeVarargs("1", "2", "3");
            if (!"1-2-3".equals(result)) {
                // Deoptimization probably occurred
                Assert.assertEquals("interpreter", result);
            }
        } catch (InvalidInstalledCodeException t) {
            Assert.fail("method invalidated");
        }
    }

    @Test
    public void test3() {
        final ResolvedJavaMethod javaMethod = getResolvedJavaMethod("testMethod");
        InstalledCode compiledMethod = getCode(javaMethod);
        try {
            Object result = compiledMethod.executeVarargs("1", "2", "3");
            Assert.assertEquals("1 2 3", result);
        } catch (InvalidInstalledCodeException t) {
            Assert.fail("method invalidated");
        }
    }

    @Test
    public void test4() {
        final ResolvedJavaMethod javaMethod = getResolvedJavaMethod("testMethodVirtual");
        InstalledCode compiledMethod = getCode(javaMethod);
        try {
            f1 = "0";
            Object result = compiledMethod.executeVarargs(this, "1", "2", "3");
            Assert.assertEquals("0 1 2 3", result);
        } catch (InvalidInstalledCodeException t) {
            Assert.fail("method invalidated");
        }
    }
}
