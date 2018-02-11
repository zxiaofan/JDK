/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.openpisces;

/**
 */
public interface AlphaConsumer {
    public int getOriginX();
    public int getOriginY();
    public int getWidth();
    public int getHeight();
    public void setMaxAlpha(int maxalpha);
    public void setAndClearRelativeAlphas(int alphaDeltas[], int pix_y,
                                          int firstdelta, int lastdelta);
}
