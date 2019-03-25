/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class System_setOut extends JTTTest {

    public static int test(int n) throws Exception {
        PrintStream oldOut = System.out;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            ByteArrayOutputStream ba = new ByteArrayOutputStream(n * 10);
            PrintStream newOut = new PrintStream(ba);
            System.setOut(newOut);
            doPrint(n);
            sum += ba.size();
        }

        System.setOut(oldOut);
        return sum;
    }

    private static void doPrint(int n) {
        PrintStream out = System.out;
        for (int i = 0; i < n; i++) {
            out.print('x');
        }
    }

    public static void main(String[] args) throws Exception {
        PrintStream out = System.out;
        out.println(test(10000));
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 10000);
    }

}
