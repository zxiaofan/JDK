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

package com.sun.glass.ui.monocle;

import com.sun.glass.events.MouseEvent;

class MouseInputSynthesizer {

    private static final MouseInputSynthesizer instance = new MouseInputSynthesizer();

    private final MouseState mouseState = new MouseState();

    private MouseInputSynthesizer() {
        MouseInput.getInstance().getState(mouseState);
    }

    static MouseInputSynthesizer getInstance() {
        return instance;
    }

    void setState(TouchState touchState) {
        if (touchState.getPointCount() == 0) {
            mouseState.releaseButton(MouseEvent.BUTTON_LEFT);
        } else {
            mouseState.pressButton(MouseEvent.BUTTON_LEFT);
        }
        TouchState.Point p = touchState.getPointForID(touchState.getPrimaryID());
        if (p != null) {
            mouseState.setX(p.x);
            mouseState.setY(p.y);
        }
        MouseInput.getInstance().setState(mouseState, true);
    }

}
