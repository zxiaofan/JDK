/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.calc;

//JaCoCo Exclude

/**
 * Utilities for unsigned comparisons. All methods have correct, but slow, standard Java
 * implementations so that they can be used with compilers not supporting the intrinsics.
 */
public class UnsignedMath {

    /**
     * Unsigned comparison aboveThan for two numbers.
     */
    public static boolean aboveThan(int a, int b) {
        return Integer.compareUnsigned(a, b) > 0;
    }

    /**
     * Unsigned comparison aboveOrEqual for two numbers.
     */
    public static boolean aboveOrEqual(int a, int b) {
        return Integer.compareUnsigned(a, b) >= 0;
    }

    /**
     * Unsigned comparison belowThan for two numbers.
     */
    public static boolean belowThan(int a, int b) {
        return Integer.compareUnsigned(a, b) < 0;
    }

    /**
     * Unsigned comparison belowOrEqual for two numbers.
     */
    public static boolean belowOrEqual(int a, int b) {
        return Integer.compareUnsigned(a, b) <= 0;
    }

    /**
     * Unsigned comparison aboveThan for two numbers.
     */
    public static boolean aboveThan(long a, long b) {
        return Long.compareUnsigned(a, b) > 0;
    }

    /**
     * Unsigned comparison aboveOrEqual for two numbers.
     */
    public static boolean aboveOrEqual(long a, long b) {
        return Long.compareUnsigned(a, b) >= 0;
    }

    /**
     * Unsigned comparison belowThan for two numbers.
     */
    public static boolean belowThan(long a, long b) {
        return Long.compareUnsigned(a, b) < 0;
    }

    /**
     * Unsigned comparison belowOrEqual for two numbers.
     */
    public static boolean belowOrEqual(long a, long b) {
        return Long.compareUnsigned(a, b) <= 0;
    }
}
