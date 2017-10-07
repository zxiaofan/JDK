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
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ByteBufferReference  implements Supplier<ByteBuffer> {

    private ByteBuffer buffer;
    private final ByteBufferPool pool;

    public static ByteBufferReference of(ByteBuffer buffer) {
        return of(buffer, null);
    }

    public static ByteBufferReference of(ByteBuffer buffer, ByteBufferPool pool) {
        Objects.requireNonNull(buffer);
        return new ByteBufferReference(buffer, pool);
    }

    public static ByteBuffer[] toBuffers(ByteBufferReference... refs) {
        ByteBuffer[] bufs = new ByteBuffer[refs.length];
        for (int i = 0; i < refs.length; i++) {
            bufs[i] = refs[i].get();
        }
        return bufs;
    }

    public static ByteBufferReference[] toReferences(ByteBuffer... buffers) {
        ByteBufferReference[] refs = new ByteBufferReference[buffers.length];
        for (int i = 0; i < buffers.length; i++) {
            refs[i] = of(buffers[i]);
        }
        return refs;
    }


    public static void clear(ByteBufferReference[] refs) {
        for(ByteBufferReference ref : refs) {
            ref.clear();
        }
    }

    private ByteBufferReference(ByteBuffer buffer, ByteBufferPool pool) {
        this.buffer = buffer;
        this.pool = pool;
    }

    @Override
    public ByteBuffer get() {
        ByteBuffer buf = this.buffer;
        assert buf!=null : "getting ByteBuffer after clearance";
        return buf;
    }

    public void clear() {
        ByteBuffer buf = this.buffer;
        assert buf!=null : "double ByteBuffer clearance";
        this.buffer = null;
        if (pool != null) {
            pool.release(buf);
        }
    }
}
