/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.cfg;

import org.graalvm.compiler.core.common.cfg.Loop;
import org.graalvm.compiler.nodes.LoopBeginNode;
import jdk.internal.vm.compiler.word.LocationIdentity;

public final class HIRLoop extends Loop<Block> {

    private LocationSet killLocations;

    protected HIRLoop(Loop<Block> parent, int index, Block header) {
        super(parent, index, header);
    }

    @Override
    public long numBackedges() {
        return ((LoopBeginNode) getHeader().getBeginNode()).loopEnds().count();
    }

    public LocationSet getKillLocations() {
        if (killLocations == null) {
            killLocations = new LocationSet();
            for (Block b : this.getBlocks()) {
                if (b.getLoop() == this) {
                    killLocations.addAll(b.getKillLocations());
                    if (killLocations.isAny()) {
                        break;
                    }
                }
            }
        }
        for (Loop<Block> child : this.getChildren()) {
            if (killLocations.isAny()) {
                break;
            }
            killLocations.addAll(((HIRLoop) child).getKillLocations());
        }
        return killLocations;
    }

    public boolean canKill(LocationIdentity location) {
        return getKillLocations().contains(location);
    }

    @Override
    public String toString() {
        return super.toString() + " header:" + getHeader().getBeginNode();
    }
}
