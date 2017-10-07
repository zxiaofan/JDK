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
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLParameters;
import jdk.incubator.http.SSLDelegate.WrapperResult;

import jdk.incubator.http.internal.common.ByteBufferReference;
import jdk.incubator.http.internal.common.Utils;

/**
 * An SSL tunnel built on a Plain (CONNECT) TCP tunnel.
 */
class SSLTunnelConnection extends HttpConnection {

    final PlainTunnelingConnection delegate;
    protected SSLDelegate sslDelegate;
    private volatile boolean connected;

    @Override
    public void connect() throws IOException, InterruptedException {
        delegate.connect();
        this.sslDelegate = new SSLDelegate(delegate.channel(), client, null);
        connected = true;
    }

    @Override
    boolean connected() {
        return connected && delegate.connected();
    }

    @Override
    public CompletableFuture<Void> connectAsync() {
        return delegate.connectAsync()
            .thenAccept((Void v) -> {
                try {
                    // can this block?
                    this.sslDelegate = new SSLDelegate(delegate.channel(),
                                                       client,
                                                       null);
                    connected = true;
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
    }

    SSLTunnelConnection(InetSocketAddress addr,
                        HttpClientImpl client,
                        InetSocketAddress proxy)
    {
        super(addr, client);
        delegate = new PlainTunnelingConnection(addr, proxy, client);
    }

    @Override
    SSLParameters sslParameters() {
        return sslDelegate.getSSLParameters();
    }

    @Override
    public String toString() {
        return "SSLTunnelConnection: " + super.toString();
    }

    private static long countBytes(ByteBuffer[] buffers, int start, int number) {
        long c = 0;
        for (int i=0; i<number; i++) {
            c+= buffers[start+i].remaining();
        }
        return c;
    }

    @Override
    ConnectionPool.CacheKey cacheKey() {
        return ConnectionPool.cacheKey(address, delegate.proxyAddr);
    }

    @Override
    long write(ByteBuffer[] buffers, int start, int number) throws IOException {
        //debugPrint("Send", buffers, start, number);
        long l = countBytes(buffers, start, number);
        WrapperResult r = sslDelegate.sendData(buffers, start, number);
        if (r.result.getStatus() == Status.CLOSED) {
            if (l > 0) {
                throw new IOException("SSLHttpConnection closed");
            }
        }
        return l;
    }

    @Override
    long write(ByteBuffer buffer) throws IOException {
        //debugPrint("Send", buffer);
        long l = buffer.remaining();
        WrapperResult r = sslDelegate.sendData(buffer);
        if (r.result.getStatus() == Status.CLOSED) {
            if (l > 0) {
                throw new IOException("SSLHttpConnection closed");
            }
        }
        return l;
    }

    @Override
    void writeAsync(ByteBufferReference[] buffers) throws IOException {
        write(ByteBufferReference.toBuffers(buffers), 0, buffers.length);
    }

    @Override
    void writeAsyncUnordered(ByteBufferReference[] buffers) throws IOException {
        write(ByteBufferReference.toBuffers(buffers), 0, buffers.length);
    }

    @Override
    void flushAsync() throws IOException {
        // nothing to do
    }

    @Override
    public void close() {
        Utils.close(delegate.channel());
    }

    @Override
    void shutdownInput() throws IOException {
        delegate.channel().shutdownInput();
    }

    @Override
    void shutdownOutput() throws IOException {
        delegate.channel().shutdownOutput();
    }

    @Override
    protected ByteBuffer readImpl() throws IOException {
        ByteBuffer buf = Utils.getBuffer();

        WrapperResult r = sslDelegate.recvData(buf);
        return r.buf;
    }

    @Override
    SocketChannel channel() {
        return delegate.channel();
    }

    @Override
    CompletableFuture<Void> whenReceivingResponse() {
        return delegate.whenReceivingResponse();
    }

    @Override
    boolean isSecure() {
        return true;
    }

    @Override
    boolean isProxied() {
        return true;
    }
}
