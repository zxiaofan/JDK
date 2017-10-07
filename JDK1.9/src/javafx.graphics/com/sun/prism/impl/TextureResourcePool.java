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

package com.sun.prism.impl;

import com.sun.prism.PixelFormat;

/**
 * A {@link ResourcePool} that manages memory for textures.
 * This interface only adds a couple of methods for computing
 * the size of a potential new texture allocation.
 */
public interface TextureResourcePool<T> extends ResourcePool<T> {
    public long estimateTextureSize(int width, int height, PixelFormat format);
    public long estimateRTTextureSize(int width, int height, boolean hasDepth);
}
