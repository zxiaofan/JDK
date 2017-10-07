/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font.freetype;

class FT_Bitmap {
    int rows;
    int width;
    int pitch;
    long buffer;
    short num_grays;
    byte pixel_mode;
    char palette_mode;
    long palette;
}
