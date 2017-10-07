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

import java.security.AccessController;
import java.security.PrivilegedAction;

/** Native platform compatible with X11
 *
 */
class X11Platform extends NativePlatform {

    private final boolean x11Input;

    X11Platform() {
        LinuxSystem.getLinuxSystem().loadLibrary();
        x11Input = AccessController.doPrivileged((PrivilegedAction<Boolean>)
                () -> Boolean.getBoolean("x11.input"));
    }

    /** Create the appropriate input device registry - if the system property
     * x11.input is true, then we use X11InputDeviceRegistry and get native
     * events via the X11 event queue.  If x11.input is not true, we listen
     * directly to the udev raw events.
     */
    @Override
    protected InputDeviceRegistry createInputDeviceRegistry() {
        if (x11Input) {
            return new X11InputDeviceRegistry();
        } else {
            return new LinuxInputDeviceRegistry(false);
        }
    }

    /** Create the appropriate X11 cursor.  If we are using x11 input, we let
     * X11 handle the cursor movement.  If we are using udev input, we need
     * to handle the cursor movement ourselves via X11WarpingCursor.
     */
    @Override
    protected NativeCursor createCursor() {
        if (x11Input) {
            return new X11Cursor();
        } else {
            return new X11WarpingCursor();
        }
    }

    /** Create the native screen for this platform
     */
    @Override
    protected NativeScreen createScreen() {
        return new X11Screen(x11Input);
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
            accScreen = new X11AcceleratedScreen(attributes);
        }
        return accScreen;
    }
}
