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

import java.util.Objects;
import jdk.internal.access.foreign.MemorySegmentProxy;

/**

 * A read/write HeapCharBuffer.






 */

class HeapCharBuffer
    extends CharBuffer
{
    // Cached array base offset
    private static final long ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(char[].class);

    // Cached array index scale
    private static final long ARRAY_INDEX_SCALE = UNSAFE.arrayIndexScale(char[].class);

    // For speed these fields are actually declared in X-Buffer;
    // these declarations are here as documentation
    /*

    protected final char[] hb;
    protected final int offset;

    */

    HeapCharBuffer(int cap, int lim, MemorySegmentProxy segment) {            // package-private

        super(-1, 0, lim, cap, new char[cap], 0, segment);
        /*
        hb = new char[cap];
        offset = 0;
        */
        this.address = ARRAY_BASE_OFFSET;




    }

    HeapCharBuffer(char[] buf, int off, int len, MemorySegmentProxy segment) { // package-private

        super(-1, off, off + len, buf.length, buf, 0, segment);
        /*
        hb = buf;
        offset = 0;
        */
        this.address = ARRAY_BASE_OFFSET;




    }

    protected HeapCharBuffer(char[] buf,
                                   int mark, int pos, int lim, int cap,
                                   int off, MemorySegmentProxy segment)
    {

        super(mark, pos, lim, cap, buf, off, segment);
        /*
        hb = buf;
        offset = off;
        */
        this.address = ARRAY_BASE_OFFSET + off * ARRAY_INDEX_SCALE;




    }

    public CharBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        return new HeapCharBuffer(hb,
                                        -1,
                                        0,
                                        rem,
                                        rem,
                                        pos + offset, segment);
    }

    @Override
    public CharBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapCharBuffer(hb,
                                        -1,
                                        0,
                                        length,
                                        length,
                                        index + offset, segment);
    }

    public CharBuffer duplicate() {
        return new HeapCharBuffer(hb,
                                        this.markValue(),
                                        this.position(),
                                        this.limit(),
                                        this.capacity(),
                                        offset, segment);
    }

    public CharBuffer asReadOnlyBuffer() {

        return new HeapCharBufferR(hb,
                                     this.markValue(),
                                     this.position(),
                                     this.limit(),
                                     this.capacity(),
                                     offset, segment);



    }



    protected int ix(int i) {
        return i + offset;
    }







    public char get() {
        return hb[ix(nextGetIndex())];
    }

    public char get(int i) {
        return hb[ix(checkIndex(i))];
    }


    char getUnchecked(int i) {
    return hb[ix(i)];
    }


    public CharBuffer get(char[] dst, int offset, int length) {
        checkScope();
        Objects.checkFromIndexSize(offset, length, dst.length);
        int pos = position();
        if (length > limit() - pos)
            throw new BufferUnderflowException();
        System.arraycopy(hb, ix(pos), dst, offset, length);
        position(pos + length);
        return this;
    }

    public CharBuffer get(int index, char[] dst, int offset, int length) {
        checkScope();
        Objects.checkFromIndexSize(index, length, limit());
        Objects.checkFromIndexSize(offset, length, dst.length);
        System.arraycopy(hb, ix(index), dst, offset, length);
        return this;
    }

    public boolean isDirect() {
        return false;
    }



    public boolean isReadOnly() {
        return false;
    }

    public CharBuffer put(char x) {

        hb[ix(nextPutIndex())] = x;
        return this;



    }

    public CharBuffer put(int i, char x) {

        hb[ix(checkIndex(i))] = x;
        return this;



    }

    public CharBuffer put(char[] src, int offset, int length) {

        checkScope();
        Objects.checkFromIndexSize(offset, length, src.length);
        int pos = position();
        if (length > limit() - pos)
            throw new BufferOverflowException();
        System.arraycopy(src, offset, hb, ix(pos), length);
        position(pos + length);
        return this;



    }

    public CharBuffer put(CharBuffer src) {

        checkScope();
        super.put(src);
        return this;



    }

    public CharBuffer put(int index, CharBuffer src, int offset, int length) {

        checkScope();
        super.put(index, src, offset, length);
        return this;



    }

    public CharBuffer put(int index, char[] src, int offset, int length) {

        checkScope();
        Objects.checkFromIndexSize(index, length, limit());
        Objects.checkFromIndexSize(offset, length, src.length);
        System.arraycopy(src, offset, hb, ix(index), length);
        return this;



    }



    public CharBuffer put(String src, int start, int end) {

        checkScope();
        int length = end - start;
        Objects.checkFromIndexSize(start, length, src.length());
        int pos = position();
        int lim = limit();
        int rem = (pos <= lim) ? lim - pos : 0;
        if (length > rem)
            throw new BufferOverflowException();
        src.getChars(start, end, hb, ix(pos));
        position(pos + length);
        return this;



    }



    public CharBuffer compact() {

        int pos = position();
        int lim = limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);
        System.arraycopy(hb, ix(pos), hb, ix(0), rem);
        position(rem);
        limit(capacity());
        discardMark();
        return this;



    }






















































































































































































































































































































































    String toString(int start, int end) {               // package-private
        try {
            return new String(hb, start + offset, end - start);
        } catch (StringIndexOutOfBoundsException x) {
            throw new IndexOutOfBoundsException();
        }
    }


    // --- Methods to support CharSequence ---

    public CharBuffer subSequence(int start, int end) {
        int pos = position();
        Objects.checkFromToIndex(start, end, limit() - pos);
        return new HeapCharBuffer(hb,
                                      -1,
                                      pos + start,
                                      pos + end,
                                      capacity(),
                                      offset, segment);
    }






    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }



    ByteOrder charRegionOrder() {
        return order();
    }

}
