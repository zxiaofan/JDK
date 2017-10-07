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

package com.sun.prism.null3d;

import com.sun.glass.ui.Screen;
import com.sun.prism.MediaFrame;
import com.sun.prism.Graphics;
import com.sun.prism.Image;
import com.sun.prism.PixelFormat;
import com.sun.prism.RTTexture;
import java.nio.Buffer;


class DummyRTTexture extends DummyTexture implements RTTexture {
    private boolean opaque;

    DummyRTTexture(DummyContext context, WrapMode wrapMode,
                   int contentWidth, int contentHeight)
    {
        super(context, PixelFormat.INT_ARGB_PRE, wrapMode,
              contentWidth, contentHeight, true);
    }

    public Graphics createGraphics() {
        return DummyGraphics.create(this, getContext());
    }

    public int[] getPixels() {
        return null;
    }

    public boolean readPixels(Buffer pixels, int x, int y, int width, int height) {
        return false;
    }

    public boolean readPixels(Buffer pixels) {
        return false;
    }

    public Screen getAssociatedScreen() {
        return getContext().getAssociatedScreen();
    }

    @Override
    public void update(Image img) {
    }

    @Override
    public void update(Image img, int dstx, int dsty) {
    }

    @Override
    public void update(Image img, int dstx, int dsty, int w, int h) {
    }

    @Override
    public void update(Image img, int dstx, int dsty, int w, int h, boolean skipFlush) {
    }

    @Override
    public void update(Buffer pixels, PixelFormat format,
                       int dstx, int dsty,
                       int srcx, int srcy, int srcw, int srch, int srcscan,
                       boolean skipFlush)
    {
    }

    public void update(MediaFrame frame, boolean skipFlush) {
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

    @Override
    public boolean isMSAA() {
        return false;
    }
}
