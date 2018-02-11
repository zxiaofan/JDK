/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javafx.application.Platform;

import javafx.scene.input.TransferMode;

import com.sun.glass.ui.ClipboardAssistance;
import com.sun.glass.ui.View;
import com.sun.glass.ui.Window;

import java.security.AccessController;
import java.security.PrivilegedAction;

class GlassSceneDnDEventHandler {

    private final GlassScene scene;

    public GlassSceneDnDEventHandler(final GlassScene scene) {
        this.scene = scene;
    }

    // Drop target handlers

    private double getPlatformScaleX() {
        View view = scene.getPlatformView();
        if (view != null) {
            Window w = view.getWindow();
            if (w != null) {
                return w.getPlatformScaleX();
            }
        }
        return 1.0;
    }

    private double getPlatformScaleY() {
        View view = scene.getPlatformView();
        if (view != null) {
            Window w = view.getWindow();
            if (w != null) {
                return w.getPlatformScaleY();
            }
        }
        return 1.0;
    }

    public TransferMode handleDragEnter(final int x, final int y, final int xAbs, final int yAbs,
                                        final TransferMode recommendedTransferMode,
                                        final ClipboardAssistance dropTargetAssistant)
    {
        assert Platform.isFxApplicationThread();
        return AccessController.doPrivileged((PrivilegedAction<TransferMode>) () -> {
            if (scene.dropTargetListener != null) {
                double pScaleX = getPlatformScaleX();
                double pScaleY = getPlatformScaleY();
                QuantumClipboard dragboard =
                        QuantumClipboard.getDragboardInstance(dropTargetAssistant, false);
                return scene.dropTargetListener.dragEnter(x / pScaleX, y / pScaleY, xAbs / pScaleX, yAbs / pScaleY,
                        recommendedTransferMode, dragboard);
            }
            return null;
        }, scene.getAccessControlContext());
    }

    public void handleDragLeave(final ClipboardAssistance dropTargetAssistant) {
        assert Platform.isFxApplicationThread();
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            if (scene.dropTargetListener != null) {
                scene.dropTargetListener.dragExit(0, 0, 0, 0);
            }
            return null;
        }, scene.getAccessControlContext());
    }

    public TransferMode handleDragDrop(final int x, final int y, final int xAbs, final int yAbs,
                                       final TransferMode recommendedTransferMode,
                                       final ClipboardAssistance dropTargetAssistant)
    {
        assert Platform.isFxApplicationThread();
        return AccessController.doPrivileged((PrivilegedAction<TransferMode>) () -> {
            if (scene.dropTargetListener != null) {
                double pScaleX = getPlatformScaleX();
                double pScaleY = getPlatformScaleY();
                return scene.dropTargetListener.drop(x / pScaleX, y / pScaleY, xAbs / pScaleX, yAbs / pScaleY,
                        recommendedTransferMode);
            }
            return null;
        }, scene.getAccessControlContext());
    }

    public TransferMode handleDragOver(final int x, final int y, final int xAbs, final int yAbs,
                                       final TransferMode recommendedTransferMode,
                                       final ClipboardAssistance dropTargetAssistant)
    {
        assert Platform.isFxApplicationThread();
        return AccessController.doPrivileged((PrivilegedAction<TransferMode>) () -> {
            if (scene.dropTargetListener != null) {
                double pScaleX = getPlatformScaleX();
                double pScaleY = getPlatformScaleY();
                return scene.dropTargetListener.dragOver(x / pScaleX, y / pScaleY, xAbs / pScaleX, yAbs / pScaleY,
                        recommendedTransferMode);
            }
            return null;
        }, scene.getAccessControlContext());
    }

    // Drag source handlers

    // This is a callback from the native platform, when a drag gesture is
    // detected. This mechanism is currently not used in FX, as we have
    // a custom gesture recognizer in Scene, and DnD is started with
    // Toolkit.startDrag().
    public void handleDragStart(final int button, final int x, final int y, final int xAbs, final int yAbs,
                                final ClipboardAssistance dragSourceAssistant)
    {
        assert Platform.isFxApplicationThread();
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            if (scene.dragGestureListener != null) {
                double pScaleX = getPlatformScaleX();
                double pScaleY = getPlatformScaleY();
                QuantumClipboard dragboard =
                        QuantumClipboard.getDragboardInstance(dragSourceAssistant, true);
                scene.dragGestureListener.dragGestureRecognized(
                        x / pScaleX, y / pScaleY, xAbs / pScaleX, yAbs / pScaleY, button, dragboard);
            }
            return null;
        }, scene.getAccessControlContext());
    }

    // This is a callback from the native platform, when the drag was started
    // from handleDragStart() above, or when FX as a drag source is embedded
    // to Swing/SWT.
    public void handleDragEnd(final TransferMode performedTransferMode,
                              final ClipboardAssistance dragSourceAssistant)
    {
        assert Platform.isFxApplicationThread();
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            try {
                if (scene.dragSourceListener != null) {
                    scene.dragSourceListener.dragDropEnd(0, 0, 0, 0, performedTransferMode);
                }
            } finally {
                QuantumClipboard.releaseCurrentDragboard();
            }
            return null;
        }, scene.getAccessControlContext());
    }

}
