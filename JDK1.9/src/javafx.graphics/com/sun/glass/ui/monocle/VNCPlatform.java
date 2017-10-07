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

class VNCPlatform extends HeadlessPlatform {

    @Override
    protected InputDeviceRegistry createInputDeviceRegistry() {
        InputDeviceRegistry registry = new InputDeviceRegistry() {
            {
                // Register a pointing device so that the virtual keyboard will
                // be used
                devices.add(new InputDevice() {
                    @Override public boolean isTouch() { return true; }
                    @Override public boolean isMultiTouch() { return false; }
                    @Override public boolean isRelative() { return false; }
                    @Override public boolean is5Way() { return false; }
                    @Override public boolean isFullKeyboard() { return false; }
                });
            }
        };
        return registry;
    }

    @Override
    protected NativeScreen createScreen() {
        return new VNCScreen();
    }

}
