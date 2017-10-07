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
 * This is a Singleton class that allows you to allocate buffer that
 * are stored in ThreadLocal. This class stores 3 types of char
 * buffers - small (< 128 bytes), medium (<2K) and large (> 2K) as
 * well as three byte buffers - small, medium and large.
 * The local storage is activated on the return of the buffer.
 * The buffer returns null if it is already allocated.
 *
 * @author Binu.John@sun.com
 * @author Santiago.PericasGeertsen@sun.com
 */
public class ThreadLocalBufferAllocator {
   private static ThreadLocal<SoftReference> tlba = new ThreadLocal<>();

   public static BufferAllocator getBufferAllocator() {
        SoftReference<BufferAllocator> bAllocatorRef = tlba.get();
        if (bAllocatorRef == null || bAllocatorRef.get() == null) {
            bAllocatorRef = new SoftReference(new BufferAllocator());
            tlba.set(bAllocatorRef);
        }

        return bAllocatorRef.get();
   }
}
