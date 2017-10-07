/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.imageio.plugins.common;

import java.awt.color.ColorSpace;

/**
 * Singleton class representing a simple, mathematically defined CMYK
 * color space.
 */
public final class SimpleCMYKColorSpace extends ColorSpace {
    private static final long serialVersionUID = 5387117338644522424L;

    private static ColorSpace theInstance = null;
    private ColorSpace csRGB;

    /** The exponent for gamma correction. */
    private static final double power1 = 1.0 / 2.4;

    public static final synchronized ColorSpace getInstance() {
        if(theInstance == null) {
            theInstance = new SimpleCMYKColorSpace();
        }
        return theInstance;
    }

    private SimpleCMYKColorSpace() {
        super(TYPE_CMYK, 4);
        csRGB = ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB);
    }

    public boolean equals(Object o) {
        return o != null && o instanceof SimpleCMYKColorSpace;
    }

    public int hashCode() {
        return theInstance.hashCode();
    }

    public float[] toRGB(float[] colorvalue) {
        float C = colorvalue[0];
        float M = colorvalue[1];
        float Y = colorvalue[2];
        float K = colorvalue[3];

        float K1 = 1.0F - K;

        // Convert from CMYK to linear RGB.
        float[] rgbvalue = new float[] {K1*(1.0F - C),
                                        K1*(1.0F - M),
                                        K1*(1.0F - Y)};

        // Convert from linear RGB to sRGB.
        for (int i = 0; i < 3; i++) {
            float v = rgbvalue[i];

            if (v < 0.0F) v = 0.0F;

            if (v < 0.0031308F) {
                rgbvalue[i] = 12.92F * v;
            } else {
                if (v > 1.0F) v = 1.0F;

                rgbvalue[i] = (float)(1.055 * Math.pow(v, power1) - 0.055);
            }
        }

        return rgbvalue;
    }

    public float[] fromRGB(float[] rgbvalue) {
        // Convert from sRGB to linear RGB.
        for (int i = 0; i < 3; i++) {
            if (rgbvalue[i] < 0.040449936F) {
                rgbvalue[i] /= 12.92F;
            } else {
                rgbvalue[i] =
                (float)(Math.pow((rgbvalue[i] + 0.055)/1.055, 2.4));
            }
        }

        // Convert from linear RGB to CMYK.
        float C = 1.0F - rgbvalue[0];
        float M = 1.0F - rgbvalue[1];
        float Y = 1.0F - rgbvalue[2];
        float K = Math.min(C, Math.min(M, Y));

        // If K == 1.0F, then C = M = Y = 1.0F.
        if(K != 1.0F) {
            float K1 = 1.0F - K;

            C = (C - K)/K1;
            M = (M - K)/K1;
            Y = (Y - K)/K1;
        } else {
            C = M = Y = 0.0F;
        }

        return new float[] {C, M, Y, K};
    }

    public float[] toCIEXYZ(float[] colorvalue) {
        return csRGB.toCIEXYZ(toRGB(colorvalue));
    }

    public float[] fromCIEXYZ(float[] xyzvalue) {
        return fromRGB(csRGB.fromCIEXYZ(xyzvalue));
    }
}
