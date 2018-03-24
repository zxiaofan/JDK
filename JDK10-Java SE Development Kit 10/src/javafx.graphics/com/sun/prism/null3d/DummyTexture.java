/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.null3d;

import com.sun.prism.MediaFrame;
import com.sun.prism.PixelFormat;
import com.sun.prism.Texture;
import com.sun.prism.impl.BaseTexture;
import com.sun.prism.impl.ManagedResource;
import com.sun.prism.impl.PrismTrace;
import java.nio.Buffer;

class DummyTexture extends BaseTexture  {
    static class DummyManagedResource extends ManagedResource<Object> {
        DummyManagedResource() {
            super(new Object(), DummyTexturePool.instance);
        }
    };

    DummyContext context;

    DummyTexture(DummyContext context, PixelFormat format, WrapMode wrapMode,
                 int contentWidth, int contentHeight)
    {
        this(context, format, wrapMode, contentWidth, contentHeight, false);
    }

    DummyTexture(DummyContext context, PixelFormat format, WrapMode wrapMode,
                 int contentWidth, int contentHeight, boolean isRTT)
    {
        super(new DummyManagedResource(), format, wrapMode,
              contentWidth, contentHeight,
              0, 0, contentWidth, contentHeight, false);

        this.context = context;

        if (isRTT) {
            PrismTrace.rttCreated(0, contentWidth, contentWidth, 4);
        } else {
            PrismTrace.textureCreated(0, contentWidth, contentWidth,
                                      format.getBytesPerPixelUnit());
        }
    }

    public DummyContext getContext() {
        return context;
    }

    public void update(Buffer buffer, PixelFormat format, int dstx, int dsty, int srcx, int srcy, int srcw, int srch, int srcscan, boolean skipFlush) {

    }

    public void update(MediaFrame frame, boolean skipFlush) {
    }

    @Override
    protected Texture createSharedTexture(WrapMode newMode) {
        return this;
    }

}
