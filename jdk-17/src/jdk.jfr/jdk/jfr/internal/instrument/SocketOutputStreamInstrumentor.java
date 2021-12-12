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
import java.net.InetAddress;
import java.net.Socket;

import jdk.jfr.events.Handlers;
import jdk.jfr.internal.handlers.EventHandler;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("java.net.Socket$SocketOutputStream")
final class SocketOutputStreamInstrumentor {

    private SocketOutputStreamInstrumentor() {
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(byte b[], int off, int len) throws IOException {
        EventHandler handler = Handlers.SOCKET_WRITE;
        if (!handler.isEnabled()) {
            write(b, off, len);
            return;
        }
        int bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            write(b, off, len);
            bytesWritten = len;
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                InetAddress remote = parent.getInetAddress();
                handler.write(
                        start,
                        duration,
                        remote.getHostName(),
                        remote.getHostAddress(),
                        parent.getPort(),
                        bytesWritten);
            }
        }
    }

    // private field in java.net.Socket$SocketOutputStream
    private Socket parent;
}
