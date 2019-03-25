/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

/**
 * A helper class for {@link AbstractKey}s that can nest and need to split out accumulated and flat
 * values for some kind of counter-like measurement.
 */
public abstract class CloseableCounter implements DebugCloseable {

    protected final DebugContext debug;
    protected final CloseableCounter parent;
    protected final AccumulatedKey counter;
    protected final long start;
    protected long nestedAmountToSubtract;

    CloseableCounter(DebugContext debug, CloseableCounter parent, AccumulatedKey counter) {
        this.debug = debug;
        this.parent = parent;
        this.start = getCounterValue();
        this.counter = counter;
    }

    @Override
    public DebugContext getDebug() {
        return debug;
    }

    /**
     * A hook for subclasses. Lets them perform custom operations with the value since the last
     * invocation of {@link CloseableCounter#close()} of this accumulated
     * {@link CloseableCounter#counter}.
     *
     * @param difference since the last invocation of this counter flat
     */
    protected void interceptDifferenceAccm(long difference) {
        // hook for subclasses
    }

    /**
     * A hook for subclasses. Lets them perform custom operations with the value since the last
     * invocation of {@link CloseableCounter#close()} of this flat {@link CloseableCounter#counter}.
     *
     * @param difference since the last invocation of this counter flat
     */
    protected void interceptDifferenceFlat(long difference) {
        // hook for subclasses
    }

    @Override
    public void close() {
        long end = getCounterValue();
        long difference = end - start;
        if (parent != null) {
            if (!counter.getName().equals(parent.counter.getName())) {
                parent.nestedAmountToSubtract += difference;
                // Look for our counter in an outer scope and fix up
                // the adjustment to the flat count
                CloseableCounter ancestor = parent.parent;
                while (ancestor != null) {
                    if (ancestor.counter.getName().equals(counter.getName())) {
                        ancestor.nestedAmountToSubtract -= difference;
                        break;
                    }
                    ancestor = ancestor.parent;
                }
            }
        }
        long flatAmount = difference - nestedAmountToSubtract;
        counter.addToCurrentValue(debug, difference);
        counter.flat.addToCurrentValue(debug, flatAmount);
        interceptDifferenceAccm(difference);
        interceptDifferenceFlat(flatAmount);
    }

    abstract long getCounterValue();
}
