/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.Pixels;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class AndroidScreen implements NativeScreen {

    private float density = -1;
    public int getDepth() {
        return 24;
    }

    /**
     * Returns the native format of the screen, as a constant from the Pixels
     * class.
     */
    public int getNativeFormat() {
        return Pixels.Format.BYTE_ARGB;
    }

    /**
     * Returns the pixel width of the screen.
     */
    public int getWidth() {
        int answer = (int)(_getWidth()/getScale());
        return answer;
    }

    /**
     * Returns the pixel height of the screen.
     */
    public int getHeight() {
        return (int)(_getHeight()/getScale());
    }

    /**
     * Returns the number of pixels per inch in the screen.
     */
    public int getDPI() {
        return 100;
    }

    @Override
    public float getScale () {
        if (density < 0)  {
            density = _getDensity();
        }
        return density;
    }

    /**
     * Returns a native handle for the screen. The handle is platform-specific.
     */
    public long getNativeHandle() {
        long answer = _getNativeHandle();
        return answer;
    }

    /**
     * Called during JavaFX shutdown to release the screen. Called only once.
     */
    public void shutdown() {
        _shutdown();
    }

    /** Uploads a pixel buffer to the screen. Called on the JavaFX application thread.
     *
     * @param b Pixel data, in BYTE_BGRA_PRE format. The byte stride of the
     *          data is equal to width * 4.
     * @param x The X offset of the pixel data on the screen
     * @param y The Y offset of the pixel data on the screen
     * @param width The pixel width of the data
     * @param height The pixel height of the data
     * @param alpha The alpha level to use to compose the data over existing
     *              pixels
     */
    public void uploadPixels(Buffer b,
                             int x, int y, int width, int height, float alpha) {
        _uploadPixels (b, x, y, width, height, alpha);
    }

    /**
     * Called on the JavaFX application thread when pixel data for all windows
     * has been uploaded.
     */
    public void swapBuffers() {
        _swapBuffers();
    }

    /**
     * Returns a read-only ByteBuffer in the native pixel format containing the screen contents.
     * @return ByteBuffer a read-only ByteBuffer containing the screen contents
     */
    public ByteBuffer getScreenCapture() {
        return _getScreenCapture();
    }

    /**
     * An Object to lock against when swapping screen buffers.
     */
    public static final Object framebufferSwapLock = new Object();

    native int _getWidth();
    native int _getHeight();
    native float _getDensity();
    native long _getNativeHandle();
    native void _shutdown();
    native void _uploadPixels(Buffer b,
                             int x, int y, int width, int height, float alpha);
    native void _swapBuffers();
    native ByteBuffer _getScreenCapture();
}
