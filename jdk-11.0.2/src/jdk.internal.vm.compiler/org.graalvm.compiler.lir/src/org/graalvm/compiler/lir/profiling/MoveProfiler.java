/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.profiling;

import java.util.ArrayList;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.core.common.cfg.BlockMap;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.StandardOp.BlockEndOp;
import org.graalvm.compiler.lir.StandardOp.LabelOp;
import org.graalvm.compiler.lir.StandardOp.MoveOp;

public final class MoveProfiler {

    public static BlockMap<MoveStatistics> profile(LIR lir) {
        MoveProfiler profiler = new MoveProfiler(lir);
        profiler.run();
        return profiler.blockMap;
    }

    static class MoveStatistics {

        private final int[] cnt;

        MoveStatistics() {
            cnt = new int[MoveType.values().length];

        }

        public void add(MoveType moveType) {
            cnt[moveType.ordinal()]++;
        }

        public int get(MoveType moveType) {
            return cnt[moveType.ordinal()];
        }

        public void add(MoveType moveType, int value) {
            cnt[moveType.ordinal()] += value;
        }
    }

    private final LIR lir;
    private final BlockMap<MoveStatistics> blockMap;

    private MoveProfiler(LIR lir) {
        this.lir = lir;
        blockMap = new BlockMap<>(lir.getControlFlowGraph());
    }

    private void run() {
        for (AbstractBlockBase<?> block : lir.getControlFlowGraph().getBlocks()) {
            doBlock(block);
        }
    }

    private void doBlock(AbstractBlockBase<?> block) {
        ArrayList<LIRInstruction> instructions = lir.getLIRforBlock(block);
        assert instructions.size() >= 2 : "Malformed block: " + block + ", " + instructions;
        assert instructions.get(instructions.size() - 1) instanceof BlockEndOp : "Not a BlockEndOp: " + instructions.get(instructions.size() - 1);
        assert !(instructions.get(instructions.size() - 2) instanceof BlockEndOp) : "Is a BlockEndOp: " + instructions.get(instructions.size() - 2);
        assert instructions.get(0) instanceof LabelOp : "Not a LabelOp: " + instructions.get(0);
        assert !(instructions.get(1) instanceof LabelOp) : "Is a LabelOp: " + instructions.get(1);

        MoveStatistics stats = null;
        // analysis phase
        for (LIRInstruction inst : instructions) {
            if (MoveOp.isMoveOp(inst)) {
                if (stats == null) {
                    stats = new MoveStatistics();
                    blockMap.put(block, stats);
                }
                stats.add(MoveType.get(inst));
            }
        }
    }

}
