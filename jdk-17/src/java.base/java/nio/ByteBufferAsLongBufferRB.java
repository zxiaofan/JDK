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

class ByteBufferAsLongBufferRB                  // package-private
    extends ByteBufferAsLongBufferB
{







    ByteBufferAsLongBufferRB(ByteBuffer bb, MemorySegmentProxy segment) {   // package-private












        super(bb, segment);

    }

    ByteBufferAsLongBufferRB(ByteBuffer bb,
                                     int mark, int pos, int lim, int cap,
                                     long addr, MemorySegmentProxy segment)
    {






        super(bb, mark, pos, lim, cap, addr, segment);

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
        return new ByteBufferAsLongBufferRB(bb, -1, 0, rem, rem, addr, segment);
    }

    @Override
    public LongBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsLongBufferRB(bb,
                                                    -1,
                                                    0,
                                                    length,
                                                    length,
                                                    byteOffset(index), segment);
    }

    public LongBuffer duplicate() {
        return new ByteBufferAsLongBufferRB(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    address, segment);
    }

    public LongBuffer asReadOnlyBuffer() {








        return duplicate();

    }


































    public LongBuffer put(long x) {






        throw new ReadOnlyBufferException();

    }

    public LongBuffer put(int i, long x) {






        throw new ReadOnlyBufferException();

    }

    public LongBuffer compact() {

















        throw new ReadOnlyBufferException();

    }

    public boolean isDirect() {
        return bb.isDirect();
    }

    public boolean isReadOnly() {
        return true;
    }









































    public ByteOrder order() {

        return ByteOrder.BIG_ENDIAN;




    }






}
