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

import jdk.jfr.events.Handlers;
import jdk.jfr.internal.handlers.EventHandler;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("java.io.FileOutputStream")
final class FileOutputStreamInstrumentor {

    private FileOutputStreamInstrumentor() {
    }

    private String path;

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(int b) throws IOException {
        EventHandler handler = Handlers.FILE_WRITE;
        if (!handler.isEnabled()) {
            write(b);
            return;
        }
        long bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            write(b);
            bytesWritten = 1;
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                handler.write(start, duration, path, bytesWritten);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(byte b[]) throws IOException {
        EventHandler handler = Handlers.FILE_WRITE;
        if (!handler.isEnabled()) {
            write(b);
            return;
        }
        long bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            write(b);
            bytesWritten = b.length;
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                handler.write(start, duration, path, bytesWritten);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void write(byte b[], int off, int len) throws IOException {
        EventHandler handler = Handlers.FILE_WRITE;
        if (!handler.isEnabled()) {
            write(b, off, len);
            return;
        }
        long bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            write(b, off, len);
            bytesWritten = len;
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                handler.write(start, duration, path, bytesWritten);
            }
        }
    }
}
