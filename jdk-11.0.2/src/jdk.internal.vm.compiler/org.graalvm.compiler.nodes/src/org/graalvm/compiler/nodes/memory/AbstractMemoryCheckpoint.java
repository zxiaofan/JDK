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


package org.graalvm.compiler.nodes.memory;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.AbstractStateSplit;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.StateSplit;

/**
 * Provides an implementation of {@link StateSplit}.
 */
@NodeInfo
public abstract class AbstractMemoryCheckpoint extends AbstractStateSplit implements MemoryCheckpoint {

    public static final NodeClass<AbstractMemoryCheckpoint> TYPE = NodeClass.create(AbstractMemoryCheckpoint.class);

    protected AbstractMemoryCheckpoint(NodeClass<? extends AbstractMemoryCheckpoint> c, Stamp stamp) {
        this(c, stamp, null);
    }

    protected AbstractMemoryCheckpoint(NodeClass<? extends AbstractMemoryCheckpoint> c, Stamp stamp, FrameState stateAfter) {
        super(c, stamp, stateAfter);
    }
}
