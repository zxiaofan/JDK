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
 * Thrown when the opening handshake has failed.
 *
 * @since 11
 */
public final class WebSocketHandshakeException extends IOException {

    private static final long serialVersionUID = 1L;

    private final transient HttpResponse<?> response;

    /**
     * Constructs a {@code WebSocketHandshakeException} with the given
     * {@code HttpResponse}.
     *
     * @param response
     *        the {@code HttpResponse} that resulted in the handshake failure
     */
    public WebSocketHandshakeException(HttpResponse<?> response) {
        this.response = response;
    }

    /**
     * Returns the server's counterpart of the opening handshake.
     *
     * <p> The value may be unavailable ({@code null}) if this exception has
     * been serialized and then deserialized.
     *
     * @apiNote The primary purpose of this method is to allow programmatic
     * examination of the reasons behind the failure of the opening handshake.
     * Some of these reasons might allow recovery.
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
