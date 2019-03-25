/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.common;

import java.io.IOException;

/**
 * Signals that an end of file or end of stream has been reached
 * unexpectedly before any protocol specific data has been received.
 */
public final class ConnectionExpiredException extends IOException {
    private static final long serialVersionUID = 0;

    /**
     * Constructs a {@code ConnectionExpiredException} with a detail message of
     * "subscription is finished" and the given cause.
     *
     * @param   cause the throwable cause
     */
    public ConnectionExpiredException(Throwable cause) {
        super("subscription is finished", cause);
    }
}
