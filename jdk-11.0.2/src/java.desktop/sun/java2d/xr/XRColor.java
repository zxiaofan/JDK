/*
 * Copyright (c) 2010, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.xr;

import java.awt.*;

/**
 * XRender color class.
 *
 * @author Clemens Eisserer
 */

public class XRColor {
    public static final XRColor FULL_ALPHA = new XRColor(0xffff, 0, 0, 0);
    public static final XRColor NO_ALPHA = new XRColor(0, 0, 0, 0);

    int red, green, blue, alpha;

    public XRColor() {
        red = 0;
        green = 0;
        blue = 0;
        alpha = 0;
    }

    public XRColor(int alpha, int red, int green, int blue) {
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public XRColor(Color color) {
        setColorValues(color);
    }

    public void setColorValues(Color color) {
        alpha = byteToXRColorValue(color.getAlpha());

        red = byteToXRColorValue(
                      (int)(color.getRed() * color.getAlpha() / 255.0));
        green = byteToXRColorValue(
                      (int)(color.getGreen() * color.getAlpha() / 255.0));
        blue = byteToXRColorValue(
                      (int)(color.getBlue() * color.getAlpha() / 255.0));
    }

    public static int[] ARGBPrePixelToXRColors(int[] pixels) {
        int[] colorValues = new int[pixels.length * 4];
        XRColor c = new XRColor();

        for (int i = 0; i < pixels.length; i++) {
            c.setColorValues(pixels[i]);
            colorValues[i * 4 + 0] = c.alpha;
            colorValues[i * 4 + 1] = c.red;
            colorValues[i * 4 + 2] = c.green;
            colorValues[i * 4 + 3] = c.blue;
        }

        return colorValues;
    }

    public void setColorValues(int pixel) {
        long pix = XRUtils.intToULong(pixel);
        alpha = (int) (((pix & 0xFF000000) >> 16) + 255);
        red = (int) (((pix & 0x00FF0000) >> 8) + 255);
        green = (int) (((pix & 0x0000FF00) >> 0) + 255);
        blue = (int) (((pix & 0x000000FF) << 8) + 255);

        if (alpha == 255) {
            alpha = 0;
        }
    }

    public static int byteToXRColorValue(int byteValue) {
        int xrValue = 0;

        if (byteValue != 0) {
            if (byteValue == 255) {
                xrValue = 0xffff;
            } else {
                xrValue = ((byteValue << 8) + 255);
            }
        }

        return xrValue;
    }

    public String toString(){
        return "A:"+alpha+"  R:"+red+"  G:"+green+" B:"+blue;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getAlpha() {
        return alpha;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
