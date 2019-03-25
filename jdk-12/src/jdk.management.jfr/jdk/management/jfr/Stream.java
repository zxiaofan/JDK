/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.management.jfr;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

final class Stream implements Closeable {

    private final long identifier;
    private final BufferedInputStream inputStream;
    private final byte[] buffer;

    private volatile long time;

    Stream(InputStream is, long identifier, int blockSize) {
        this.inputStream = new BufferedInputStream(is, 50000);
        this.identifier = identifier;
        this.buffer = new byte[blockSize];
    }

    private void touch() {
        time = System.currentTimeMillis();
    }

    public long getLastTouched() {
        return time;
    }

    public byte[] read() throws IOException {
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
    public void close() throws IOException {
        inputStream.close();
    }

    public long getId() {
        return identifier;
    }
}
