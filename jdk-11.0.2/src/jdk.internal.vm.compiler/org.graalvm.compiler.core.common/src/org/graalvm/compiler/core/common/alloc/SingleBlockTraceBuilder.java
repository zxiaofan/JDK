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


package org.graalvm.compiler.core.common.alloc;

import java.util.ArrayList;

import org.graalvm.compiler.core.common.alloc.TraceBuilderResult.TrivialTracePredicate;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.debug.DebugContext;

/**
 * Builds traces consisting of a single basic block.
 */
public final class SingleBlockTraceBuilder {

    public static TraceBuilderResult computeTraces(DebugContext debug, AbstractBlockBase<?> startBlock, AbstractBlockBase<?>[] blocks, TrivialTracePredicate pred) {
        return build(debug, startBlock, blocks, pred);
    }

    private static TraceBuilderResult build(DebugContext debug, AbstractBlockBase<?> startBlock, AbstractBlockBase<?>[] blocks, TrivialTracePredicate pred) {
        Trace[] blockToTrace = new Trace[blocks.length];
        ArrayList<Trace> traces = new ArrayList<>(blocks.length);

        for (AbstractBlockBase<?> block : blocks) {
            Trace trace = new Trace(new AbstractBlockBase<?>[]{block});
            blockToTrace[block.getId()] = trace;
            block.setLinearScanNumber(0);
            trace.setId(traces.size());
            traces.add(trace);
        }

        assert traces.get(0).getBlocks()[0].equals(startBlock) : "The first traces always contains the start block";
        return TraceBuilderResult.create(debug, blocks, traces, blockToTrace, pred);
    }

}
