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

class HeadlessPlatform extends NativePlatform {

    @Override
    protected InputDeviceRegistry createInputDeviceRegistry() {
        // use of a LinuxInputDeviceRegistry lets us simulate
        // Linux input devices on any system
        return new LinuxInputDeviceRegistry(true);
    }

    @Override
    protected NativeCursor createCursor() {
        return new NullCursor();
    }

    @Override
    protected NativeScreen createScreen() {
        return new HeadlessScreen();
    }

}
