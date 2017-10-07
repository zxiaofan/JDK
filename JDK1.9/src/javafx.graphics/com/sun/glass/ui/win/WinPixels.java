/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.win;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Pixels;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * MS Windows platform implementation class for Pixels.
 */
final class WinPixels extends Pixels {

    private native static int _initIDs(); // returns the native format
    static {
        nativeFormat = _initIDs();
    }

    private static final int nativeFormat;

    protected WinPixels(int width, int height, ByteBuffer data) {
        super(width, height, data);
    }

    protected WinPixels(int width, int height, IntBuffer data) {
        super(width, height, data);
    }

    protected WinPixels(int width, int height, IntBuffer data, float scalex, float scaley) {
        super(width, height, data, scalex, scaley);
    }

    static int getNativeFormat_impl() {
        return nativeFormat;
    }

    @Override native protected void _fillDirectByteBuffer(ByteBuffer bb);
    @Override native protected void _attachInt(long ptr, int w, int h, IntBuffer ints, int[] array, int offset);
    @Override native protected void _attachByte(long ptr, int w, int h, ByteBuffer bytes, byte[] array, int offset);
}

