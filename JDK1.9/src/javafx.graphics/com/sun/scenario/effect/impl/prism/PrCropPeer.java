/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.prism;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.prism.Graphics;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.impl.EffectPeer;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.RenderState;

public class PrCropPeer extends EffectPeer {

    public PrCropPeer(FilterContext fctx, Renderer r, String uniqueName) {
        super(fctx, r, uniqueName);
    }

    @Override
    public ImageData filter(Effect effect,
                            RenderState rstate,
                            BaseTransform transform,
                            Rectangle outputClip,
                            ImageData... inputs)
    {
        FilterContext fctx = getFilterContext();
        ImageData srcData = inputs[0];
        Rectangle srcBounds = srcData.getTransformedBounds(null);
        if (outputClip.contains(srcBounds)) {
            srcData.addref();
            return srcData;
        }

        Rectangle dstBounds = new Rectangle(srcBounds);
        dstBounds.intersectWith(outputClip);
        int w = dstBounds.width;
        int h = dstBounds.height;
        PrDrawable dst = (PrDrawable)getRenderer().getCompatibleImage(w, h);

        if (!srcData.validate(fctx) || dst == null) {
            dst = null;
        } else {
            Graphics gdst = dst.createGraphics();
            PrEffectHelper.renderImageData(gdst, srcData, dstBounds);
        }

        return new ImageData(fctx, dst, dstBounds);
    }
}
