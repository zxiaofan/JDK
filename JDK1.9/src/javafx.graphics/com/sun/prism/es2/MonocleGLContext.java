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

package com.sun.prism.es2;

import com.sun.glass.ui.monocle.AcceleratedScreen;

class MonocleGLContext extends GLContext {

    private AcceleratedScreen accScreen;

    MonocleGLContext(long nativeCtxInfo) {
        this.nativeCtxInfo = nativeCtxInfo;
    }

    MonocleGLContext(GLDrawable drawable, GLPixelFormat pixelFormat,
                          boolean vSyncRequest, AcceleratedScreen accScreen,
                          long nativeCtxInfo) {
        this.accScreen = accScreen;
        this.nativeCtxInfo = nativeCtxInfo;
    }

    @Override
    long getNativeHandle() {
        return 0l;
    }

    @Override
    void makeCurrent(GLDrawable drawable) {
        if (drawable != null) {
            accScreen.enableRendering(true);
        } else {
            accScreen.enableRendering(false);
        }
    }
}
