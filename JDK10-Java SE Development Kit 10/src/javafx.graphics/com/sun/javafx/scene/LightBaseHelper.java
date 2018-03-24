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

package com.sun.javafx.scene;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.LightBase;
import javafx.scene.Node;

/**
 * Used to access internal methods of LightBase.
 */
public class LightBaseHelper extends NodeHelper {

    private static final LightBaseHelper theInstance;
    private static LightBaseAccessor lightBaseAccessor;

    static {
        theInstance = new LightBaseHelper();
        Utils.forceInit(LightBase.class);
    }

    private static LightBaseHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(LightBase lightBase) {
        setHelper(lightBase, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        throw new UnsupportedOperationException("Applications should not extend the LightBase class directly.");
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        lightBaseAccessor.doUpdatePeer(node);
    }

    @Override
    protected void markDirtyImpl(Node node, DirtyBits dirtyBit) {
        super.markDirtyImpl(node, dirtyBit);
        lightBaseAccessor.doMarkDirty(node, dirtyBit);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return lightBaseAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return lightBaseAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected Object processMXNodeImpl(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return lightBaseAccessor.doProcessMXNode(node, alg, ctx);
    }

    public static void setLightBaseAccessor(final LightBaseAccessor newAccessor) {
        if (lightBaseAccessor != null) {
            throw new IllegalStateException();
        }

        lightBaseAccessor = newAccessor;
    }

    public interface LightBaseAccessor {
        void doMarkDirty(Node node, DirtyBits dirtyBit);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx);
    }

}
