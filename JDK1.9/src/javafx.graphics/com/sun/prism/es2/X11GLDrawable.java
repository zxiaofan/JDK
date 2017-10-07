/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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


class X11GLDrawable extends GLDrawable {

    private static native long nCreateDrawable(long nativeWindow, long nativeCtxInfo);
    private static native long nGetDummyDrawable(long nativeCtxInfo);
    private static native boolean nSwapBuffers(long nativeDInfo);

    X11GLDrawable(GLPixelFormat pixelFormat) {

        super(0L, pixelFormat);
        long nDInfo = nGetDummyDrawable(pixelFormat.getNativePFInfo());
        setNativeDrawableInfo(nDInfo);
    }

    X11GLDrawable(long nativeWindow, GLPixelFormat pixelFormat) {
        super(nativeWindow, pixelFormat);
        long nDInfo = nCreateDrawable(nativeWindow, pixelFormat.getNativePFInfo());
        setNativeDrawableInfo(nDInfo);
    }

    @Override
    boolean swapBuffers(GLContext glCtx) {
        return nSwapBuffers(getNativeDrawableInfo());
    }
}
