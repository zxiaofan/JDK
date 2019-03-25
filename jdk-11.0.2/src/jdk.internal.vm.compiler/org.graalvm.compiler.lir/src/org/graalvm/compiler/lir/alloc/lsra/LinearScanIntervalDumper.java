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


package org.graalvm.compiler.lir.alloc.lsra;

import static jdk.vm.ci.code.ValueUtil.isRegister;

import org.graalvm.compiler.lir.alloc.lsra.Interval.UsePosList;
import org.graalvm.compiler.lir.debug.IntervalDumper;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Value;

class LinearScanIntervalDumper implements IntervalDumper {
    private final Interval[] intervals;

    LinearScanIntervalDumper(Interval[] intervals) {
        this.intervals = intervals;
    }

    @Override
    public void visitIntervals(IntervalVisitor visitor) {
        for (Interval interval : intervals) {
            if (interval != null) {
                printInterval(interval, visitor);
            }
        }
    }

    private static void printInterval(Interval interval, IntervalVisitor visitor) {
        Value hint = interval.locationHint(false) != null ? interval.locationHint(false).operand : null;
        AllocatableValue operand = interval.operand;
        String type = isRegister(operand) ? "fixed" : operand.getValueKind().getPlatformKind().toString();
        visitor.visitIntervalStart(interval.splitParent().operand, operand, interval.location(), hint, type);

        // print ranges
        Range cur = interval.first();
        while (!cur.isEndMarker()) {
            visitor.visitRange(cur.from, cur.to);
            cur = cur.next;
            assert cur != null : "range list not closed with range sentinel";
        }

        // print use positions
        int prev = -1;
        UsePosList usePosList = interval.usePosList();
        for (int i = usePosList.size() - 1; i >= 0; --i) {
            assert prev < usePosList.usePos(i) : "use positions not sorted";
            visitor.visitUsePos(usePosList.usePos(i), usePosList.registerPriority(i));
            prev = usePosList.usePos(i);
        }

        visitor.visitIntervalEnd(interval.spillState());
    }

}
