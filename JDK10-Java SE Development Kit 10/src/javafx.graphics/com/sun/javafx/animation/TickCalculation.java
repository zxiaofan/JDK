/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package com.sun.javafx.animation;

import javafx.util.Duration;

public class TickCalculation {
    public static final int TICKS_PER_SECOND = 6000;
    private static final double TICKS_PER_MILI = TICKS_PER_SECOND / 1000.0;
    private static final double TICKS_PER_NANO =  TICKS_PER_MILI * 1e-6;

    private TickCalculation() {}

    public static long add(long op1, long op2) {
        assert (op1 >= 0);

        if (op1 == Long.MAX_VALUE || op2 == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        } else if (op2 == Long.MIN_VALUE) {
            return 0;
        }

        if (op2 >= 0) {
            final long result = op1 + op2;
            return (result < 0)? Long.MAX_VALUE : result;
        } else {
            return Math.max(0, op1 + op2);
        }

    }

    public static long sub(long op1, long op2) {
        assert (op1 >= 0);

        if (op1 == Long.MAX_VALUE || op2 == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        } else if (op2 == Long.MAX_VALUE) {
            return 0;
        }

        if (op2 >= 0) {
            return Math.max(0, op1 - op2);
        } else {
            final long result = op1 - op2;
            return result < 0 ? Long.MAX_VALUE : result;
        }

    }

    public static long fromMillis(double millis) {
        return Math.round(TICKS_PER_MILI * millis);
    }

    public static long fromNano(long nano) {
        return Math.round(TICKS_PER_NANO * nano);
    }

    public static long fromDuration(Duration duration) {
        return fromMillis(duration.toMillis());
    }

    public static long fromDuration(Duration duration, double rate) {
        return Math.round(TICKS_PER_MILI * duration.toMillis() / Math.abs(rate));
    }

    public static Duration toDuration(long ticks) {
        return Duration.millis(toMillis(ticks));
    }

    public static double toMillis(long ticks) {
        return ticks / TICKS_PER_MILI;
    }


}
