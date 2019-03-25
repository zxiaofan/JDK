/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;

import jdk.vm.ci.code.Architecture;
import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.Assumptions.Assumption;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.ResolvedJavaType;

public abstract class GraalCompilerAssumptionsTest extends GraalCompilerTest {

    public GraalCompilerAssumptionsTest() {
        super();
    }

    public GraalCompilerAssumptionsTest(Class<? extends Architecture> arch) {
        super(arch);
    }

    protected void testAssumptionInvalidate(String methodName, Assumption expected, String classToLoad) {
        testAssumption(methodName, expected, classToLoad, true);
    }

    /**
     * Checks the behavior of class loading on {@link Assumption invalidation}. {@code methodName}
     * is compiled and the resulting graph is checked for {@code expectedAssumption}. The code is
     * installed and optionally {@code classToLoad} is loaded. The class is assumed to be an inner
     * class of the test class and the name of the class to load is constructed relative to that.
     *
     * @param methodName the method to compile
     * @param expectedAssumption expected {@link Assumption} instance to find in graph
     * @param classToLoad an optional class to load to trigger an invalidation check
     * @param willInvalidate true if loading {@code classToLoad} should invalidate the method
     */
    protected void testAssumption(String methodName, Assumption expectedAssumption, String classToLoad, boolean willInvalidate) {
        ResolvedJavaMethod javaMethod = getResolvedJavaMethod(methodName);

        StructuredGraph graph = parseEager(javaMethod, AllowAssumptions.YES);
        assertTrue(!graph.getAssumptions().isEmpty());
        checkGraph(expectedAssumption, graph);

        CompilationResult compilationResult = compile(javaMethod, graph);
        final InstalledCode installedCode = getBackend().createDefaultInstalledCode(graph.getDebug(), javaMethod, compilationResult);
        assertTrue(installedCode.isValid());
        if (classToLoad != null) {
            String fullName = getClass().getName() + "$" + classToLoad;
            try {
                Class.forName(fullName);
            } catch (ClassNotFoundException e) {
                fail("Can't find class %s", fullName);
            }
            assertTrue(!willInvalidate == installedCode.isValid(), "method should be %s", willInvalidate ? "invalid" : "valid");
        }
    }

    protected void checkGraph(Assumption expectedAssumption, StructuredGraph graph) {
        boolean found = false;
        for (Assumption a : graph.getAssumptions()) {
            if (expectedAssumption.equals(a)) {
                found = true;
            }
        }
        assertTrue(found, "Can't find assumption %s", expectedAssumption);
    }

    /**
     * Converts a {@link Class} to an initialized {@link ResolvedJavaType}.
     */
    protected ResolvedJavaType resolveAndInitialize(Class<?> clazz) {
        ResolvedJavaType type = getMetaAccess().lookupJavaType(clazz);
        type.initialize();
        return type;
    }
}
