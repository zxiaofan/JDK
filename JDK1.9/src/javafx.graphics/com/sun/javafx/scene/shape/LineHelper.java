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
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Line.
 */
public class LineHelper extends ShapeHelper {

    private static final LineHelper theInstance;
    private static LineAccessor lineAccessor;

    static {
        theInstance = new LineHelper();
        Utils.forceInit(Line.class);
    }

    private static LineHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Line line) {
        setHelper(line, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return lineAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        lineAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return lineAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected Paint cssGetFillInitialValueImpl(Shape shape) {
        return lineAccessor.doCssGetFillInitialValue(shape);
    }

    @Override
    protected Paint cssGetStrokeInitialValueImpl(Shape shape) {
        return lineAccessor.doCssGetStrokeInitialValue(shape);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return lineAccessor.doConfigShape(shape);
    }

    public static void setLineAccessor(final LineAccessor newAccessor) {
        if (lineAccessor != null) {
            throw new IllegalStateException();
        }

        lineAccessor = newAccessor;
    }

    public interface LineAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        Paint doCssGetFillInitialValue(Shape shape);
        Paint doCssGetStrokeInitialValue(Shape shape);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}
