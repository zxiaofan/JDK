/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.util;

import java.lang.ref.*;

/**
 * Buffer allocator for buffers of sizes 128 B, 2 KB and 8 KB. Includes
 * methods for allocating and freeing buffers.
 *
 * @author Binu John
 * @author Santiago PericasGeertsen
 */
public class BufferAllocator {
    private static final int SMALL_SIZE_LIMIT = 128;
    private static final int MEDIUM_SIZE_LIMIT = 2048;
    private static final int LARGE_SIZE_LIMIT = 8192;

    char[] smallCharBuffer;
    char[] mediumCharBuffer;
    char[] largeCharBuffer;

    byte[] smallByteBuffer;
    byte[] mediumByteBuffer;
    byte[] largeByteBuffer;

    public BufferAllocator() {
    }

    public char[] getCharBuffer(int size) {
        if (size <= SMALL_SIZE_LIMIT) {
            char[] buffer = smallCharBuffer;
            smallCharBuffer = null;
            return buffer;
        }
        else if (size <= MEDIUM_SIZE_LIMIT) {
            char[] buffer = mediumCharBuffer;
            mediumCharBuffer = null;
            return buffer;
        }
        else if (size <= LARGE_SIZE_LIMIT) {
            char[] buffer = largeCharBuffer;
            largeCharBuffer = null;
            return buffer;
        }
        return null;
    }

    public void returnCharBuffer(char[] c) {
        if (c == null) {
            return;
        }
        if (c.length <= SMALL_SIZE_LIMIT) {
            smallCharBuffer = c;
        }
        else if (c.length <= MEDIUM_SIZE_LIMIT) {
            mediumCharBuffer = c;
        }
        else if (c.length <= LARGE_SIZE_LIMIT) {
            largeCharBuffer = c;
        }
    }

    public byte[] getByteBuffer(int size) {
        if (size <= SMALL_SIZE_LIMIT) {
            byte[] buffer = smallByteBuffer;
            smallByteBuffer = null;
            return buffer;
        }
        else if (size <= MEDIUM_SIZE_LIMIT) {
            byte[] buffer = mediumByteBuffer;
            mediumByteBuffer = null;
            return buffer;
        }
        else if (size <= LARGE_SIZE_LIMIT) {
            byte[] buffer = largeByteBuffer;
            largeByteBuffer = null;
            return buffer;
        }
        return null;
    }

    public void returnByteBuffer(byte[] b) {
        if (b == null) {
            return;
        }
        if (b.length <= SMALL_SIZE_LIMIT) {
            smallByteBuffer = b;
        }
        else if (b.length <= MEDIUM_SIZE_LIMIT) {
            mediumByteBuffer = b;
        }
        else if (b.length <= LARGE_SIZE_LIMIT) {
            largeByteBuffer = b;
        }
    }

}
