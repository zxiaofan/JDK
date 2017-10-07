/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.javafx.geom.Rectangle;
import com.sun.prism.CompositeMode;
import com.sun.prism.Graphics;
import com.sun.prism.Presentable;
import com.sun.prism.PresentableState;
import com.sun.prism.RTTexture;

class D3DSwapChain
    extends D3DResource
    implements D3DRenderTarget, Presentable, D3DContextSource {

    private final D3DRTTexture texBackBuffer;
    private final float pixelScaleFactorX;
    private final float pixelScaleFactorY;

    D3DSwapChain(D3DContext context, long pResource, D3DRTTexture rtt, float pixelScaleX, float pixelScaleY) {
        super(new D3DRecord(context, pResource));
        texBackBuffer = rtt;
        pixelScaleFactorX = pixelScaleX;
        pixelScaleFactorY = pixelScaleY;
    }

    @Override
    public void dispose() {
        texBackBuffer.dispose();
        super.dispose();
    }

    @Override
    public boolean prepare(Rectangle dirtyregion) {
        D3DContext context = getContext();
        context.flushVertexBuffer();
        D3DGraphics g = (D3DGraphics) D3DGraphics.create(this, context);
        if (g == null) {
            return false;
        }
        int sw = texBackBuffer.getContentWidth();
        int sh = texBackBuffer.getContentHeight();
        int dw = this.getContentWidth();
        int dh = this.getContentHeight();
        if (isMSAA()) {
            context.flushVertexBuffer();
            g.blit(texBackBuffer, null, 0, 0, sw, sh, 0, 0, dw, dh);
        } else {
            g.setCompositeMode(CompositeMode.SRC);
            g.drawTexture(texBackBuffer, 0, 0, dw, dh, 0, 0, sw, sh);
        }
        context.flushVertexBuffer();
        texBackBuffer.unlock();
        return true;
    }

    public boolean present() {
        D3DContext context = getContext();
        int res = nPresent(context.getContextHandle(), d3dResRecord.getResource());
        return context.validatePresent(res);
    }

    public long getResourceHandle() {
        return d3dResRecord.getResource();
    }

    public int getPhysicalWidth() {
        return D3DResourceFactory.nGetTextureWidth(d3dResRecord.getResource());
    }

    public int getPhysicalHeight() {
        return D3DResourceFactory.nGetTextureHeight(d3dResRecord.getResource());
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

    private static native int nPresent(long context, long pSwapChain);

    public D3DContext getContext() {
        return d3dResRecord.getContext();
    }

    public boolean lockResources(PresentableState pState) {
        if (pState.getRenderWidth() != texBackBuffer.getContentWidth() ||
            pState.getRenderHeight() != texBackBuffer.getContentHeight() ||
            pState.getRenderScaleX() != pixelScaleFactorX ||
            pState.getRenderScaleY() != pixelScaleFactorY)
        {
            return true;
        }
        texBackBuffer.lock();
        return texBackBuffer.isSurfaceLost();
    }

    public Graphics createGraphics() {
        Graphics g = D3DGraphics.create(texBackBuffer, getContext());
        g.scale(pixelScaleFactorX, pixelScaleFactorY);
        return g;
    }

    public RTTexture getRTTBackBuffer() {
        return texBackBuffer;
    }

    public Screen getAssociatedScreen() {
        return getContext().getAssociatedScreen();
    }

    @Override
    public float getPixelScaleFactorX() {
        return pixelScaleFactorX;
    }

    @Override
    public float getPixelScaleFactorY() {
        return pixelScaleFactorY;
    }

    public boolean isOpaque() {
        return texBackBuffer.isOpaque();
    }

    public void setOpaque(boolean opaque) {
        texBackBuffer.setOpaque(opaque);
    }

    public boolean isMSAA() {
        return texBackBuffer != null ? texBackBuffer.isMSAA() : false;
    }
}
