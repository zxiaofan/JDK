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
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.PathElement;

/**
 * Used to access internal methods of MoveTo.
 */
public class MoveToHelper extends PathElementHelper {

    private static final MoveToHelper theInstance;
    private static MoveToAccessor moveToAccessor;

    static {
        theInstance = new MoveToHelper();
        Utils.forceInit(MoveTo.class);
    }

    private static MoveToHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(MoveTo moveTo) {
        setHelper(moveTo, getInstance());
    }

    @Override
    protected  void addToImpl(PathElement pathElement, Path2D path) {
        moveToAccessor.doAddTo(pathElement, path);
    }

    public static void setMoveToAccessor(final MoveToAccessor newAccessor) {
        if (moveToAccessor != null) {
            throw new IllegalStateException();
        }

        moveToAccessor = newAccessor;
    }

    public interface MoveToAccessor {
        void doAddTo(PathElement pathElement, Path2D path);
    }

}

