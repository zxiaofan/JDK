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
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of HLineTo.
 */
public class HLineToHelper extends PathElementHelper {

    private static final HLineToHelper theInstance;
    private static HLineToAccessor hLineToAccessor;

    static {
        theInstance = new HLineToHelper();
        Utils.forceInit(HLineTo.class);
    }

    private static HLineToHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(HLineTo hLineTo) {
        setHelper(hLineTo, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        hLineToAccessor.doAddTo(pathElement, path);
    }

    public static void setHLineToAccessor(final HLineToAccessor newAccessor) {
        if (hLineToAccessor != null) {
            throw new IllegalStateException();
        }

        hLineToAccessor = newAccessor;
    }

    public interface HLineToAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

