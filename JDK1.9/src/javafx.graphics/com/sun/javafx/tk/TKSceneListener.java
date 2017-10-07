/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

import com.sun.glass.ui.Accessible;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.input.*;

/**
 * TKSceneListener - Listener for the Scene Peer TKScene to pass updates and events back to the scene
 *
 */
public interface TKSceneListener {

    /**
     * The scenes peer's location have changed so we need to update the scene
     *
     * @param x the new X
     * @param y The new Y
     */
    public void changedLocation(float x, float y);

    /**
     * The scenes peer's size have changed so we need to update the scene
     *
     * @param width The new Width
     * @param height The new Height
     */
    public void changedSize(float width, float height);

    /**
     * Pass a mouse event to the scene to handle
     */
    public void mouseEvent(EventType<MouseEvent> type, double x, double y, double screenX, double screenY,
                           MouseButton button, boolean popupTrigger, boolean synthesized,
                           boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown,
                           boolean primaryDown, boolean middleDown, boolean secondaryDown);

    /**
     * Pass a key event to the scene to handle
     */
    public void keyEvent(KeyEvent keyEvent);

    /**
     * Pass an input method event to the scene to handle
     */
    public void inputMethodEvent(EventType<InputMethodEvent> type,
                                 ObservableList<InputMethodTextRun> composed, String committed,
                                 int caretPosition);

    public void scrollEvent(
            EventType<ScrollEvent> eventType, double scrollX, double scrollY,
            double totalScrollX, double totalScrollY,
            double xMultiplier, double yMultiplier, int touchCount,
            int scrollTextX, int scrollTextY,
            int defaultTextX, int defaultTextY,
            double x, double y, double screenX, double screenY,
            boolean _shiftDown, boolean _controlDown,
            boolean _altDown, boolean _metaDown,
            boolean _direct, boolean _inertia);

    public void menuEvent(double x, double y, double xAbs, double yAbs,
            boolean isKeyboardTrigger);

    public void zoomEvent(
            EventType<ZoomEvent> eventType,
            double zoomFactor, double totalZoomFactor,
            double x, double y, double screenX, double screenY,
            boolean _shiftDown, boolean _controlDown,
            boolean _altDown, boolean _metaDown,
            boolean _direct, boolean _inertia);

    public void rotateEvent(
            EventType<RotateEvent> eventType, double angle, double totalAngle,
            double x, double y, double screenX, double screenY,
            boolean _shiftDown, boolean _controlDown,
            boolean _altDown, boolean _metaDown,
            boolean _direct, boolean _inertia);

    public void swipeEvent(
            EventType<SwipeEvent> eventType, int touchCount,
            double x, double y, double screenX, double screenY,
            boolean _shiftDown, boolean _controlDown,
            boolean _altDown, boolean _metaDown, boolean _direct);

    public void touchEventBegin(
            long time, int touchCount, boolean isDirect,
            boolean _shiftDown, boolean _controlDown,
            boolean _altDown, boolean _metaDown);

    public void touchEventNext(
            TouchPoint.State state, long touchId,
            double x, double y, double xAbs, double yAbs);

    public void touchEventEnd();

    public Accessible getSceneAccessible();
}
