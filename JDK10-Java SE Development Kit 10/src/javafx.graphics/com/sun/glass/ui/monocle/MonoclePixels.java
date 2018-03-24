/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import com.sun.glass.ui.Pixels;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

final class MonoclePixels extends Pixels {

    MonoclePixels(int width, int height, ByteBuffer data) {
        super(width, height, data);
    }

    MonoclePixels(int width, int height, IntBuffer data) {
        super(width, height, data);
    }

    MonoclePixels(int width, int height, IntBuffer data, float scalex, float scaley) {
        super(width, height, data, scalex, scaley);
    }


    private void _copyPixels(Buffer dst, Buffer src, int size) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override protected void _fillDirectByteBuffer(ByteBuffer bb) {
        if (this.bytes != null) {
            this.bytes.rewind();
            if (this.bytes.isDirect()) {
                _copyPixels(bb, this.bytes, getWidth() * getHeight());
            } else {
                bb.put(this.bytes);
            }
            this.bytes.rewind();
        } else {
            this.ints.rewind();
            if (this.ints.isDirect()) {
                _copyPixels(bb, this.ints, getWidth() * getHeight());
            } else {
                for (int i = 0; i < this.ints.capacity(); i++) {
                    int data = this.ints.get();
                    bb.put((byte)((data) & 0xff));
                    bb.put((byte)((data >> 8) & 0xff));
                    bb.put((byte)((data >> 16) & 0xff));
                    bb.put((byte)((data >> 24) & 0xff));
                }
            }
            this.ints.rewind();
        }
        bb.rewind();
    }

    @Override protected void _attachInt(long nativeWindowPointer, int w, int h,
                                        IntBuffer ints, int[] array, int offset) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override protected void _attachByte(long ptr, int w, int h, ByteBuffer bytes,
                                         byte[] array, int offset) {

        throw new UnsupportedOperationException("not implemented");
    }
}
