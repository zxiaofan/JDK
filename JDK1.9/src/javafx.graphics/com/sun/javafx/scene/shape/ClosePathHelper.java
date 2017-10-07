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
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of ClosePath.
 */
public class ClosePathHelper extends PathElementHelper {

    private static final ClosePathHelper theInstance;
    private static ClosePathAccessor closePathAccessor;

    static {
        theInstance = new ClosePathHelper();
        Utils.forceInit(ClosePath.class);
    }

    private static ClosePathHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(ClosePath closePath) {
        setHelper(closePath, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        closePathAccessor.doAddTo(pathElement, path);
    }

    public static void setClosePathAccessor(final ClosePathAccessor newAccessor) {
        if (closePathAccessor != null) {
            throw new IllegalStateException();
        }

        closePathAccessor = newAccessor;
    }

    public interface ClosePathAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

