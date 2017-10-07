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
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of ArcTo.
 */
public class ArcToHelper extends PathElementHelper {

    private static final ArcToHelper theInstance;
    private static ArcToAccessor arcToAccessor;

    static {
        theInstance = new ArcToHelper();
        Utils.forceInit(ArcTo.class);
    }

    private static ArcToHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(ArcTo arcTo) {
        setHelper(arcTo, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        arcToAccessor.doAddTo(pathElement, path);
    }

    public static void setArcToAccessor(final ArcToAccessor newAccessor) {
        if (arcToAccessor != null) {
            throw new IllegalStateException();
        }

        arcToAccessor = newAccessor;
    }

    public interface ArcToAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

