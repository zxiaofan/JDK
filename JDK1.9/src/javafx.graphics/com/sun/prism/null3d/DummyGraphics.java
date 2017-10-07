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

package com.sun.prism.null3d;

import com.sun.prism.Graphics;
import com.sun.prism.RenderTarget;
import com.sun.prism.impl.ps.BaseShaderGraphics;
import com.sun.prism.paint.Color;

class DummyGraphics extends BaseShaderGraphics  {

    private DummyGraphics(DummyContext context, RenderTarget target) {
        super(context, target);
    }

    static Graphics create(RenderTarget target, DummyContext ctx) {
        return new DummyGraphics(ctx, target);
    }

    public void clearQuad(float x1, float y1, float x2, float y2) {
    }

    public void clear(Color color) {
    }

    public void sync() {
    }

    @Override
    public void setState3D(boolean flag) {
    }

    @Override
    public boolean isState3D() {
        return false;
    }

    @Override
    public void setup3DRendering() {
    }
}
