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

import jdk.incubator.http.internal.common.ByteBufferReference;
import jdk.incubator.http.internal.common.MinimalFuture;
import jdk.incubator.http.HttpResponse.BodyHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;

/**
 * A plain text socket tunnel through a proxy. Uses "CONNECT" but does not
 * encrypt. Used by WebSocket. Subclassed in SSLTunnelConnection for encryption.
 */
class PlainTunnelingConnection extends HttpConnection {

    final PlainHttpConnection delegate;
    protected final InetSocketAddress proxyAddr;
    private volatile boolean connected;

    @Override
    public CompletableFuture<Void> connectAsync() {
        return delegate.connectAsync()
            .thenCompose((Void v) -> {
                HttpRequestImpl req = new HttpRequestImpl("CONNECT", client, address);
                MultiExchange<Void,Void> mconnectExchange = new MultiExchange<>(req, client, this::ignore);
                return mconnectExchange.responseAsync()
                    .thenCompose((HttpResponseImpl<Void> resp) -> {
                        CompletableFuture<Void> cf = new MinimalFuture<>();
                        if (resp.statusCode() != 200) {
                            cf.completeExceptionally(new IOException("Tunnel failed"));
                        } else {
                            connected = true;
                            cf.complete(null);
                        }
                        return cf;
                    });
            });
    }

    private HttpResponse.BodyProcessor<Void> ignore(int status, HttpHeaders hdrs) {
        return HttpResponse.BodyProcessor.discard((Void)null);
    }

    @Override
    public void connect() throws IOException, InterruptedException {
        delegate.connect();
        HttpRequestImpl req = new HttpRequestImpl("CONNECT", client, address);
        MultiExchange<Void,Void> mul = new MultiExchange<>(req, client, BodyHandler.<Void>discard(null));
        Exchange<Void> connectExchange = new Exchange<>(req, mul);
        Response r = connectExchange.responseImpl(delegate);
        if (r.statusCode() != 200) {
            throw new IOException("Tunnel failed");
        }
        connected = true;
    }

    @Override
    boolean connected() {
        return connected;
    }

    protected PlainTunnelingConnection(InetSocketAddress addr,
                                       InetSocketAddress proxy,
                                       HttpClientImpl client) {
        super(addr, client);
        this.proxyAddr = proxy;
        delegate = new PlainHttpConnection(proxy, client);
    }

    @Override
    SocketChannel channel() {
        return delegate.channel();
    }

    @Override
    ConnectionPool.CacheKey cacheKey() {
        return new ConnectionPool.CacheKey(null, proxyAddr);
    }

    @Override
    long write(ByteBuffer[] buffers, int start, int number) throws IOException {
        return delegate.write(buffers, start, number);
    }

    @Override
    long write(ByteBuffer buffer) throws IOException {
        return delegate.write(buffer);
    }

    @Override
    void writeAsync(ByteBufferReference[] buffers) throws IOException {
        delegate.writeAsync(buffers);
    }

    @Override
    void writeAsyncUnordered(ByteBufferReference[] buffers) throws IOException {
        delegate.writeAsyncUnordered(buffers);
    }

    @Override
    void flushAsync() throws IOException {
        delegate.flushAsync();
    }

    @Override
    public void close() {
        delegate.close();
        connected = false;
    }

    @Override
    void shutdownInput() throws IOException {
        delegate.shutdownInput();
    }

    @Override
    void shutdownOutput() throws IOException {
        delegate.shutdownOutput();
    }

    @Override
    CompletableFuture<Void> whenReceivingResponse() {
        return delegate.whenReceivingResponse();
    }

    @Override
    protected ByteBuffer readImpl() throws IOException {
        return delegate.readImpl();
    }

    @Override
    boolean isSecure() {
        return false;
    }

    @Override
    boolean isProxied() {
        return true;
    }
}
