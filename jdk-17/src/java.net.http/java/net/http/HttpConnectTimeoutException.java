/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Thrown when a connection, over which an {@code HttpRequest} is intended to be
 * sent, is not successfully established within a specified time period.
 *
 * @since 11
 */
public class HttpConnectTimeoutException extends HttpTimeoutException {

    private static final long serialVersionUID = 321L + 11L;

    /**
     * Constructs an {@code HttpConnectTimeoutException} with the given detail
     * message.
     *
     * @param message
     *        The detail message; can be {@code null}
     */
    public HttpConnectTimeoutException(String message) {
        super(message);
    }
}
