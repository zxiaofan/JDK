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


package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_64;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_64;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;

/**
 * The {@code G1ReferentFieldReadBarrier} is added when a read access is performed to the referent
 * field of a {@link java.lang.ref.Reference} object (through a {@code LoadFieldNode} or an
 * {@code UnsafeLoadNode}). The return value of the read is passed to the snippet implementing the
 * read barrier and consequently is added to the SATB queue if the concurrent marker is enabled.
 */
@NodeInfo(cycles = CYCLES_64, size = SIZE_64)
public final class G1ReferentFieldReadBarrier extends ObjectWriteBarrier {
    public static final NodeClass<G1ReferentFieldReadBarrier> TYPE = NodeClass.create(G1ReferentFieldReadBarrier.class);

    protected final boolean doLoad;

    public G1ReferentFieldReadBarrier(AddressNode address, ValueNode expectedObject, boolean doLoad) {
        super(TYPE, address, expectedObject, true);
        this.doLoad = doLoad;
    }

    public ValueNode getExpectedObject() {
        return getValue();
    }

    public boolean doLoad() {
        return doLoad;
    }
}
