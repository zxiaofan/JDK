/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.shape;

import java.util.Collection;

import javafx.scene.shape.PathElement;

import com.sun.javafx.geom.Path2D;

public final class PathUtils {
    private PathUtils() {
    }

    public static Path2D configShape(
            final Collection<PathElement> pathElements,
            final boolean evenOddFillRule) {

        Path2D path = new Path2D(
                evenOddFillRule ? Path2D.WIND_EVEN_ODD : Path2D.WIND_NON_ZERO,
                pathElements.size());
        for (final PathElement el: pathElements) {
            PathElementHelper.addTo(el, path);
        }
        return path;
    }
}
