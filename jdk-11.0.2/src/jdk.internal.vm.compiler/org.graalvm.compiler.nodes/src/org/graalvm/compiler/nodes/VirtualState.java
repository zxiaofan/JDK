/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;

/**
 * Base class for nodes that contain "virtual" state, like FrameState and VirtualObjectState.
 * Subclasses of this class will be treated in a special way by the scheduler.
 */
@NodeInfo(allowedUsageTypes = {InputType.State})
public abstract class VirtualState extends Node {

    protected VirtualState(NodeClass<? extends VirtualState> c) {
        super(c);
    }

    public static final NodeClass<VirtualState> TYPE = NodeClass.create(VirtualState.class);

    public abstract static class NodeClosure<T extends Node> {

        public abstract void apply(Node usage, T node);
    }

    public interface VirtualClosure {

        void apply(VirtualState node);
    }

    public abstract VirtualState duplicateWithVirtualState();

    public abstract void applyToNonVirtual(NodeClosure<? super ValueNode> closure);

    /**
     * Performs a <b>pre-order</b> iteration over all elements reachable from this state that are a
     * subclass of {@link VirtualState}.
     */
    public abstract void applyToVirtual(VirtualClosure closure);

    public abstract boolean isPartOfThisState(VirtualState state);

    @Override
    public final StructuredGraph graph() {
        return (StructuredGraph) super.graph();
    }

}
