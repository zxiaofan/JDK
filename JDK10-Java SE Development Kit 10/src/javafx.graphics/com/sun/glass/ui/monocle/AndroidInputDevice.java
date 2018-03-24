/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

/**
 *
 */
class AndroidInputDevice implements Runnable, InputDevice {

    private AndroidInputProcessor inputProcessor;

    @Override
    public void run() {
        if (inputProcessor == null) {
            System.err.println("Error: no input processor");
            return;
        }
       // read from the android device (change this into push)
        // and process the events
    }

    @Override
    public boolean isTouch() {
        return true;
    }

    @Override
    public boolean isMultiTouch() {
        return true;
    }

    @Override
    public boolean isRelative() {
        return false;
    }

    @Override
    public boolean is5Way() {
        return false;
    }

    @Override
    public boolean isFullKeyboard() {
// if we return false, the JavaFX virtual keyboard will be used instead of the android built-in one
        return true;
    }

    void setInputProcessor(AndroidInputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }
}
