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

package jdk.internal.net.http;

import java.io.IOException;

/**
 * Signals that a proxy has refused a CONNECT request with a
 * 407 error code.
 */
final class ProxyAuthenticationRequired extends IOException {
    private static final long serialVersionUID = 0;
    final transient Response proxyResponse;

    /**
     * Constructs a {@code ProxyAuthenticationRequired} with the specified detail
     * message and cause.
     *
     * @param   proxyResponse the response from the proxy
     */
    public ProxyAuthenticationRequired(Response proxyResponse) {
        super("Proxy Authentication Required");
        assert proxyResponse.statusCode() == 407;
        this.proxyResponse = proxyResponse;
    }
}
