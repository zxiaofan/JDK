/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.d3d;

import com.sun.glass.ui.Screen;
import com.sun.prism.Graphics;
import com.sun.prism.Image;
import com.sun.prism.PixelFormat;
import com.sun.prism.RTTexture;
import com.sun.prism.ReadbackRenderTarget;
import com.sun.prism.Texture;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

class D3DRTTexture extends D3DTexture
    implements D3DRenderTarget, RTTexture, ReadbackRenderTarget
{

    private boolean opaque;

    D3DRTTexture(D3DContext context, WrapMode wrapMode, long pResource,
                 int physicalWidth, int physicalHeight,
                 int contentWidth, int contentHeight)
    {
        super(context, PixelFormat.INT_ARGB_PRE, wrapMode, pResource,
              physicalWidth, physicalHeight,
              contentWidth, contentHeight, true);
        this.opaque = false;
    }

    D3DRTTexture(D3DContext context, WrapMode wrapMode, long pResource,
                 int physicalWidth, int physicalHeight,
                 int contentX, int contentY,
                 int contentWidth, int contentHeight,
                 int samples)
    {
        super(context, PixelFormat.INT_ARGB_PRE, wrapMode, pResource,
              physicalWidth, physicalHeight,
              contentX, contentY, contentWidth, contentHeight, true, samples, false);
        this.opaque = false;
    }

    public Texture getBackBuffer() {
        return this;
    }

    public long getResourceHandle() {
        return resource.getResource().getResource();
    }

    public Graphics createGraphics() {
        return D3DGraphics.create(this, getContext());
    }

    public int[] getPixels() {
        return null;
    }

    public boolean readPixels(Buffer pixels, int x, int y, int width, int height) {
        if (x != getContentX() || y != getContentY()
                || width != getContentWidth() || height != getContentHeight())
        {
            throw new IllegalArgumentException("reading subtexture not yet supported!");
        }
        return readPixels(pixels);
    }

    public boolean readPixels(Buffer pixels) {
        getContext().flushVertexBuffer();
        long ctx = getContext().getContextHandle();
        int res = D3DContext.D3D_OK;
        if (pixels instanceof ByteBuffer) {
            ByteBuffer buf = (ByteBuffer) pixels;
            byte[] arr = buf.hasArray() ? buf.array() : null;
            // because of bug 6446635 we take capacity at the java level
            long length = buf.capacity();
            res = D3DResourceFactory.nReadPixelsB(ctx, getNativeSourceHandle(),
                                                  length, pixels, arr,
                                                  getContentWidth(), getContentHeight());
        } else if (pixels instanceof IntBuffer) {
            IntBuffer buf = (IntBuffer) pixels;
            int[] arr = buf.hasArray() ? buf.array() : null;
            long length = buf.capacity()*4;
            res = D3DResourceFactory.nReadPixelsI(ctx, getNativeSourceHandle(),
                                                  length, pixels, arr,
                                                  getContentWidth(), getContentHeight());
        } else {
            throw new IllegalArgumentException("Buffer of this type is " +
                                               "not supported: "+pixels);
        }
        return getContext().validatePresent(res);
    }

    public Screen getAssociatedScreen() {
        return getContext().getAssociatedScreen();
    }

    @Override
    public void update(Image img) {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    @Override
    public void update(Image img, int dstx, int dsty) {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    @Override
    public void update(Image img, int dstx, int dsty, int w, int h) {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    @Override
    public void update(Image img, int dstx, int dsty, int w, int h, boolean skipFlush) {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    @Override
    public void update(Buffer pixels, PixelFormat format,
                       int dstx, int dsty,
                       int srcx, int srcy, int srcw, int srch, int srcscan,
                       boolean skipFlush)
    {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    public void setOpaque(boolean isOpaque) {
        this.opaque = isOpaque;
    }

    public boolean isOpaque() {
        return opaque;
    }

    public boolean isVolatile() {
        return getContext().isRTTVolatile();
    }

    public boolean isMSAA() {
        return resource.getResource().getSamples() != 0;
    }
}
