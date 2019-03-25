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
public abstract class BC_double_base extends JTTTest {

    /** Some interesting values. */
    private static final double[] values = {
                    0.0d,
                    -0.0d,
                    1.0d,
                    -1.0d,
                    Double.POSITIVE_INFINITY,
                    Double.NEGATIVE_INFINITY,
                    Double.NaN,
                    10.0d,
                    -10.0d,
                    311.0d,
                    -311.0d,
    };

    @Parameters(name = "{0}, {1}")
    public static Collection<Object[]> data() {
        List<Object[]> d = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            double x = values[i];
            for (int j = 0; j < values.length; j++) {
                double y = values[j];
                d.add(new Object[]{x, y});
            }
        }
        return d;
    }

    @Parameter(value = 0) public double x;
    @Parameter(value = 1) public double y;
}
