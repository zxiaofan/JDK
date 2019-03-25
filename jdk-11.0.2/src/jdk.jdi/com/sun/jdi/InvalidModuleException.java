/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Thrown to indicate that the requested module is invalid
 * or became invalid after the module was unloaded.
 *
 * @since  9
 */
public class InvalidModuleException extends RuntimeException {

    private static final long serialVersionUID = 7907359387320658039L;

    /**
     * Constructs an {@code InvalidModuleException} with no detail message.
     */
    public InvalidModuleException() {
        super();
    }

    /**
     * Constructs an {@code InvalidModuleException} with the given detail
     * message.
     *
     * @param msg
     *        The detail message; can be {@code null}
     */
    public InvalidModuleException(String msg) {
        super(msg);
    }
}
