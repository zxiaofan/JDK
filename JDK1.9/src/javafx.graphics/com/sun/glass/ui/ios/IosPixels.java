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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.Pixels;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * iOS platform implementation class for Pixels.
 */
final class IosPixels extends Pixels {

    protected IosPixels(int width, int height, ByteBuffer data) {
        super(width, height, data);
    }

    protected IosPixels(int width, int height, IntBuffer data) {
        super(width, height, data);
    }

    protected IosPixels(int width, int height, IntBuffer data, float scalex, float scaley) {
        super(width, height, data, scalex, scaley);
    }

    @Override
    protected void _fillDirectByteBuffer(ByteBuffer bb) { }

    @Override
    protected void _attachInt(long ptr, int w, int h, IntBuffer ints, int[] array, int offset) { }

    @Override
    protected void _attachByte(long ptr, int w, int h, ByteBuffer bytes, byte[] array, int offset) { }
}
