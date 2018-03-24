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
import javafx.scene.shape.MeshView;

/**
 * Used to access internal methods of MeshView.
 */
public class MeshViewHelper extends Shape3DHelper {

    private static final MeshViewHelper theInstance;
    private static MeshViewAccessor meshViewAccessor;

    static {
        theInstance = new MeshViewHelper();
        Utils.forceInit(MeshView.class);
    }

    private static MeshViewHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(MeshView meshView) {
        setHelper(meshView, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return meshViewAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        meshViewAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return meshViewAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return meshViewAccessor.doComputeContains(node, localX, localY);
    }

    protected boolean computeIntersectsImpl(Node node, PickRay pickRay,
            PickResultChooser pickResult) {
        return meshViewAccessor.doComputeIntersects(node, pickRay, pickResult);
    }

    public static void setMeshViewAccessor(final MeshViewAccessor newAccessor) {
        if (meshViewAccessor != null) {
            throw new IllegalStateException();
        }

        meshViewAccessor = newAccessor;
    }

    public interface MeshViewAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        boolean doComputeIntersects(Node node, PickRay pickRay,
                PickResultChooser pickResult);
    }

}
