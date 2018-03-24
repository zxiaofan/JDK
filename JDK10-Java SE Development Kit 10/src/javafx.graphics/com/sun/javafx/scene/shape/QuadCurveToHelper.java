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
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of QuadCurveTo.
 */
public class QuadCurveToHelper extends PathElementHelper {

    private static final QuadCurveToHelper theInstance;
    private static QuadCurveToAccessor quadCurveToAccessor;

    static {
        theInstance = new QuadCurveToHelper();
        Utils.forceInit(QuadCurveTo.class);
    }

    private static QuadCurveToHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(QuadCurveTo quadCurveTo) {
        setHelper(quadCurveTo, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        quadCurveToAccessor.doAddTo(pathElement, path);
    }

    public static void setQuadCurveToAccessor(final QuadCurveToAccessor newAccessor) {
        if (quadCurveToAccessor != null) {
            throw new IllegalStateException();
        }

        quadCurveToAccessor = newAccessor;
    }

    public interface QuadCurveToAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

