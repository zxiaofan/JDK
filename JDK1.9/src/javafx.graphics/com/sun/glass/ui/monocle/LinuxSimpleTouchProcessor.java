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

class LinuxSimpleTouchProcessor extends LinuxTouchProcessor {

    LinuxSimpleTouchProcessor(LinuxInputDevice device) {
        super(device);
        pipeline.addFilter(new LookaheadTouchFilter(true));
        pipeline.addFilter(new AssignPointIDTouchFilter());
    }

    @Override
    public void processEvents(LinuxInputDevice device) {
        LinuxEventBuffer buffer = device.getBuffer();
        state.clear();
        boolean touchReleased = false;
        while (buffer.hasNextEvent()) {
            switch (buffer.getEventType()) {
                case LinuxInput.EV_ABS: {
                    int value = transform.getValue(buffer);
                    switch (transform.getAxis(buffer)) {
                        case LinuxInput.ABS_X:
                        case LinuxInput.ABS_MT_POSITION_X:
                            if (state.getPointCount() == 0) {
                                state.addPoint(null).x = value;
                            } else {
                                state.getPoint(0).x = value;
                            }
                            break;
                        case LinuxInput.ABS_Y:
                        case LinuxInput.ABS_MT_POSITION_Y:
                            if (state.getPointCount() == 0) {
                                state.addPoint(null).y = value;
                            } else {
                                state.getPoint(0).y = value;
                            }
                            break;
                    }
                    break;
                }
                case LinuxInput.EV_KEY:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.BTN_TOUCH:
                            if (buffer.getEventValue() == 0) {
                                touchReleased = true;
                            } else if (state.getPointCount() == 0) {
                                // restore an old point
                                state.addPoint(null);
                            }
                            break;
                    }
                    break;
                case LinuxInput.EV_SYN:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.SYN_REPORT:
                            if (touchReleased) {
                                // remove points
                                state.clear();
                                touchReleased = false;
                            }
                            pipeline.pushState(state);
                            state.clear();
                            break;
                        default: // ignore
                    }
                    break;
            }
            buffer.nextEvent();
        }
        pipeline.flush();
    }

}
