/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import com.sun.javafx.tk.CompletionListener;
import com.sun.javafx.tk.RenderJob;

class PaintRenderJob extends RenderJob {

    private GlassScene scene;

    public PaintRenderJob(GlassScene gs, CompletionListener cl, Runnable r) {
        super(r, cl);

        this.scene = gs;
    }

    public GlassScene getScene() {
        return scene;
    }

}
