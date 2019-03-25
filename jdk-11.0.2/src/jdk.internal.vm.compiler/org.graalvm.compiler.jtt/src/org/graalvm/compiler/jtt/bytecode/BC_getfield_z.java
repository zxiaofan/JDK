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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_getfield_z extends JTTTest {

    static class FieldHolder {
        FieldHolder(boolean field) {
            this.field = field;
        }

        private boolean field;
    }

    public static boolean test(FieldHolder object) {
        return object.field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", new FieldHolder(true));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", new FieldHolder(false));
    }

}
