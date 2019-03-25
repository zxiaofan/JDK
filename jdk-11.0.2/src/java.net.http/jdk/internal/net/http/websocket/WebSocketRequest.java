/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.net.Proxy;

/*
 * https://tools.ietf.org/html/rfc6455#section-4.1
 */
public interface WebSocketRequest {

    /*
     * If set to `true` and a proxy is used, instructs the implementation that
     * a TCP tunnel must be opened.
     */
    void isWebSocket(boolean flag);

    /*
     * Needed for setting "Connection" and "Upgrade" headers as required by the
     * WebSocket specification.
     */
    void setSystemHeader(String name, String value);

    /*
     * Sets the proxy for this request.
     */
    void setProxy(Proxy proxy);
}
