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



 * A read-only HeapDoubleBuffer.  This class extends the corresponding
 * read/write class, overriding the mutation methods to throw a {@link
 * ReadOnlyBufferException} and overriding the view-buffer methods to return an
 * instance of this class rather than of the superclass.

 */

class HeapDoubleBufferR
    extends HeapDoubleBuffer
{
    // Cached array base offset
    private static final long ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(double[].class);

    // Cached array index scale
    private static final long ARRAY_INDEX_SCALE = UNSAFE.arrayIndexScale(double[].class);

    // For speed these fields are actually declared in X-Buffer;
    // these declarations are here as documentation
    /*




    */

    HeapDoubleBufferR(int cap, int lim, MemorySegmentProxy segment) {            // package-private








        super(cap, lim, segment);
        this.isReadOnly = true;

    }

    HeapDoubleBufferR(double[] buf, int off, int len, MemorySegmentProxy segment) { // package-private








        super(buf, off, len, segment);
        this.isReadOnly = true;

    }

    protected HeapDoubleBufferR(double[] buf,
                                   int mark, int pos, int lim, int cap,
                                   int off, MemorySegmentProxy segment)
    {








        super(buf, mark, pos, lim, cap, off, segment);
        this.isReadOnly = true;

    }

    public DoubleBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        return new HeapDoubleBufferR(hb,
                                        -1,
                                        0,
                                        rem,
                                        rem,
                                        pos + offset, segment);
    }

    @Override
    public DoubleBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapDoubleBufferR(hb,
                                        -1,
                                        0,
                                        length,
                                        length,
                                        index + offset, segment);
    }

    public DoubleBuffer duplicate() {
        return new HeapDoubleBufferR(hb,
                                        this.markValue(),
                                        this.position(),
                                        this.limit(),
                                        this.capacity(),
                                        offset, segment);
    }

    public DoubleBuffer asReadOnlyBuffer() {








        return duplicate();

    }




















































    public boolean isReadOnly() {
        return true;
    }

    public DoubleBuffer put(double x) {




        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer put(int i, double x) {




        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer put(double[] src, int offset, int length) {










        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer put(DoubleBuffer src) {





        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer put(int index, DoubleBuffer src, int offset, int length) {





        throw new ReadOnlyBufferException();

    }

    public DoubleBuffer put(int index, double[] src, int offset, int length) {







        throw new ReadOnlyBufferException();

    }























    public DoubleBuffer compact() {











        throw new ReadOnlyBufferException();

    }

















































































































































































































































































































































































    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }







}
