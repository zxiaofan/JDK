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



 * A read-only HeapFloatBuffer.  This class extends the corresponding
 * read/write class, overriding the mutation methods to throw a {@link
 * ReadOnlyBufferException} and overriding the view-buffer methods to return an
 * instance of this class rather than of the superclass.

 */

class HeapFloatBufferR
    extends HeapFloatBuffer
{
    // Cached array base offset
    private static final long ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(float[].class);

    // Cached array index scale
    private static final long ARRAY_INDEX_SCALE = UNSAFE.arrayIndexScale(float[].class);

    // For speed these fields are actually declared in X-Buffer;
    // these declarations are here as documentation
    /*




    */

    HeapFloatBufferR(int cap, int lim, MemorySegmentProxy segment) {            // package-private








        super(cap, lim, segment);
        this.isReadOnly = true;

    }

    HeapFloatBufferR(float[] buf, int off, int len, MemorySegmentProxy segment) { // package-private








        super(buf, off, len, segment);
        this.isReadOnly = true;

    }

    protected HeapFloatBufferR(float[] buf,
                                   int mark, int pos, int lim, int cap,
                                   int off, MemorySegmentProxy segment)
    {








        super(buf, mark, pos, lim, cap, off, segment);
        this.isReadOnly = true;

    }

    public FloatBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        return new HeapFloatBufferR(hb,
                                        -1,
                                        0,
                                        rem,
                                        rem,
                                        pos + offset, segment);
    }

    @Override
    public FloatBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapFloatBufferR(hb,
                                        -1,
                                        0,
                                        length,
                                        length,
                                        index + offset, segment);
    }

    public FloatBuffer duplicate() {
        return new HeapFloatBufferR(hb,
                                        this.markValue(),
                                        this.position(),
                                        this.limit(),
                                        this.capacity(),
                                        offset, segment);
    }

    public FloatBuffer asReadOnlyBuffer() {








        return duplicate();

    }




















































    public boolean isReadOnly() {
        return true;
    }

    public FloatBuffer put(float x) {




        throw new ReadOnlyBufferException();

    }

    public FloatBuffer put(int i, float x) {




        throw new ReadOnlyBufferException();

    }

    public FloatBuffer put(float[] src, int offset, int length) {










        throw new ReadOnlyBufferException();

    }

    public FloatBuffer put(FloatBuffer src) {





        throw new ReadOnlyBufferException();

    }

    public FloatBuffer put(int index, FloatBuffer src, int offset, int length) {





        throw new ReadOnlyBufferException();

    }

    public FloatBuffer put(int index, float[] src, int offset, int length) {







        throw new ReadOnlyBufferException();

    }























    public FloatBuffer compact() {











        throw new ReadOnlyBufferException();

    }

















































































































































































































































































































































































    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }







}
