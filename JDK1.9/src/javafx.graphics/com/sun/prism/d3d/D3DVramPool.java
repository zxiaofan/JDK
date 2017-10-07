/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.d3d;

import com.sun.prism.PixelFormat;
import com.sun.prism.impl.BaseResourcePool;
import com.sun.prism.impl.PrismSettings;
import com.sun.prism.impl.TextureResourcePool;

class D3DVramPool extends BaseResourcePool<D3DTextureData>
    implements TextureResourcePool<D3DTextureData>
{
    public static final D3DVramPool instance = new D3DVramPool();

    private D3DVramPool() {
        super(PrismSettings.targetVram, PrismSettings.maxVram);
    }

    @Override
    public long size(D3DTextureData resource) {
        return resource.getSize();
    }

    @Override
    public long estimateTextureSize(int width, int height,
                                    PixelFormat format)
    {
        return ((long) width) * ((long) height) *
               ((long) format.getBytesPerPixelUnit());
    }

    @Override
    public long estimateRTTextureSize(int width, int height,
                                      boolean hasDepth)
    {
        // REMIND: need to deal with size of depth buffer, etc.
        return ((long) width) * ((long) height) * 4L;
    }

    @Override
    public String toString() {
        return "D3D Vram Pool";
    }
}
