/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.sg.prism.NGCamera;
import com.sun.prism.CompositeMode;
import com.sun.prism.RTTexture;
import com.sun.prism.RenderTarget;
import com.sun.prism.Texture;
import com.sun.prism.impl.ps.BaseShaderContext;
import com.sun.prism.ps.Shader;

class DummyContext extends BaseShaderContext {

    private State state;

    DummyContext(Screen screen, DummyResourceFactory factory) {
        super(screen, factory, 32);
    }

    protected void renderQuads(float coordArray[], byte colorArray[], int numVertices) {
    }

    @Override
    protected void init() {
        super.init();
        this.state = new State();
    }

    @Override
    protected State updateRenderTarget(RenderTarget target, NGCamera camera, boolean depthTest) {
        return state;
    }

    @Override
    protected void updateTexture(int texUnit, Texture tex) {
    }

    @Override
    protected void updateShaderTransform(Shader shader, BaseTransform xform) {
    }

    @Override
    protected void updateWorldTransform(BaseTransform xform) {
    }

    @Override
    protected void updateClipRect(Rectangle clipRect) {
    }

    @Override
    protected void updateCompositeMode(CompositeMode mode) {
    }

    @Override
    public void blit(RTTexture srcRTT, RTTexture dstRTT,
                     int srcX0, int srcY0, int srcX1, int srcY1,
                     int dstX0, int dstY0, int dstX1, int dstY1) {
    }
}
