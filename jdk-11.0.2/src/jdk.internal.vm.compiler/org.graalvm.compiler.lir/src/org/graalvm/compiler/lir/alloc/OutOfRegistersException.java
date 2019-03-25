/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.alloc;

import org.graalvm.compiler.lir.BailoutAndRestartBackendException;

/**
 * Thrown if the register allocator runs out of registers. This should never happen in normal mode.
 */
public final class OutOfRegistersException extends BailoutAndRestartBackendException {

    private static final long serialVersionUID = -3479786650143432195L;

    private final String description;

    public OutOfRegistersException(String msg) {
        super(msg);
        this.description = "";
    }

    public OutOfRegistersException(Throwable cause, String msg) {
        super(cause, msg);
        this.description = "";
    }

    public OutOfRegistersException(String msg, String description) {
        super(msg);
        this.description = description;
    }

    public OutOfRegistersException(Throwable cause, String msg, String description) {
        super(cause, msg);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
