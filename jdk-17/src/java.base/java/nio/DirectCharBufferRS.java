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


class DirectCharBufferRS



    extends DirectCharBufferS

    implements DirectBuffer
{






















































































































































    // For duplicates and slices
    //
    DirectCharBufferRS(DirectBuffer db,         // package-private
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

    public CharBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        int off = (pos << 1);
        assert (off >= 0);
        return new DirectCharBufferRS(this,
                                              -1,
                                              0,
                                              rem, 
                                              rem,
                                              off,




                                              segment);
    }

    @Override
    public CharBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new DirectCharBufferRS(this,
                                              -1,
                                              0,
                                              length,
                                              length,
                                              index << 1,




                                              segment);
    }

    public CharBuffer duplicate() {
        return new DirectCharBufferRS(this,
                                              this.markValue(),
                                              this.position(),
                                              this.limit(),
                                              this.capacity(),
                                              0,




                                              segment);
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
        return true;
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
        return new DirectCharBufferRS(this,
                                            -1,
                                            pos + start,
                                            pos + end,
                                            capacity(),
                                            offset, segment);
    }







    public ByteOrder order() {

        return ((ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
                ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);





    }




    ByteOrder charRegionOrder() {
        return order();
    }











}
