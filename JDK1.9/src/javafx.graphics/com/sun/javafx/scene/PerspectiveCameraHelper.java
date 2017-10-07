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

import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;

/**
 * Used to access internal methods of PerspectiveCamera.
 */
public class PerspectiveCameraHelper extends CameraHelper {

    private static final PerspectiveCameraHelper theInstance;
    private static PerspectiveCameraAccessor perspectiveCameraAccessor;

    static {
        theInstance = new PerspectiveCameraHelper();
        Utils.forceInit(PerspectiveCamera.class);
    }

    private static PerspectiveCameraHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(PerspectiveCamera perspectiveCamera) {
        setHelper(perspectiveCamera, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return perspectiveCameraAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        perspectiveCameraAccessor.doUpdatePeer(node);
    }

    public static void setPerspectiveCameraAccessor(final PerspectiveCameraAccessor newAccessor) {
        if (perspectiveCameraAccessor != null) {
            throw new IllegalStateException();
        }

        perspectiveCameraAccessor = newAccessor;
    }

    public interface PerspectiveCameraAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
    }

}
