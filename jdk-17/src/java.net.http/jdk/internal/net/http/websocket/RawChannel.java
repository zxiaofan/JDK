/*
 * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;

/*
 * I/O abstraction used to implement WebSocket.
 *
 * @since 9
 */
public interface RawChannel extends Closeable {

    interface Provider {

        RawChannel rawChannel() throws IOException;
        void closeRawChannel() throws IOException;
    }

    interface RawEvent {

        /*
         * Returns the selector op flags this event is interested in.
         */
        int interestOps();

        /*
         * Called when event occurs.
         */
        void handle();
    }

    /*
     * Registers given event whose callback will be called once only (i.e.
     * register new event for each callback).
     *
     * Memory consistency effects: actions in a thread calling registerEvent
     * happen-before any subsequent actions in the thread calling event.handle
     */
    void registerEvent(RawEvent event) throws IOException;

    /**
     * Hands over the initial bytes. Once the bytes have been returned they are
     * no longer available and the method will throw an {@link
     * IllegalStateException} on each subsequent invocation.
     *
     * @return the initial bytes
     * @throws IllegalStateException
     *         if the method has been already invoked
     */
    ByteBuffer initialByteBuffer() throws IllegalStateException;

    /*
     * Returns a ByteBuffer with the data read or null if EOF is reached. Has no
     * remaining bytes if no data available at the moment.
     */
    ByteBuffer read() throws IOException;

    /*
     * Writes a sequence of bytes to this channel from a subsequence of the
     * given buffers.
     */
    long write(ByteBuffer[] srcs, int offset, int length) throws IOException;

    /**
     * Shutdown the connection for reading without closing the channel.
     *
     * <p> Once shutdown for reading then further reads on the channel will
     * return {@code null}, the end-of-stream indication. If the input side of
     * the connection is already shutdown then invoking this method has no
     * effect.
     *
     * @throws ClosedChannelException
     *         If this channel is closed
     * @throws IOException
     *         If some other I/O error occurs
     */
    void shutdownInput() throws IOException;

    /**
     * Shutdown the connection for writing without closing the channel.
     *
     * <p> Once shutdown for writing then further attempts to write to the
     * channel will throw {@link ClosedChannelException}. If the output side of
     * the connection is already shutdown then invoking this method has no
     * effect.
     *
     * @throws ClosedChannelException
     *         If this channel is closed
     * @throws IOException
     *         If some other I/O error occurs
     */
    void shutdownOutput() throws IOException;

    /**
     * Closes this channel.
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    @Override
    void close() throws IOException;
}
