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
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of CubicCurve.
 */
public class CubicCurveHelper extends ShapeHelper {

    private static final CubicCurveHelper theInstance;
    private static CubicCurveAccessor cubicCurveAccessor;

    static {
        theInstance = new CubicCurveHelper();
        Utils.forceInit(CubicCurve.class);
    }

    private static CubicCurveHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(CubicCurve cubicCurve) {
        setHelper(cubicCurve, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return cubicCurveAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        cubicCurveAccessor.doUpdatePeer(node);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return cubicCurveAccessor.doConfigShape(shape);
    }

    public static void setCubicCurveAccessor(final CubicCurveAccessor newAccessor) {
        if (cubicCurveAccessor != null) {
            throw new IllegalStateException();
        }

        cubicCurveAccessor = newAccessor;
    }

    public interface CubicCurveAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}


