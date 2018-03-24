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
 * An SSL tunnel built on a Plain (CONNECT) TCP tunnel.
 */
class AsyncSSLTunnelConnection extends AbstractAsyncSSLConnection {

    final PlainTunnelingConnection plainConnection;
    final PlainHttpPublisher writePublisher;
    volatile SSLTube flow;

    AsyncSSLTunnelConnection(InetSocketAddress addr,
                             HttpClientImpl client,
                             String[] alpn,
                             InetSocketAddress proxy)
    {
        super(addr, client, Utils.getServerName(addr), alpn);
        this.plainConnection = new PlainTunnelingConnection(addr, proxy, client);
        this.writePublisher = new PlainHttpPublisher();
    }

    @Override
    public CompletableFuture<Void> connectAsync() {
        debug.log(Level.DEBUG, "Connecting plain tunnel connection");
        // This will connect the PlainHttpConnection flow, so that
        // its HttpSubscriber and HttpPublisher are subscribed to the
        // SocketTube
        return plainConnection
                .connectAsync()
                .thenApply( unused -> {
                    debug.log(Level.DEBUG, "creating SSLTube");
                    // create the SSLTube wrapping the SocketTube, with the given engine
                    flow = new SSLTube(engine,
                                       client().theExecutor(),
                                       plainConnection.getConnectionFlow());
                    return null;} );
    }

    @Override
    boolean connected() {
        return plainConnection.connected(); // && sslDelegate.connected();
    }

    @Override
    HttpPublisher publisher() { return writePublisher; }

    @Override
    public String toString() {
        return "AsyncSSLTunnelConnection: " + super.toString();
    }

    @Override
    PlainTunnelingConnection plainConnection() {
        return plainConnection;
    }

    @Override
    ConnectionPool.CacheKey cacheKey() {
        return ConnectionPool.cacheKey(address, plainConnection.proxyAddr);
    }

    @Override
    public void close() {
        plainConnection.close();
    }

    @Override
    void shutdownInput() throws IOException {
        plainConnection.channel().shutdownInput();
    }

    @Override
    void shutdownOutput() throws IOException {
        plainConnection.channel().shutdownOutput();
    }

    @Override
    SocketChannel channel() {
        return plainConnection.channel();
    }

    @Override
    boolean isProxied() {
        return true;
    }

    @Override
    SSLTube getConnectionFlow() {
       return flow;
   }
}
