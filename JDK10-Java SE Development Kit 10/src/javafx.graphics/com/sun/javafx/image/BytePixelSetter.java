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

import java.nio.ByteBuffer;

public interface BytePixelSetter extends PixelSetter<ByteBuffer> {
    public void setArgb(byte arr[], int offset, int argb);
    public void setArgbPre(byte arr[], int offset, int argbpre);
}
