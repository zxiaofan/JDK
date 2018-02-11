/*
 * Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.misc.Unsafe;


class ByteBufferAsLongBufferRL                  // package-private
    extends ByteBufferAsLongBufferL
{










    ByteBufferAsLongBufferRL(ByteBuffer bb) {   // package-private












        super(bb);

    }

    ByteBufferAsLongBufferRL(ByteBuffer bb,
                                     int mark, int pos, int lim, int cap,
                                     long addr)
    {






        super(bb, mark, pos, lim, cap, addr);

    }

    public LongBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);
        long addr = byteOffset(pos);
        return new ByteBufferAsLongBufferRL(bb, -1, 0, rem, rem, addr);
    }

    public LongBuffer duplicate() {
        return new ByteBufferAsLongBufferRL(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    address);
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




        return ByteOrder.LITTLE_ENDIAN;

    }

}
