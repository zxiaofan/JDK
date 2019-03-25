/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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

import jdk.jfr.events.SocketReadEvent;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("java.net.SocketInputStream")
@JITypeMapping(from = "jdk.jfr.internal.instrument.SocketInputStreamInstrumentor$AbstractPlainSocketImpl",
            to = "java.net.AbstractPlainSocketImpl")
final class SocketInputStreamInstrumentor {

    private SocketInputStreamInstrumentor() {
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    int read(byte b[], int off, int length, int timeout) throws IOException {
        SocketReadEvent event = SocketReadEvent.EVENT.get();
        if (!event.isEnabled()) {
            return read(b, off, length, timeout);
        }
        int bytesRead = 0;
        try {
            event.begin();
            bytesRead = read(b, off, length, timeout);
        } finally {
            event.end();
            if (event.shouldCommit()) {
                String hostString  = impl.address.toString();
                int delimiterIndex = hostString.lastIndexOf('/');

                event.host      = hostString.substring(0, delimiterIndex);
                event.address   = hostString.substring(delimiterIndex + 1);
                event.port      = impl.port;
                if (bytesRead < 0) {
                    event.endOfStream = true;
                } else {
                    event.bytesRead = bytesRead;
                }
                event.timeout   = timeout;

                event.commit();
                event.reset();
            }
        }
        return bytesRead;
    }

    private AbstractPlainSocketImpl impl = null;

    void silenceFindBugsUnwrittenField(InetAddress dummy) {
        impl.address = dummy;
    }

    static class AbstractPlainSocketImpl {
        InetAddress address;
        int port;
    }
}
