/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.marlin;

/**
 * Faster Math ceil / floor routines derived from StrictMath
 */
public final class FloatMath implements MarlinConst {

    // overflow / NaN handling enabled:
    static final boolean CHECK_OVERFLOW = true;
    static final boolean CHECK_NAN = true;

    private FloatMath() {
        // utility class
    }

    // faster inlined min/max functions in the branch prediction is high
    static float max(final float a, final float b) {
        // no NaN handling
        return (a >= b) ? a : b;
    }

    static double max(final double a, final double b) {
        // no NaN handling
        return (a >= b) ? a : b;
    }

    public static int max(final int a, final int b) {
        return (a >= b) ? a : b;
    }

    public static int min(final int a, final int b) {
        return (a <= b) ? a : b;
    }

    /**
     * Faster alternative to ceil(float) optimized for the integer domain
     * and supporting NaN and +/-Infinity.
     *
     * @param a a value.
     * @return the largest (closest to positive infinity) integer value
     * that less than or equal to the argument and is equal to a mathematical
     * integer.
     */
    public static int ceil_int(final float a) {
        final int intpart = (int) a;

        if (a <= intpart
                || (CHECK_OVERFLOW && intpart == Integer.MAX_VALUE)
                || CHECK_NAN && Float.isNaN(a)) {
            return intpart;
        }
        return intpart + 1;
    }

    /**
     * Faster alternative to ceil(double) optimized for the integer domain
     * and supporting NaN and +/-Infinity.
     *
     * @param a a value.
     * @return the largest (closest to positive infinity) integer value
     * that less than or equal to the argument and is equal to a mathematical
     * integer.
     */
    public static int ceil_int(final double a) {
        final int intpart = (int) a;

        if (a <= intpart
                || (CHECK_OVERFLOW && intpart == Integer.MAX_VALUE)
                || CHECK_NAN && Double.isNaN(a)) {
            return intpart;
        }
        return intpart + 1;
    }

    /**
     * Faster alternative to floor(float) optimized for the integer domain
     * and supporting NaN and +/-Infinity.
     *
     * @param a a value.
     * @return the largest (closest to positive infinity) floating-point value
     * that less than or equal to the argument and is equal to a mathematical
     * integer.
     */
    public static int floor_int(final float a) {
        final int intpart = (int) a;

        if (a >= intpart
                || (CHECK_OVERFLOW && intpart == Integer.MIN_VALUE)
                || CHECK_NAN && Float.isNaN(a)) {
            return intpart;
        }
        return intpart - 1;
    }

    /**
     * Faster alternative to floor(double) optimized for the integer domain
     * and supporting NaN and +/-Infinity.
     *
     * @param a a value.
     * @return the largest (closest to positive infinity) floating-point value
     * that less than or equal to the argument and is equal to a mathematical
     * integer.
     */
    public static int floor_int(final double a) {
        final int intpart = (int) a;

        if (a >= intpart
                || (CHECK_OVERFLOW && intpart == Integer.MIN_VALUE)
                || CHECK_NAN && Double.isNaN(a)) {
            return intpart;
        }
        return intpart - 1;
    }
}
