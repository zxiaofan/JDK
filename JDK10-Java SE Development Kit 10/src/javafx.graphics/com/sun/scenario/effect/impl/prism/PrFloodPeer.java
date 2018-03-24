/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.prism.Graphics;
import com.sun.prism.paint.Paint;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.Flood;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.impl.EffectPeer;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.RenderState;

public class PrFloodPeer extends EffectPeer {

    public PrFloodPeer(FilterContext fctx, Renderer r, String uniqueName) {
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
        Flood flood = (Flood)effect;
        BaseBounds floodBounds = flood.getFloodBounds();
        int fx = (int)floodBounds.getMinX();
        int fy = (int)floodBounds.getMinY();
        int fw = (int)floodBounds.getWidth();
        int fh = (int)floodBounds.getHeight();

        BaseBounds fullBounds = Effect.transformBounds(transform, floodBounds);
        Rectangle tmp = new Rectangle(fullBounds);
        tmp.intersectWith(outputClip);
        int w = tmp.width;
        int h = tmp.height;
        PrDrawable dst = (PrDrawable)getRenderer().getCompatibleImage(w, h);
        if (dst != null) {
            Graphics gdst = dst.createGraphics();
            gdst.translate(-tmp.x, -tmp.y);
            if (transform != null && !transform.isIdentity()) {
                gdst.transform(transform);
            }
            gdst.setPaint((Paint)flood.getPaint());
            gdst.fillQuad(fx, fy, fx+fw, fy+fh);
        }

        return new ImageData(fctx, dst, tmp);
    }
}
