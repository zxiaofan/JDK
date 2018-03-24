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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Circle.
 */
public class CircleHelper extends ShapeHelper {

    private static final CircleHelper theInstance;
    private static CircleAccessor circleAccessor;

    static {
        theInstance = new CircleHelper();
        Utils.forceInit(Circle.class);
    }

    private static CircleHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Circle circle) {
        setHelper(circle, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return circleAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        circleAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return circleAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return circleAccessor.doConfigShape(shape);
    }

    public static void setCircleAccessor(final CircleAccessor newAccessor) {
        if (circleAccessor != null) {
            throw new IllegalStateException();
        }

        circleAccessor = newAccessor;
    }

    public interface CircleAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}
