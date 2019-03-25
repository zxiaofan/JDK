/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.nodes.ValueNodeInterface;

/**
 * Interface implemented by nodes that can replace themselves with lower level nodes during a phase
 * that transforms a graph to replace higher level nodes with lower level nodes.
 */
public interface Lowerable extends ValueNodeInterface {

    /**
     * Expand this node into lower level nodes expressing the same semantics. If the introduced
     * nodes are themselves lowerable, they should be recursively lowered as part of this call.
     */
    void lower(LoweringTool tool);
}
