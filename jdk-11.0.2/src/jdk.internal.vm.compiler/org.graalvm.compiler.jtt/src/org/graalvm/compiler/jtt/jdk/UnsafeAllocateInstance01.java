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

import java.util.AbstractList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/*
 */
public class UnsafeAllocateInstance01 extends JTTTest {

    int field01 = 42;

    public static int testInstance() throws SecurityException, InstantiationException {
        UnsafeAllocateInstance01 newObject = (UnsafeAllocateInstance01) UNSAFE.allocateInstance(UnsafeAllocateInstance01.class);
        return newObject.field01;
    }

    public static void testClassForException(Class<?> clazz) throws SecurityException, InstantiationException {
        UNSAFE.allocateInstance(clazz);
    }

    @Override
    protected Result executeExpected(ResolvedJavaMethod method, Object receiver, Object... args) {
        if (args.length == 1) {
            /*
             * HotSpot will crash if the C2 intrinsic for this is used with array classes, so just
             * handle it explicitly so that we can still exercise Graal.
             */
            Class<?> cl = (Class<?>) args[0];
            if (cl.isArray()) {
                return new Result(null, new InstantiationException(cl.getName()));
            }
        }
        return super.executeExpected(method, receiver, args);
    }

    @Test
    public void run0() throws Throwable {
        runTest("testInstance");
    }

    @Ignore("https://bugs.openjdk.java.net/browse/JDK-8153540")
    @Test
    public void run1() throws Throwable {
        runTest("testClassForException", UnsafeAllocateInstance01[].class);
    }

    @Test
    public void run7() throws Throwable {
        runTest("testClassForException", UnsafeAllocateInstance01.class);
    }

    @Test
    public void run2() throws Throwable {
        runTest("testClassForException", AbstractList.class);
    }

    @Test
    public void run3() throws Throwable {
        runTest("testClassForException", List.class);
    }

    @Test
    public void run4() throws Throwable {
        runTest("testClassForException", Class.class);
    }

    @Ignore("Currently crashes hotspot because primitive classes aren't handled")
    @Test
    public void run5() throws Throwable {
        runTest("testClassForException", void.class);
    }

    @Ignore("Currently crashes hotspot because primitive classes aren't handled")
    @Test
    public void run6() throws Throwable {
        runTest("testClassForException", int.class);
    }
}
