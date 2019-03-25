/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.test;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.calc.AddNode;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddNodeTest {
    @Test
    public void checkTemplateAndName() {
        AddNode add = new AddNode(ConstantNode.forInt(30), ConstantNode.forInt(12));
        NodeClass<? extends Node> addClass = add.getNodeClass();
        assertEquals("+", addClass.shortName());
        assertEquals("Using short name as template", "+", addClass.getNameTemplate());
    }
}
