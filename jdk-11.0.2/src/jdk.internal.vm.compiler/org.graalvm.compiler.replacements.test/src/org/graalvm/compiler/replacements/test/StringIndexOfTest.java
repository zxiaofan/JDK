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

import org.junit.Test;

public class StringIndexOfTest extends StringIndexOfTestBase {
    /*
     * These test definitions could live in the superclass except that the mx junit individual test
     * runner can't find tests in superclasses.
     */

    @Override
    @Test
    public void testStringIndexOfConstant() {
        super.testStringIndexOfConstant();
    }

    @Override
    @Test
    public void testStringIndexOfConstantOffset() {
        super.testStringIndexOfConstantOffset();
    }

    @Override
    @Test
    public void testStringBuilderIndexOfConstant() {
        super.testStringBuilderIndexOfConstant();
    }

    @Override
    @Test
    public void testStringBuilderIndexOfConstantOffset() {
        super.testStringBuilderIndexOfConstantOffset();
    }
}
