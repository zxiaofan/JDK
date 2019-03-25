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

import jdk.jfr.events.SocketWriteEvent;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("java.net.SocketOutputStream")
@JITypeMapping(from = "jdk.jfr.internal.instrument.SocketOutputStreamInstrumentor$AbstractPlainSocketImpl",
            to = "java.net.AbstractPlainSocketImpl")
final class SocketOutputStreamInstrumentor {

    private SocketOutputStreamInstrumentor() {
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    private void socketWrite(byte b[], int off, int len) throws IOException {
        SocketWriteEvent event = SocketWriteEvent.EVENT.get();
        if (!event.isEnabled()) {
            socketWrite(b, off, len);
            return;
        }
        int bytesWritten = 0;
        try {
            event.begin();
            socketWrite(b, off, len);
            bytesWritten = len;
        } finally {
            event.end() ;
            if (event.shouldCommit()) {
                String hostString  = impl.address.toString();
                int delimiterIndex = hostString.lastIndexOf('/');

                event.host         = hostString.substring(0, delimiterIndex);
                event.address      = hostString.substring(delimiterIndex + 1);
                event.port         = impl.port;
                event.bytesWritten = bytesWritten < 0 ? 0 : bytesWritten;

                event.commit();
                event.reset();
            }
        }
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
