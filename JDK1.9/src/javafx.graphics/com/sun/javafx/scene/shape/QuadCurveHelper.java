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
import javafx.scene.Node;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of QuadCurve.
 */
public class QuadCurveHelper extends ShapeHelper {

    private static final QuadCurveHelper theInstance;
    private static QuadCurveAccessor quadCurveAccessor;

    static {
        theInstance = new QuadCurveHelper();
        Utils.forceInit(QuadCurve.class);
    }

    private static QuadCurveHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(QuadCurve quadCurve) {
        setHelper(quadCurve, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return quadCurveAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        quadCurveAccessor.doUpdatePeer(node);
    }

    @Override
    protected com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return quadCurveAccessor.doConfigShape(shape);
    }

    public static void setQuadCurveAccessor(final QuadCurveAccessor newAccessor) {
        if (quadCurveAccessor != null) {
            throw new IllegalStateException();
        }

        quadCurveAccessor = newAccessor;
    }

    public interface QuadCurveAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}

