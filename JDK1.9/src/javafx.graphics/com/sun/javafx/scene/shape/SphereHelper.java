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
import javafx.scene.shape.Sphere;

/**
 * Used to access internal methods of Sphere.
 */
public class SphereHelper extends Shape3DHelper {

    private static final SphereHelper theInstance;
    private static SphereAccessor sphereAccessor;

    static {
        theInstance = new SphereHelper();
        Utils.forceInit(Sphere.class);
    }

    private static SphereHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Sphere sphere) {
        setHelper(sphere, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return sphereAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        sphereAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return sphereAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return sphereAccessor.doComputeContains(node, localX, localY);
    }

    protected boolean computeIntersectsImpl(Node node, PickRay pickRay,
          PickResultChooser pickResult) {
        return sphereAccessor.doComputeIntersects(node, pickRay, pickResult);
    }

    public static void setSphereAccessor(final SphereAccessor newAccessor) {
        if (sphereAccessor != null) {
            throw new IllegalStateException();
        }

        sphereAccessor = newAccessor;
    }

    public interface SphereAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        boolean doComputeIntersects(Node node, PickRay pickRay,
                PickResultChooser pickResult);
    }

}
