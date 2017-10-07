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

class WinGLFactory extends GLFactory {

    private static native long nInitialize(int[] attrArr);
    private static native int nGetAdapterOrdinal(long hMonitor);
    private static native int nGetAdapterCount();
    private static native boolean nGetIsGL2(long nativeCtxInfo);

    // Entries must be in lowercase and null string is a wild card
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
        return new WinGLContext(nativeCtxInfo);
    }

    @Override
    GLContext createGLContext(GLDrawable drawable, GLPixelFormat pformat,
            GLContext shareCtx, boolean vSyncRequest) {
        // No need to pass down shareCtx as we don't use shared ctx on Windows
        return new WinGLContext(drawable, pformat, vSyncRequest);
    }

    @Override
    GLDrawable createDummyGLDrawable(GLPixelFormat pixelFormat) {
        return new WinGLDrawable(pixelFormat);
    }

    @Override
    GLDrawable createGLDrawable(long nativeWindow, GLPixelFormat pixelFormat) {
        return new WinGLDrawable(nativeWindow, pixelFormat);
    }

    @Override
    GLPixelFormat createGLPixelFormat(long nativeScreen, Attributes attributes) {
        return new WinGLPixelFormat(nativeScreen, attributes);
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

        // return the context info object created on the default screen
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
        // This is a NOP on Windows
    }
}
