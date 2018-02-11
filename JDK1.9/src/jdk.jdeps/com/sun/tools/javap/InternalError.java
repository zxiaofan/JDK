/*
 * Copyright (c) 2007, 2009, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javap;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class InternalError extends Error {
    private static final long serialVersionUID = 8114054446416187030L;
    InternalError(Throwable t, Object... args) {
        super("Internal error", t);
        this.args = args;
    }

    InternalError(Object... args) {
        super("Internal error");
        this.args = args;
    }

    public final Object[] args;
}
