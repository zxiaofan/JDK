/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.prism.paint.Color;
import java.security.AccessController;
import java.security.PrivilegedAction;


class EGLFBGLDrawable extends GLDrawable {

    private static final boolean transparentFramebuffer =
            AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> Boolean.getBoolean("com.sun.javafx.transparentFramebuffer"));

    private static native long nCreateDrawable(long nativeWindow, long nativeCtxInfo);
    private static native long nGetDummyDrawable(long nativeCtxInfo);
    private static native boolean nSwapBuffers(long nativeDInfo);
    boolean isDummy = false;

    EGLFBGLDrawable(GLPixelFormat pixelFormat) {

        super(0L, pixelFormat);
        long nDInfo = nGetDummyDrawable(pixelFormat.getNativePFInfo());
        setNativeDrawableInfo(nDInfo);
        isDummy = true;
    }

    EGLFBGLDrawable(long nativeWindow, GLPixelFormat pixelFormat) {
        super(nativeWindow, pixelFormat);
        long nDInfo = nCreateDrawable(nativeWindow, pixelFormat.getNativePFInfo());
        setNativeDrawableInfo(nDInfo);
    }

    @Override
    boolean swapBuffers(GLContext glCtx) {
        boolean retval = nSwapBuffers(getNativeDrawableInfo());
        // TODO: This looks hacky. Need to find a better approach.
        // For eglfb, we are painting in Z-order from the back,
        // possibly (likely) with an app that does not cover the
        // full screen. We need to start each paint with an empty canvas.
        // The assumption here was that we would do that by clearing the buffer.
        glCtx.clearBuffers(
                transparentFramebuffer ? Color.TRANSPARENT : Color.BLACK,
                true, true, true);
        return retval;
    }
}
