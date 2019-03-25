/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
 * Aarch64 ISA offers a count leading zeros instruction which can be used to implement
 * numberOfLeadingZeros more efficiently than using BitScanReverse.
 */
@ClassSubstitution(Long.class)
public class AArch64LongSubstitutions {

    @MethodSubstitution
    public static int bitCount(long value) {
        // Based on Warren, Hacker's Delight, slightly adapted to profit from Aarch64 add + shift
        // instruction.
        // Assuming the peephole optimizer optimizes all x - y >>> z into a single instruction
        // this takes 11 instructions.
        long x = value;
        x = x - ((x & 0xaaaaaaaaaaaaaaaaL) >>> 1);
        x = (x & 0x3333333333333333L) + ((x & 0xccccccccccccccccL) >>> 2);
        x = (x + (x >>> 4)) & 0x0f0f0f0f0f0f0f0fL;
        x = x + (x >>> 8);
        x = x + (x >>> 16);
        x = x + (x >>> 32);
        return (int) x & 0x7f;
    }

}
