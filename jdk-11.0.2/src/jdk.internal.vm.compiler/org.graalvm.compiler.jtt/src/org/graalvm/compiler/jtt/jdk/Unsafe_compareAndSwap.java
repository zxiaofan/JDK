/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.jdk;

import org.graalvm.compiler.jtt.JTTTest;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class Unsafe_compareAndSwap extends JTTTest {

    static final long valueOffset;
    static {
        try {
            valueOffset = UNSAFE.objectFieldOffset(Unsafe_compareAndSwap.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public static String test(Unsafe_compareAndSwap u, Object o, String expected, String newValue) {
        // First arg is not an array - can use a field write barrier
        UNSAFE.compareAndSwapObject(u, valueOffset, expected, newValue);
        // Not known if first arg is an array - different write barrier may be used
        UNSAFE.compareAndSwapObject(o, valueOffset, expected, newValue);

        return instance.value;
    }

    private String value;

    private static final Unsafe_compareAndSwap instance = new Unsafe_compareAndSwap();

    @Override
    protected void before(ResolvedJavaMethod m) {
        instance.value = "a";
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", instance, instance, "a", "b");
    }
}
