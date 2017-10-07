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
import sun.java2d.InvalidPipeException;
import sun.java2d.SunGraphics2D;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.loops.GraphicsPrimitiveMgr;
import sun.java2d.loops.CompositeType;
import sun.java2d.loops.SurfaceType;
import sun.java2d.pipe.BufferedMaskFill;
import static sun.java2d.loops.CompositeType.*;
import static sun.java2d.loops.SurfaceType.*;

class D3DMaskFill extends BufferedMaskFill {

    static void register() {
        GraphicsPrimitive[] primitives = {
            new D3DMaskFill(AnyColor,                  SrcOver),
            new D3DMaskFill(OpaqueColor,               SrcNoEa),
            new D3DMaskFill(GradientPaint,             SrcOver),
            new D3DMaskFill(OpaqueGradientPaint,       SrcNoEa),
            new D3DMaskFill(LinearGradientPaint,       SrcOver),
            new D3DMaskFill(OpaqueLinearGradientPaint, SrcNoEa),
            new D3DMaskFill(RadialGradientPaint,       SrcOver),
            new D3DMaskFill(OpaqueRadialGradientPaint, SrcNoEa),
            new D3DMaskFill(TexturePaint,              SrcOver),
            new D3DMaskFill(OpaqueTexturePaint,        SrcNoEa),
        };
        GraphicsPrimitiveMgr.register(primitives);
    }

    protected D3DMaskFill(SurfaceType srcType, CompositeType compType) {
        super(D3DRenderQueue.getInstance(),
              srcType, compType, D3DSurfaceData.D3DSurface);
    }

    @Override
    protected native void maskFill(int x, int y, int w, int h,
                                   int maskoff, int maskscan, int masklen,
                                   byte[] mask);

    @Override
    protected void validateContext(SunGraphics2D sg2d,
                                   Composite comp, int ctxflags)
    {
        D3DSurfaceData dstData;
        try {
            dstData = (D3DSurfaceData) sg2d.surfaceData;
        } catch (ClassCastException e) {
            throw new InvalidPipeException("wrong surface data type: " +
                                           sg2d.surfaceData);
        }
        D3DContext.validateContext(dstData, dstData,
                                   sg2d.getCompClip(), comp,
                                   null, sg2d.paint, sg2d, ctxflags);
    }
}
