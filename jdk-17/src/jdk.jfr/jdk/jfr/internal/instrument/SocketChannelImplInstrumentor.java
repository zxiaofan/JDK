/*
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.instrument;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import jdk.jfr.events.Handlers;
import jdk.jfr.internal.handlers.EventHandler;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("sun.nio.ch.SocketChannelImpl")
final class SocketChannelImplInstrumentor {

    private SocketChannelImplInstrumentor() {
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int read(ByteBuffer dst) throws IOException {
        EventHandler handler = Handlers.SOCKET_READ;
        if (!handler.isEnabled()) {
            return read(dst);
        }
        int bytesRead = 0;
        long start  = 0;
        try {
            start = EventHandler.timestamp();;
            bytesRead = read(dst);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration))  {
                SocketAddress remoteAddress = getRemoteAddress();
                if (remoteAddress instanceof InetSocketAddress isa) {
                    String hostString  = isa.getAddress().toString();
                    int delimiterIndex = hostString.lastIndexOf('/');

                    String host = hostString.substring(0, delimiterIndex);
                    String address = hostString.substring(delimiterIndex + 1);
                    int port = isa.getPort();
                    if (bytesRead < 0) {
                        handler.write(start, duration, host, address, port, 0, 0L, true);
                    } else {
                        handler.write(start, duration, host, address, port, 0, bytesRead, false);
                    }
                } else {
                    UnixDomainSocketAddress udsa = (UnixDomainSocketAddress) remoteAddress;
                    String path = "[" + udsa.getPath().toString() + "]";
                    if (bytesRead < 0) {
                        handler.write(start, duration, "Unix domain socket", path, 0, 0, 0L, true);
                    } else {
                        handler.write(start, duration, "Unix domain socket", path, 0, 0, bytesRead, false);
                    }
                }
            }
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        EventHandler handler = Handlers.SOCKET_READ;
        if (!handler.isEnabled()) {
            return read(dsts, offset, length);
        }
        long bytesRead = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesRead = read(dsts, offset, length);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                SocketAddress remoteAddress = getRemoteAddress();
                if (remoteAddress instanceof InetSocketAddress isa) {
                    String hostString  = isa.getAddress().toString();
                    int delimiterIndex = hostString.lastIndexOf('/');

                    String host = hostString.substring(0, delimiterIndex);
                    String address = hostString.substring(delimiterIndex + 1);
                    int port = isa.getPort();
                    if (bytesRead < 0) {
                        handler.write(start, duration, host, address, port, 0, 0L, true);
                    } else {
                        handler.write(start, duration, host, address, port, 0, bytesRead, false);
                    }
                } else {
                    UnixDomainSocketAddress udsa = (UnixDomainSocketAddress) remoteAddress;
                    String path = "[" + udsa.getPath().toString() + "]";
                    if (bytesRead < 0) {
                        handler.write(start, duration, "Unix domain socket", path, 0, 0, 0L, true);
                    } else {
                        handler.write(start, duration, "Unix domain socket", path, 0, 0, bytesRead, false);
                    }
                }
            }
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int write(ByteBuffer buf) throws IOException {
        EventHandler handler = Handlers.SOCKET_WRITE;
        if (!handler.isEnabled()) {
            return write(buf);
        }
        int bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesWritten = write(buf);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                long bytes = bytesWritten < 0 ? 0 : bytesWritten;
                SocketAddress remoteAddress = getRemoteAddress();
                if (remoteAddress instanceof InetSocketAddress isa) {
                    String hostString  = isa.getAddress().toString();
                    int delimiterIndex = hostString.lastIndexOf('/');

                    String host = hostString.substring(0, delimiterIndex);
                    String address = hostString.substring(delimiterIndex + 1);
                    int port = isa.getPort();
                    handler.write(start, duration, host, address, port, bytes);
                } else {
                    UnixDomainSocketAddress udsa = (UnixDomainSocketAddress) remoteAddress;
                    String path = "[" + udsa.getPath().toString() + "]";
                    handler.write(start, duration, "Unix domain socket", path, 0, bytes);
                }
            }
        }
        return bytesWritten;
    }

    public SocketAddress getRemoteAddress() throws IOException {
        // gets replaced by call to instrumented class
        return null;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        EventHandler handler = Handlers.SOCKET_WRITE;
        if (!handler.isEnabled()) {
            return write(srcs, offset, length);
        }
        long bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesWritten = write(srcs, offset, length);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                long bytes = bytesWritten < 0 ? 0 : bytesWritten;
                SocketAddress remoteAddress = getRemoteAddress();
                if (remoteAddress instanceof InetSocketAddress isa) {
                    String hostString  = isa.getAddress().toString();
                    int delimiterIndex = hostString.lastIndexOf('/');

                    String host = hostString.substring(0, delimiterIndex);
                    String address = hostString.substring(delimiterIndex + 1);
                    int port = isa.getPort();
                    handler.write(start, duration, host, address, port, bytes);
                } else {
                    UnixDomainSocketAddress udsa = (UnixDomainSocketAddress) remoteAddress;
                    String path = "[" + udsa.getPath().toString() + "]";
                    handler.write(start, duration, "Unix domain socket", path, 0, bytes);
                }
            }
        }
        return bytesWritten;
    }
}
