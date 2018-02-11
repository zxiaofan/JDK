/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

import java.nio.Buffer;

public interface RTTexture extends Texture, RenderTarget {
    public int[] getPixels();
    public boolean readPixels(Buffer pixels);
    public boolean readPixels(Buffer pixels, int x, int y, int width, int height);
    public boolean isVolatile();
}
