/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test.ea;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.junit.Test;

public class CountUppercaseParallelTest extends GraalCompilerTest {
    public static long count(CharSequence sentence) {
        return sentence.chars().parallel().filter(c -> Character.isUpperCase(c)).count();
    }

    @Test
    public void testCount() {
        String sequence = "In 2017 I would like to run ALL languages in one VM.";
        for (int i = 0; i < 5000; i++) {
            count(sequence);
        }
        test("count", sequence);
    }

}
