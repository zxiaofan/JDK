/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.glass.utils.NativeLibLoader;

class AndroidPlatform extends NativePlatform {

    AndroidPlatform() {
        NativeLibLoader.loadLibrary("glass_monocle");
    }

    @Override
    protected InputDeviceRegistry createInputDeviceRegistry() {
        return AndroidInputDeviceRegistry.getInstance();
    }

    @Override
    protected NativeCursor createCursor() {
        return new NullCursor();
    }

    @Override
    protected NativeScreen createScreen() {
        return new AndroidScreen();
    }

    /** Create the accelerated screen for this platform
     *
     * @param attributes a sequence of pairs (GLAttibute, value)
     * @throws GLException
     */
    @Override
    public synchronized AcceleratedScreen getAcceleratedScreen(
            int[] attributes) throws GLException {
        if (accScreen == null) {
            accScreen = new AndroidAcceleratedScreen(attributes);
        }
        return accScreen;
    }

}
