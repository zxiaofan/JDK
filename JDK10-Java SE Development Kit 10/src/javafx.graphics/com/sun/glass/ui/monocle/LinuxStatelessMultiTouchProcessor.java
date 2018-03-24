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

/**
 * This multitouch processor works with drivers that do not send a tracking ID
 * themselves. Drivers that do not send tracking IDs will send all touch points
 * in each SYN_REPORT-terminated event sequence. So for these drivers we will
 * clear touch state before each event sequence.
 */
class LinuxStatelessMultiTouchProcessor extends LinuxTouchProcessor {

    private static final int COORD_UNDEFINED = Integer.MIN_VALUE;

    LinuxStatelessMultiTouchProcessor(LinuxInputDevice device) {
        super(device);
        pipeline.addFilter(new LookaheadTouchFilter(true));
        pipeline.addFilter(new AssignPointIDTouchFilter());
    }

    @Override
    public void processEvents(LinuxInputDevice device) {
        LinuxEventBuffer buffer = device.getBuffer();
        state.clear();
        int x = COORD_UNDEFINED;
        int y = COORD_UNDEFINED;
        boolean touchReleased = false;
        while (buffer.hasNextEvent()) {
            switch (buffer.getEventType()) {
                case LinuxInput.EV_ABS: {
                    int value = transform.getValue(buffer);
                    switch (transform.getAxis(buffer)) {
                        case LinuxInput.ABS_X:
                        case LinuxInput.ABS_MT_POSITION_X:
                            x = value;
                            break;
                        case LinuxInput.ABS_Y:
                        case LinuxInput.ABS_MT_POSITION_Y:
                            y = value;
                            break;
                    }
                    break;
                }
                case LinuxInput.EV_KEY:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.BTN_TOUCH:
                            if (buffer.getEventValue() == 0) {
                                touchReleased = true;
                            }
                            break;
                    }
                    break;
                case LinuxInput.EV_SYN:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.SYN_MT_REPORT: {
                            if (x != COORD_UNDEFINED && y != COORD_UNDEFINED) {
                                TouchState.Point p = state.addPoint(null);
                                p.id = 0;
                                p.x = x;
                                p.y = y;
                            }
                            x = y = COORD_UNDEFINED;
                            break;
                        }
                        case LinuxInput.SYN_REPORT:
                            if (touchReleased) {
                                // remove points
                                state.clear();
                                touchReleased = false;
                            }
                            pipeline.pushState(state);
                            state.clear();
                            x = y = COORD_UNDEFINED;
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
