/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

/** LinuxPlatform matches any Linux system */
class LinuxPlatform extends NativePlatform {

    LinuxPlatform() {
        LinuxSystem.getLinuxSystem().loadLibrary();
    }

    @Override
    protected InputDeviceRegistry createInputDeviceRegistry() {
        return new LinuxInputDeviceRegistry(false);
    }

    @Override
    protected NativeCursor createCursor() {
        return new SoftwareCursor();
    }

    @Override
    protected NativeScreen createScreen() {
        try {
            return new FBDevScreen();
        } catch (RuntimeException e) {
            return new HeadlessScreen();
        }
    }
}
