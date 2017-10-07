/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.Accessible;
import com.sun.javafx.tk.TKPulseListener;
import com.sun.javafx.tk.TKScene;
import com.sun.javafx.util.Utils;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

/**
 * Used to access internal scene methods.
 */
public final class SceneHelper {
    private static SceneAccessor sceneAccessor;

    static {
        Utils.forceInit(Scene.class);
    }

    private SceneHelper() {
    }

    public static void enableInputMethodEvents(Scene scene, boolean enable) {
        sceneAccessor.enableInputMethodEvents(scene, enable);
    }

    public static void processKeyEvent(Scene scene, KeyEvent e) {
        sceneAccessor.processKeyEvent(scene, e);
    }

    public static void processMouseEvent(Scene scene, MouseEvent e) {
        sceneAccessor.processMouseEvent(scene, e);
    }

    public static void preferredSize(Scene scene) {
        sceneAccessor.preferredSize(scene);
    }

    public static void disposePeer(Scene scene) {
        sceneAccessor.disposePeer(scene);
    }

    public static void initPeer(Scene scene) {
        sceneAccessor.initPeer(scene);
    }

    public static void setWindow(Scene scene, Window window) {
        sceneAccessor.setWindow(scene, window);
    }

    public static TKPulseListener getScenePulseListener(Scene scene) {
        return sceneAccessor.getScenePulseListener(scene);
    }

    public static TKScene getPeer(Scene scene) {
        return sceneAccessor.getPeer(scene);
    }

    public static void setAllowPGAccess(boolean flag) {
        sceneAccessor.setAllowPGAccess(flag);
    }

    public static void setPaused(final boolean paused) {
        sceneAccessor.setPaused(paused);
    }

    public static void parentEffectiveOrientationInvalidated(
            final Scene scene) {
        sceneAccessor.parentEffectiveOrientationInvalidated(scene);
    }

    public static Camera getEffectiveCamera(final Scene scene) {
        return sceneAccessor.getEffectiveCamera(scene);
    }

    public static Scene createPopupScene(final Parent root) {
        return sceneAccessor.createPopupScene(root);
    }

    public static Accessible getAccessible(Scene scene) {
        return sceneAccessor.getAccessible(scene);
    }

    public static void setSceneAccessor(final SceneAccessor newAccessor) {
        if (sceneAccessor != null) {
            throw new IllegalStateException();
        }

        sceneAccessor = newAccessor;
    }

    public static SceneAccessor getSceneAccessor() {
        if (sceneAccessor == null) throw new IllegalStateException();
        return sceneAccessor;
    }

    public interface SceneAccessor {
        void enableInputMethodEvents(Scene scene, boolean enable);

        void processKeyEvent(Scene scene, KeyEvent e);

        void processMouseEvent(Scene scene, MouseEvent e);

        void preferredSize(Scene scene);

        void disposePeer(Scene scene);

        void initPeer(Scene scene);

        void setWindow(Scene scene, Window window);

        TKPulseListener getScenePulseListener(Scene scene);

        TKScene getPeer(Scene scene);

        void setAllowPGAccess(boolean flag);

        void setPaused(boolean paused);

        void parentEffectiveOrientationInvalidated(Scene scene);

        Camera getEffectiveCamera(Scene scene);

        Scene createPopupScene(Parent root);

        void setTransientFocusContainer(Scene scene, Node node);

        Accessible getAccessible(Scene scene);
    }

}
