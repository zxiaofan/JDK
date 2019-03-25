/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import org.junit.Test;

public class NestedArithmeticTest extends GraalCompilerTest {
    public static int runNestedLoopTry() {
        int checksum = 0;
        int i3 = 240;
        int i5 = 13485;
        for (int i4 = 303; i4 > 15; i4 -= 2) {
            int f = 1;
            do {
                try {
                    i3 = (38726 / i5);
                    i3 = (i4 % -21500);
                    i5 = (i3 % 787);
                } catch (ArithmeticException a_e) {
                    checksum += f + i3 + i5;
                    return checksum;
                }
                i3 <<= i4;
                i5 <<= i5;
                i3 += (8 + (f * f));
                i5 >>= i5;
                checksum += f;
            } while (++f < 11);
        }
        return checksum;
    }

    @Test
    public void nestedLoopTryTest() {
        test("runNestedLoopTry");
    }

    private interface FloatSupplier {
        float get();
    }

    private static volatile FloatSupplier problematicFloatValue = new FloatSupplier() {
        @Override
        public float get() {
            return Float.intBitsToFloat(1585051832);
        }
    };

    @SuppressWarnings("unused") private static volatile FloatSupplier normalFloatValue = new FloatSupplier() {
        @Override
        public float get() {
            return 0;
        }
    };

    public static int absConvert() {
        int i2 = -51498;
        int i16 = -12;
        int i17 = -121;
        int i18 = 1;
        int i19 = 11;
        long l1 = -275151857L;
        for (int i1 = 21; 22 > i1; ++i1) {
            float f = problematicFloatValue.get();
            float absolute = Math.abs(f);
            i2 = (int) absolute;
            i2 += i2;
        }
        long result = i2 + l1 + i16 + i17 + i18 + i19;
        return (int) result;
    }

    @Test
    public void absConvertTest() {
        test("absConvert");
    }
}
