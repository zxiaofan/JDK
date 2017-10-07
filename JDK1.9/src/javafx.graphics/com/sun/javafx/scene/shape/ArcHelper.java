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

import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Arc.
 */
public class ArcHelper extends ShapeHelper {

    private static final ArcHelper theInstance;
    private static ArcAccessor arcAccessor;

    static {
        theInstance = new ArcHelper();
        Utils.forceInit(Arc.class);
    }

    private static ArcHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Arc arc) {
        setHelper(arc, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return arcAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        arcAccessor.doUpdatePeer(node);
    }

    @Override
    protected  com.sun.javafx.geom.Shape configShapeImpl(Shape shape) {
        return arcAccessor.doConfigShape(shape);
    }

    public static void setArcAccessor(final ArcAccessor newAccessor) {
        if (arcAccessor != null) {
            throw new IllegalStateException();
        }

        arcAccessor = newAccessor;
    }

    public interface ArcAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        com.sun.javafx.geom.Shape doConfigShape(Shape shape);
    }

}


