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

package com.sun.scenario.effect.impl.prism.ps;

import com.sun.javafx.geom.Rectangle;
import com.sun.prism.ps.Shader;
import com.sun.prism.ps.ShaderGraphics;
import com.sun.prism.paint.Color;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.impl.Renderer;

public abstract class PPSZeroSamplerPeer extends PPSEffectPeer {

    private Shader shader;

    protected PPSZeroSamplerPeer(FilterContext fctx, Renderer r, String shaderName) {
        super(fctx, r, shaderName);
    }

    @Override
    public void dispose() {
        if (shader != null) {
            shader.dispose();
        }
    }

    @Override
    ImageData filterImpl(ImageData... inputs) {
        final Rectangle dstBounds = getDestBounds();
        final int dstw = dstBounds.width;
        final int dsth = dstBounds.height;

        PPSRenderer renderer = getRenderer();
        PPSDrawable dst = renderer.getCompatibleImage(dstw, dsth);
        if (dst == null) {
            renderer.markLost();
            return new ImageData(getFilterContext(), dst, dstBounds);
        }
        setDestNativeBounds(dst.getPhysicalWidth(), dst.getPhysicalHeight());

        ShaderGraphics g = dst.createGraphics();
        if (g == null) {
            renderer.markLost();
            return new ImageData(getFilterContext(), dst, dstBounds);
        }
        if (shader == null) {
            shader = createShader();
        }
        if (shader == null || !shader.isValid()) {
            renderer.markLost();
            return new ImageData(getFilterContext(), dst, dstBounds);
        }
        g.setExternalShader(shader);
        updateShader(shader);

        float dx1 = 0;
        float dy1 = 0;
        float dx2 = dstw;
        float dy2 = dsth;

        g.setPaint(Color.WHITE);
        g.fillQuad(dx1, dy1, dx2, dy2);
        g.setExternalShader(null);

        return new ImageData(getFilterContext(), dst, dstBounds);
    }
}
