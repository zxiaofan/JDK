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



package org.graalvm.compiler.hotspot.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.junit.Test;

public class ClassSubstitutionsTests extends GraalCompilerTest {

    public Number instanceField;

    public Object[] arrayField;

    public String[] stringArrayField;

    @SuppressWarnings("try")
    protected StructuredGraph test(final String snippet) {
        DebugContext debug = getDebugContext();
        try (DebugContext.Scope s = debug.scope("ClassSubstitutionsTest", getMetaAccess().lookupJavaMethod(getMethod(snippet)))) {
            StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES, debug);
            compile(graph.method(), graph);
            assertNotInGraph(graph, Invoke.class);
            debug.dump(DebugContext.BASIC_LEVEL, graph, snippet);
            return graph;
        } catch (Throwable e) {
            throw debug.handle(e);
        }
    }

    protected static StructuredGraph assertNotInGraph(StructuredGraph graph, Class<?> clazz) {
        for (Node node : graph.getNodes()) {
            if (clazz.isInstance(node)) {
                fail(node.toString());
            }
        }
        return graph;
    }

    public boolean constantIsArray() {
        return "".getClass().isArray();
    }

    public boolean constantIsInterface() {
        return "".getClass().isInterface();
    }

    public boolean constantIsPrimitive() {
        return "".getClass().isPrimitive();
    }

    @Test
    public void testIsArray() {
        testConstantReturn("constantIsArray", 0);
    }

    @Test
    public void testIsInterface() {
        testConstantReturn("constantIsInterface", 0);
    }

    @Test
    public void testIsPrimitive() {
        testConstantReturn("constantIsPrimitive", 0);
    }

    public boolean fieldIsNotArray() {
        if (instanceField != null) {
            // The base type of instanceField is not Object or an Interface, so it's provably an
            // instance type, so isArray will always return false.
            return instanceField.getClass().isArray();
        }
        return false;
    }

    @Test
    public void testFieldIsNotArray() {
        testConstantReturn("fieldIsNotArray", 0);
    }

    public boolean foldComponentType() {
        return stringArrayField.getClass().getComponentType() == String.class;
    }

    @Test
    public void testFoldComponentType() {
        testConstantReturn("foldComponentType", 1);
    }

    @Test
    public void testFieldIsArray() {
        testConstantReturn("fieldIsArray", 1);
    }

    public boolean fieldIsArray() {
        if (arrayField != null) {
            // The base type of arrayField is an array of some sort so isArray will always return
            // true.
            return arrayField.getClass().isArray();
        }
        return true;
    }

    private static class A {
    }

    private static class B extends A {
    }

    private static class C {
    }

    private static final A a = new A();
    private static final B b = new B();
    private static final C c = new C();

    public boolean classIsAssignable1() {
        return a.getClass().isAssignableFrom(a.getClass());
    }

    public boolean classIsAssignable2() {
        return a.getClass().isAssignableFrom(b.getClass());
    }

    public boolean classIsAssignable3() {
        return a.getClass().isAssignableFrom(c.getClass());
    }

    public boolean classIsAssignable4() {
        return b.getClass().isAssignableFrom(a.getClass());
    }

    public boolean classIsAssignable5() {
        return c.getClass().isAssignableFrom(b.getClass());
    }

    public boolean classIsAssignable6() {
        return int.class.isAssignableFrom(b.getClass());
    }

    public boolean classIsAssignable7() {
        return int.class.isAssignableFrom(int.class);
    }

    @Test
    public void testClassIsAssignable() {
        testConstantReturn("classIsAssignable1", 1);
        testConstantReturn("classIsAssignable2", 1);
        testConstantReturn("classIsAssignable3", 0);
        testConstantReturn("classIsAssignable4", 0);
        testConstantReturn("classIsAssignable5", 0);
        testConstantReturn("classIsAssignable6", 0);
        testConstantReturn("classIsAssignable7", 1);
    }

    private void testConstantReturn(String name, Object value) {
        StructuredGraph result = test(name);
        ReturnNode ret = result.getNodes(ReturnNode.TYPE).first();
        assertDeepEquals(1, result.getNodes(ReturnNode.TYPE).count());

        assertDeepEquals(true, ret.result().isConstant());
        assertDeepEquals(value, ret.result().asJavaConstant().asBoxedPrimitive());
    }
}
