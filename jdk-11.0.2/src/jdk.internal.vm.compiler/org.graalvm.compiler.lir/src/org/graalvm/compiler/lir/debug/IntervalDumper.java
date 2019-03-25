/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.debug;

import jdk.vm.ci.meta.Value;

/**
 * Provides abstract access to intervals for dumping.
 */
public interface IntervalDumper {

    public interface IntervalVisitor {
        void visitIntervalStart(Value parentOperand, Value splitOperand, Value location, Value hint, String typeName);

        void visitRange(int from, int to);

        void visitUsePos(int pos, Object registerPrioObject);

        void visitIntervalEnd(Object spillState);

    }

    /**
     * Visits the {@link IntervalVisitor} for every interval.
     *
     * The order is as follows:
     * <ul>
     * <li>Call {@link IntervalVisitor#visitIntervalStart}</li>
     * <li>For every range:
     * <ul>
     * <li>Call {@link IntervalVisitor#visitRange}</li>
     * </ul>
     * <li>For every use position:
     * <ul>
     * <li>Call {@link IntervalVisitor#visitUsePos}</li>
     * </ul>
     * </li>
     * <li>call {@link IntervalVisitor#visitIntervalEnd}</li>
     * </ul>
     */
    void visitIntervals(IntervalVisitor visitor);

}
