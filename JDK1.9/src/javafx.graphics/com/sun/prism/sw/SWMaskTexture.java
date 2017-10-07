/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.sw;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import com.sun.prism.MediaFrame;
import com.sun.prism.PixelFormat;
import com.sun.prism.Texture;
import com.sun.prism.impl.PrismSettings;

public class SWMaskTexture extends SWTexture {

    private byte data[];

    SWMaskTexture(SWResourceFactory factory, WrapMode wrapMode, int w, int h) {
        super(factory, wrapMode, w, h);
    }

    SWMaskTexture(SWMaskTexture sharedTex, WrapMode altMode) {
        super(sharedTex, altMode);
        this.data = sharedTex.data;
    }

    byte[] getDataNoClone() {
        return data;
    }

    @Override
    public PixelFormat getPixelFormat() {
        return PixelFormat.BYTE_ALPHA;
    }

    @Override
    public void update(Buffer buffer, PixelFormat format, int dstx, int dsty,
                       int srcx, int srcy, int srcw, int srch, int srcscan, boolean skipFlush)
    {
        if (PrismSettings.debug) {
            System.out.println("MASK TEXTURE, Pixel format: " + format + ", buffer: " + buffer);
            System.out.println("dstx:" + dstx + " dsty:" + dsty);
            System.out.println("srcx:" + srcx + " srcy:" + srcy + " srcw:" + srcw + " srch:" + srch + " srcscan: " + srcscan);
        }

        if (format != PixelFormat.BYTE_ALPHA) {
            throw new IllegalArgumentException("SWMaskTexture supports BYTE_ALPHA format only.");
        }
        this.checkAllocation(srcw, srch);
        this.physicalWidth = srcw;
        this.physicalHeight = srch;
        this.allocate();

        ByteBuffer bb = (ByteBuffer)buffer;
        for (int i = 0; i < srch; i++) {
            bb.position((srcy + i)*srcscan + srcx);
            bb.get(this.data, i*this.physicalWidth, srcw);
        }
    }

    @Override
    public void update(MediaFrame frame, boolean skipFlush) {
        throw new UnsupportedOperationException("update6:unimp");
    }

    void checkAllocation(int srcw, int srch) {
        if (allocated) {
            final int nlen = srcw * srch;
            if (nlen > this.data.length) {
                throw new IllegalArgumentException("SRCW * SRCH exceeds buffer length");
            }
        }
    }

    void allocateBuffer() {
        this.data = new byte[physicalWidth * physicalHeight];
    }

    Texture createSharedLockedTexture(WrapMode altMode) {
        return new SWMaskTexture(this, altMode);
    }
}
