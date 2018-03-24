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
import javafx.scene.shape.VLineTo;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of VLineTo.
 */
public class VLineToHelper extends PathElementHelper {

    private static final VLineToHelper theInstance;
    private static VLineToAccessor vLineToAccessor;

    static {
        theInstance = new VLineToHelper();
        Utils.forceInit(VLineTo.class);
    }

    private static VLineToHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(VLineTo vLineTo) {
        setHelper(vLineTo, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        vLineToAccessor.doAddTo(pathElement, path);
    }

    public static void setVLineToAccessor(final VLineToAccessor newAccessor) {
        if (vLineToAccessor != null) {
            throw new IllegalStateException();
        }

        vLineToAccessor = newAccessor;
    }

    public interface VLineToAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

