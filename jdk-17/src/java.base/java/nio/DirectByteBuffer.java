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


class DirectByteBuffer

    extends MappedByteBuffer



    implements DirectBuffer
{



    // Cached array base offset
    private static final long ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);

    // Cached unaligned-access capability
    protected static final boolean UNALIGNED = Bits.unaligned();

    // Base address, used in all indexing calculations
    // NOTE: moved up to Buffer.java for speed in JNI GetDirectBufferAddress
    //    protected long address;

    // An object attached to this buffer. If this buffer is a view of another
    // buffer then we use this field to keep a reference to that buffer to
    // ensure that its memory isn't freed before we are done with it.
    private final Object att;

    public Object attachment() {
        return att;
    }



    private static class Deallocator
        implements Runnable
    {

        private long address;
        private long size;
        private int capacity;

        private Deallocator(long address, long size, int capacity) {
            assert (address != 0);
            this.address = address;
            this.size = size;
            this.capacity = capacity;
        }

        public void run() {
            if (address == 0) {
                // Paranoia
                return;
            }
            UNSAFE.freeMemory(address);
            address = 0;
            Bits.unreserveMemory(size, capacity);
        }

    }

    private final Cleaner cleaner;

    public Cleaner cleaner() { return cleaner; }











    // Primary constructor
    //
    DirectByteBuffer(int cap) {                   // package-private

        super(-1, 0, cap, cap, null);
        boolean pa = VM.isDirectMemoryPageAligned();
        int ps = Bits.pageSize();
        long size = Math.max(1L, (long)cap + (pa ? ps : 0));
        Bits.reserveMemory(size, cap);

        long base = 0;
        try {
            base = UNSAFE.allocateMemory(size);
        } catch (OutOfMemoryError x) {
            Bits.unreserveMemory(size, cap);
            throw x;
        }
        UNSAFE.setMemory(base, size, (byte) 0);
        if (pa && (base % ps != 0)) {
            // Round up to page boundary
            address = base + ps - (base & (ps - 1));
        } else {
            address = base;
        }
        cleaner = Cleaner.create(this, new Deallocator(base, size, cap));
        att = null;




    }



    // Invoked to construct a direct ByteBuffer referring to the block of
    // memory. A given arbitrary object may also be attached to the buffer.
    //
    DirectByteBuffer(long addr, int cap, Object ob, MemorySegmentProxy segment) {
        super(-1, 0, cap, cap, segment);
        address = addr;
        cleaner = null;
        att = ob;
    }

    // Invoked to construct a direct ByteBuffer referring to the block of
    // memory. A given arbitrary object may also be attached to the buffer.
    //
    DirectByteBuffer(long addr, int cap, Object ob, FileDescriptor fd, boolean isSync, MemorySegmentProxy segment) {
        super(-1, 0, cap, cap, fd, isSync, segment);
        address = addr;
        cleaner = null;
        att = ob;
    }

    // Invoked only by JNI: NewDirectByteBuffer(void*, long)
    //
    private DirectByteBuffer(long addr, int cap) {
        super(-1, 0, cap, cap, null);
        address = addr;
        cleaner = null;
        att = null;
    }



    // For memory-mapped buffers -- invoked by FileChannelImpl via reflection
    //
    protected DirectByteBuffer(int cap, long addr,
                                     FileDescriptor fd,
                                     Runnable unmapper,
                                     boolean isSync, MemorySegmentProxy segment)
    {

        super(-1, 0, cap, cap, fd, isSync, segment);
        address = addr;
        cleaner = Cleaner.create(this, unmapper);
        att = null;




    }



    // For duplicates and slices
    //
    DirectByteBuffer(DirectBuffer db,         // package-private
                               int mark, int pos, int lim, int cap, int off,

                               FileDescriptor fd, boolean isSync,

                               MemorySegmentProxy segment)
    {

        super(mark, pos, lim, cap,

              fd, isSync,

              segment);
        address = ((Buffer)db).address + off;

        cleaner = null;

        Object attachment = db.attachment();
        att = (attachment == null ? db : attachment);








    }

    @Override
    Object base() {
        return null;
    }

    public MappedByteBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        int off = (pos << 0);
        assert (off >= 0);
        return new DirectByteBuffer(this,
                                              -1,
                                              0,
                                              rem, 
                                              rem,
                                              off,

                                              fileDescriptor(),
                                              isSync(),

                                              segment);
    }

    @Override
    public MappedByteBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new DirectByteBuffer(this,
                                              -1,
                                              0,
                                              length,
                                              length,
                                              index << 0,

                                              fileDescriptor(),
                                              isSync(),

                                              segment);
    }

    public MappedByteBuffer duplicate() {
        return new DirectByteBuffer(this,
                                              this.markValue(),
                                              this.position(),
                                              this.limit(),
                                              this.capacity(),
                                              0,

                                              fileDescriptor(),
                                              isSync(),

                                              segment);
    }

    public ByteBuffer asReadOnlyBuffer() {

        return new DirectByteBufferR(this,
                                           this.markValue(),
                                           this.position(),
                                           this.limit(),
                                           this.capacity(),
                                           0,

                                           fileDescriptor(),
                                           isSync(),

                                           segment);



    }



    public long address() {
        Scope scope = scope();
        if (scope != null) {
            if (scope.ownerThread() == null) {
                throw new UnsupportedOperationException("ByteBuffer derived from shared segments not supported");
            }
            try {
                scope.checkValidState();
            } catch (Scope.ScopedAccessError e) {
                throw new IllegalStateException("This segment is already closed");
            }
        }
        return address;
    }

    private long ix(int i) {
        return address + ((long)i << 0);
    }

    public byte get() {
        try {
            return ((SCOPED_MEMORY_ACCESS.getByte(scope(), null, ix(nextGetIndex()))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public byte get(int i) {
        try {
            return ((SCOPED_MEMORY_ACCESS.getByte(scope(), null, ix(checkIndex(i)))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }












    public ByteBuffer put(byte x) {

        try {
            SCOPED_MEMORY_ACCESS.putByte(scope(), null, ix(nextPutIndex()), ((x)));
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer put(int i, byte x) {

        try {
            SCOPED_MEMORY_ACCESS.putByte(scope(), null, ix(checkIndex(i)), ((x)));
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public MappedByteBuffer compact() {

        int pos = position();
        int lim = limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);
        try {
            // null is passed as destination Scope to avoid checking scope() twice
            SCOPED_MEMORY_ACCESS.copyMemory(scope(), null, null,
                    ix(pos), null, ix(0), (long)rem << 0);
        } finally {
            Reference.reachabilityFence(this);
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;



    }

    public boolean isDirect() {
        return true;
    }

    public boolean isReadOnly() {
        return false;
    }





































































    private char getChar(long a) {
        try {
            char x = SCOPED_MEMORY_ACCESS.getCharUnaligned(scope(), null, a, bigEndian);
            return (x);
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public char getChar() {
        try {
            return getChar(ix(nextGetIndex((1 << 1))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public char getChar(int i) {
        try {
            return getChar(ix(checkIndex(i, (1 << 1))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }



    private ByteBuffer putChar(long a, char x) {

        try {
            char y = (x);
            SCOPED_MEMORY_ACCESS.putCharUnaligned(scope(), null, a, y, bigEndian);
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer putChar(char x) {

        putChar(ix(nextPutIndex((1 << 1))), x);
        return this;



    }

    public ByteBuffer putChar(int i, char x) {

        putChar(ix(checkIndex(i, (1 << 1))), x);
        return this;



    }

    public CharBuffer asCharBuffer() {
        int off = this.position();
        int lim = this.limit();
        assert (off <= lim);
        int rem = (off <= lim ? lim - off : 0);

        int size = rem >> 1;
        if (!UNALIGNED && ((address + off) % (1 << 1) != 0)) {
            return (bigEndian
                    ? (CharBuffer)(new ByteBufferAsCharBufferB(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment))
                    : (CharBuffer)(new ByteBufferAsCharBufferL(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment)));
        } else {
            return (nativeByteOrder
                    ? (CharBuffer)(new DirectCharBufferU(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment))
                    : (CharBuffer)(new DirectCharBufferS(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment)));
        }
    }




    private short getShort(long a) {
        try {
            short x = SCOPED_MEMORY_ACCESS.getShortUnaligned(scope(), null, a, bigEndian);
            return (x);
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public short getShort() {
        try {
            return getShort(ix(nextGetIndex((1 << 1))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public short getShort(int i) {
        try {
            return getShort(ix(checkIndex(i, (1 << 1))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }



    private ByteBuffer putShort(long a, short x) {

        try {
            short y = (x);
            SCOPED_MEMORY_ACCESS.putShortUnaligned(scope(), null, a, y, bigEndian);
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer putShort(short x) {

        putShort(ix(nextPutIndex((1 << 1))), x);
        return this;



    }

    public ByteBuffer putShort(int i, short x) {

        putShort(ix(checkIndex(i, (1 << 1))), x);
        return this;



    }

    public ShortBuffer asShortBuffer() {
        int off = this.position();
        int lim = this.limit();
        assert (off <= lim);
        int rem = (off <= lim ? lim - off : 0);

        int size = rem >> 1;
        if (!UNALIGNED && ((address + off) % (1 << 1) != 0)) {
            return (bigEndian
                    ? (ShortBuffer)(new ByteBufferAsShortBufferB(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment))
                    : (ShortBuffer)(new ByteBufferAsShortBufferL(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment)));
        } else {
            return (nativeByteOrder
                    ? (ShortBuffer)(new DirectShortBufferU(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment))
                    : (ShortBuffer)(new DirectShortBufferS(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment)));
        }
    }




    private int getInt(long a) {
        try {
            int x = SCOPED_MEMORY_ACCESS.getIntUnaligned(scope(), null, a, bigEndian);
            return (x);
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public int getInt() {
        try {
            return getInt(ix(nextGetIndex((1 << 2))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public int getInt(int i) {
        try {
            return getInt(ix(checkIndex(i, (1 << 2))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }



    private ByteBuffer putInt(long a, int x) {

        try {
            int y = (x);
            SCOPED_MEMORY_ACCESS.putIntUnaligned(scope(), null, a, y, bigEndian);
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer putInt(int x) {

        putInt(ix(nextPutIndex((1 << 2))), x);
        return this;



    }

    public ByteBuffer putInt(int i, int x) {

        putInt(ix(checkIndex(i, (1 << 2))), x);
        return this;



    }

    public IntBuffer asIntBuffer() {
        int off = this.position();
        int lim = this.limit();
        assert (off <= lim);
        int rem = (off <= lim ? lim - off : 0);

        int size = rem >> 2;
        if (!UNALIGNED && ((address + off) % (1 << 2) != 0)) {
            return (bigEndian
                    ? (IntBuffer)(new ByteBufferAsIntBufferB(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment))
                    : (IntBuffer)(new ByteBufferAsIntBufferL(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment)));
        } else {
            return (nativeByteOrder
                    ? (IntBuffer)(new DirectIntBufferU(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment))
                    : (IntBuffer)(new DirectIntBufferS(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment)));
        }
    }




    private long getLong(long a) {
        try {
            long x = SCOPED_MEMORY_ACCESS.getLongUnaligned(scope(), null, a, bigEndian);
            return (x);
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public long getLong() {
        try {
            return getLong(ix(nextGetIndex((1 << 3))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public long getLong(int i) {
        try {
            return getLong(ix(checkIndex(i, (1 << 3))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }



    private ByteBuffer putLong(long a, long x) {

        try {
            long y = (x);
            SCOPED_MEMORY_ACCESS.putLongUnaligned(scope(), null, a, y, bigEndian);
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer putLong(long x) {

        putLong(ix(nextPutIndex((1 << 3))), x);
        return this;



    }

    public ByteBuffer putLong(int i, long x) {

        putLong(ix(checkIndex(i, (1 << 3))), x);
        return this;



    }

    public LongBuffer asLongBuffer() {
        int off = this.position();
        int lim = this.limit();
        assert (off <= lim);
        int rem = (off <= lim ? lim - off : 0);

        int size = rem >> 3;
        if (!UNALIGNED && ((address + off) % (1 << 3) != 0)) {
            return (bigEndian
                    ? (LongBuffer)(new ByteBufferAsLongBufferB(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment))
                    : (LongBuffer)(new ByteBufferAsLongBufferL(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment)));
        } else {
            return (nativeByteOrder
                    ? (LongBuffer)(new DirectLongBufferU(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment))
                    : (LongBuffer)(new DirectLongBufferS(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment)));
        }
    }




    private float getFloat(long a) {
        try {
            int x = SCOPED_MEMORY_ACCESS.getIntUnaligned(scope(), null, a, bigEndian);
            return Float.intBitsToFloat(x);
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public float getFloat() {
        try {
            return getFloat(ix(nextGetIndex((1 << 2))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public float getFloat(int i) {
        try {
            return getFloat(ix(checkIndex(i, (1 << 2))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }



    private ByteBuffer putFloat(long a, float x) {

        try {
            int y = Float.floatToRawIntBits(x);
            SCOPED_MEMORY_ACCESS.putIntUnaligned(scope(), null, a, y, bigEndian);
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer putFloat(float x) {

        putFloat(ix(nextPutIndex((1 << 2))), x);
        return this;



    }

    public ByteBuffer putFloat(int i, float x) {

        putFloat(ix(checkIndex(i, (1 << 2))), x);
        return this;



    }

    public FloatBuffer asFloatBuffer() {
        int off = this.position();
        int lim = this.limit();
        assert (off <= lim);
        int rem = (off <= lim ? lim - off : 0);

        int size = rem >> 2;
        if (!UNALIGNED && ((address + off) % (1 << 2) != 0)) {
            return (bigEndian
                    ? (FloatBuffer)(new ByteBufferAsFloatBufferB(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment))
                    : (FloatBuffer)(new ByteBufferAsFloatBufferL(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment)));
        } else {
            return (nativeByteOrder
                    ? (FloatBuffer)(new DirectFloatBufferU(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment))
                    : (FloatBuffer)(new DirectFloatBufferS(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment)));
        }
    }




    private double getDouble(long a) {
        try {
            long x = SCOPED_MEMORY_ACCESS.getLongUnaligned(scope(), null, a, bigEndian);
            return Double.longBitsToDouble(x);
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public double getDouble() {
        try {
            return getDouble(ix(nextGetIndex((1 << 3))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }

    public double getDouble(int i) {
        try {
            return getDouble(ix(checkIndex(i, (1 << 3))));
        } finally {
            Reference.reachabilityFence(this);
        }
    }



    private ByteBuffer putDouble(long a, double x) {

        try {
            long y = Double.doubleToRawLongBits(x);
            SCOPED_MEMORY_ACCESS.putLongUnaligned(scope(), null, a, y, bigEndian);
        } finally {
            Reference.reachabilityFence(this);
        }
        return this;



    }

    public ByteBuffer putDouble(double x) {

        putDouble(ix(nextPutIndex((1 << 3))), x);
        return this;



    }

    public ByteBuffer putDouble(int i, double x) {

        putDouble(ix(checkIndex(i, (1 << 3))), x);
        return this;



    }

    public DoubleBuffer asDoubleBuffer() {
        int off = this.position();
        int lim = this.limit();
        assert (off <= lim);
        int rem = (off <= lim ? lim - off : 0);

        int size = rem >> 3;
        if (!UNALIGNED && ((address + off) % (1 << 3) != 0)) {
            return (bigEndian
                    ? (DoubleBuffer)(new ByteBufferAsDoubleBufferB(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment))
                    : (DoubleBuffer)(new ByteBufferAsDoubleBufferL(this,
                                                                       -1,
                                                                       0,
                                                                       size,
                                                                       size,
                                                                       address + off, segment)));
        } else {
            return (nativeByteOrder
                    ? (DoubleBuffer)(new DirectDoubleBufferU(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment))
                    : (DoubleBuffer)(new DirectDoubleBufferS(this,
                                                                 -1,
                                                                 0,
                                                                 size,
                                                                 size,
                                                                 off, segment)));
        }
    }

}
