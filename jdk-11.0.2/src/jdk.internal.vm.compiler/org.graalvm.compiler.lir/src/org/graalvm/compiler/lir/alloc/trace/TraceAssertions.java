/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.alloc.trace;

import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;

/**
 * A collection of assertions that are assumed to hold in various places of the Trace Register
 * Allocation framework.
 *
 * The main goal is to document pieces of code that rely on specific properties of traces. In case
 * an assumption is no longer valid, this makes it easy (assumed they are used correctly) to find
 * places that need changes.
 */
final class TraceAssertions {

    /**
     * Asserts that variable indices are properly sorted.
     */
    public static boolean liveSetsAreSorted(GlobalLivenessInfo livenessInfo, AbstractBlockBase<?> block) {
        return isSorted(livenessInfo.getBlockIn(block)) && isSorted(livenessInfo.getBlockOut(block));
    }

    private static boolean isSorted(int[] live) {
        if (live.length == 0) {
            return true;
        }
        int current = live[0];
        for (int i = 1; i < live.length; i++) {
            int last = current;
            current = live[i];
            if (current <= last) {
                return false;
            }
        }
        return true;
    }

    /**
     * Asserts that a trace head has only a single predecessor.
     *
     * This is not true for every trace-building algorithm (for example
     * {@link TraceBuilderPhase.TraceBuilder#SingleBlock}).
     */
    public static boolean singleHeadPredecessor(Trace trace) {
        return trace.getBlocks()[0].getPredecessorCount() == 1;
    }
}
