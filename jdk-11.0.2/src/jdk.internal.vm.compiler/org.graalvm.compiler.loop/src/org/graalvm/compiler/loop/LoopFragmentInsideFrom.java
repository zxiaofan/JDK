/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.loop;

import org.graalvm.compiler.graph.NodeBitMap;
import org.graalvm.compiler.nodes.FixedNode;

public class LoopFragmentInsideFrom extends LoopFragmentInside {

    private final FixedNode point;

    public LoopFragmentInsideFrom(LoopEx loop, FixedNode point) {
        super(loop);
        this.point = point;
    }

    // duplicates lazily
    public LoopFragmentInsideFrom(LoopFragmentInsideFrom original) {
        super(original);
        this.point = original.point();
    }

    public FixedNode point() {
        return point;
    }

    @Override
    public LoopFragmentInsideFrom duplicate() {
        return new LoopFragmentInsideFrom(this);
    }

    @Override
    public NodeBitMap nodes() {
        return null;
    }
}
