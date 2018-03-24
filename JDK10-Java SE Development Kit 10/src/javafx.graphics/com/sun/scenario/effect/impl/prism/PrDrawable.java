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

package com.sun.scenario.effect.impl.prism;

import com.sun.prism.Graphics;
import com.sun.prism.RTTexture;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.impl.ImagePool;
import com.sun.scenario.effect.impl.PoolFilterable;
import com.sun.scenario.effect.impl.Renderer;
import java.lang.ref.WeakReference;

public abstract class PrDrawable extends PrTexture<RTTexture> implements PoolFilterable {
    private WeakReference<ImagePool> pool;

    public static PrDrawable create(FilterContext fctx, RTTexture rtt) {
        return ((PrRenderer) Renderer.getRenderer(fctx)).createDrawable(rtt);
    }

    protected PrDrawable(RTTexture rtt) {
        super(rtt);
    }

    @Override
    public void setImagePool(ImagePool pool) {
        this.pool = new WeakReference<>(pool);
    }

    @Override
    public ImagePool getImagePool() {
        return pool == null ? null : pool.get();
    }

    @Override public float getPixelScale() {
        return 1.0f;
    }

    @Override public int getMaxContentWidth() {
        return getTextureObject().getMaxContentWidth();
    }

    @Override public int getMaxContentHeight() {
        return getTextureObject().getMaxContentHeight();
    }

    @Override public void setContentWidth(int contentW) {
        getTextureObject().setContentWidth(contentW);
    }

    @Override public void setContentHeight(int contentH) {
        getTextureObject().setContentHeight(contentH);
    }

    public abstract Graphics createGraphics();

    public void clear() {
        Graphics g = createGraphics();
        g.clear();
    }
}
