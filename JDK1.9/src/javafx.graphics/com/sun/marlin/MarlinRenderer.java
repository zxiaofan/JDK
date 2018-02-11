/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.marlin;

import com.sun.javafx.geom.PathConsumer2D;

public interface MarlinRenderer extends PathConsumer2D {

    public static final int WIND_EVEN_ODD = 0;
    public static final int WIND_NON_ZERO = 1;

    public MarlinRenderer init(final int pix_boundsX, final int pix_boundsY,
                               final int pix_boundsWidth, final int pix_boundsHeight,
                               final int windingRule);

    /**
     * Disposes this renderer and recycle it clean up before reusing this instance
     */
    public void dispose();

    public int getOutpixMinX();
    public int getOutpixMaxX();
    public int getOutpixMinY();
    public int getOutpixMaxY();

    public void produceAlphas(MarlinAlphaConsumer ac);
}
