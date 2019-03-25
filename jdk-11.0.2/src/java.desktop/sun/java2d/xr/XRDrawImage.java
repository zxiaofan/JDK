/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.xr;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

import sun.java2d.*;
import sun.java2d.loops.*;
import sun.java2d.pipe.*;

/**
 * Class used for re-routing transformed blits to the accelerated loops.
 */

public class XRDrawImage extends DrawImage {

    @Override
    protected void renderImageXform(SunGraphics2D sg, Image img,
            AffineTransform tx, int interpType, int sx1, int sy1, int sx2,
            int sy2, Color bgColor) {
        SurfaceData dstData = sg.surfaceData;
        SurfaceData srcData = dstData.getSourceSurfaceData(img,
                SunGraphics2D.TRANSFORM_GENERIC, sg.imageComp, bgColor);

        if (sg.composite instanceof AlphaComposite) {
            int compRule = ((AlphaComposite) sg.composite).getRule();
            float extraAlpha = ((AlphaComposite) sg.composite).getAlpha();

            if (srcData != null && !isBgOperation(srcData, bgColor)
                && interpType <= AffineTransformOp.TYPE_BILINEAR
                && (XRUtils.isMaskEvaluated(XRUtils.j2dAlphaCompToXR(compRule))
                    || (XRUtils.isTransformQuadrantRotated(tx))
                    && extraAlpha == 1.0f))
            {
                SurfaceType srcType = srcData.getSurfaceType();
                SurfaceType dstType = dstData.getSurfaceType();

                TransformBlit blit = TransformBlit.getFromCache(srcType,
                        sg.imageComp, dstType);
                if (blit != null) {
                    blit.Transform(srcData, dstData, sg.composite,
                          sg.getCompClip(), tx, interpType, sx1, sy1, 0, 0, sx2
                                - sx1, sy2 - sy1);
                    return;
                }
            }
        }

        super.renderImageXform(sg, img, tx, interpType, sx1, sy1, sx2, sy2,
                bgColor);
    }
}
