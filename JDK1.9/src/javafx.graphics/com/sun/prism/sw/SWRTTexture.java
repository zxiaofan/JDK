/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.Screen;
import com.sun.javafx.geom.Rectangle;
import com.sun.pisces.JavaSurface;
import com.sun.pisces.PiscesRenderer;
import com.sun.pisces.RendererBase;
import com.sun.prism.Graphics;
import com.sun.prism.RTTexture;
import com.sun.prism.impl.PrismSettings;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

class SWRTTexture extends SWArgbPreTexture implements RTTexture {

    private PiscesRenderer pr;
    private JavaSurface surface;
    private final Rectangle dimensions = new Rectangle();
    private boolean isOpaque;

    SWRTTexture(SWResourceFactory factory, int w, int h) {
        super(factory, WrapMode.CLAMP_TO_ZERO, w, h);
        this.allocate();
        this.surface = new JavaSurface(getDataNoClone(), RendererBase.TYPE_INT_ARGB_PRE, w, h);
        this.dimensions.setBounds(0, 0, w, h);
    }

    JavaSurface getSurface() {
        return this.surface;
    }

    @Override
    public int[] getPixels() {
        if (contentWidth == physicalWidth) {
            return getDataNoClone();
        } else {
            return null;
        }
    }

    @Override
    public boolean readPixels(Buffer pixels, int x, int y, int width, int height) {
        if (x != getContentX() || y != getContentY()
                || width != getContentWidth() || height != getContentHeight())
        {
            throw new IllegalArgumentException("reading subtexture not yet supported!");
        }
        return readPixels(pixels);
    }

    @Override
    public boolean readPixels(Buffer pixels) {
        if (PrismSettings.debug) {
            System.out.println("+ SWRTT.readPixels: this: " + this);
        }

        final int pixbuf[] = getDataNoClone();
        pixels.clear();
        // REMIND: This assumes that the caller wants BGRA PRE data...?
        if (pixels instanceof IntBuffer) {
            final IntBuffer iPixels = (IntBuffer)pixels;
            for (int i = 0; i < contentHeight; i++) {
                iPixels.put(pixbuf, i*physicalWidth, contentWidth);
            }
        } else if (pixels instanceof ByteBuffer) {
            final ByteBuffer bPixels = (ByteBuffer)pixels;
            for (int i = 0; i < contentHeight; i++) {
                for (int j = 0; j < contentWidth; j++) {
                    final int argb = pixbuf[i*physicalWidth + j];
                    final byte a = (byte) (argb >> 24);
                    final byte r = (byte) (argb >> 16);
                    final byte g = (byte) (argb >>  8);
                    final byte b = (byte) (argb      );
                    bPixels.put(b).put(g).put(r).put(a);
                }
            }
        } else {
            return false;
        }
        pixels.rewind();
        return true;
    }

    public Screen getAssociatedScreen() {
        return getResourceFactory().getScreen();
    }

    public Graphics createGraphics() {
        if (pr == null) {
            pr = new PiscesRenderer(this.surface);
        }
        return new SWGraphics(this, getResourceFactory().getContext(), pr);
    }

    public boolean isOpaque() {
        return isOpaque;
    }

    public void setOpaque(boolean opaque) {
        this.isOpaque = opaque;
    }

    Rectangle getDimensions() { return dimensions; }

    public boolean isVolatile() {
        return false;
    }

    @Override
    public boolean isMSAA() {
        return false;
    }
}
