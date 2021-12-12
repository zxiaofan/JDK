/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.consumer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import jdk.jfr.internal.management.EventByteStream;

public final class FinishedStream extends EventByteStream {
    private final BufferedInputStream inputStream;
    private final byte[] buffer;

    public FinishedStream(InputStream is, int blockSize) {
        super();
        this.inputStream = new BufferedInputStream(is, 50000);
        this.buffer = new byte[blockSize];
    }

    @Override
    public synchronized byte[] read() throws IOException {
        // OK to reuse buffer since this
        // is only used for serialization
        touch();
        int read = inputStream.read(buffer);
        if (read == -1) {
            // null indicate no more data
            return null;
        }
        if (read != buffer.length) {
            byte[] smallerBuffer = new byte[read];
            System.arraycopy(buffer, 0, smallerBuffer, 0, read);
            return smallerBuffer;
        }

        return buffer;
    }

    @Override
    public synchronized void close() throws IOException {
        inputStream.close();
    }

}
