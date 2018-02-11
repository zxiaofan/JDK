/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.incubator.http.internal.common;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The class provides reuse of ByteBuffers.
 * It is supposed that all requested buffers have the same size for a long period of time.
 * That is why there is no any logic splitting buffers into different buckets (by size). It's unnecessary.
 *
 * At the same moment it is allowed to change requested buffers size (all smaller buffers will be discarded).
 * It may be needed for example, if after rehandshaking netPacketBufferSize was changed.
 */
public class ByteBufferPool {

    private final java.util.Queue<ByteBuffer> pool = new ConcurrentLinkedQueue<>();

    public ByteBufferPool() {
    }

    public ByteBufferReference get(int size) {
        ByteBuffer buffer;
        while ((buffer = pool.poll()) != null) {
            if (buffer.capacity() >= size) {
                return ByteBufferReference.of(buffer, this);
            }
        }
        return ByteBufferReference.of(ByteBuffer.allocate(size), this);
    }

    public void release(ByteBuffer buffer) {
        buffer.clear();
        pool.offer(buffer);
    }

}
