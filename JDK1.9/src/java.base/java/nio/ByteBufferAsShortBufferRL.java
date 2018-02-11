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


class ByteBufferAsShortBufferRL                  // package-private
    extends ByteBufferAsShortBufferL
{










    ByteBufferAsShortBufferRL(ByteBuffer bb) {   // package-private












        super(bb);

    }

    ByteBufferAsShortBufferRL(ByteBuffer bb,
                                     int mark, int pos, int lim, int cap,
                                     long addr)
    {






        super(bb, mark, pos, lim, cap, addr);

    }

    public ShortBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);
        long addr = byteOffset(pos);
        return new ByteBufferAsShortBufferRL(bb, -1, 0, rem, rem, addr);
    }

    public ShortBuffer duplicate() {
        return new ByteBufferAsShortBufferRL(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    address);
    }

    public ShortBuffer asReadOnlyBuffer() {








        return duplicate();

    }


































    public ShortBuffer put(short x) {






        throw new ReadOnlyBufferException();

    }

    public ShortBuffer put(int i, short x) {






        throw new ReadOnlyBufferException();

    }

    public ShortBuffer compact() {

















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
