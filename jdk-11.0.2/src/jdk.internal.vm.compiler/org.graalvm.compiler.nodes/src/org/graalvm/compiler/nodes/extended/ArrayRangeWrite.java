/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.extended;

import org.graalvm.compiler.graph.NodeInterface;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;

public interface ArrayRangeWrite extends NodeInterface {
    AddressNode getAddress();

    /**
     * The length of the modified range.
     */
    ValueNode getLength();

    /**
     * Return true if the written array is an object array, false if it is a primitive array.
     */
    boolean writesObjectArray();

    /**
     * Returns whether this write is the initialization of the written location. If it is true, the
     * old value of the memory location is either uninitialized or zero. If it is false, the memory
     * location is guaranteed to contain a valid value or zero.
     */
    boolean isInitialization();

    int getElementStride();

    @Override
    FixedWithNextNode asNode();
}
