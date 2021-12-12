/*
 * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
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

// -- This file was mechanically generated: Do not edit! -- //

package java.nio;

import java.util.Objects;
import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.Unsafe;

class ByteBufferAsLongBufferL                  // package-private
    extends LongBuffer
{



    protected final ByteBuffer bb;



    ByteBufferAsLongBufferL(ByteBuffer bb, MemorySegmentProxy segment) {   // package-private

        super(-1, 0,
              bb.remaining() >> 3,
              bb.remaining() >> 3, segment);
        this.bb = bb;
        // enforce limit == capacity
        int cap = this.capacity();
        this.limit(cap);
        int pos = this.position();
        assert (pos <= cap);
        address = bb.address;



    }

    ByteBufferAsLongBufferL(ByteBuffer bb,
                                     int mark, int pos, int lim, int cap,
                                     long addr, MemorySegmentProxy segment)
    {

        super(mark, pos, lim, cap, segment);
        this.bb = bb;
        address = addr;
        assert address >= bb.address;



    }

    @Override
    Object base() {
        return bb.hb;
    }

    public LongBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        long addr = byteOffset(pos);
        return new ByteBufferAsLongBufferL(bb, -1, 0, rem, rem, addr, segment);
    }

    @Override
    public LongBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsLongBufferL(bb,
                                                    -1,
                                                    0,
                                                    length,
                                                    length,
                                                    byteOffset(index), segment);
    }

    public LongBuffer duplicate() {
        return new ByteBufferAsLongBufferL(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    address, segment);
    }

    public LongBuffer asReadOnlyBuffer() {

        return new ByteBufferAsLongBufferRL(bb,
                                                 this.markValue(),
                                                 this.position(),
                                                 this.limit(),
                                                 this.capacity(),
                                                 address, segment);



    }



    private int ix(int i) {
        int off = (int) (address - bb.address);
        return (i << 3) + off;
    }

    protected long byteOffset(long i) {
        return (i << 3) + address;
    }

    public long get() {
        long x = SCOPED_MEMORY_ACCESS.getLongUnaligned(scope(), bb.hb, byteOffset(nextGetIndex()),
            false);
        return (x);
    }

    public long get(int i) {
        long x = SCOPED_MEMORY_ACCESS.getLongUnaligned(scope(), bb.hb, byteOffset(checkIndex(i)),
            false);
        return (x);
    }











    public LongBuffer put(long x) {

        long y = (x);
        SCOPED_MEMORY_ACCESS.putLongUnaligned(scope(), bb.hb, byteOffset(nextPutIndex()), y,
            false);
        return this;



    }

    public LongBuffer put(int i, long x) {

        long y = (x);
        SCOPED_MEMORY_ACCESS.putLongUnaligned(scope(), bb.hb, byteOffset(checkIndex(i)), y,
            false);
        return this;



    }

    public LongBuffer compact() {

        int pos = position();
        int lim = limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);

        ByteBuffer db = bb.duplicate();
        db.limit(ix(lim));
        db.position(ix(0));
        ByteBuffer sb = db.slice();
        sb.position(pos << 3);
        sb.compact();
        position(rem);
        limit(capacity());
        discardMark();
        return this;



    }

    public boolean isDirect() {
        return bb.isDirect();
    }

    public boolean isReadOnly() {
        return false;
    }









































    public ByteOrder order() {




        return ByteOrder.LITTLE_ENDIAN;

    }






}
