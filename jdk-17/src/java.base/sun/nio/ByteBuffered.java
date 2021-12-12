/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio;

import java.nio.ByteBuffer;
import java.io.IOException;

/**
 * This is an interface to adapt existing APIs to use {@link java.nio.ByteBuffer
 * ByteBuffers} as the underlying data format.  Only the initial producer and
 * final consumer have to be changed.
 *
 * <p>
 * For example, the Zip/Jar code supports {@link java.io.InputStream InputStreams}.
 * To make the Zip code use {@link java.nio.MappedByteBuffer MappedByteBuffers} as
 * the underlying data structure, it can create a class of InputStream that wraps
 * the ByteBuffer, and implements the ByteBuffered interface. A co-operating class
 * several layers away can ask the InputStream if it is an instance of ByteBuffered,
 * then call the {@link #getByteBuffer()} method.
 */
public interface ByteBuffered {

    /**
     * Returns the {@code ByteBuffer} behind this object, if this particular
     * instance has one. An implementation of {@code getByteBuffer()} is allowed
     * to return {@code null} for any reason.
     *
     * @return  The {@code ByteBuffer}, if this particular instance has one,
     *          or {@code null} otherwise.
     *
     * @throws  IOException
     *          If the ByteBuffer is no longer valid.
     *
     * @since  1.5
     */
    public ByteBuffer getByteBuffer() throws IOException;
}
