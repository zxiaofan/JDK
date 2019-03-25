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


package org.graalvm.compiler.code;

import org.graalvm.compiler.core.common.PermanentBailoutException;

/**
 * Represents a bailout exception with a stack trace in terms of the Java source being compiled
 * instead of the stack trace of the compiler. The exception of the compiler is saved as the cause
 * of this exception.
 */
public abstract class SourceStackTraceBailoutException extends PermanentBailoutException {
    private static final long serialVersionUID = 2144811793442316776L;

    public static SourceStackTraceBailoutException create(Throwable cause, String reason, StackTraceElement[] elements) {
        return new SourceStackTraceBailoutException(cause, reason) {

            private static final long serialVersionUID = 6279381376051787907L;

            @Override
            public synchronized Throwable fillInStackTrace() {
                assert elements != null;
                setStackTrace(elements);
                return this;
            }
        };
    }

    private SourceStackTraceBailoutException(Throwable cause, String reason) {
        super(cause, "%s", reason);
    }
}
