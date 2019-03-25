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

package jdk.internal.net.http;

import java.net.InetSocketAddress;

class PlainProxyConnection extends PlainHttpConnection {

    PlainProxyConnection(InetSocketAddress proxy, HttpClientImpl client) {
        super(proxy, client);
    }

    @Override
    ConnectionPool.CacheKey cacheKey() {
        return new ConnectionPool.CacheKey(null, address);
    }

    @Override
    public boolean isProxied() { return true; }
}
