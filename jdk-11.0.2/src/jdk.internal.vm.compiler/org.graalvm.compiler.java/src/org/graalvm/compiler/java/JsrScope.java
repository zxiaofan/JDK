/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.java;

public class JsrScope {

    public static final JsrScope EMPTY_SCOPE = new JsrScope();

    private final long scope;

    private JsrScope(long scope) {
        this.scope = scope;
    }

    public JsrScope() {
        this.scope = 0;
    }

    public int nextReturnAddress() {
        return (int) (scope & 0xffff);
    }

    public JsrScope push(int jsrReturnBci) {
        if ((scope & 0xffff000000000000L) != 0) {
            throw new JsrNotSupportedBailout("only four jsr nesting levels are supported");
        }
        return new JsrScope((scope << 16) | jsrReturnBci);
    }

    public boolean isEmpty() {
        return scope == 0;
    }

    public boolean isPrefixOf(JsrScope other) {
        return (scope & other.scope) == scope;
    }

    public JsrScope pop() {
        return new JsrScope(scope >>> 16);
    }

    @Override
    public int hashCode() {
        return (int) (scope ^ (scope >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && scope == ((JsrScope) obj).scope;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        long tmp = scope;
        sb.append(" [");
        while (tmp != 0) {
            sb.append(", ").append(tmp & 0xffff);
            tmp = tmp >>> 16;
        }
        sb.append(']');
        return sb.toString();
    }
}
