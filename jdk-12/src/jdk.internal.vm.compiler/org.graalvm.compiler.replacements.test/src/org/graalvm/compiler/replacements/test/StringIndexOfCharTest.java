/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import java.util.ArrayList;
import java.util.Collection;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class StringIndexOfCharTest extends GraalCompilerTest {
    @Parameterized.Parameter(value = 0) public String sourceString;
    @Parameterized.Parameter(value = 1) public int constantChar;
    @Parameterized.Parameter(value = 2) public int fromIndex;

    @Parameterized.Parameters(name = "{0},{1},{2}")
    public static Collection<Object[]> data() {
        ArrayList<Object[]> tests = new ArrayList<>();
        String longString = "ab";
        for (int i = 0; i < 15; i++) {
            longString = longString + longString;
        }
        longString = longString + "xx";
        String longUTF16String = "\u03bb" + longString;
        String mediumString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaax" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String mediumUTF16String = "\u03bbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaax" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] targets = new String[]{"foobar", "foo", "bar", "\u03bbfoobar", mediumString, mediumUTF16String, longString, longUTF16String};
        int[] targetChars = new int[]{'f', 'o', 'r', 'x', Character.MIN_SUPPLEMENTARY_CODE_POINT};
        int[] targetOffsets = new int[18];
        for (int i = 0; i < 18; i++) {
            targetOffsets[i] = i - 1;
        }
        for (String source : targets) {
            for (int targetChar : targetChars) {
                for (int offset : targetOffsets) {
                    tests.add(new Object[]{source, targetChar, offset});
                }
            }
        }

        return tests;
    }

    public int testStringIndexOf(String a, int b) {
        return a.indexOf(b);
    }

    public int testStringIndexOfOffset(String a, int b, int offset) {
        return a.indexOf(b, offset);
    }

    @Test
    public void testStringIndexOfConstant() {
        test("testStringIndexOf", this.sourceString, this.constantChar);
    }

    @Test
    public void testStringIndexOfConstantOffset() {
        test("testStringIndexOfOffset", this.sourceString, this.constantChar, this.fromIndex);
    }
}
