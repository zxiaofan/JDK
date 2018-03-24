/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http.internal.common;

import java.io.IOException;

/**
 * Signals that an end of file or end of stream has been reached
 * unexpectedly before any protocol specific data has been received.
 */
public final class ConnectionExpiredException extends IOException {
    private static final long serialVersionUID = 0;

    /**
     * Constructs a {@code ConnectionExpiredException} with the specified detail
     * message and cause.
     *
     * @param   s     the detail message
     * @param   cause the throwable cause
     */
    public ConnectionExpiredException(String s, Throwable cause) {
        super(s, cause);
    }
}
