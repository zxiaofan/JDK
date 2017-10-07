/*
 * Copyright (c) 2003, 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.opengl;

import java.awt.Composite;
import sun.font.GlyphList;
import sun.java2d.SunGraphics2D;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.pipe.BufferedTextPipe;
import sun.java2d.pipe.RenderQueue;

class OGLTextRenderer extends BufferedTextPipe {

    OGLTextRenderer(RenderQueue rq) {
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
        OGLSurfaceData oglDst = (OGLSurfaceData)sg2d.surfaceData;
        OGLContext.validateContext(oglDst, oglDst,
                                   sg2d.getCompClip(), comp,
                                   null, sg2d.paint, sg2d,
                                   OGLContext.NO_CONTEXT_FLAGS);
    }

    OGLTextRenderer traceWrap() {
        return new Tracer(this);
    }

    private static class Tracer extends OGLTextRenderer {
        Tracer(OGLTextRenderer ogltr) {
            super(ogltr.rq);
        }
        protected void drawGlyphList(SunGraphics2D sg2d, GlyphList gl) {
            GraphicsPrimitive.tracePrimitive("OGLDrawGlyphs");
            super.drawGlyphList(sg2d, gl);
        }
    }
}
