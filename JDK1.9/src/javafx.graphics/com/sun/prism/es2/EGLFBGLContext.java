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



class EGLFBGLContext extends GLContext {

    private static native long nInitialize(long nativeDInfo, long nativePFInfo,
                                           boolean vSyncRequest);
    private static native long nGetNativeHandle(long nativeCtxInfo);
    private static native void nMakeCurrent(long nativeCtxInfo, long nativeDInfo);

    EGLFBGLContext(long nativeCtxInfo) {
        this.nativeCtxInfo = nativeCtxInfo;
    }

    EGLFBGLContext(GLDrawable drawable, GLPixelFormat pixelFormat,
                          boolean vSyncRequest) {

        // holds the list of attributes to be translated for native call
        int attrArr[] = new int[GLPixelFormat.Attributes.NUM_ITEMS];

        GLPixelFormat.Attributes attrs = pixelFormat.getAttributes();

        attrArr[GLPixelFormat.Attributes.RED_SIZE] = attrs.getRedSize();
        attrArr[GLPixelFormat.Attributes.GREEN_SIZE] = attrs.getGreenSize();
        attrArr[GLPixelFormat.Attributes.BLUE_SIZE] = attrs.getBlueSize();
        attrArr[GLPixelFormat.Attributes.ALPHA_SIZE] = attrs.getAlphaSize();
        attrArr[GLPixelFormat.Attributes.DEPTH_SIZE] = attrs.getDepthSize();
        attrArr[GLPixelFormat.Attributes.DOUBLEBUFFER] = attrs.isDoubleBuffer() ? 1 : 0;
        attrArr[GLPixelFormat.Attributes.ONSCREEN] = attrs.isOnScreen() ? 1 : 0;

        // return the context info object created on the default screen
        nativeCtxInfo = nInitialize(drawable.getNativeDrawableInfo(),
                                    pixelFormat.getNativePFInfo(), vSyncRequest);
    }

    @Override
    long getNativeHandle() {
        return nGetNativeHandle(nativeCtxInfo);
    }

    @Override
    void makeCurrent(GLDrawable drawable) {
        nMakeCurrent(nativeCtxInfo, drawable.getNativeDrawableInfo());
    }
}
