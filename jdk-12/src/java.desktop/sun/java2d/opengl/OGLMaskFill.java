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
import sun.java2d.InvalidPipeException;
import sun.java2d.SunGraphics2D;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.loops.GraphicsPrimitiveMgr;
import sun.java2d.loops.CompositeType;
import sun.java2d.loops.SurfaceType;
import sun.java2d.pipe.BufferedMaskFill;
import static sun.java2d.loops.CompositeType.*;
import static sun.java2d.loops.SurfaceType.*;

class OGLMaskFill extends BufferedMaskFill {

    static void register() {
        GraphicsPrimitive[] primitives = {
            new OGLMaskFill(AnyColor,                  SrcOver),
            new OGLMaskFill(OpaqueColor,               SrcNoEa),
            new OGLMaskFill(GradientPaint,             SrcOver),
            new OGLMaskFill(OpaqueGradientPaint,       SrcNoEa),
            new OGLMaskFill(LinearGradientPaint,       SrcOver),
            new OGLMaskFill(OpaqueLinearGradientPaint, SrcNoEa),
            new OGLMaskFill(RadialGradientPaint,       SrcOver),
            new OGLMaskFill(OpaqueRadialGradientPaint, SrcNoEa),
            new OGLMaskFill(TexturePaint,              SrcOver),
            new OGLMaskFill(OpaqueTexturePaint,        SrcNoEa),
        };
        GraphicsPrimitiveMgr.register(primitives);
    }

    protected OGLMaskFill(SurfaceType srcType, CompositeType compType) {
        super(OGLRenderQueue.getInstance(),
              srcType, compType, OGLSurfaceData.OpenGLSurface);
    }

    @Override
    protected native void maskFill(int x, int y, int w, int h,
                                   int maskoff, int maskscan, int masklen,
                                   byte[] mask);

    @Override
    protected void validateContext(SunGraphics2D sg2d,
                                   Composite comp, int ctxflags)
    {
        OGLSurfaceData dstData;
        try {
            dstData = (OGLSurfaceData) sg2d.surfaceData;
        } catch (ClassCastException e) {
            throw new InvalidPipeException("wrong surface data type: " +
                                           sg2d.surfaceData);
        }

        OGLContext.validateContext(dstData, dstData,
                                   sg2d.getCompClip(), comp,
                                   null, sg2d.paint, sg2d, ctxflags);
    }
}
