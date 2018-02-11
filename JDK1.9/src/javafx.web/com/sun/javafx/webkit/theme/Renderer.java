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

package com.sun.javafx.webkit.theme;

import javafx.scene.control.Control;

import com.sun.webkit.graphics.WCGraphicsContext;

public abstract class Renderer {
    private static Renderer instance;

    public static void setRenderer(Renderer renderer) {
        instance = renderer;
    }

    public static Renderer getRenderer() {
        return instance;
    }

    protected abstract void render(Control c, WCGraphicsContext g);
}
