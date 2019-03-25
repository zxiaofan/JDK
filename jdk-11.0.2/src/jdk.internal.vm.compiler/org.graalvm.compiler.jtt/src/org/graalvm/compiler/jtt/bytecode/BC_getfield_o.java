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

public class BC_getfield_o extends JTTTest {

    static class FieldHolder {
        FieldHolder(Object field) {
            this.field = field;
        }

        private Object field;
    }

    public static Object test(FieldHolder object) {
        return object.field == null ? null : object.field.getClass();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", new FieldHolder(null));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", new FieldHolder("field"));
    }

}
