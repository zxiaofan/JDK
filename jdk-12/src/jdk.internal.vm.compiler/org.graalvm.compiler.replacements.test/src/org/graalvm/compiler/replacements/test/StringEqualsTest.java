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

import org.graalvm.compiler.replacements.nodes.ArrayEqualsNode;
import org.junit.Test;

/**
 * Tests compareTo method intrinsic.
 */
public class StringEqualsTest extends StringSubstitutionTestBase {

    public StringEqualsTest() {
        initSubstitution(
                        getResolvedJavaMethod(String.class, "equals"),
                        getResolvedJavaMethod("stringEquals"),
                        ArrayEqualsNode.class);
    }

    public static boolean stringEquals(String a, String b) {
        return a.equals(b);
    }

    @Test
    @Override
    public void testEqualString() {
        super.testEqualString();
    }

    @Test
    @Override
    public void testDifferentString() {
        super.testDifferentString();
    }

    @Test
    @Override
    public void testAllStrings() {
        super.testAllStrings();
    }
}
