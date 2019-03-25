/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.net.http;

import java.io.IOException;

/**
 * Thrown when a response is not received within a specified time period.
 *
 * @since 11
 */
public class HttpTimeoutException extends IOException {

    private static final long serialVersionUID = 981344271622632951L;

    /**
     * Constructs an {@code HttpTimeoutException} with the given detail message.
     *
     * @param message
     *        The detail message; can be {@code null}
     */
    public HttpTimeoutException(String message) {
        super(message);
    }
}
