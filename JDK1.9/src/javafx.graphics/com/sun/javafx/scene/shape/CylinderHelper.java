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
import javafx.scene.shape.Cylinder;

/**
 * Used to access internal methods of Cylinder.
 */
public class CylinderHelper extends Shape3DHelper {

    private static final CylinderHelper theInstance;
    private static CylinderAccessor cylinderAccessor;

    static {
        theInstance = new CylinderHelper();
        Utils.forceInit(Cylinder.class);
    }

    private static CylinderHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Cylinder cylinder) {
        setHelper(cylinder, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return cylinderAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        cylinderAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return cylinderAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return cylinderAccessor.doComputeContains(node, localX, localY);
    }

    protected boolean computeIntersectsImpl(Node node, PickRay pickRay,
            PickResultChooser pickResult) {
        return cylinderAccessor.doComputeIntersects(node, pickRay, pickResult);
    }

    public static void setCylinderAccessor(final CylinderAccessor newAccessor) {
        if (cylinderAccessor != null) {
            throw new IllegalStateException();
        }

        cylinderAccessor = newAccessor;
    }

    public interface CylinderAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        boolean doComputeIntersects(Node node, PickRay pickRay,
                PickResultChooser pickResult);
    }

}
