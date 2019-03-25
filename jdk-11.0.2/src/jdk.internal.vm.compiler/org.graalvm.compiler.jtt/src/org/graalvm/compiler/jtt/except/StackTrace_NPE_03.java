/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class StackTrace_NPE_03 extends JTTTest {

    private static String[] trace = {"test2", "test1", "test"};

    public static int test(int a) {
        try {
            if (a >= 0) {
                return test1();
            }
        } catch (NullPointerException npe) {
            String thisClass = StackTrace_NPE_03.class.getName();
            StackTraceElement[] stackTrace = npe.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement e = stackTrace[i];
                if (e.getClassName().equals(thisClass)) {
                    for (int j = 0; j < trace.length; j++) {
                        StackTraceElement f = stackTrace[i + j];
                        if (!f.getClassName().equals(thisClass)) {
                            return -2;
                        }
                        if (!f.getMethodName().equals(trace[j])) {
                            return -3;
                        }
                    }
                    return 0;
                }
            }
        }
        return -1;
    }

    private static int test1() {
        return test2();
    }

    private static int test2() {
        throw new NullPointerException();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

}
