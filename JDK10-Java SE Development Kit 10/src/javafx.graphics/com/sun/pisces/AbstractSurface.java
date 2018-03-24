/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.pisces;

public abstract class AbstractSurface implements Surface {

    private long nativePtr = 0L;
    private int width;
    private int height;

    AbstractSurface(int width, int height) {
        if (width < 0) {
            throw new IllegalArgumentException("WIDTH must be positive");
        }
        if (height < 0) {
            throw new IllegalArgumentException("HEIGHT must be positive");
        }
        final int nbits = 32-Integer.numberOfLeadingZeros(width) + 32-Integer.numberOfLeadingZeros(height);
        if (nbits > 31) {
            throw new IllegalArgumentException("WIDTH * HEIGHT is too large");
        }
        this.width = width;
        this.height = height;
    }

    public final void getRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height) {
        this.rgbCheck(argb.length, offset, scanLength, x, y, width, height);
        this.getRGBImpl(argb, offset, scanLength, x, y, width, height);
    }

    private native void getRGBImpl(int[] argb, int offset, int scanLength, int x, int y, int width, int height);

    public final void setRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height) {
        this.rgbCheck(argb.length, offset, scanLength, x, y, width, height);
        this.setRGBImpl(argb, offset, scanLength, x, y, width, height);
    }

    private native void setRGBImpl(int[] argb, int offset, int scanLength, int x, int y, int width, int height);

    private void rgbCheck(int arr_length, int offset, int scanLength, int x, int y, int width, int height) {
        if (x < 0 || x >= this.width) {
            throw new IllegalArgumentException("X is out of surface");
        }
        if (y < 0 || y >= this.height) {
            throw new IllegalArgumentException("Y is out of surface");
        }
        if (width < 0) {
            throw new IllegalArgumentException("WIDTH must be positive");
        }
        if (height < 0) {
            throw new IllegalArgumentException("HEIGHT must be positive");
        }
        if (x + width > this.width) {
            throw new IllegalArgumentException("X+WIDTH is out of surface");
        }
        if (y + height > this.height) {
            throw new IllegalArgumentException("Y+HEIGHT is out of surface");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("OFFSET must be positive");
        }
        if (scanLength < 0) {
            throw new IllegalArgumentException("SCAN-LENGTH must be positive");
        }
        if (scanLength < width) {
            throw new IllegalArgumentException("SCAN-LENGTH must be >= WIDTH");
        }
        final int nbits = 32-Integer.numberOfLeadingZeros(scanLength) + 32-Integer.numberOfLeadingZeros(height);
        if (nbits > 31) {
            throw new IllegalArgumentException("SCAN-LENGTH * HEIGHT is too large");
        }
        if ((offset + scanLength*(height-1) + width) > arr_length) {
            throw new IllegalArgumentException("STRIDE * HEIGHT exceeds length of data");
        }
    }

    protected void finalize() {
        this.nativeFinalize();
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

    private native void nativeFinalize();
}
