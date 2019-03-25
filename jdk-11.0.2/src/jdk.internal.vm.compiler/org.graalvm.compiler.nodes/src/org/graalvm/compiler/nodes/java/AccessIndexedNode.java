/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.java;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.JavaKind;

/**
 * The {@code AccessIndexedNode} class is the base class of instructions that read or write elements
 * of an array.
 */
@NodeInfo
public abstract class AccessIndexedNode extends AccessArrayNode implements Lowerable {

    public static final NodeClass<AccessIndexedNode> TYPE = NodeClass.create(AccessIndexedNode.class);
    @Input protected ValueNode index;
    @OptionalInput(InputType.Guard) private GuardingNode boundsCheck;
    protected final JavaKind elementKind;

    public ValueNode index() {
        return index;
    }

    /**
     * Create an new AccessIndexedNode.
     *
     * @param stamp the result kind of the access
     * @param array the instruction producing the array
     * @param index the instruction producing the index
     * @param boundsCheck the explicit array bounds check already performed before the access, or
     *            null if no check was performed yet
     * @param elementKind the kind of the elements of the array
     */
    protected AccessIndexedNode(NodeClass<? extends AccessIndexedNode> c, Stamp stamp, ValueNode array, ValueNode index, GuardingNode boundsCheck, JavaKind elementKind) {
        super(c, stamp, array);
        this.index = index;
        this.boundsCheck = boundsCheck;
        this.elementKind = elementKind;
    }

    public GuardingNode getBoundsCheck() {
        return boundsCheck;
    }

    /**
     * Gets the element type of the array.
     *
     * @return the element type
     */
    public JavaKind elementKind() {
        return elementKind;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }
}
