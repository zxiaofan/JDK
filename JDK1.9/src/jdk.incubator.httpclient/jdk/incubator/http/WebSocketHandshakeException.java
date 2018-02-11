/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.io.IOException;

/**
 * An exception used to signal the opening handshake failed.
 * {@Incubating}
 *
 * @since 9
 */
public final class WebSocketHandshakeException extends IOException {

    private static final long serialVersionUID = 1L;

    private final transient HttpResponse<?> response;

    public WebSocketHandshakeException(HttpResponse<?> response) {
        this.response = response;
    }

    /**
     * Returns the server's counterpart of the opening handshake.
     *
     * <p> The value may be unavailable ({@code null}) if this exception has
     * been serialized and then read back in.
     *
     * @return server response
     */
    public HttpResponse<?> getResponse() {
        return response;
    }

    @Override
    public WebSocketHandshakeException initCause(Throwable cause) {
        return (WebSocketHandshakeException) super.initCause(cause);
    }
}
