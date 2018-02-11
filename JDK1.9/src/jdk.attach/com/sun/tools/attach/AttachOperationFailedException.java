/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.attach;

import java.io.IOException;

/**
 * Exception type to signal that an attach operation failed in the target VM.
 *
 * <p> This exception can be thrown by the various operations of
 * {@link com.sun.tools.attach.VirtualMachine} when the operation
 * fails in the target VM. If there is a communication error,
 * a regular IOException will be thrown.
 *
 * @since 9
 */
public class AttachOperationFailedException extends IOException {

    private static final long serialVersionUID = 2140308168167478043L;

    /**
     * Constructs an <code>AttachOperationFailedException</code> with
     * the specified detail message.
     *
     * @param message the detail message.
     */
    public AttachOperationFailedException(String message) {
        super(message);
    }
}
