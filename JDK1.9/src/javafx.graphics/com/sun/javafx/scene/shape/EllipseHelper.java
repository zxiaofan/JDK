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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Ellipse.
 */
public class EllipseHelper extends ShapeHelper {

    private static final EllipseHelper theInstance;
    private static EllipseAccessor ellipseAccessor;

    static {
        theInstance = new EllipseHelper();
        Utils.forceInit(Ellipse.class);
    }

    private static EllipseHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Ellipse ellipse) {
        setHelper(ellipse, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return ellipseAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        ellipseAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return ellipseAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return ellipseAccessor.doConfigShape(shape);
    }

    public static void setEllipseAccessor(final EllipseAccessor newAccessor) {
        if (ellipseAccessor != null) {
            throw new IllegalStateException();
        }

        ellipseAccessor = newAccessor;
    }

    public interface EllipseAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}


