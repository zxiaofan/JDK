/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Node;

/**
 * Used to access internal methods of Camera.
 */
public class CameraHelper extends NodeHelper {

    private static final CameraHelper theInstance;
    private static CameraAccessor cameraAccessor;

    static {
        theInstance = new CameraHelper();
        Utils.forceInit(Camera.class);
    }

    private static CameraHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Camera camera) {
        setHelper(camera, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        throw new UnsupportedOperationException("Applications should not extend the Camera class directly.");
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        cameraAccessor.doUpdatePeer(node);
    }

    @Override
    protected void markDirtyImpl(Node node, DirtyBits dirtyBit) {
        super.markDirtyImpl(node, dirtyBit);
        cameraAccessor.doMarkDirty(node, dirtyBit);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return cameraAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return cameraAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected Object processMXNodeImpl(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return cameraAccessor.doProcessMXNode(node, alg, ctx);
    }

    public static Point2D project(Camera camera, Point3D p) {
        return cameraAccessor.project(camera, p);
    }

    public static Point2D pickNodeXYPlane(Camera camera, Node node, double x, double y) {
        return cameraAccessor.pickNodeXYPlane(camera, node, x, y);
    }

    public static Point3D pickProjectPlane(Camera camera, double x, double y) {
        return cameraAccessor.pickProjectPlane(camera, x, y);
    }

    public static void setCameraAccessor(final CameraAccessor newAccessor) {
        if (cameraAccessor != null) {
            throw new IllegalStateException();
        }

        cameraAccessor = newAccessor;
    }

    public interface CameraAccessor {
        void doMarkDirty(Node node, DirtyBits dirtyBit);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx);
        Point2D project(Camera camera, Point3D p);
        Point2D pickNodeXYPlane(Camera camera, Node node, double x, double y);
        Point3D pickProjectPlane(Camera camera, double x, double y);
    }

}
