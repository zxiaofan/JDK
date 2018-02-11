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

import java.security.AccessController;
import java.security.PrivilegedAction;


class AndroidPlatformFactory extends NativePlatformFactory {

    @Override
    protected boolean matches() {
       String platform = AccessController.doPrivileged(
                (PrivilegedAction<String>) () -> System.getProperty("javafx.platform"));
        return platform != null && platform.equals("android");
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
        return new AndroidPlatform();
    }

}
