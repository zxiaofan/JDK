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

class MX6AcceleratedScreen extends AcceleratedScreen {

    private long fbGetDisplayByIndexHandle, fbCreateWindowHandle;
    private long cachedNativeDisplay = 0l;

    private native long _platformGetNativeWindow(long methodHandle,
                                                 long display);

    private native long _platformGetNativeDisplay(long methodHandle);

    MX6AcceleratedScreen(int[] attributes) throws GLException {
        super(attributes);
    }

    @Override
    protected long platformGetNativeWindow() {
        fbCreateWindowHandle = ls.dlsym(getEGLHandle(), "fbCreateWindow");
        if (fbCreateWindowHandle == 0l) {
            return -1l;
        } else {
            return _platformGetNativeWindow(fbCreateWindowHandle, cachedNativeDisplay);
        }
    }

    @Override
    protected long platformGetNativeDisplay() {
        fbGetDisplayByIndexHandle = ls.dlsym(getEGLHandle(), "fbGetDisplayByIndex");
        if (fbGetDisplayByIndexHandle == 0l) {
            return -1l;
        } else {
            cachedNativeDisplay = _platformGetNativeDisplay(fbGetDisplayByIndexHandle);
            return cachedNativeDisplay;
        }
    }
}
