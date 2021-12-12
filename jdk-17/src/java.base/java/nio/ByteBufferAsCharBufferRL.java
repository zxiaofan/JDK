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

class ByteBufferAsCharBufferRL                  // package-private
    extends ByteBufferAsCharBufferL
{







    ByteBufferAsCharBufferRL(ByteBuffer bb, MemorySegmentProxy segment) {   // package-private












        super(bb, segment);

    }

    ByteBufferAsCharBufferRL(ByteBuffer bb,
                                     int mark, int pos, int lim, int cap,
                                     long addr, MemorySegmentProxy segment)
    {






        super(bb, mark, pos, lim, cap, addr, segment);

    }

    @Override
    Object base() {
        return bb.hb;
    }

    public CharBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        long addr = byteOffset(pos);
        return new ByteBufferAsCharBufferRL(bb, -1, 0, rem, rem, addr, segment);
    }

    @Override
    public CharBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsCharBufferRL(bb,
                                                    -1,
                                                    0,
                                                    length,
                                                    length,
                                                    byteOffset(index), segment);
    }

    public CharBuffer duplicate() {
        return new ByteBufferAsCharBufferRL(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    address, segment);
    }

    public CharBuffer asReadOnlyBuffer() {








        return duplicate();

    }


































    public CharBuffer put(char x) {






        throw new ReadOnlyBufferException();

    }

    public CharBuffer put(int i, char x) {






        throw new ReadOnlyBufferException();

    }

    public CharBuffer compact() {

















        throw new ReadOnlyBufferException();

    }

    public boolean isDirect() {
        return bb.isDirect();
    }

    public boolean isReadOnly() {
        return true;
    }



    public String toString(int start, int end) {
        Objects.checkFromToIndex(start, end, limit());
        try {
            int len = end - start;
            char[] ca = new char[len];
            CharBuffer cb = CharBuffer.wrap(ca);
            CharBuffer db = this.duplicate();
            db.position(start);
            db.limit(end);
            cb.put(db);
            return new String(ca);
        } catch (StringIndexOutOfBoundsException x) {
            throw new IndexOutOfBoundsException();
        }
    }


    // --- Methods to support CharSequence ---

    public CharBuffer subSequence(int start, int end) {
        int pos = position();
        int lim = limit();
        assert (pos <= lim);
        pos = (pos <= lim ? pos : lim);
        int len = lim - pos;

        Objects.checkFromToIndex(start, end, len);
        return new ByteBufferAsCharBufferRL(bb,
                                                  -1,
                                                  pos + start,
                                                  pos + end,
                                                  capacity(),
                                                  address, segment);
    }




    public ByteOrder order() {




        return ByteOrder.LITTLE_ENDIAN;

    }


    ByteOrder charRegionOrder() {
        return order();
    }

}
