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

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.calc.AndNode;
import org.graalvm.compiler.nodes.calc.NotNode;
import org.graalvm.compiler.nodes.calc.OrNode;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.junit.Assert;
import org.junit.Test;

public class DeMorganCanonicalizationTest extends GraalCompilerTest {

    public static int or(int a, int b) {
        return ~a | ~b;
    }

    public static int and(int a, int b) {
        return ~a & ~b;
    }

    @Test
    public void testAnd() {
        StructuredGraph g = parseEager("and", AllowAssumptions.NO, getInitialOptions());
        new CanonicalizerPhase().apply(g, getDefaultHighTierContext());
        Assert.assertEquals(1, g.getNodes().filter(OrNode.class).count());
        Assert.assertEquals(1, g.getNodes().filter(NotNode.class).count());

        testAgainstExpected(g.method(), new Result(and(-1, 17), null), (Object) null, -1, 17);
        testAgainstExpected(g.method(), new Result(and(-1, 1), null), (Object) null, -1, 1);
        testAgainstExpected(g.method(), new Result(and(-1, -1), null), (Object) null, -1, -1);
        testAgainstExpected(g.method(), new Result(and(Integer.MIN_VALUE, Integer.MIN_VALUE), null), (Object) null, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Test
    public void testOr() {
        StructuredGraph g = parseEager("or", AllowAssumptions.NO, getInitialOptions());
        new CanonicalizerPhase().apply(g, getDefaultHighTierContext());
        Assert.assertEquals(1, g.getNodes().filter(AndNode.class).count());
        Assert.assertEquals(1, g.getNodes().filter(NotNode.class).count());

        testAgainstExpected(g.method(), new Result(or(-1, 17), null), (Object) null, -1, 17);
        testAgainstExpected(g.method(), new Result(or(-1, 1), null), (Object) null, -1, 1);
        testAgainstExpected(g.method(), new Result(or(-1, -1), null), (Object) null, -1, -1);
        testAgainstExpected(g.method(), new Result(or(Integer.MIN_VALUE, Integer.MIN_VALUE), null), (Object) null, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

}
