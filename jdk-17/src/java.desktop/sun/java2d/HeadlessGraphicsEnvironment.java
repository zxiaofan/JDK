/*
 * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Locale;

/**
 * Headless decorator implementation of a SunGraphicsEnvironment
 */
public final class HeadlessGraphicsEnvironment extends GraphicsEnvironment {

    private GraphicsEnvironment ge;

    public HeadlessGraphicsEnvironment(GraphicsEnvironment ge) {
        this.ge = ge;
    }

    @Override
    public GraphicsDevice[] getScreenDevices()
        throws HeadlessException {
        throw new HeadlessException();
    }

    @Override
    public GraphicsDevice getDefaultScreenDevice()
        throws HeadlessException {
        throw new HeadlessException();
    }

    @Override
    public Point getCenterPoint() throws HeadlessException {
        throw new HeadlessException();
    }

    @Override
    public Rectangle getMaximumWindowBounds() throws HeadlessException {
        throw new HeadlessException();
    }

    @Override
    public Graphics2D createGraphics(BufferedImage img) {
        return ge.createGraphics(img); }

    @Override
    public Font[] getAllFonts() { return ge.getAllFonts(); }

    @Override
    public String[] getAvailableFontFamilyNames() {
        return ge.getAvailableFontFamilyNames(); }

    @Override
    public String[] getAvailableFontFamilyNames(Locale l) {
        return ge.getAvailableFontFamilyNames(l);
    }
}
