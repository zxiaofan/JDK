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

public interface BytePixelGetter extends PixelGetter<ByteBuffer> {
    public int getArgb(byte arr[], int offset);
    public int getArgbPre(byte arr[], int offset);
}
