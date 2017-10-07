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

import com.sun.prism.es2.GLPixelFormat.Attributes;
import java.util.HashMap;


class EGLFBGLFactory extends GLFactory {

    private static native long nInitialize(int[] attrArr);
    private static native int nGetAdapterOrdinal(long nativeScreen);
    private static native int nGetAdapterCount();
    private static native int nGetDefaultScreen(long nativeCtxInfo);
    private static native long nGetDisplay(long nativeCtxInfo);
    private static native long nGetVisualID(long nativeCtxInfo);
    private static native boolean nGetIsGL2(long nativeCtxInfo);

    // Entries must be in lowercase and null string is a wild card
    // For Linux Beta release we will limit es2 pipe qualification check to NVidia GPUs only
    private GLGPUInfo preQualificationFilter[] = null;
    private GLGPUInfo blackList[] = null;

    @Override
    GLGPUInfo[] getPreQualificationFilter() {
        return preQualificationFilter;
    }

    @Override
    GLGPUInfo[] getBlackList() {
        return blackList;
    }

    @Override
    GLContext createGLContext(long nativeCtxInfo) {
        return new EGLFBGLContext(nativeCtxInfo);
    }

    @Override
    GLContext createGLContext(GLDrawable drawable, GLPixelFormat pixelFormat,
                                     GLContext shareCtx, boolean vSyncRequest) {
        // No need to pass down shareCtx as we don't use shared ctx on EGLFB
        return new EGLFBGLContext(drawable, pixelFormat, vSyncRequest);
    }

    @Override
    GLDrawable createDummyGLDrawable(GLPixelFormat pixelFormat) {
        return new EGLFBGLDrawable(pixelFormat);
    }

    @Override
    GLDrawable createGLDrawable(long nativeWindow, GLPixelFormat pixelFormat) {
        return new EGLFBGLDrawable(nativeWindow, pixelFormat);
    }

    @Override
    GLPixelFormat createGLPixelFormat(long nativeScreen, Attributes attributes) {
        return new EGLFBGLPixelFormat(nativeScreen, attributes);
    }

    @Override
    boolean initialize(Class psClass, Attributes attrs) {

        // holds the list of attributes to be translated for native call
        int attrArr[] = new int[GLPixelFormat.Attributes.NUM_ITEMS];

        attrArr[GLPixelFormat.Attributes.RED_SIZE] = attrs.getRedSize();
        attrArr[GLPixelFormat.Attributes.GREEN_SIZE] = attrs.getGreenSize();
        attrArr[GLPixelFormat.Attributes.BLUE_SIZE] = attrs.getBlueSize();
        attrArr[GLPixelFormat.Attributes.ALPHA_SIZE] = attrs.getAlphaSize();
        attrArr[GLPixelFormat.Attributes.DEPTH_SIZE] = attrs.getDepthSize();
        attrArr[GLPixelFormat.Attributes.DOUBLEBUFFER] = attrs.isDoubleBuffer() ? 1 : 0;
        attrArr[GLPixelFormat.Attributes.ONSCREEN] = attrs.isOnScreen() ? 1 : 0;

        // return the context info object create on the default screen
        nativeCtxInfo = nInitialize(attrArr);

        if (nativeCtxInfo == 0) {
            // current pipe doesn't support this pixelFormat request
            return false;
        } else {
            gl2 = nGetIsGL2(nativeCtxInfo);
            return true;
        }
    }

    @Override
    int getAdapterCount() {
        return nGetAdapterCount();
    }

    @Override
    int getAdapterOrdinal(long nativeScreen) {
        return nGetAdapterOrdinal(nativeScreen);
    }

    @Override
    void updateDeviceDetails(HashMap deviceDetails) {
    }
}
