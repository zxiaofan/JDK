/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.Application;
import com.sun.javafx.sg.prism.NGCamera;
import com.sun.prism.PixelSource;
import com.sun.prism.PresentableState;
import com.sun.prism.paint.Color;
import com.sun.prism.paint.Paint;

/**
 * SceneState is intended to provide for a shadow copy the View/Scene state
 * similar to the shadow Graph, providing a static snapshot until the Scene
 * is rendered.
 */
class SceneState extends PresentableState {

    final GlassScene scene;

    private Color clearColor;
    private Paint currentPaint;
    private NGCamera camera;

    /**
     * Create the View State
     * .
     * May only be called from the event thread.
     */
    public SceneState(GlassScene vs) {
        super();
        scene = vs;
    }

    @Override
    public boolean isMSAA() {
        return scene.isMSAA();
    }

    /**
     * Returns the glass scene for the view state
     * .
     * @return the glass scene
     *
     * May be called on any thread.
     */
    public GlassScene getScene() {
        return scene;
    }

    /**
     * Drawing can occur in a Glass view if the view exists
     * (is not null), the window exists (is not null) and
     * the view is attached to a window (ie. has not been
     * closed).
     *
     * @return true if drawing can occur; false otherwise
     *
     * May be called on any thread. Must be called under the
     * render lock.
     */
    public boolean isValid() {
        return getWindow() != null && getView() != null && !isViewClosed() && getWidth() > 0 && getHeight() > 0;
    }

    /** Updates the state of this object based on the current
     * state of the glass scene.
     *
     * May only be called from the event thread. Must be called
     * under the render lock.
     */
    public void update() {
        // When the state is created, the platform view has not yet been
        // created (it is null).  Update the view each time the we ask
        // for the updated state.
        view = scene.getPlatformView();
        clearColor = scene.getClearColor();
        currentPaint = scene.getCurrentPaint();

        super.update();
        camera = scene.getCamera();
        //Use the camera width and height so that we are consistent
        //with what was used to calculate the Projection Matrix at
        //sync time.
        if (camera != null) {
            viewWidth = (int)camera.getViewWidth();
            viewHeight = (int)camera.getViewHeight();
        }
    }

    /**
     * Put the pixels on the screen.
     *
     * @param source - the source for the Pixels object to be uploaded
     */
    @Override
    public void uploadPixels(PixelSource source) {
        Application.invokeLater(() -> {
            if (isValid()) {
                SceneState.super.uploadPixels(source);
            } else {
                source.skipLatestPixels();
            }
       });
    }

    Color getClearColor() {
        return clearColor;
    }

    Paint getCurrentPaint() {
        return currentPaint;
    }

    NGCamera getCamera() {
        return camera;
    }
}
