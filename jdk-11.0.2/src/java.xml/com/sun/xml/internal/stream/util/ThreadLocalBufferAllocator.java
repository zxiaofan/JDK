/*
 * Copyright (c) 2005, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * This is a Singleton class that allows you to allocate buffer that
 * are stored in ThreadLocal. This class stores 3 types of char
 * buffers - small (< 128 bytes), medium (<2K) and large (> 2K) as
 * well as three byte buffers - small, medium and large.
 * The local storage is activated on the return of the buffer.
 * The buffer returns null if it is already allocated.
 *
 * @author Binu John
 * @author Santiago PericasGeertsen
 */
public class ThreadLocalBufferAllocator {
    private static final ThreadLocal<SoftReference<BufferAllocator>> TL = new ThreadLocal<>();

    public static BufferAllocator getBufferAllocator() {
        BufferAllocator ba = null;
        SoftReference<BufferAllocator> sr = TL.get();
        if (sr != null) {
            ba = sr.get();
        }
        if (ba == null) {
            ba = new BufferAllocator();
            sr = new SoftReference<>(ba);
            TL.set(sr);
        }
        return ba;
    }
}
