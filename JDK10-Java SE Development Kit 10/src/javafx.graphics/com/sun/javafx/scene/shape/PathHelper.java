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

import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Path.
 */
public class PathHelper extends ShapeHelper {

    private static final PathHelper theInstance;
    private static PathAccessor pathAccessor;

    static {
        theInstance = new PathHelper();
        Utils.forceInit(Path.class);
    }

    private static PathHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Path path) {
        setHelper(path, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return pathAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        pathAccessor.doUpdatePeer(node);
    }

    @Override
    protected Bounds computeLayoutBoundsImpl(Node node) {
        Bounds bounds = pathAccessor.doComputeLayoutBounds(node);
        if (bounds != null) {
            return bounds;
        }
        return super.computeLayoutBoundsImpl(node);
    }

    @Override
    protected Paint cssGetFillInitialValueImpl(Shape shape) {
        return pathAccessor.doCssGetFillInitialValue(shape);
    }

    @Override
    protected Paint cssGetStrokeInitialValueImpl(Shape shape) {
        return pathAccessor.doCssGetStrokeInitialValue(shape);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return pathAccessor.doConfigShape(shape);
    }

    public static void setPathAccessor(final PathAccessor newAccessor) {
        if (pathAccessor != null) {
            throw new IllegalStateException();
        }

        pathAccessor = newAccessor;
    }

    public interface PathAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        Bounds doComputeLayoutBounds(Node node);
        Paint doCssGetFillInitialValue(Shape shape);
        Paint doCssGetStrokeInitialValue(Shape shape);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}

