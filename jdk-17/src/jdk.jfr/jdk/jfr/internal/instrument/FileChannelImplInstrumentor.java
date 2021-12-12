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
import java.nio.ByteBuffer;

import jdk.jfr.events.Handlers;
import jdk.jfr.internal.handlers.EventHandler;

/**
 * See {@link JITracer} for an explanation of this code.
 */
@JIInstrumentationTarget("sun.nio.ch.FileChannelImpl")
final class FileChannelImplInstrumentor {

    private FileChannelImplInstrumentor() {
    }

    private String path;

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public void force(boolean metaData) throws IOException {
        EventHandler handler = Handlers.FILE_FORCE;
        if (!handler.isEnabled()) {
            force(metaData);
            return;
        }
        long start = 0;
        try {
            start = EventHandler.timestamp();
            force(metaData);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                handler.write(start, duration, path, metaData);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int read(ByteBuffer dst) throws IOException {
        EventHandler handler = Handlers.FILE_READ;
        if (!handler.isEnabled()) {
            return read(dst);
        }
        int bytesRead = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesRead = read(dst);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                if (bytesRead < 0) {
                    handler.write(start, duration, path, 0L, true);
                } else {
                    handler.write(start, duration, path, bytesRead, false);
                }
            }
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int read(ByteBuffer dst, long position) throws IOException {
        EventHandler handler = Handlers.FILE_READ;
        if (!handler.isEnabled()) {
            return read(dst, position);
        }
        int bytesRead = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesRead = read(dst, position);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                if (bytesRead < 0) {
                    handler.write(start, duration, path, 0L, true);
                } else {
                    handler.write(start, duration, path, bytesRead, false);
                }
            }
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        EventHandler handler = Handlers.FILE_READ;
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
                if (bytesRead < 0) {
                    handler.write(start, duration, path, 0L, true);
                } else {
                    handler.write(start, duration, path, bytesRead, false);
                }
            }
        }
        return bytesRead;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int write(ByteBuffer src) throws IOException {
        EventHandler handler = Handlers.FILE_WRITE;
        if (!handler.isEnabled()) {
            return write(src);
        }
        int bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesWritten = write(src);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                long bytes = bytesWritten > 0 ? bytesWritten : 0;
                handler.write(start, duration, path, bytes);
            }
        }
        return bytesWritten;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public int write(ByteBuffer src, long position) throws IOException {
        EventHandler handler = Handlers.FILE_WRITE;
        if (!handler.isEnabled()) {
            return write(src, position);
        }

        int bytesWritten = 0;
        long start = 0;
        try {
            start = EventHandler.timestamp();
            bytesWritten = write(src, position);
        } finally {
            long duration = EventHandler.timestamp() - start;
            if (handler.shouldCommit(duration)) {
                long bytes = bytesWritten > 0 ? bytesWritten : 0;
                handler.write(start, duration, path, bytes);
            }
        }
        return bytesWritten;
    }

    @SuppressWarnings("deprecation")
    @JIInstrumentationMethod
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        EventHandler handler = Handlers.FILE_WRITE;
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
                long bytes = bytesWritten > 0 ? bytesWritten : 0;
                handler.write(start, duration, path, bytes);
            }
        }
        return bytesWritten;
    }
}
