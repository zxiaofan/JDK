/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.traversal;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Traversal engine for Scene.
 */
public final class SceneTraversalEngine extends TopMostTraversalEngine{

    private final Scene scene;

    public SceneTraversalEngine(Scene scene) {
        this.scene = scene;
    }

    protected Parent getRoot() {
        return scene.getRoot();
    }
}
