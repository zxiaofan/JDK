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

import jdk.incubator.http.internal.common.Utils;
import jdk.incubator.http.internal.websocket.RawChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import java.util.function.Supplier;

/*
 * Each RawChannel corresponds to a TCP connection (SocketChannel) but is
 * connected to a Selector and an ExecutorService for invoking the send and
 * receive callbacks. Also includes SSL processing.
 */
final class RawChannelImpl implements RawChannel {

    private final HttpClientImpl client;
    private final HttpConnection.DetachedConnectionChannel detachedChannel;
    private final Object         initialLock = new Object();
    private Supplier<ByteBuffer> initial;

    RawChannelImpl(HttpClientImpl client,
                   HttpConnection connection,
                   Supplier<ByteBuffer> initial)
            throws IOException
    {
        this.client = client;
        this.detachedChannel = connection.detachChannel();
        this.initial = initial;

        SocketChannel chan = connection.channel();
        client.cancelRegistration(chan);
        // Constructing a RawChannel is supposed to have a "hand over"
        // semantics, in other words if construction fails, the channel won't be
        // needed by anyone, in which case someone still needs to close it
        try {
            chan.configureBlocking(false);
        } catch (IOException e) {
            try {
                chan.close();
            } catch (IOException e1) {
                e.addSuppressed(e1);
            } finally {
                detachedChannel.close();
            }
            throw e;
        }
    }

    private class NonBlockingRawAsyncEvent extends AsyncEvent {

        private final RawEvent re;

        NonBlockingRawAsyncEvent(RawEvent re) {
            // !BLOCKING & !REPEATING
            this.re = re;
        }

        @Override
        public SelectableChannel channel() {
            return detachedChannel.channel();
        }

        @Override
        public int interestOps() {
            return re.interestOps();
        }

        @Override
        public void handle() {
            re.handle();
        }

        @Override
        public void abort(IOException ioe) { }
    }

    @Override
    public void registerEvent(RawEvent event) throws IOException {
        client.registerEvent(new NonBlockingRawAsyncEvent(event));
    }

    @Override
    public ByteBuffer read() throws IOException {
        assert !detachedChannel.channel().isBlocking();
        // connection.read() will no longer be available.
        return detachedChannel.read();
    }

    @Override
    public ByteBuffer initialByteBuffer() {
        synchronized (initialLock) {
            if (initial == null) {
                throw new IllegalStateException();
            }
            ByteBuffer ref = initial.get();
            ref = ref.hasRemaining() ? Utils.copy(ref)
                    : Utils.EMPTY_BYTEBUFFER;
            initial = null;
            return ref;
        }
    }

    @Override
    public long write(ByteBuffer[] src, int offset, int len) throws IOException {
        // this makes the whitebox driver test fail.
        return detachedChannel.write(src, offset, len);
    }

    @Override
    public void shutdownInput() throws IOException {
        detachedChannel.shutdownInput();
    }

    @Override
    public void shutdownOutput() throws IOException {
        detachedChannel.shutdownOutput();
    }

    @Override
    public void close() throws IOException {
        detachedChannel.close();
    }

    @Override
    public String toString() {
        return super.toString()+"("+ detachedChannel.toString() + ")";
    }


}
