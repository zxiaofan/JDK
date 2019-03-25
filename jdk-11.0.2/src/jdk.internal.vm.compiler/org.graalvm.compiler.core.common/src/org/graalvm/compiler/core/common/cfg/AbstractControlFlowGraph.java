/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.cfg;

import java.util.Collection;

public interface AbstractControlFlowGraph<T extends AbstractBlockBase<T>> {

    int BLOCK_ID_INITIAL = -1;
    int BLOCK_ID_VISITED = -2;

    /**
     * Returns the list blocks contained in this control flow graph.
     *
     * It is {@linkplain CFGVerifier guaranteed} that the blocks are numbered and ordered according
     * to a reverse post order traversal of the control flow graph.
     *
     * @see CFGVerifier
     */
    T[] getBlocks();

    Collection<Loop<T>> getLoops();

    T getStartBlock();

    /**
     * True if block {@code a} is dominated by block {@code b}.
     */
    static boolean isDominatedBy(AbstractBlockBase<?> a, AbstractBlockBase<?> b) {
        int domNumberA = a.getDominatorNumber();
        int domNumberB = b.getDominatorNumber();
        return domNumberA >= domNumberB && domNumberA <= b.getMaxChildDominatorNumber();
    }

    /**
     * True if block {@code a} dominates block {@code b} and {@code a} is not identical block to
     * {@code b}.
     */
    static boolean strictlyDominates(AbstractBlockBase<?> a, AbstractBlockBase<?> b) {
        return a != b && dominates(a, b);
    }

    /**
     * True if block {@code a} dominates block {@code b}.
     */
    static boolean dominates(AbstractBlockBase<?> a, AbstractBlockBase<?> b) {
        assert a != null && b != null;
        return isDominatedBy(b, a);
    }

    /**
     * Calculates the common dominator of two blocks.
     *
     * Note that this algorithm makes use of special properties regarding the numbering of blocks.
     *
     * @see #getBlocks()
     * @see CFGVerifier
     */
    static AbstractBlockBase<?> commonDominator(AbstractBlockBase<?> a, AbstractBlockBase<?> b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else if (a == b) {
            return a;
        } else {
            int aDomDepth = a.getDominatorDepth();
            int bDomDepth = b.getDominatorDepth();
            AbstractBlockBase<?> aTemp;
            AbstractBlockBase<?> bTemp;
            if (aDomDepth > bDomDepth) {
                aTemp = a;
                bTemp = b;
            } else {
                aTemp = b;
                bTemp = a;
            }
            return commonDominatorHelper(aTemp, bTemp);
        }
    }

    static AbstractBlockBase<?> commonDominatorHelper(AbstractBlockBase<?> a, AbstractBlockBase<?> b) {
        int domNumberA = a.getDominatorNumber();
        AbstractBlockBase<?> result = b;
        while (domNumberA < result.getDominatorNumber()) {
            result = result.getDominator();
        }
        while (domNumberA > result.getMaxChildDominatorNumber()) {
            result = result.getDominator();
        }
        return result;
    }

    /**
     * @see AbstractControlFlowGraph#commonDominator(AbstractBlockBase, AbstractBlockBase)
     */
    @SuppressWarnings("unchecked")
    static <T extends AbstractBlockBase<T>> T commonDominatorTyped(T a, T b) {
        return (T) commonDominator(a, b);
    }
}
