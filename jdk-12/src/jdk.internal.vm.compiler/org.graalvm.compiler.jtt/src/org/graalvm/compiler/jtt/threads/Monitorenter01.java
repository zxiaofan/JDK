/*
 * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.threads;

import org.graalvm.compiler.jtt.JTTTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public final class Monitorenter01 extends JTTTest {

    @Rule public TestRule timeout = createTimeoutSeconds(20);

    static final Object object = new Object();

    public static boolean test() {
        // test nested locking.
        synchronized (object) {
            synchronized (object) {
                return true;
            }
        }
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
