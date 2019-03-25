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
/*
 */


package org.graalvm.compiler.jtt.lang;

import org.graalvm.compiler.jtt.JTTTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CheckedListTest extends JTTTest {
    @Test
    public void run0() throws Throwable {
        runTest("testCast");
    }

    @SuppressWarnings({"unchecked", "rawtypes", "serial"})
    public static void testCast() {
        final AtomicBoolean addAllWasCalled = new AtomicBoolean();
        ArrayList orig = new ArrayList() {
            @Override
            public boolean addAll(Collection c) {
                addAllWasCalled.set(true);
                return super.addAll(c);
            }
        };
        Collection checked = Collections.checkedList(orig, String.class);
        ArrayList passed = new ArrayList(Arrays.asList("a", "b", 5678, "d"));
        try {
            checked.addAll(passed);
            System.out.println(checked);
            throw new RuntimeException("not good");
        } catch (ClassCastException e) {
            // OKK
        }
        Assert.assertFalse(addAllWasCalled.get());
    }

    @Test
    public void run1() throws Throwable {
        runTest("testCopyOf");
    }

    public static void testCopyOf() {
        Object[] mixed = new Object[]{"a", "b", 18};
        try {
            Arrays.copyOf(mixed, 4, String[].class);
        } catch (ArrayStoreException e) {
            return;
        }
        throw new RuntimeException("should not reach here");
    }

    @Test
    public void run2() throws Throwable {
        runTest("testArraycopy");
    }

    public static void testArraycopy() {
        Object[] mixed = new Object[]{"a", "b", 18};
        try {
            String[] strings = new String[4];
            System.arraycopy(mixed, 0, strings, 0, 3);
        } catch (ArrayStoreException e) {
            return;
        }
        throw new RuntimeException("should not reach here");
    }
}
