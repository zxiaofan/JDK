/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

class AndroidInputProcessor {

    private final AndroidInputDevice device;
    final TouchPipeline touchPipeline;
    private final KeyInput keyInput = new KeyInput();

    AndroidInputProcessor(AndroidInputDevice device) {
        this.device = device;
        touchPipeline = new TouchPipeline();
        touchPipeline.add(TouchInput.getInstance().getBasePipeline());
    }

    void pushEvent(TouchState state) {
        touchPipeline.pushState(state);
    }

    /**
     * Called when events are waiting on the input device to be processed.
     * Called on the runnable processor provided to the input device.
     *
     * @param device The device on which events are pending
     */
    void processEvents(AndroidInputDevice device) {
        touchPipeline.pushState(null);
    }

    synchronized void pushKeyEvent(KeyState keyState) {
        keyInput.setState(keyState);
    }

}
