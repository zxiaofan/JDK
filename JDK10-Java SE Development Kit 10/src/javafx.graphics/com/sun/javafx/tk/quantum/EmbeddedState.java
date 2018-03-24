/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.Pixels;
import com.sun.prism.PixelSource;

/**
 * EmbeddedState is intended to provide for a shadow copy the View/Scene state
 * similar to the shadow Graph, providing a static snapshot until the Scene
 * is rendered.  EmbeddedState captures state that is specific to embedding.
 */
final class EmbeddedState extends SceneState {

    public EmbeddedState(GlassScene vs) {
        super(vs);
    }

    /**
     * Put the pixels on the screen.
     *
     * @param source - the source for the Pixels object to be uploaded
     */
    @Override
    public void uploadPixels(PixelSource source) {
        if (isValid()) {
            Pixels pixels = source.getLatestPixels();
            if (pixels != null) {
                try {
                    EmbeddedScene escene = (EmbeddedScene) scene;
                    // Pixels are always stored in an IntBuffer for uploading
                    escene.uploadPixels(pixels);
                } finally {
                    source.doneWithPixels(pixels);
                }
            }
        } else {
            source.skipLatestPixels();
        }
    }

    /**
     * Drawing can occur when there is an embedded scene that has a host.
     *
     * @return true if drawing can occur; false otherwise
     *
     * May be called on any thread.
     */
    @Override
    public boolean isValid() {
        return scene != null && getWidth() > 0 && getHeight() > 0;
    }

    /** Updates the state of this object based on the current state of its
     * nativeWindow.
     *
     * May only be called from the event thread.
     */
    @Override
    public void update() {
        super.update();
        float scalex = ((EmbeddedScene) scene).getRenderScaleX();
        float scaley = ((EmbeddedScene) scene).getRenderScaleY();
        update(1.0f, 1.0f, scalex, scaley, scalex, scaley);
        if (scene != null) {
            // These variables and others from the superclass need be kept up to date to
            // minimize rendering.  For now, claim that the embedded scene is always visible
            // and not minimized so that rendering can occur
            isWindowVisible = true;
            isWindowMinimized = false;
        }
    }
}
