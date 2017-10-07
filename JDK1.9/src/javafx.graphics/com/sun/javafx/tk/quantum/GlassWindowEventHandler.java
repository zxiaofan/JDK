/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.events.WindowEvent;
import com.sun.glass.ui.Application;
import com.sun.glass.ui.Screen;
import com.sun.glass.ui.Window;
import com.sun.glass.ui.Window.Level;

import com.sun.javafx.tk.FocusCause;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

class GlassWindowEventHandler extends Window.EventHandler implements PrivilegedAction<Void> {

    private final WindowStage stage;

    private Window window;
    private int type;

    public GlassWindowEventHandler(WindowStage stage) {
        this.stage = stage;
    }

    @Override
    public Void run() {
        if (stage == null || stage.stageListener == null) {
            return null;
        }
        switch (type) {
            case WindowEvent.MINIMIZE:
                stage.stageListener.changedIconified(true);
                break;
            case WindowEvent.MAXIMIZE:
                stage.stageListener.changedIconified(false);
                stage.stageListener.changedMaximized(true);
                break;
            case WindowEvent.RESTORE:
                stage.stageListener.changedIconified(false);
                stage.stageListener.changedMaximized(false);
                break;
            case WindowEvent.MOVE: {
                float wx = window.getX();
                float wy = window.getY();
                Screen screen = window.getScreen();
                float newx, newy;
                if (screen != null) {
                    float pScaleX = screen.getPlatformScaleX();
                    float pScaleY = screen.getPlatformScaleY();
                    float sx = screen.getX();
                    float sy = screen.getY();
                    float px = screen.getPlatformX();
                    float py = screen.getPlatformY();
                    newx = sx + (wx - px) / pScaleX;
                    newy = sy + (wy - py) / pScaleY;
                } else {
                    newx = wx;
                    newy = wy;
                }
                stage.stageListener.changedLocation(newx, newy);
                //We need to sync the new x,y for painting
                if (!Application.GetApplication().hasWindowManager()) {
                    QuantumToolkit.runWithRenderLock(() -> {
                        GlassScene scene = stage.getScene();
                        if (scene != null) {
                            scene.updateSceneState();
                        }
                        return null;
                    });
                }
                break;
            }
            case WindowEvent.RESIZE: {
                float pScaleX = window.getPlatformScaleX();
                float pScaleY = window.getPlatformScaleY();
                stage.stageListener.changedSize(window.getWidth()  / pScaleX,
                                                window.getHeight() / pScaleY);
                 break;
            }
            case WindowEvent.RESCALE: {
                float outScaleX = window.getOutputScaleX();
                float outScaleY = window.getOutputScaleY();
                stage.stageListener.changedScale(outScaleX, outScaleY);
                // We need to sync the new scales for painting
                QuantumToolkit.runWithRenderLock(() -> {
                    GlassScene scene = stage.getScene();
                    if (scene != null) {
                        scene.entireSceneNeedsRepaint();
                        scene.updateSceneState();
                    }
                    return null;
                });
                break;
            }
            case WindowEvent.FOCUS_GAINED:
                WindowStage.addActiveWindow(stage);
                stage.stageListener.changedFocused(true, FocusCause.ACTIVATED);
                break;
            case WindowEvent.FOCUS_LOST:
                stage.stageListener.changedFocused(false, FocusCause.DEACTIVATED);
                break;
            case WindowEvent.FOCUS_UNGRAB:
                stage.stageListener.focusUngrab();
                break;
            case WindowEvent.FOCUS_GAINED_FORWARD:
                WindowStage.addActiveWindow(stage);
                stage.stageListener.changedFocused(true, FocusCause.TRAVERSED_FORWARD);
                break;
            case WindowEvent.FOCUS_GAINED_BACKWARD:
                WindowStage.addActiveWindow(stage);
                stage.stageListener.changedFocused(true, FocusCause.TRAVERSED_BACKWARD);
                break;
            case WindowEvent.FOCUS_DISABLED:
                stage.handleFocusDisabled();
                break;
            case WindowEvent.DESTROY:
                stage.setPlatformWindowClosed();
                stage.stageListener.closed();
                break;
            case WindowEvent.CLOSE:
                stage.stageListener.closing();
                break;
            default:
                if (QuantumToolkit.verbose) {
                    System.err.println("GlassWindowEventHandler: unknown type: " + type);
                }
                break;
        }
        return null;
    }

    @Override
    public void handleLevelEvent(int level) {
        QuantumToolkit.runWithoutRenderLock(() -> {
            AccessControlContext acc = stage.getAccessControlContext();
            return AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
                stage.stageListener.changedAlwaysOnTop(level != Level.NORMAL);
                return (Void)null;
            } , acc);
        });
    }

    @Override
    public void handleWindowEvent(final Window window, final long time, final int type) {
        this.window = window;
        this.type = type;

        QuantumToolkit.runWithoutRenderLock(() -> {
            AccessControlContext acc = stage.getAccessControlContext();
            return AccessController.doPrivileged(this, acc);
        });
    }

    @Override
    public void handleScreenChangedEvent(Window window, long time, Screen oldScreen, Screen newScreen) {
        GlassScene scene = stage.getScene();
        if (scene != null) {
            QuantumToolkit.runWithRenderLock(() -> {
                scene.entireSceneNeedsRepaint();
                scene.updateSceneState();
                return null;
            });
        }

        QuantumToolkit.runWithoutRenderLock(() -> {
            AccessControlContext acc = stage.getAccessControlContext();
            return AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
                stage.stageListener.changedScreen(oldScreen, newScreen);
                return (Void)null;
            } , acc);
        });
    }
}
