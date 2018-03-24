/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.paint;

import com.sun.prism.paint.Paint.Type;
import java.nio.ByteBuffer;

/**
 * An immutable color, represented by four floating point values.
 * The color components should be provided in non-premultiplied format.
 */
public final class Color extends Paint {

    public static final Color WHITE       = new Color(1f, 1f, 1f, 1f);
    public static final Color BLACK       = new Color(0f, 0f, 0f, 1f);
    public static final Color RED         = new Color(1f, 0f, 0f, 1f);
    public static final Color GREEN       = new Color(0f, 1f, 0f, 1f);
    public static final Color BLUE        = new Color(0f, 0f, 1f, 1f);
    public static final Color TRANSPARENT = new Color(0f, 0f, 0f, 0f);

    private final int argb;
    private final float r;
    private final float g;
    private final float b;
    private final float a;

    /**
     * Constructs a new {@code Color} instance.
     * The color components should be provided in non-premultiplied format.
     */
    public Color(float r, float g, float b, float a) {
        super(Type.COLOR, false, false);
        int ia = (int)(255.0 * a);
        int ir = (int)(255.0 * r * a);
        int ig = (int)(255.0 * g * a);
        int ib = (int)(255.0 * b * a);
        this.argb = (ia << 24) |(ir << 16) | (ig << 8) | (ib << 0);
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    /**
     * Returns this color value (in premultiplied form) packed into an integer
     * in ARGB order.
     */
    public int getIntArgbPre() {
        return argb;
    }

    /**
     * Stores the color components (in premultiplied form) of this
     * {@code Color} object into a byte array in RGBA order.
     */
    public void putRgbaPreBytes(byte[] arr, int offset) {
        arr[offset+0] = (byte)((argb >> 16) & 0xff);
        arr[offset+1] = (byte)((argb >>  8) & 0xff);
        arr[offset+2] = (byte)((argb      ) & 0xff);
        arr[offset+3] = (byte)((argb >> 24) & 0xff);
    }

    /**
     * Stores the color components (in premultiplied form) of this
     * {@code Color} object into the given ByteBuffer in BGRA order.
     */
    public void putBgraPreBytes(ByteBuffer buf) {
        buf.put((byte)((argb      ) & 0xff));
        buf.put((byte)((argb >>  8) & 0xff));
        buf.put((byte)((argb >> 16) & 0xff));
        buf.put((byte)((argb >> 24) & 0xff));
    }

    /**
     * Returns the red component of this {@code Color} in
     * non-premultiplied form.
     */
    public float getRed() {
        return r;
    }

    /**
     * Returns the red component of this {@code Color} in
     * premultiplied form.
     */
    public float getRedPremult() {
        return r*a;
    }

    /**
     * Returns the green component of this {@code Color} in
     * non-premultiplied form.
     */
    public float getGreen() {
        return g;
    }

    /**
     * Returns the green component of this {@code Color} in
     * premultiplied form.
     */
    public float getGreenPremult() {
        return g*a;
    }

    /**
     * Returns the blue component of this {@code Color} in
     * non-premultiplied form.
     */
    public float getBlue() {
        return b;
    }

    /**
     * Returns the blue component of this {@code Color} in
     * premultiplied form.
     */
    public float getBluePremult() {
        return b*a;
    }

    /**
     * Returns the alpha component of this {@code Color}.
     */
    public float getAlpha() {
        return a;
    }

    @Override
    public boolean isOpaque() {
        return a >= 1f;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Color)) {
            return false;
        }

        final Color other = (Color) obj;
        return
            this.r == other.r &&
            this.g == other.g &&
            this.b == other.b &&
            this.a == other.a;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Float.floatToIntBits(this.r);
        hash = 53 * hash + Float.floatToIntBits(this.g);
        hash = 53 * hash + Float.floatToIntBits(this.b);
        hash = 53 * hash + Float.floatToIntBits(this.a);
        return hash;
    }

    @Override
    public String toString() {
        return "Color[" +
            "r=" + r +
            ", g=" + g +
            ", b=" + b +
            ", a=" + a +
            "]";
    }
}
