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
import com.sun.javafx.geom.PickRay;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.input.PickResultChooser;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.shape.Box;

/**
 * Used to access internal methods of Box.
 */
public class BoxHelper extends Shape3DHelper {

    private static final BoxHelper theInstance;
    private static BoxAccessor boxAccessor;

    static {
        theInstance = new BoxHelper();
        Utils.forceInit(Box.class);
    }

    private static BoxHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Box box) {
        setHelper(box, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return boxAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        boxAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return boxAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return boxAccessor.doComputeContains(node, localX, localY);
    }

    protected boolean computeIntersectsImpl(Node node, PickRay pickRay,
            PickResultChooser pickResult) {
        return boxAccessor.doComputeIntersects(node, pickRay, pickResult);
    }

    public static void setBoxAccessor(final BoxAccessor newAccessor) {
        if (boxAccessor != null) {
            throw new IllegalStateException();
        }

        boxAccessor = newAccessor;
    }

    public interface BoxAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        boolean doComputeIntersects(Node node, PickRay pickRay,
                PickResultChooser pickResult);
    }

}
