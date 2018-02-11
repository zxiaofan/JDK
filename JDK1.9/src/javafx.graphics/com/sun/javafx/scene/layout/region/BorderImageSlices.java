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

package com.sun.javafx.scene.layout.region;

import javafx.scene.layout.BorderWidths;

/**
 * A helper class during the conversion process.
 */
public class BorderImageSlices {

    /**
     * Using EMPTY results in no border-image being drawn since the slices are zero. You probably
     * want to use {@link BorderImageSlices#DEFAULT}
     */
    public static final BorderImageSlices EMPTY = new BorderImageSlices(BorderWidths.EMPTY, false);

    /**
     * Default border-image-slice is 100%
     * @see <a href="http://www.w3.org/TR/css3-background/#the-border-image-slice">border-image-slice</a>
     */
    public static final BorderImageSlices DEFAULT = new BorderImageSlices(BorderWidths.FULL, false);

    public BorderWidths widths;
    public boolean filled;

    public BorderImageSlices(BorderWidths widths, boolean filled) {
        this.widths = widths;
        this.filled = filled;
    }
}
