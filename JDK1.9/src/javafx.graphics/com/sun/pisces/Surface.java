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

package com.sun.pisces;

public interface Surface {

    public int getWidth();

    public int getHeight();

    public void getRGB(int[] argb, int offset, int scanLength,
            int x, int y, int width, int height);

    public void setRGB(int[] argb, int offset, int scanLength,
            int x, int y, int width, int height);

}
