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

public class LoopFragmentInsideBefore extends LoopFragmentInside {

    private final FixedNode point;

    public LoopFragmentInsideBefore(LoopEx loop, FixedNode point) {
        super(loop);
        this.point = point;
    }

    // duplicates lazily
    public LoopFragmentInsideBefore(LoopFragmentInsideBefore original) {
        super(original);
        this.point = original.point();
    }

    public FixedNode point() {
        return point;
    }

    @Override
    public LoopFragmentInsideBefore duplicate() {
        return new LoopFragmentInsideBefore(this);
    }

    @Override
    public NodeBitMap nodes() {
        return null;
    }
}
