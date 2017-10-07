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

import java.util.HashMap;
import java.util.Map;

/**
 * This multitouch processor works with drivers that send tracking IDs.
 */
class LinuxStatefulMultiTouchProcessor extends LinuxTouchProcessor {

    private static final int ID_UNASSIGNED = -1;
    private static final int COORD_UNDEFINED = Integer.MIN_VALUE;
    private int currentID = ID_UNASSIGNED;
    private int currentSlot = 0;

    private final Map<Integer, Integer> slotToIDMap =
            new HashMap<Integer, Integer>();

    LinuxStatefulMultiTouchProcessor(LinuxInputDevice device) {
        super(device);
        pipeline.addFilter(new LookaheadTouchFilter(false));
    }

    @Override
    public void processEvents(LinuxInputDevice device) {
        LinuxEventBuffer buffer = device.getBuffer();
        int x = COORD_UNDEFINED;
        int y = COORD_UNDEFINED;
        // Some devices send EV_KEY BTN_TOUCH 0 to notify that all
        // touch points are released.
        boolean allPointsReleased = false;
        while (buffer.hasNextEvent()) {
            switch (buffer.getEventType()) {
                case LinuxInput.EV_ABS: {
                    int value = transform.getValue(buffer);
                    switch (transform.getAxis(buffer)) {
                        case LinuxInput.ABS_MT_SLOT:
                            // If we received coordinates already, assign them
                            // to the current slot.
                            if (currentID != ID_UNASSIGNED
                                    && (x != COORD_UNDEFINED || y != COORD_UNDEFINED)) {
                                updatePoint(x, y);
                                x = y = COORD_UNDEFINED;
                            }
                            // We expect ABS_MT_SLOT and ABS_MT_TRACKING_ID
                            // to precede the coordinates they describe
                            currentSlot = value;
                            currentID = slotToIDMap.getOrDefault(currentSlot,
                                                                 ID_UNASSIGNED);
                            break;
                        case LinuxInput.ABS_MT_TRACKING_ID:
                            if (value == ID_UNASSIGNED && currentID != ID_UNASSIGNED) {
                                state.removePointForID(currentID);
                            }
                            currentID = value;
                            if (currentID == ID_UNASSIGNED) {
                                slotToIDMap.remove(currentSlot);
                            } else {
                                slotToIDMap.put(currentSlot, currentID);
                            }
                            break;
                        case LinuxInput.ABS_X:
                        case LinuxInput.ABS_MT_POSITION_X:
                            if (x == COORD_UNDEFINED) {
                                x = value;
                            }
                            break;
                        case LinuxInput.ABS_Y:
                        case LinuxInput.ABS_MT_POSITION_Y:
                            if (y == COORD_UNDEFINED) {
                                y = value;
                            }
                            break;
                    }
                    break;
                }

                case LinuxInput.EV_KEY:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.BTN_TOUCH:
                            if (buffer.getEventValue() == 0) {
                                allPointsReleased = true;
                            }
                            break;

                    }
                    break;


                case LinuxInput.EV_SYN:
                    switch (buffer.getEventCode()) {
                        case LinuxInput.SYN_MT_REPORT: {
                            if (currentID != ID_UNASSIGNED) {
                                if (x == COORD_UNDEFINED
                                        && y == COORD_UNDEFINED) {
                                    state.removePointForID(currentID);
                                    currentID = ID_UNASSIGNED;
                                } else {
                                    updatePoint(x, y);
                                }
                            }
                            x = y = COORD_UNDEFINED;
                            break;
                        }
                        case LinuxInput.SYN_REPORT:
                            if ((x != COORD_UNDEFINED || y != COORD_UNDEFINED)
                                    && currentID != ID_UNASSIGNED) {
                                // we received coordinates,
                                // but no SYN_MT_REPORT event. Assign these
                                // coordinates to the current ID.
                                updatePoint(x, y);
                            } else if (allPointsReleased) {
                                state.clear();
                            }
                            pipeline.pushState(state);
                            x = y = COORD_UNDEFINED;
                            allPointsReleased = false;
                            break;
                        default: // ignore
                    }
                    break;
            }
            buffer.nextEvent();
        }
        pipeline.flush();
    }

    private void updatePoint(int x, int y) {
        TouchState.Point p = state
                .getPointForID(currentID);
        if (p == null) {
            p = new TouchState.Point();
            p.id = currentID;
            p = state.addPoint(p);
        }
        if (x != COORD_UNDEFINED) {
            p.x = x;
        }
        if (y != COORD_UNDEFINED) {
            p.y = y;
        }
    }

}
