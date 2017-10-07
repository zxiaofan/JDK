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

package com.sun.scenario.effect.impl.prism.ps;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.prism.ps.Shader;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.impl.EffectPeer;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.RenderState;

public abstract class PPSEffectPeer<T extends RenderState> extends EffectPeer<T> {

    protected PPSEffectPeer(FilterContext fctx, Renderer r, String shaderName) {
        super(fctx, r, shaderName);
    }

    @Override
    public final ImageData filter(final Effect effect,
                                  final T renderState,
                                  final BaseTransform transform,
                                  final Rectangle outputClip,
                                  final ImageData... inputs)
    {
        setEffect(effect);
        setRenderState(renderState);
        setDestBounds(getResultBounds(transform, outputClip, inputs));
        return filterImpl(inputs);
    }

    abstract ImageData filterImpl(ImageData... inputs);

    protected abstract boolean isSamplerLinear(int i);

    protected abstract Shader createShader();

    protected abstract void updateShader(Shader shader);

    /**
     * Disposes resources associated with this peer.
     * Warning: called from the rendering thread.
     */
    @Override
    public abstract void dispose();

    @Override
    protected final PPSRenderer getRenderer() {
        return (PPSRenderer)super.getRenderer();
    }

    protected final String getShaderName() {
        return getUniqueName();
    }
}
