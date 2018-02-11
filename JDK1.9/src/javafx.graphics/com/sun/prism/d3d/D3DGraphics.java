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

package com.sun.prism.d3d;

import com.sun.javafx.geom.transform.Affine3D;
import com.sun.prism.CompositeMode;
import com.sun.prism.Graphics;
import com.sun.prism.RenderTarget;
import com.sun.prism.impl.PrismSettings;
import com.sun.prism.impl.ps.BaseShaderGraphics;
import com.sun.prism.paint.Color;
import com.sun.prism.paint.Paint;

class D3DGraphics extends BaseShaderGraphics implements D3DContextSource {

    private D3DContext context;

    private D3DGraphics(D3DContext context, RenderTarget target) {
        super(context, target);
        this.context = context;
    }

    @Override
    public void getPaintShaderTransform(Affine3D ret) {
        super.getPaintShaderTransform(ret);
        ret.preTranslate(-0.5, -0.5, 0.0);
    }

    static Graphics create(RenderTarget target, D3DContext context) {
        if (target == null) {
            return null;
        }
        long resourceHandle = ((D3DRenderTarget)target).getResourceHandle();
        if (resourceHandle == 0) {
            return null;
        }

        if (PrismSettings.verbose && context.isLost()) {
            System.err.println("Create graphics while the device is lost");
        }

        return new D3DGraphics(context, target);
    }

    public void clearQuad(float x1, float y1, float x2, float y2) {
        // note that unlike clear(), this method does not currently
        // attempt to clear the depth buffer...
        context.setRenderTarget(this);
        context.flushVertexBuffer();
        // set the blend mode to CLEAR and any regular Color as paint
        CompositeMode oldMode = getCompositeMode();
        setCompositeMode(CompositeMode.CLEAR);
        Paint oldPaint = getPaint();
        setPaint(Color.BLACK); // any color will do...
        fillQuad(x1, y1, x2, y2);
        context.flushVertexBuffer();
        // restore prior paint and blend mode
        setPaint(oldPaint);
        setCompositeMode(oldMode);
    }

    public void clear(Color color) {
        context.validateClearOp(this);
        this.getRenderTarget().setOpaque(color.isOpaque());
        int res = nClear(context.getContextHandle(),
                          color.getIntArgbPre(), isDepthBuffer(), false);
        context.validate(res);
    }

    public void sync() {
        context.flushVertexBuffer();
    }

    public D3DContext getContext() {
        return context;
    }

    private static native int nClear(long pContext, int colorArgbPre,
                                      boolean clearDepth, boolean ignoreScissor);
}
