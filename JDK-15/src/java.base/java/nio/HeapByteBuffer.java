/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio;

import java.util.Objects;
import jdk.internal.access.foreign.MemorySegmentProxy;

/**

 * A read/write HeapByteBuffer.






 */

class HeapByteBuffer
    extends ByteBuffer
{
    // Cached array base offset
    private static final long ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);

    // Cached array index scale
    private static final long ARRAY_INDEX_SCALE = UNSAFE.arrayIndexScale(byte[].class);

    // For speed these fields are actually declared in X-Buffer;
    // these declarations are here as documentation
    /*

    protected final byte[] hb;
    protected final int offset;

    */

    HeapByteBuffer(int cap, int lim, MemorySegmentProxy segment) {            // package-private

        super(-1, 0, lim, cap, new byte[cap], 0, segment);
        /*
        hb = new byte[cap];
        offset = 0;
        */
        this.address = ARRAY_BASE_OFFSET;




    }

    HeapByteBuffer(byte[] buf, int off, int len, MemorySegmentProxy segment) { // package-private

        super(-1, off, off + len, buf.length, buf, 0, segment);
        /*
        hb = buf;
        offset = 0;
        */
        this.address = ARRAY_BASE_OFFSET;




    }

    protected HeapByteBuffer(byte[] buf,
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

    public ByteBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        return new HeapByteBuffer(hb,
                                        -1,
                                        0,
                                        rem,
                                        rem,
                                        pos + offset, segment);
    }

    @Override
    public ByteBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapByteBuffer(hb,
                                        -1,
                                        0,
                                        length,
                                        length,
                                        index + offset, segment);
    }

    public ByteBuffer duplicate() {
        return new HeapByteBuffer(hb,
                                        this.markValue(),
                                        this.position(),
                                        this.limit(),
                                        this.capacity(),
                                        offset, segment);
    }

    public ByteBuffer asReadOnlyBuffer() {

        return new HeapByteBufferR(hb,
                                     this.markValue(),
                                     this.position(),
                                     this.limit(),
                                     this.capacity(),
                                     offset, segment);



    }



    protected int ix(int i) {
        return i + offset;
    }


    private long byteOffset(long i) {
        return address + i;
    }


    public byte get() {
        checkSegment();
        return hb[ix(nextGetIndex())];
    }

    public byte get(int i) {
        checkSegment();
        return hb[ix(checkIndex(i))];
    }







    public ByteBuffer get(byte[] dst, int offset, int length) {
        checkSegment();
        Objects.checkFromIndexSize(offset, length, dst.length);
        int pos = position();
        if (length > limit() - pos)
            throw new BufferUnderflowException();
        System.arraycopy(hb, ix(pos), dst, offset, length);
        position(pos + length);
        return this;
    }

    public ByteBuffer get(int index, byte[] dst, int offset, int length) {
        checkSegment();
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

    public ByteBuffer put(byte x) {

        checkSegment();
        hb[ix(nextPutIndex())] = x;
        return this;



    }

    public ByteBuffer put(int i, byte x) {

        checkSegment();
        hb[ix(checkIndex(i))] = x;
        return this;



    }

    public ByteBuffer put(byte[] src, int offset, int length) {

        checkSegment();
        Objects.checkFromIndexSize(offset, length, src.length);
        int pos = position();
        if (length > limit() - pos)
            throw new BufferOverflowException();
        System.arraycopy(src, offset, hb, ix(pos), length);
        position(pos + length);
        return this;



    }

    public ByteBuffer put(ByteBuffer src) {

        checkSegment();
        super.put(src);
        return this;



    }

    public ByteBuffer put(int index, byte[] src, int offset, int length) {

        checkSegment();
        Objects.checkFromIndexSize(index, length, limit());
        Objects.checkFromIndexSize(offset, length, src.length);
        System.arraycopy(src, offset, hb, ix(index), length);
        return this;



    }





















    public ByteBuffer compact() {

        int pos = position();
        int rem = limit() - pos;
        System.arraycopy(hb, ix(pos), hb, ix(0), rem);
        position(rem);
        limit(capacity());
        discardMark();
        return this;



    }





    byte _get(int i) {                          // package-private
        return hb[i];
    }

    void _put(int i, byte b) {                  // package-private

        hb[i] = b;



    }

    // char



    public char getChar() {
        checkSegment();
        return UNSAFE.getCharUnaligned(hb, byteOffset(nextGetIndex(2)), bigEndian);
    }

    public char getChar(int i) {
        return UNSAFE.getCharUnaligned(hb, byteOffset(checkIndex(i, 2)), bigEndian);
    }



    public ByteBuffer putChar(char x) {

        checkSegment();
        UNSAFE.putCharUnaligned(hb, byteOffset(nextPutIndex(2)), x, bigEndian);
        return this;



    }

    public ByteBuffer putChar(int i, char x) {

        checkSegment();
        UNSAFE.putCharUnaligned(hb, byteOffset(checkIndex(i, 2)), x, bigEndian);
        return this;



    }

    public CharBuffer asCharBuffer() {
        int pos = position();
        int size = (limit() - pos) >> 1;
        long addr = address + pos;
        return (bigEndian
                ? (CharBuffer)(new ByteBufferAsCharBufferB(this,
                                                               -1,
                                                               0,
                                                               size,
                                                               size,
                                                               addr, segment))
                : (CharBuffer)(new ByteBufferAsCharBufferL(this,
                                                               -1,
                                                               0,
                                                               size,
                                                               size,
                                                               addr, segment)));
    }


    // short



    public short getShort() {
        checkSegment();
        return UNSAFE.getShortUnaligned(hb, byteOffset(nextGetIndex(2)), bigEndian);
    }

    public short getShort(int i) {
        checkSegment();
        return UNSAFE.getShortUnaligned(hb, byteOffset(checkIndex(i, 2)), bigEndian);
    }



    public ByteBuffer putShort(short x) {

        checkSegment();
        UNSAFE.putShortUnaligned(hb, byteOffset(nextPutIndex(2)), x, bigEndian);
        return this;



    }

    public ByteBuffer putShort(int i, short x) {

        checkSegment();
        UNSAFE.putShortUnaligned(hb, byteOffset(checkIndex(i, 2)), x, bigEndian);
        return this;



    }

    public ShortBuffer asShortBuffer() {
        int pos = position();
        int size = (limit() - pos) >> 1;
        long addr = address + pos;
        return (bigEndian
                ? (ShortBuffer)(new ByteBufferAsShortBufferB(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 addr, segment))
                : (ShortBuffer)(new ByteBufferAsShortBufferL(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 addr, segment)));
    }


    // int



    public int getInt() {
        checkSegment();
        return UNSAFE.getIntUnaligned(hb, byteOffset(nextGetIndex(4)), bigEndian);
    }

    public int getInt(int i) {
        checkSegment();
        return UNSAFE.getIntUnaligned(hb, byteOffset(checkIndex(i, 4)), bigEndian);
    }



    public ByteBuffer putInt(int x) {

        checkSegment();
        UNSAFE.putIntUnaligned(hb, byteOffset(nextPutIndex(4)), x, bigEndian);
        return this;



    }

    public ByteBuffer putInt(int i, int x) {

        checkSegment();
        UNSAFE.putIntUnaligned(hb, byteOffset(checkIndex(i, 4)), x, bigEndian);
        return this;



    }

    public IntBuffer asIntBuffer() {
        int pos = position();
        int size = (limit() - pos) >> 2;
        long addr = address + pos;
        return (bigEndian
                ? (IntBuffer)(new ByteBufferAsIntBufferB(this,
                                                             -1,
                                                             0,
                                                             size,
                                                             size,
                                                             addr, segment))
                : (IntBuffer)(new ByteBufferAsIntBufferL(this,
                                                             -1,
                                                             0,
                                                             size,
                                                             size,
                                                             addr, segment)));
    }


    // long



    public long getLong() {
        checkSegment();
        return UNSAFE.getLongUnaligned(hb, byteOffset(nextGetIndex(8)), bigEndian);
    }

    public long getLong(int i) {
        checkSegment();
        return UNSAFE.getLongUnaligned(hb, byteOffset(checkIndex(i, 8)), bigEndian);
    }



    public ByteBuffer putLong(long x) {

        checkSegment();
        UNSAFE.putLongUnaligned(hb, byteOffset(nextPutIndex(8)), x, bigEndian);
        return this;



    }

    public ByteBuffer putLong(int i, long x) {

        checkSegment();
        UNSAFE.putLongUnaligned(hb, byteOffset(checkIndex(i, 8)), x, bigEndian);
        return this;



    }

    public LongBuffer asLongBuffer() {
        int pos = position();
        int size = (limit() - pos) >> 3;
        long addr = address + pos;
        return (bigEndian
                ? (LongBuffer)(new ByteBufferAsLongBufferB(this,
                                                               -1,
                                                               0,
                                                               size,
                                                               size,
                                                               addr, segment))
                : (LongBuffer)(new ByteBufferAsLongBufferL(this,
                                                               -1,
                                                               0,
                                                               size,
                                                               size,
                                                               addr, segment)));
    }


    // float



    public float getFloat() {
        checkSegment();
        int x = UNSAFE.getIntUnaligned(hb, byteOffset(nextGetIndex(4)), bigEndian);
        return Float.intBitsToFloat(x);
    }

    public float getFloat(int i) {
        checkSegment();
        int x = UNSAFE.getIntUnaligned(hb, byteOffset(checkIndex(i, 4)), bigEndian);
        return Float.intBitsToFloat(x);
    }



    public ByteBuffer putFloat(float x) {

        checkSegment();
        int y = Float.floatToRawIntBits(x);
        UNSAFE.putIntUnaligned(hb, byteOffset(nextPutIndex(4)), y, bigEndian);
        return this;



    }

    public ByteBuffer putFloat(int i, float x) {

        checkSegment();
        int y = Float.floatToRawIntBits(x);
        UNSAFE.putIntUnaligned(hb, byteOffset(checkIndex(i, 4)), y, bigEndian);
        return this;



    }

    public FloatBuffer asFloatBuffer() {
        int pos = position();
        int size = (limit() - pos) >> 2;
        long addr = address + pos;
        return (bigEndian
                ? (FloatBuffer)(new ByteBufferAsFloatBufferB(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 addr, segment))
                : (FloatBuffer)(new ByteBufferAsFloatBufferL(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 addr, segment)));
    }


    // double



    public double getDouble() {
        checkSegment();
        long x = UNSAFE.getLongUnaligned(hb, byteOffset(nextGetIndex(8)), bigEndian);
        return Double.longBitsToDouble(x);
    }

    public double getDouble(int i) {
        checkSegment();
        long x = UNSAFE.getLongUnaligned(hb, byteOffset(checkIndex(i, 8)), bigEndian);
        return Double.longBitsToDouble(x);
    }



    public ByteBuffer putDouble(double x) {

        checkSegment();
        long y = Double.doubleToRawLongBits(x);
        UNSAFE.putLongUnaligned(hb, byteOffset(nextPutIndex(8)), y, bigEndian);
        return this;



    }

    public ByteBuffer putDouble(int i, double x) {

        checkSegment();
        long y = Double.doubleToRawLongBits(x);
        UNSAFE.putLongUnaligned(hb, byteOffset(checkIndex(i, 8)), y, bigEndian);
        return this;



    }

    public DoubleBuffer asDoubleBuffer() {
        int pos = position();
        int size = (limit() - pos) >> 3;
        long addr = address + pos;
        return (bigEndian
                ? (DoubleBuffer)(new ByteBufferAsDoubleBufferB(this,
                                                                   -1,
                                                                   0,
                                                                   size,
                                                                   size,
                                                                   addr, segment))
                : (DoubleBuffer)(new ByteBufferAsDoubleBufferL(this,
                                                                   -1,
                                                                   0,
                                                                   size,
                                                                   size,
                                                                   addr, segment)));
    }












































}
