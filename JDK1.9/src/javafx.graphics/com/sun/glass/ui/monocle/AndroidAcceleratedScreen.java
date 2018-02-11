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

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Provide Android implementation of AcceleratedScreen
 *
 */
class AndroidAcceleratedScreen extends AcceleratedScreen {


    AndroidAcceleratedScreen(int[] attributes) throws GLException {
        super(attributes);
    }

    boolean initPlatformLibraries() {
        return super.initPlatformLibraries();
    }

    @Override
    protected long platformGetNativeDisplay() {
        return 0;
    }

    @Override
    protected long platformGetNativeWindow() {
        long answer = NativePlatformFactory.getNativePlatform()
                .getScreen().getNativeHandle();
        return answer;
    }

}
