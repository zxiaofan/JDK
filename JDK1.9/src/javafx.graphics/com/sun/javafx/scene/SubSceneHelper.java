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
import com.sun.javafx.geom.PickRay;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.scene.input.PickResultChooser;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.SubScene;

/**
 * Used to access internal methods of SubScene.
 */
public class SubSceneHelper extends NodeHelper {

    private static final SubSceneHelper theInstance;
    private static SubSceneAccessor subSceneAccessor;

    static {
        theInstance = new SubSceneHelper();
        Utils.forceInit(SubScene.class);
    }

    private static SubSceneHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(SubScene subScene) {
        setHelper(subScene, getInstance());
    }

    public static void superProcessCSS(Node node) {
        ((SubSceneHelper) getHelper(node)).superProcessCSSImpl(node);
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return subSceneAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        subSceneAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return subSceneAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return subSceneAccessor.doComputeContains(node, localX, localY);
    }

    void superProcessCSSImpl(Node node) {
        super.processCSSImpl(node);
    }

    protected void processCSSImpl(Node node) {
        subSceneAccessor.doProcessCSS(node);
    }

    @Override
    protected Object processMXNodeImpl(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return subSceneAccessor.doProcessMXNode(node, alg, ctx);
    }

    @Override
    protected void pickNodeLocalImpl(Node node, PickRay localPickRay,
            PickResultChooser result) {
        subSceneAccessor.doPickNodeLocal(node, localPickRay, result);
    }

    public static boolean isDepthBuffer(SubScene subScene) {
        return subSceneAccessor.isDepthBuffer(subScene);
    }

    public static Camera getEffectiveCamera(SubScene subScene) {
        return subSceneAccessor.getEffectiveCamera(subScene);
    }

    public static void setSubSceneAccessor(final SubSceneAccessor newAccessor) {
        if (subSceneAccessor != null) {
            throw new IllegalStateException();
        }

        subSceneAccessor = newAccessor;
    }

    public interface SubSceneAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        void doProcessCSS(Node node);
        Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx);
        void doPickNodeLocal(Node node, PickRay localPickRay,
                PickResultChooser result);
        boolean isDepthBuffer(SubScene subScene);
        Camera getEffectiveCamera(SubScene subScene);
    }

}
