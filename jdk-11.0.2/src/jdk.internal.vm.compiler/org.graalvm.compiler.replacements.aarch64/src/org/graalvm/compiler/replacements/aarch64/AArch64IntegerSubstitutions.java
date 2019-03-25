/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.aarch64;

import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.MethodSubstitution;

/**
 * AArch64 ISA offers a count leading zeros instruction which can be used to implement
 * numberOfLeadingZeros more efficiently than using BitScanReverse.
 */
@ClassSubstitution(Integer.class)
public class AArch64IntegerSubstitutions {

    @MethodSubstitution
    public static int bitCount(int value) {
        // Based on Warren, Hacker's Delight, slightly adapted to profit from Aarch64 add + shift
        // instruction.
        // Assuming the peephole optimizer optimizes all x - y >>> z into a single instruction
        // this takes 10 instructions.
        int x = value;
        x = x - ((x & 0xaaaaaaaa) >>> 1);
        x = (x & 0x33333333) + ((x & 0xcccccccc) >>> 2);
        x = (x + (x >>> 4)) & 0x0f0f0f0f;
        x = x + (x >>> 8);
        x = x + (x >>> 16);
        return x & 0x3f;
    }
}
