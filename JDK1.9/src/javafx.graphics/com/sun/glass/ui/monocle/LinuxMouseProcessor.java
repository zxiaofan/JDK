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

class LinuxMouseProcessor implements LinuxInputProcessor {

    private MouseInput mouse = MouseInput.getInstance();
    private MouseState previousState = new MouseState();
    private MouseState state = new MouseState();
    /**
     * does previousState hold an update that has not yet been sent to
     * MouseInput?
     */
    private boolean hasPendingState;

    @Override
    public void processEvents(LinuxInputDevice device) {
        LinuxEventBuffer buffer = device.getBuffer();
        mouse.getState(previousState);
        mouse.getState(state);
        hasPendingState = false;
        while (buffer.hasNextEvent()) {
            switch (buffer.getEventType()) {
                case LinuxInput.EV_REL:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.REL_X:
                            int x = previousState.getX();
                            x += buffer.getEventValue();
                            state.setX(x);
                            break;
                        case LinuxInput.REL_Y:
                            int y = previousState.getY();
                            y += buffer.getEventValue();
                            state.setY(y);
                            break;
                        case LinuxInput.REL_WHEEL: {
                            int value = buffer.getEventValue();
                            if (value < 0) {
                                state.setWheel(MouseState.WHEEL_DOWN);
                            } else if (value > 0) {
                                state.setWheel(MouseState.WHEEL_UP);
                            } else {
                                state.setWheel(MouseState.WHEEL_NONE);
                            }
                            break;
                        }
                        default:
                            // Ignore other axes
                    }
                    break;
                case LinuxInput.EV_SYN:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.SYN_REPORT:
                            sendEvent();
                            break;
                        default: // ignore
                    }
                    break;
                case LinuxInput.EV_KEY: {
                    int button = mouseButtonForKeyCode(buffer.getEventCode());
                    if (button >= 0) {
                        if (buffer.getEventValue() == 0) {
                            state.releaseButton(button);
                        } else {
                            state.pressButton(button);
                        }
                    }
                    break;
                }
                default:
                    // Ignore other events
            }
            buffer.nextEvent();
        }
        if (hasPendingState) {
            mouse.setState(previousState, false);
        }
    }

    private void sendEvent() {
        if (state.canBeFoldedWith(previousState)) {
            // fold together MouseStates that differ only in their coordinates
            hasPendingState = true;
        } else {
            // the events are different.
            if (hasPendingState) {
                // send and clear the pending state
                mouse.setState(previousState, false);
                hasPendingState = false;
            }
            // send this event
            mouse.setState(state, false);
        }
        state.copyTo(previousState);
    }

    private static int mouseButtonForKeyCode(int keyCode) {
        switch (keyCode) {
            case LinuxInput.BTN_MOUSE:
                return MouseEvent.BUTTON_LEFT;
            case LinuxInput.BTN_MIDDLE:
                return MouseEvent.BUTTON_OTHER;
            case LinuxInput.BTN_RIGHT:
                return MouseEvent.BUTTON_RIGHT;
            default:
                return -1;
        }
    }

}
