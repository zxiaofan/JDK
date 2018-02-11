/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.Rectangle;
import com.sun.scenario.effect.LockableResource;

public class PrTexture<T extends com.sun.prism.Texture> implements LockableResource {

    private final T tex;
    private final Rectangle bounds;

    public PrTexture(T tex) {
        if (tex == null) {
            throw new IllegalArgumentException("Texture must be non-null");
        }
        this.tex = tex;
        this.bounds = new Rectangle(tex.getPhysicalWidth(), tex.getPhysicalHeight());
    }

    public void lock() {
        if (tex != null) tex.lock();
    }

    public void unlock() {
        if (tex != null) tex.unlock();
    }

    public boolean isLost() {
        return tex.isSurfaceLost();
    }

    public Rectangle getNativeBounds() {
        return bounds;
    }

    public T getTextureObject() {
        return tex;
    }
}
