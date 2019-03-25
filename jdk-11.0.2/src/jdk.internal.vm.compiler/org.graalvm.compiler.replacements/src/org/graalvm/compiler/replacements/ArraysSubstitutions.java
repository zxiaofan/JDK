/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements;

import java.util.Arrays;

import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.replacements.nodes.ArrayEqualsNode;

// JaCoCo Exclude

/**
 * Substitutions for {@link java.util.Arrays} methods.
 */
@ClassSubstitution(Arrays.class)
public class ArraysSubstitutions {

    @MethodSubstitution
    public static boolean equals(boolean[] a, boolean[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(byte[] a, byte[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(char[] a, char[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(short[] a, short[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(int[] a, int[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(long[] a, long[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(float[] a, float[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }

    @MethodSubstitution
    public static boolean equals(double[] a, double[] a2) {
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a.length != a2.length) {
            return false;
        }
        return ArrayEqualsNode.equals(a, a2, a.length);
    }
}
