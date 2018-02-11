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
import com.sun.prism.paint.Color;
import java.security.AccessController;
import java.security.PrivilegedAction;

class MonocleGLDrawable extends GLDrawable {

    private static final boolean transparentFramebuffer =
            AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> Boolean.getBoolean("com.sun.javafx.transparentFramebuffer"));

    AcceleratedScreen accScreen;

    MonocleGLDrawable(GLPixelFormat pixelFormat, AcceleratedScreen accScreen) {

        super(0L, pixelFormat);
        this.accScreen = accScreen;
    }

    MonocleGLDrawable(long nativeWindow, GLPixelFormat pixelFormat,
                      AcceleratedScreen accScreen) {
        super(nativeWindow, pixelFormat);
        this.accScreen = accScreen;
    }

    @Override
    boolean swapBuffers(GLContext glCtx) {

       boolean retval = accScreen.swapBuffers();
       // boolean retval = nSwapBuffers(getNativeDrawableInfo());

        // TODO: This looks hacky. Need to find a better approach.
        // For Monocle, we are painting in Z-order from the back,
        // possibly (likely) with an app that does not cover the
        // full screen. We need to start each paint with an empty canvas.
        // The assumption here was that we would do that by clearing the buffer.
        glCtx.clearBuffers(
                transparentFramebuffer ? Color.TRANSPARENT : Color.BLACK,
                true, true, true);
        return retval;

    }
}
