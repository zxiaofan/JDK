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
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 * Used to access internal methods of Text.
 */
public class TextHelper extends ShapeHelper {

    private static final TextHelper theInstance;
    private static TextAccessor textAccessor;

    static {
        theInstance = new TextHelper();
        Utils.forceInit(Text.class);
    }

    private static TextHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Text text) {
        setHelper(text, getInstance());
    }

    public static BaseBounds superComputeGeomBounds(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return ((TextHelper) getHelper(node)).superComputeGeomBoundsImpl(node, bounds, tx);
    }

    public static Bounds superComputeLayoutBounds(Node node) {
        return ((TextHelper) getHelper(node)).superComputeLayoutBoundsImpl(node);
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return textAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        textAccessor.doUpdatePeer(node);
    }

    BaseBounds superComputeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return super.computeGeomBoundsImpl(node, bounds, tx);
    }

    Bounds superComputeLayoutBoundsImpl(Node node) {
        return super.computeLayoutBoundsImpl(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return textAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected Bounds computeLayoutBoundsImpl(Node node) {
        return textAccessor.doComputeLayoutBounds(node);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return textAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected void geomChangedImpl(Node node) {
        super.geomChangedImpl(node);
        textAccessor.doGeomChanged(node);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return textAccessor.doConfigShape(shape);
    }

    public static void setTextAccessor(final TextAccessor newAccessor) {
        if (textAccessor != null) {
            throw new IllegalStateException();
        }

        textAccessor = newAccessor;
    }

    public interface TextAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        Bounds doComputeLayoutBounds(Node node);
        boolean doComputeContains(Node node, double localX, double localY);
        void doGeomChanged(Node node);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}


