/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.webkit.prism.theme;

import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.scene.SceneHelper;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.prism.Graphics;
import com.sun.webkit.graphics.WCGraphicsContext;
import com.sun.javafx.webkit.theme.Renderer;
import javafx.scene.Scene;
import javafx.scene.control.Control;

public final class PrismRenderer extends Renderer {

    @Override
    protected void render(Control control, WCGraphicsContext g) {
        SceneHelper.setAllowPGAccess(true);
        // The peer is not modified.
        NGNode peer = NodeHelper.getPeer(control);
        SceneHelper.setAllowPGAccess(false);

        peer.render((Graphics)g.getPlatformGraphics());
    }
}
