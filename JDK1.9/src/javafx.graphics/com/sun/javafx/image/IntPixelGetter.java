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

import java.nio.IntBuffer;

public interface IntPixelGetter extends PixelGetter<IntBuffer> {
    public int getArgb(int arr[], int offset);
    public int getArgbPre(int arr[], int offset);
}
