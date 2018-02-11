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

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Rectangle.
 */
public class RectangleHelper extends ShapeHelper {

    private static final RectangleHelper theInstance;
    private static RectangleAccessor rectangleAccessor;

    static {
        theInstance = new RectangleHelper();
        Utils.forceInit(Rectangle.class);
    }

    private static RectangleHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Rectangle rectangle) {
        setHelper(rectangle, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return rectangleAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        rectangleAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return rectangleAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return rectangleAccessor.doConfigShape(shape);
    }

    public static void setRectangleAccessor(final RectangleAccessor newAccessor) {
        if (rectangleAccessor != null) {
            throw new IllegalStateException();
        }

        rectangleAccessor = newAccessor;
    }

    public interface RectangleAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}

