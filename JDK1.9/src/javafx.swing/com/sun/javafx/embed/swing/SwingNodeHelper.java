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

package com.sun.javafx.embed.swing;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.embed.swing.SwingNode;
import javafx.scene.Node;

/**
 * Used to access internal methods of SwingNode.
 */
public class SwingNodeHelper extends NodeHelper {

    private static final SwingNodeHelper theInstance;
    private static SwingNodeAccessor swingNodeAccessor;

    static {
        theInstance = new SwingNodeHelper();
        Utils.forceInit(SwingNode.class);
    }

    private static SwingNodeHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(SwingNode swingNode) {
        setHelper(swingNode, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return swingNodeAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        swingNodeAccessor.doUpdatePeer(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return swingNodeAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return swingNodeAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected Object processMXNodeImpl(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return swingNodeAccessor.doProcessMXNode(node, alg, ctx);
    }

    public static void setSwingNodeAccessor(final SwingNodeAccessor newAccessor) {
        if (swingNodeAccessor != null) {
            throw new IllegalStateException();
        }

        swingNodeAccessor = newAccessor;
    }

    public interface SwingNodeAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx);
    }

}
