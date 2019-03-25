/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import java.lang.reflect.Array;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Test;

import org.graalvm.compiler.phases.common.AbstractInliningPhase;

/**
 * Tests any optimization that commons loads of non-inlineable constants.
 */
public class CommonedConstantsTest extends GraalCompilerTest {

    public static final String[] array = {"1", "2", null};

    // A method where a constant is used on the normal and exception edge of a non-inlined call.
    // The dominating block of both usages is the block containing the call.
    public static Object test0Snippet(String[] arr, int i) {
        Object result = null;
        try {
            result = Array.get(arr, i);
        } catch (ArrayIndexOutOfBoundsException e) {
            result = array[0];
        }
        if (result == null) {
            result = array[2];
        }
        return result;
    }

    @Test
    public void test0() {
        // Ensure the exception path is profiled
        ResolvedJavaMethod javaMethod = getResolvedJavaMethod("test0Snippet");
        javaMethod.reprofile();
        test0Snippet(array, array.length);

        test("test0Snippet", array, 0);
        test("test0Snippet", array, 2);
        test("test0Snippet", array, 3);
        test("test0Snippet", array, 1);
    }

    public static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    static int noninlineLength(char[] s) {
        return s.length;
    }

    /**
     * A constant with usages before and after a non-inlined call.
     */
    public static int test1Snippet(String s) {
        if (s == null) {
            return noninlineLength(alphabet) + 1;
        }
        char[] sChars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < alphabet.length && i < sChars.length; i++) {
            if (alphabet[i] == sChars[i]) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        createSuites(getInitialOptions()).getHighTier().findPhase(AbstractInliningPhase.class).remove();
        test1Snippet(new String(alphabet));

        test("test1Snippet", (Object) null);
        test("test1Snippet", "test1Snippet");
        test("test1Snippet", "");
    }

    /**
     * A constant with only usage in a loop.
     */
    public static int test2Snippet(String s) {
        char[] sChars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < alphabet.length && i < sChars.length; i++) {
            if (alphabet[i] == sChars[i]) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test2() {
        assert createSuites(getInitialOptions()).getHighTier().findPhase(AbstractInliningPhase.class).hasNext();
        test2Snippet(new String(alphabet));

        test("test2Snippet", (Object) null);
        test("test2Snippet", "test1Snippet");
        test("test2Snippet", "");
    }
}
