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

package jdk.jfr.internal.management;

import java.io.Closeable;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import jdk.jfr.Recording;
import jdk.jfr.internal.consumer.FinishedStream;
import jdk.jfr.internal.consumer.OngoingStream;

// abstract class that hides if a recording is ongoing or finished.
public abstract class EventByteStream implements Closeable {
    public static final String NAME = "Remote Recording Stream";
    private static AtomicLong idCounter = new AtomicLong();

    private final long identifier;
    private volatile long time;

    public EventByteStream() {
        this.identifier = idCounter.incrementAndGet();
    }

    public static EventByteStream newOngoingStream(Recording recording, int blockSize, long  startTimeNanos,long endTimeNanos) {
        return new OngoingStream(recording, blockSize, startTimeNanos, endTimeNanos);
    }

    public static EventByteStream newFinishedStream(InputStream is, int blockSize) {
        return new FinishedStream(is, blockSize);
    }

    protected final void touch() {
        time = System.currentTimeMillis();
    }

    public final long getLastTouched() {
        return time;
    }

    public abstract byte[] read() throws IOException;

    public final long getId() {
        return identifier;
    }
}
