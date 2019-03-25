/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
@SuppressWarnings("unused")
public class List_reorder_bug extends JTTTest {

    private static class TestClass {
        String s;

        private void print(String s2) {
            this.s = s2;
        }

        private void match(Object a, int src, int id, int seq) {
            print("match: " + src + ", " + id);
            List item = list;
            List itemPrev = null;
            while (item != null) {
                if (item.id == id) {
                    if (item.bool) {
                        outcall(item.id);
                    }
                    if (itemPrev != null) {
                        itemPrev.next = item.next;
                    } else {
                        list = item.next;
                    }

                    item.next = null;
                    return;
                }

                itemPrev = item;
                item = item.next;
            }
        }
    }

    static class List {

        List(int id) {
            this.id = id;
        }

        List next;
        int id;
        boolean bool = true;
    }

    private static List list;

    public static boolean test(int i) {
        list = new List(5);
        list.next = new List(6);
        new TestClass().match(new Object(), 27, 6, 0);
        return list.next == null;
    }

    static int globalId;

    private static void outcall(int id) {
        globalId = id;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

}
