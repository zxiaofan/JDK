/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * A com.sun.glass.ui.monocle.input.LinuxInputProcessor is registered with a
 * com.sun.glass.ui.monocle.input.LinuxInputDevice when the device
 * is created. The listener is then notified when events are waiting to be
 * processed on the device.
 */
interface LinuxInputProcessor {
    /**
     * Called when events are waiting on the input device to be processed.
     * Called on the runnable processor provided to the input device.
     *
     * @param device The device on which events are pending
     */
    void processEvents(LinuxInputDevice device);

    static class Logger implements LinuxInputProcessor {
        @Override
        public void processEvents(LinuxInputDevice device) {
            LinuxEventBuffer buffer = device.getBuffer();
            while (buffer.hasNextEvent()) {
                System.out.format("%1$ts.%1$tL %2$s: %3$s\n",
                                  new java.util.Date(),
                                  device, buffer.getEventDescription());
                buffer.nextEvent();
            }
        }
    }

}
