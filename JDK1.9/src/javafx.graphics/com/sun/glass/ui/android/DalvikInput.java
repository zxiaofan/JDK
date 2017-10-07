/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.android;

import javafx.application.Platform;
import javafx.scene.Node;

public class DalvikInput {

    public static void onMultiTouchEvent(final int count, final int[] actions,
            final int[] ids, final int[] touchXs, final int[] touchYs) {
        Platform.runLater(new Runnable() {
            public void run() {
                onMultiTouchEventNative(count, actions, ids, touchXs, touchYs);
            }
        });

    }

    private static native void onMultiTouchEventNative(int count, int[] actions,
            int[] ids, int[] touchXs, int[] touchYs);

    public static void onKeyEvent(final int action, final int keycode, final String characters){
        Platform.runLater(new Runnable() {
            public void run() {
                onKeyEventNative(action, keycode, characters);
            }
        });
    };

    private static Node activeNode;

    public static void onGlobalLayoutChanged() {
        if (activeNode != null) {
            Platform.runLater(() -> activeNode.getParent().requestFocus());
        }
    }

    public static void setActiveNode (Node n) {
        activeNode = n;
    }

    private static native void onKeyEventNative(int action, int keycode, String characters);

    public static native void onSurfaceChangedNative();

    public static native void onSurfaceChangedNative(int format, int width, int height);

    public static native void onSurfaceRedrawNeededNative();

    public static native void onConfigurationChangedNative(int flag);
}
