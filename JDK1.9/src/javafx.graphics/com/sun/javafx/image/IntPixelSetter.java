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

public interface IntPixelSetter extends PixelSetter<IntBuffer> {
    public void setArgb(int arr[], int offset, int argb);
    public void setArgbPre(int arr[], int offset, int argbpre);
}
