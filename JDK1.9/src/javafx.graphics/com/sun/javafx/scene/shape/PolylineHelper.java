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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Polyline.
 */
public class PolylineHelper extends ShapeHelper {

    private static final PolylineHelper theInstance;
    private static PolylineAccessor polylineAccessor;

    static {
        theInstance = new PolylineHelper();
        Utils.forceInit(Polyline.class);
    }

    private static PolylineHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Polyline polyline) {
        setHelper(polyline, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return polylineAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        polylineAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return polylineAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected Paint cssGetFillInitialValueImpl(Shape shape) {
        return polylineAccessor.doCssGetFillInitialValue(shape);
    }

    @Override
    protected Paint cssGetStrokeInitialValueImpl(Shape shape) {
        return polylineAccessor.doCssGetStrokeInitialValue(shape);
    }

    @Override
    protected com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return polylineAccessor.doConfigShape(shape);
    }

    public static void setPolylineAccessor(final PolylineAccessor newAccessor) {
        if (polylineAccessor != null) {
            throw new IllegalStateException();
        }

        polylineAccessor = newAccessor;
    }

    public interface PolylineAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        Paint doCssGetFillInitialValue(Shape shape);
        Paint doCssGetStrokeInitialValue(Shape shape);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}
