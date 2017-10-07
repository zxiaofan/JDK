/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.j2d;

import com.sun.glass.ui.Screen;
import com.sun.javafx.image.impl.IntArgbPre;
import com.sun.prism.Graphics;
import com.sun.prism.Image;
import com.sun.prism.PixelFormat;
import com.sun.prism.RTTexture;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

class J2DRTTexture extends J2DTexture implements RTTexture {
    protected J2DResourceFactory factory;
    private boolean opaque;

    J2DRTTexture(int w, int h, J2DResourceFactory factory) {
        super(new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB_PRE),
              PixelFormat.INT_ARGB_PRE,
              IntArgbPre.setter, WrapMode.CLAMP_TO_ZERO);
        this.factory = factory;
        this.opaque = false;
    }

    public int[] getPixels() {
        BufferedImage bimg = getBufferedImage();
        java.awt.image.DataBuffer db = bimg.getRaster().getDataBuffer();
        if (db instanceof java.awt.image.DataBufferInt) {
            return ((java.awt.image.DataBufferInt) db).getData();
        }
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
//        int x = getContentX();
//        int y = getContentY();
        int w = getContentWidth();
        int h = getContentHeight();
        int pixbuf[] = getPixels();
        // NOTE: Caller should clear this, not the callee...
        pixels.clear();

        // REMIND: This assumes that the caller wants BGRA PRE data...?
        for (int i = 0; i < w * h; i++) {
            int argb = pixbuf[i];
            if (pixels instanceof IntBuffer) {
                ((IntBuffer)pixels).put(argb);
            } else if (pixels instanceof ByteBuffer) {
                byte a = (byte) (argb >> 24);
                byte r = (byte) (argb >> 16);
                byte g = (byte) (argb >>  8);
                byte b = (byte) (argb      );
                ((ByteBuffer)pixels).put((byte)b);
                ((ByteBuffer)pixels).put((byte)g);
                ((ByteBuffer)pixels).put((byte)r);
                ((ByteBuffer)pixels).put((byte)a);
            }
        }
        pixels.rewind();
        return true;
    }

    public Graphics createGraphics() {
        BufferedImage bimg = getBufferedImage();
        J2DPresentable presentable = J2DPresentable.create(bimg, factory);
        java.awt.Graphics2D g2d = bimg.createGraphics();
        return factory.createJ2DPrismGraphics(presentable, g2d);
    }

    java.awt.Graphics2D createAWTGraphics2D() {
        return getBufferedImage().createGraphics();
    }

    public Screen getAssociatedScreen() {
        return factory.getScreen();
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
    public void update(Image img, int dstx, int dsty, int srcw, int srch,
                       boolean skipFlush)
    {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    @Override
    public void update(Buffer buffer, PixelFormat format, int dstx, int dsty,
                       int srcx, int srcy, int srcw, int srch,
                       int srcscan,
                       boolean skipFlush)
    {
        throw new UnsupportedOperationException("update() not supported for RTTextures");
    }

    public boolean isOpaque() {
        return opaque;
    }

    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    public boolean isVolatile() {
        return false;
    }

    @Override public boolean isMSAA() {
        return false;
    }
}
