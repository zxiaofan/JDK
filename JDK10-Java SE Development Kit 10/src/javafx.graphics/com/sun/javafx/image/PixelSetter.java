/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.image;

import java.nio.Buffer;

public interface PixelSetter<T extends Buffer> {
    public AlphaType getAlphaType();
    public int getNumElements();

    public void setArgb(T buf, int offset, int argb);
    public void setArgbPre(T buf, int offset, int argbpre);
}
