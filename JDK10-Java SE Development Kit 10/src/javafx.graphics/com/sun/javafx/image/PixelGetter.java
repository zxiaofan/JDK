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

public interface PixelGetter<T extends Buffer> {
    public AlphaType getAlphaType();
    public int getNumElements();

    public int getArgb(T buf, int offset);
    public int getArgbPre(T buf, int offset);
}
