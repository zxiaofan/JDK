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

package com.sun.javafx.scene.shape;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.util.Utils;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of PathElement.
 */
public abstract class PathElementHelper {
    private static PathElementAccessor pathElementAccessor;

    static {
        Utils.forceInit(PathElement.class);
    }

    protected PathElementHelper() {
    }

    private static PathElementHelper getHelper(PathElement pathElement) {
        return pathElementAccessor.getHelper(pathElement);
    }

    protected static void setHelper(PathElement pathElement, PathElementHelper pathElementHelper) {
        pathElementAccessor.setHelper(pathElement, pathElementHelper);
    }

    /*
     * Static helper methods for cases where the implementation is done in an
     * instance method that is overridden by subclasses.
     * These methods exist in the base class only.
     */

    public static void addTo(PathElement pathElement, Path2D path) {
        getHelper(pathElement).addToImpl(pathElement, path);
    }

    /*
     * Methods that will be overridden by subclasses
     */

    protected abstract void addToImpl(PathElement pathElement, Path2D path);

    /*
     * Methods used by PathElement (base) class only
     */

    public static void setPathElementAccessor(final PathElementAccessor newAccessor) {
        if (pathElementAccessor != null) {
            throw new IllegalStateException();
        }

        pathElementAccessor = newAccessor;
    }

    public interface PathElementAccessor {
        PathElementHelper getHelper(PathElement pathElement);
        void setHelper(PathElement pathElement, PathElementHelper pathElementHelper);
    }

}

