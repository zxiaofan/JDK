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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class LoopSwitch01 extends JTTTest {

    static int count = 0;

    @SuppressWarnings("unused")
    public static String test() {
        String line;
        while ((line = string()) != null) {
            switch (line.charAt(0)) {
                case 'a':
                    new Object();
                    break;
                case 'b':
                    new Object();
                    break;
                default:
                    new Object();
                    break;
            }
        }
        return "ok" + count;
    }

    private static String string() {
        if (count == 0) {
            return null;
        }
        count--;
        return "" + ('a' + count);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
