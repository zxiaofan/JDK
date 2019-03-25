/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
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
import sun.java2d.SurfaceData;
import sun.java2d.loops.CompositeType;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.loops.GraphicsPrimitiveMgr;
import sun.java2d.loops.SurfaceType;
import sun.java2d.pipe.Region;
import sun.java2d.pipe.BufferedMaskBlit;
import static sun.java2d.loops.CompositeType.*;
import static sun.java2d.loops.SurfaceType.*;

class OGLMaskBlit extends BufferedMaskBlit {

    static void register() {
        GraphicsPrimitive[] primitives = {
            new OGLMaskBlit(IntArgb,    SrcOver),
            new OGLMaskBlit(IntArgbPre, SrcOver),
            new OGLMaskBlit(IntRgb,     SrcOver),
            new OGLMaskBlit(IntRgb,     SrcNoEa),
            new OGLMaskBlit(IntBgr,     SrcOver),
            new OGLMaskBlit(IntBgr,     SrcNoEa),
        };
        GraphicsPrimitiveMgr.register(primitives);
    }

    private OGLMaskBlit(SurfaceType srcType,
                        CompositeType compType)
    {
        super(OGLRenderQueue.getInstance(),
              srcType, compType, OGLSurfaceData.OpenGLSurface);
    }

    @Override
    protected void validateContext(SurfaceData dstData,
                                   Composite comp, Region clip)
    {
        OGLSurfaceData oglDst = (OGLSurfaceData)dstData;
        OGLContext.validateContext(oglDst, oglDst,
                                   clip, comp, null, null, null,
                                   OGLContext.NO_CONTEXT_FLAGS);
    }
}
