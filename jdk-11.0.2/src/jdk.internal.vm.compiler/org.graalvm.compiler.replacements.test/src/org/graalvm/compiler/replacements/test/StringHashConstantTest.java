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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import jdk.vm.ci.meta.JavaConstant;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Assert;

/**
 * Tests constant folding of {@link String#hashCode()}.
 */
public class StringHashConstantTest extends GraalCompilerTest {

    private static final String A_CONSTANT_STRING = "a constant string";

    private ValueNode asConstant(StructuredGraph graph, String str) {
        return ConstantNode.forConstant(getSnippetReflection().forObject(str), getMetaAccess(), graph);
    }

    @Test
    public void test1() {
        ResolvedJavaMethod method = getResolvedJavaMethod("parameterizedHashCode");
        StructuredGraph graph = parseForCompile(method);

        String s = "some string";
        int expected = s.hashCode();
        graph.getParameter(0).replaceAndDelete(asConstant(graph, s));

        compile(method, graph);

        FixedNode firstFixed = graph.start().next();
        Assert.assertThat(firstFixed, instanceOf(ReturnNode.class));

        ReturnNode ret = (ReturnNode) firstFixed;
        JavaConstant result = ret.result().asJavaConstant();
        if (result == null) {
            Assert.fail("result not constant: " + ret.result());
        } else {
            Assert.assertEquals("result", expected, result.asInt());
        }
    }

    public static int parameterizedHashCode(String value) {
        return value.hashCode();
    }

    @Test
    public void test2() {
        ResolvedJavaMethod method = getResolvedJavaMethod("constantHashCode");
        StructuredGraph graph = parseForCompile(method);

        FixedNode firstFixed = graph.start().next();
        Assert.assertThat(firstFixed, instanceOf(ReturnNode.class));

        ReturnNode ret = (ReturnNode) firstFixed;
        JavaConstant result = ret.result().asJavaConstant();
        if (result == null) {
            Assert.fail("result not constant: " + ret.result());
        } else {
            int expected = A_CONSTANT_STRING.hashCode();
            Assert.assertEquals("result", expected, result.asInt());
        }
    }

    public static int constantHashCode() {
        return A_CONSTANT_STRING.hashCode();
    }
}
