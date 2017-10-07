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

class OMAPPlatform extends LinuxPlatform {

    @Override
    protected NativeCursor createCursor() {
        return new OMAPCursor();
    }

    @Override
    protected NativeScreen createScreen() {
        return new OMAPScreen();
    }

}
