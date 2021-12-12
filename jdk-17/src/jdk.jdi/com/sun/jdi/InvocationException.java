/*
 * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown to indicate an exception occurred in an invoked method within
 * the target VM.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public class InvocationException extends Exception {

    private static final long serialVersionUID = 6066780907971918568L;

    @SuppressWarnings("serial") // Not statically typed as Serializable
    ObjectReference exception;

    public InvocationException(ObjectReference exception) {
        super("Exception occurred in target VM");
        this.exception = exception;
    }

    public ObjectReference exception() {
        return exception;
    }
}
