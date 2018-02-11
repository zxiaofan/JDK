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

package com.sun.prism.null3d;

import com.sun.prism.PixelFormat;
import com.sun.prism.impl.BaseResourcePool;
import com.sun.prism.impl.TextureResourcePool;

public class DummyTexturePool extends BaseResourcePool<Object>
    implements TextureResourcePool<Object>
{
    public static final DummyTexturePool instance = new DummyTexturePool();

    private DummyTexturePool() {
        super(128 * 1024 * 1024, 256 * 1024 * 1024);
    }

    @Override
    public long size(Object resource) {
        return 0;
    }

    @Override
    public long estimateTextureSize(int width, int height, PixelFormat format) {
        return 0;
    }

    @Override
    public long estimateRTTextureSize(int width, int height, boolean hasDepth) {
        return 0;
    }
}
