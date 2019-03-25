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
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import jdk.internal.net.http.common.MinimalFuture;
import jdk.internal.net.http.common.SSLTube;
import jdk.internal.net.http.common.Utils;

/**
 * Asynchronous version of SSLConnection.
 */
class AsyncSSLConnection extends AbstractAsyncSSLConnection {

    final PlainHttpConnection plainConnection;
    final PlainHttpPublisher writePublisher;
    private volatile SSLTube flow;

    AsyncSSLConnection(InetSocketAddress addr,
                       HttpClientImpl client,
                       String[] alpn) {
        super(addr, client, Utils.getServerName(addr), addr.getPort(), alpn);
        plainConnection = new PlainHttpConnection(addr, client);
        writePublisher = new PlainHttpPublisher();
    }

    @Override
    public CompletableFuture<Void> connectAsync(Exchange<?> exchange) {
        return plainConnection
                .connectAsync(exchange)
                .thenApply( unused -> {
                    // create the SSLTube wrapping the SocketTube, with the given engine
                    flow = new SSLTube(engine,
                                       client().theExecutor(),
                                       client().getSSLBufferSupplier()::recycle,
                                       plainConnection.getConnectionFlow());
                    return null; } );
    }

    @Override
    public CompletableFuture<Void> finishConnect() {
        // The actual ALPN value, which may be the empty string, is not
        // interesting at this point, only that the handshake has completed.
        return getALPN()
                .handle((String unused, Throwable ex) -> {
                    if (ex == null) {
                        return plainConnection.finishConnect();
                    } else {
                        plainConnection.close();
                        return MinimalFuture.<Void>failedFuture(ex);
                    } })
                .thenCompose(Function.identity());
    }

    @Override
    boolean connected() {
        return plainConnection.connected();
    }

    @Override
    HttpPublisher publisher() { return writePublisher; }

    @Override
    boolean isProxied() {
        return false;
    }

    @Override
    SocketChannel channel() {
        return plainConnection.channel();
    }

    @Override
    ConnectionPool.CacheKey cacheKey() {
        return ConnectionPool.cacheKey(address, null);
    }

    @Override
    public void close() {
        plainConnection.close();
    }

    @Override
    SSLTube getConnectionFlow() {
       return flow;
   }
}
