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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Polygon.
 */
public class PolygonHelper extends ShapeHelper {

    private static final PolygonHelper theInstance;
    private static PolygonAccessor polygonAccessor;

    static {
        theInstance = new PolygonHelper();
        Utils.forceInit(Polygon.class);
    }

    private static PolygonHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Polygon polygon) {
        setHelper(polygon, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return polygonAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        polygonAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return polygonAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return polygonAccessor.doConfigShape(shape);
    }

    public static void setPolygonAccessor(final PolygonAccessor newAccessor) {
        if (polygonAccessor != null) {
            throw new IllegalStateException();
        }

        polygonAccessor = newAccessor;
    }

    public interface PolygonAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}


