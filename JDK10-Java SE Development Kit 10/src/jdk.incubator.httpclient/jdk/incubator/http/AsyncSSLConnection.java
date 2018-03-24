/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.lang.System.Logger.Level;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;
import jdk.incubator.http.internal.common.SSLTube;
import jdk.incubator.http.internal.common.Utils;


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
        super(addr, client, Utils.getServerName(addr), alpn);
        plainConnection = new PlainHttpConnection(addr, client);
        writePublisher = new PlainHttpPublisher();
    }

    @Override
    PlainHttpConnection plainConnection() {
        return plainConnection;
    }

    @Override
    public CompletableFuture<Void> connectAsync() {
        return plainConnection
                .connectAsync()
                .thenApply( unused -> {
                    // create the SSLTube wrapping the SocketTube, with the given engine
                    flow = new SSLTube(engine,
                                       client().theExecutor(),
                                       plainConnection.getConnectionFlow());
                    return null; } );
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
    void shutdownInput() throws IOException {
        debug.log(Level.DEBUG, "plainConnection.channel().shutdownInput()");
        plainConnection.channel().shutdownInput();
    }

    @Override
    void shutdownOutput() throws IOException {
        debug.log(Level.DEBUG, "plainConnection.channel().shutdownOutput()");
        plainConnection.channel().shutdownOutput();
    }

   @Override
   SSLTube getConnectionFlow() {
       return flow;
   }
}
