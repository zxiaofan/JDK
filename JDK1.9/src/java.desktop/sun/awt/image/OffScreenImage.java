/*
 * Copyright (c) 1996, 2007, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.image;

import java.awt.Component;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;

/**
 * This is a special variant of BufferedImage that keeps a reference to
 * a Component.  The Component's foreground and background colors and
 * default font are used as the defaults for this image.
 */
public class OffScreenImage extends BufferedImage {

    protected Component c;
    private OffScreenImageSource osis;
    private Font defaultFont;

    /**
     * Constructs an OffScreenImage given a color model and tile,
     * for offscreen rendering to be used with a given component.
     * The component is used to obtain the foreground color, background
     * color and font.
     */
    public OffScreenImage(Component c, ColorModel cm, WritableRaster raster,
                          boolean isRasterPremultiplied)
    {
        super(cm, raster, isRasterPremultiplied, null);
        this.c = c;
        initSurface(raster.getWidth(), raster.getHeight());
    }

    public Graphics getGraphics() {
        return createGraphics();
    }

    public Graphics2D createGraphics() {
        if (c == null) {
            GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            return env.createGraphics(this);
        }

        Color bg = c.getBackground();
        if (bg == null) {
            bg = SystemColor.window;
        }

        Color fg = c.getForeground();
        if (fg == null) {
            fg = SystemColor.windowText;
        }

        Font font = c.getFont();
        if (font == null) {
            if (defaultFont == null) {
                defaultFont = new Font("Dialog", Font.PLAIN, 12);
            }
            font = defaultFont;
        }

        return new SunGraphics2D(SurfaceData.getPrimarySurfaceData(this),
                                 fg, bg, font);
    }

    private void initSurface(int width, int height) {
        Graphics2D g2 = createGraphics();
        try {
            g2.clearRect(0, 0, width, height);
        } finally {
            g2.dispose();
        }
    }

    public ImageProducer getSource() {
        if (osis == null) {
            osis = new OffScreenImageSource(this);
        }
        return osis;
    }
}
