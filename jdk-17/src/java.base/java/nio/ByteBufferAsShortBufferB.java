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

class ByteBufferAsShortBufferB                  // package-private
    extends ShortBuffer
{



    protected final ByteBuffer bb;



    ByteBufferAsShortBufferB(ByteBuffer bb, MemorySegmentProxy segment) {   // package-private

        super(-1, 0,
              bb.remaining() >> 1,
              bb.remaining() >> 1, segment);
        this.bb = bb;
        // enforce limit == capacity
        int cap = this.capacity();
        this.limit(cap);
        int pos = this.position();
        assert (pos <= cap);
        address = bb.address;



    }

    ByteBufferAsShortBufferB(ByteBuffer bb,
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

    public ShortBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        long addr = byteOffset(pos);
        return new ByteBufferAsShortBufferB(bb, -1, 0, rem, rem, addr, segment);
    }

    @Override
    public ShortBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsShortBufferB(bb,
                                                    -1,
                                                    0,
                                                    length,
                                                    length,
                                                    byteOffset(index), segment);
    }

    public ShortBuffer duplicate() {
        return new ByteBufferAsShortBufferB(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    address, segment);
    }

    public ShortBuffer asReadOnlyBuffer() {

        return new ByteBufferAsShortBufferRB(bb,
                                                 this.markValue(),
                                                 this.position(),
                                                 this.limit(),
                                                 this.capacity(),
                                                 address, segment);



    }



    private int ix(int i) {
        int off = (int) (address - bb.address);
        return (i << 1) + off;
    }

    protected long byteOffset(long i) {
        return (i << 1) + address;
    }

    public short get() {
        short x = SCOPED_MEMORY_ACCESS.getShortUnaligned(scope(), bb.hb, byteOffset(nextGetIndex()),
            true);
        return (x);
    }

    public short get(int i) {
        short x = SCOPED_MEMORY_ACCESS.getShortUnaligned(scope(), bb.hb, byteOffset(checkIndex(i)),
            true);
        return (x);
    }











    public ShortBuffer put(short x) {

        short y = (x);
        SCOPED_MEMORY_ACCESS.putShortUnaligned(scope(), bb.hb, byteOffset(nextPutIndex()), y,
            true);
        return this;



    }

    public ShortBuffer put(int i, short x) {

        short y = (x);
        SCOPED_MEMORY_ACCESS.putShortUnaligned(scope(), bb.hb, byteOffset(checkIndex(i)), y,
            true);
        return this;



    }

    public ShortBuffer compact() {

        int pos = position();
        int lim = limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);

        ByteBuffer db = bb.duplicate();
        db.limit(ix(lim));
        db.position(ix(0));
        ByteBuffer sb = db.slice();
        sb.position(pos << 1);
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

        return ByteOrder.BIG_ENDIAN;




    }






}
