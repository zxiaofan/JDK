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

package com.sun.prism.sw;

import com.sun.glass.ui.Pixels;
import com.sun.javafx.geom.Rectangle;
import com.sun.prism.Presentable;
import com.sun.prism.PresentableState;
import com.sun.prism.impl.QueuedPixelSource;
import java.nio.IntBuffer;

final class SWPresentable extends SWRTTexture implements Presentable {

    private final PresentableState pState;
    private Pixels pixels;
    private QueuedPixelSource pixelSource = new QueuedPixelSource(false);

    public SWPresentable(PresentableState pState, SWResourceFactory factory) {
        super(factory, pState.getRenderWidth(), pState.getRenderHeight());
        this.pState = pState;
    }

    @Override
    public boolean lockResources(PresentableState pState) {
        return (getPhysicalWidth() != pState.getRenderWidth() ||
                getPhysicalHeight() != pState.getRenderHeight());
    }

    public boolean prepare(Rectangle dirtyregion) {
        if (!pState.isViewClosed()) {
            /*
             * RT-27374
             * TODO: make sure the imgrep matches the Pixels.getNativeFormat()
             * TODO: dirty region support
             */
            int w = getPhysicalWidth();
            int h = getPhysicalHeight();
            pixels = pixelSource.getUnusedPixels(w, h, 1.0f, 1.0f);
            IntBuffer pixBuf = (IntBuffer) pixels.getPixels();
            IntBuffer buf = getSurface().getDataIntBuffer();
            assert buf.hasArray();
            System.arraycopy(buf.array(), 0, pixBuf.array(), 0, w*h);
            return true;
        } else {
            return false;
        }
    }

    public boolean present() {
        pixelSource.enqueuePixels(pixels);
        pState.uploadPixels(pixelSource);
        return true;
    }

    @Override
    public float getPixelScaleFactorX() {
        return pState.getRenderScaleX();
    }

    @Override
    public float getPixelScaleFactorY() {
        return pState.getRenderScaleY();
    }

    public int getContentWidth() {
        return pState.getOutputWidth();
    }

    public int getContentHeight() {
        return pState.getOutputHeight();
    }

    @Override public boolean isMSAA() {
        return super.isMSAA();
    }
}
