/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.io.FileDescriptor;
import java.lang.ref.Reference;
import java.util.Objects;
import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.ScopedMemoryAccess.Scope;
import jdk.internal.misc.VM;
import jdk.internal.ref.Cleaner;
import sun.nio.ch.DirectBuffer;


class DirectDoubleBufferRS



    extends DirectDoubleBufferS

    implements DirectBuffer
{






















































































































































    // For duplicates and slices
    //
    DirectDoubleBufferRS(DirectBuffer db,         // package-private
                               int mark, int pos, int lim, int cap, int off,



                               MemorySegmentProxy segment)
    {













        super(db, mark, pos, lim, cap, off,



              segment);
        this.isReadOnly = true;

    }

    @Override
    Object base() {
        return null;
    }

    public DoubleBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        int off = (pos << 3);
        assert (off >= 0);
        return new DirectDoubleBufferRS(this,
                                              -1,
                                              0,
                                              rem, 
                                              rem,
                                              off,




                                              segment);
    }

    @Override
    public DoubleBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new DirectDoubleBufferRS(this,
                                              -1,
                                              0,
                                              length,
                                              length,
                                              index << 3,




                                              segment);
    }

    public DoubleBuffer duplicate() {
        return new DirectDoubleBufferRS(this,
                                              this.markValue(),
                                              this.position(),
                                              this.limit(),
                                              this.capacity(),
                                              0,




                                              segment);
    }

    public DoubleBuffer asReadOnlyBuffer() {













        return duplicate();

    }

















































    public DoubleBuffer put(double x) {








        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer put(int i, double x) {








        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer compact() {

















        throw new ReadOnlyBufferException();

    }

    public boolean isDirect() {
        return true;
    }

    public boolean isReadOnly() {
        return true;
    }













































    public ByteOrder order() {

        return ((ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
                ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);





    }


















}
