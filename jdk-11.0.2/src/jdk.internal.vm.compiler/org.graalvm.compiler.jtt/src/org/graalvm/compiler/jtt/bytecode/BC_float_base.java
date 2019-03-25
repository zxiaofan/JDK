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



package org.graalvm.compiler.jtt.bytecode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.graalvm.compiler.jtt.JTTTest;

@RunWith(Parameterized.class)
public abstract class BC_float_base extends JTTTest {

    /** Some interesting values. */
    private static final float[] values = {
                    0.0f,
                    -0.0f,
                    1.0f,
                    -1.0f,
                    Float.POSITIVE_INFINITY,
                    Float.NEGATIVE_INFINITY,
                    Float.NaN,
                    10.0f,
                    -10.0f,
                    311.0f,
                    -311.0f,
    };

    @Parameters(name = "{0}, {1}")
    public static Collection<Object[]> data() {
        List<Object[]> d = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            float x = values[i];
            for (int j = 0; j < values.length; j++) {
                float y = values[j];
                d.add(new Object[]{x, y});
            }
        }
        return d;
    }

    @Parameter(value = 0) public float x;
    @Parameter(value = 1) public float y;

}
