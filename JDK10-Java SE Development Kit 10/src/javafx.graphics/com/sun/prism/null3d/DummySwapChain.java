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

package com.sun.prism.null3d;

import com.sun.glass.ui.Screen;
import com.sun.javafx.geom.Rectangle;
import com.sun.prism.Graphics;
import com.sun.prism.Presentable;
import com.sun.prism.PresentableState;

class DummySwapChain extends DummyResource implements Presentable {

    private final PresentableState pState;
    private final DummyRTTexture texBackBuffer;
    private int w,h;
    private boolean opaque;

    DummySwapChain(DummyContext context, PresentableState pState, DummyRTTexture rtt) {
        super(context);
        this.pState = pState;
        this.w = pState.getWidth();
        this.h = pState.getHeight();
        texBackBuffer = rtt;
    }

    @Override
    public void dispose() {
        texBackBuffer.dispose();
        super.dispose();
    }

    public boolean lockResources(PresentableState pState) {
        texBackBuffer.lock();
        return false;
    }

    public boolean prepare(Rectangle clip) {
        texBackBuffer.unlock();
        return true;
    }

    public boolean present() {
        return true;
    }

    public int getPhysicalWidth() {
        return w;
    }

    public int getPhysicalHeight() {
        return h;
    }

    public int getContentWidth() {
        return getPhysicalWidth();
    }

    public int getContentHeight() {
        return getPhysicalHeight();
    }

    public int getContentX() {
        return 0;
    }

    public int getContentY() {
        return 0;
    }

    @Override
    public float getPixelScaleFactorX() {
        return 1.0f;
    }

    @Override
    public float getPixelScaleFactorY() {
        return 1.0f;
    }

    public Graphics createGraphics() {
        return DummyGraphics.create(texBackBuffer, context);
    }

    public Screen getAssociatedScreen() {
        return context.getAssociatedScreen();
    }

    public boolean isOpaque() {
        return opaque;
    }

    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    @Override
    public boolean isMSAA() {
        return false;
    }
}
