/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.Rectangle;

public interface ReadbackGraphics extends Graphics {
    public boolean canReadBack();
    public RTTexture readBack(Rectangle view);
    public void releaseReadBackBuffer(RTTexture view);
}
