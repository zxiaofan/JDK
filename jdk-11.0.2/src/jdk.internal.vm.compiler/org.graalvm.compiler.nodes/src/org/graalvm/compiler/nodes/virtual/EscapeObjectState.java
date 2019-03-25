/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.virtual;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.Node.ValueNumberable;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.VirtualState;

@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public abstract class EscapeObjectState extends VirtualState implements ValueNumberable {
    public static final NodeClass<EscapeObjectState> TYPE = NodeClass.create(EscapeObjectState.class);

    @Input protected VirtualObjectNode object;

    public VirtualObjectNode object() {
        return object;
    }

    public EscapeObjectState(NodeClass<? extends EscapeObjectState> c, VirtualObjectNode object) {
        super(c);
        this.object = object;
    }

    @Override
    public abstract EscapeObjectState duplicateWithVirtualState();

    @Override
    public boolean isPartOfThisState(VirtualState state) {
        return this == state;
    }

    @Override
    public void applyToVirtual(VirtualClosure closure) {
        closure.apply(this);
    }
}
