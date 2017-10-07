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
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of CubicCurveTo.
 */
public class CubicCurveToHelper extends PathElementHelper {

    private static final CubicCurveToHelper theInstance;
    private static CubicCurveToAccessor cubicCurveToAccessor;

    static {
        theInstance = new CubicCurveToHelper();
        Utils.forceInit(CubicCurveTo.class);
    }

    private static CubicCurveToHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(CubicCurveTo cubicCurveTo) {
        setHelper(cubicCurveTo, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        cubicCurveToAccessor.doAddTo(pathElement, path);
    }

    public static void setCubicCurveToAccessor(final CubicCurveToAccessor newAccessor) {
        if (cubicCurveToAccessor != null) {
            throw new IllegalStateException();
        }

        cubicCurveToAccessor = newAccessor;
    }

    public interface CubicCurveToAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

