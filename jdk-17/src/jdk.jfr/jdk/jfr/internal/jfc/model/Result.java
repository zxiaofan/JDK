/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */
package jdk.jfr.internal.jfc.model;

record Result(String value) {
    public static final Result FALSE = new Result("false");
    public static final Result TRUE = new Result("true");
    public static final Result NULL = new Result(null);

    public boolean isTrue() {
        return "true".equalsIgnoreCase(value);
    }

    public boolean isNull() {
        return value == null;
    }

    public boolean isFalse() {
        return "false".equalsIgnoreCase(value);
    }

    public static Result of(String value) {
        if ("true".equalsIgnoreCase(value)) {
            return TRUE;
        }
        if ("false".equalsIgnoreCase(value)) {
            return FALSE;
        }
        return new Result(value);
    }
}
