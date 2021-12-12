/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.d3d;

import java.awt.Composite;
import sun.font.GlyphList;
import sun.java2d.SunGraphics2D;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.pipe.BufferedTextPipe;
import sun.java2d.pipe.RenderQueue;

class D3DTextRenderer extends BufferedTextPipe {

    D3DTextRenderer(RenderQueue rq) {
        super(rq);
    }

    @Override
    protected native void drawGlyphList(int numGlyphs, boolean usePositions,
                                        boolean subPixPos, boolean rgbOrder,
                                        int lcdContrast,
                                        float glOrigX, float glOrigY,
                                        long[] images, float[] positions);

    @Override
    protected void validateContext(SunGraphics2D sg2d, Composite comp) {
        // assert rq.lock.isHeldByCurrentThread();
        D3DSurfaceData d3dDst = (D3DSurfaceData)sg2d.surfaceData;
        D3DContext.validateContext(d3dDst, d3dDst,
                                   sg2d.getCompClip(), comp,
                                   null, sg2d.paint, sg2d,
                                   D3DContext.NO_CONTEXT_FLAGS);
    }

    D3DTextRenderer traceWrap() {
        return new Tracer(this);
    }

    private static class Tracer extends D3DTextRenderer {
        Tracer(D3DTextRenderer d3dtr) {
            super(d3dtr.rq);
        }
        protected void drawGlyphList(SunGraphics2D sg2d, GlyphList gl) {
            GraphicsPrimitive.tracePrimitive("D3DDrawGlyphs");
            super.drawGlyphList(sg2d, gl);
        }
    }
}
