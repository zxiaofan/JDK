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

/** Implementation of NativePlatformFactory for X11 platform
 *
 */
class X11PlatformFactory extends NativePlatformFactory {

    @Override
    protected boolean matches() {
        String display = AccessController.doPrivileged(
                (PrivilegedAction<String>) () -> System.getenv("DISPLAY"));
        return display != null;
    }

    @Override
    protected int getMajorVersion() {
        return 1;
    }

    @Override
    protected int getMinorVersion() {
        return 0;
    }

    @Override
    protected NativePlatform createNativePlatform() {
        return new X11Platform();
    }

}
