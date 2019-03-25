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

package jdk.internal.net.http.websocket;

import static jdk.internal.net.http.websocket.StatusCodes.PROTOCOL_ERROR;

/*
 * Used as a marker for protocol issues in the incoming data, so that the
 * implementation could "Fail the WebSocket Connection" with a status code in
 * the Close message that fits the situation the most.
 *
 *     https://tools.ietf.org/html/rfc6455#section-7.1.7
 */
final class FailWebSocketException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final int statusCode;

    FailWebSocketException(String detail) {
        this(detail, PROTOCOL_ERROR);
    }

    FailWebSocketException(String detail, int statusCode) {
        super(detail);
        this.statusCode = statusCode;
    }

    int getStatusCode() {
        return statusCode;
    }

    @Override
    public FailWebSocketException initCause(Throwable cause) {
        return (FailWebSocketException) super.initCause(cause);
    }
}
