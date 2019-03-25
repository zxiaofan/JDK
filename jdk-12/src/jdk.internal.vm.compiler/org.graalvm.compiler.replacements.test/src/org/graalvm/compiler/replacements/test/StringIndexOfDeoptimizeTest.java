/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.junit.Test;

public class StringIndexOfDeoptimizeTest extends GraalCompilerTest {
    public int testStringIndexOfDeoptimize(String a) {
        int result = a.indexOf("ba");
        if (result == -1) {
            GraalDirectives.deoptimizeAndInvalidate();
        }
        return result;
    }

    @Test
    public void testStringIndexOfConstantDeoptimize() {
        test("testStringIndexOfDeoptimize", "a");
    }
}
