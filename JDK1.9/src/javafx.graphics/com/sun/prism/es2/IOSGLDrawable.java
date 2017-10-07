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


class IOSGLDrawable extends GLDrawable {

    private static native long nCreateDrawable(long nativeWindow, long nativeCtxInfo);
    private static native long nGetDummyDrawable(long nativeCtxInfo);
    private static native boolean nSwapBuffers(long nativeCtxInfo, long nativeDInfo);


    IOSGLDrawable(GLPixelFormat pixelFormat) {

        super(0L, pixelFormat);
        long nDInfo = nGetDummyDrawable(pixelFormat.getNativePFInfo());
        setNativeDrawableInfo(nDInfo);
    }

    IOSGLDrawable(long nativeWindow, GLPixelFormat pixelFormat) {
        super(nativeWindow, pixelFormat);
        long nDInfo = nCreateDrawable(nativeWindow, pixelFormat.getNativePFInfo());
        setNativeDrawableInfo(nDInfo);
    }

    @Override
    boolean swapBuffers(GLContext glCtx) {
        return nSwapBuffers(glCtx.getNativeCtxInfo(), getNativeDrawableInfo());
    }

}
