/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
public abstract class StringIndexOfTestBase extends GraalCompilerTest {
    @Parameterized.Parameter(value = 0) public String sourceString;
    @Parameterized.Parameter(value = 1) public String constantString;

    @Parameterized.Parameters(name = "{0},{1}")
    public static Collection<Object[]> data() {
        ArrayList<Object[]> tests = new ArrayList<>();
        String[] targets = new String[]{"foobar", "foo", "bar"};
        for (String source : targets) {
            for (String target : targets) {
                tests.add(new Object[]{source, target});
            }
            tests.add(new Object[]{source, ""});
            tests.add(new Object[]{"", source});
            tests.add(new Object[]{"", ""});
        }
        for (String source : targets) {
            String s = "";
            for (int i = 0; i < 10; i++) {
                s = s + source.substring(0, source.length() - 1);
            }
            for (String target : targets) {
                tests.add(new Object[]{s, target});
                tests.add(new Object[]{s + target, target});
                tests.add(new Object[]{s.substring(0, s.length() - 1) + s, s});
            }
        }
        return tests;
    }

    public int testStringIndexOf(String a, String b) {
        return a.indexOf(b);
    }

    public int testStringIndexOfOffset(String a, String b, int fromIndex) {
        return a.indexOf(b, fromIndex);
    }

    public int testStringBuilderIndexOf(StringBuilder a, String b) {
        return a.indexOf(b);
    }

    public int testStringBuilderIndexOfOffset(StringBuilder a, String b, int fromIndex) {
        return a.indexOf(b, fromIndex);
    }

    @Test
    public void testStringIndexOfConstant() {
        test("testStringIndexOf", new Object[]{this.sourceString, this.constantString});
    }

    @Test
    public void testStringIndexOfConstantOffset() {
        test("testStringIndexOfOffset", new Object[]{this.sourceString, this.constantString, -1});
        test("testStringIndexOfOffset", new Object[]{this.sourceString, this.constantString, 0});
        test("testStringIndexOfOffset", new Object[]{this.sourceString, this.constantString, Math.max(0, sourceString.length() - constantString.length())});
    }

    @Test
    public void testStringBuilderIndexOfConstant() {
        /*
         * Put a copy of the target string in the space after the current string to detect cases
         * where we search too far.
         */
        StringBuilder sb = new StringBuilder(this.sourceString);
        sb.append(constantString);
        sb.setLength(sourceString.length());
        test("testStringBuilderIndexOf", new Object[]{sb, this.constantString});
    }

    @Test
    public void testStringBuilderIndexOfConstantOffset() {
        /*
         * Put a copy of the target string in the space after the current string to detect cases
         * where we search too far.
         */
        StringBuilder sb = new StringBuilder(this.sourceString);
        sb.append(constantString);
        sb.setLength(sourceString.length());
        test("testStringBuilderIndexOfOffset", new Object[]{sb, this.constantString, -1});
        test("testStringBuilderIndexOfOffset", new Object[]{sb, this.constantString, 0});
        test("testStringBuilderIndexOfOffset", new Object[]{sb, this.constantString, Math.max(0, sourceString.length() - constantString.length())});
    }
}
