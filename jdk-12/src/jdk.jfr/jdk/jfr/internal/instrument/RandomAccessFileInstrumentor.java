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

import jdk.jfr.events.FileReadEvent;
import jdk.jfr.events.FileWriteEvent;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("java.io.RandomAccessFile")
final class RandomAccessFileInstrumentor {

    private RandomAccessFileInstrumentor() {
    }

    private String path;

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int read() throws IOException {
        FileReadEvent event = FileReadEvent.EVENT.get();
        if (!event.isEnabled()) {
            return read();
        }
        int result = 0;
        try {
            event.begin();
            result = read();
            if (result < 0) {
                event.endOfFile = true;
            } else {
                event.bytesRead = 1;
            }
        } finally {
            event.path = path;
            event.commit();
            event.reset();
        }
        return result;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int read(byte b[]) throws IOException {
        FileReadEvent event = FileReadEvent.EVENT.get();
        if (!event.isEnabled()) {
            return read(b);
        }
        int bytesRead = 0;
        try {
            event.begin();
            bytesRead = read(b);
        } finally {
            if (bytesRead < 0) {
                event.endOfFile = true;
            } else {
                event.bytesRead = bytesRead;
            }
            event.path = path;
            event.commit();
            event.reset();
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int read(byte b[], int off, int len) throws IOException {
        FileReadEvent event = FileReadEvent.EVENT.get();
        if (!event.isEnabled()) {
            return read(b, off, len);
        }
        int bytesRead = 0;
        try {
            event.begin();
            bytesRead = read(b, off, len);
        } finally {
            if (bytesRead < 0) {
                event.endOfFile = true;
            } else {
                event.bytesRead = bytesRead;
            }
            event.path = path;
            event.commit();
            event.reset();
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(int b) throws IOException {
        FileWriteEvent event = FileWriteEvent.EVENT.get();
        if (!event.isEnabled()) {
            write(b);
            return;
        }
        try {
            event.begin();
            write(b);
            event.bytesWritten = 1;
        } finally {
            event.path = path;
            event.commit();
            event.reset();
        }
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(byte b[]) throws IOException {
        FileWriteEvent event = FileWriteEvent.EVENT.get();
        if (!event.isEnabled()) {
            write(b);
            return;
        }
        try {
            event.begin();
            write(b);
            event.bytesWritten = b.length;
        } finally {
            event.path = path;
            event.commit();
            event.reset();
        }
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(byte b[], int off, int len) throws IOException {
        FileWriteEvent event = FileWriteEvent.EVENT.get();
        if (!event.isEnabled()) {
            write(b, off, len);
            return;
        }
        try {
            event.begin();
            write(b, off, len);
            event.bytesWritten = len;
        } finally {
            event.path = path;
            event.commit();
            event.reset();
        }
    }

}
