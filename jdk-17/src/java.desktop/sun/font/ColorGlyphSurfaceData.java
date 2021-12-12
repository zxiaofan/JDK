/*
 * Copyright 2021 JetBrains s.r.o.
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

package sun.font;

import sun.java2d.SurfaceData;

import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.image.Raster;

/**
 * SurfaceData view for a color glyph from glyph cache
 */
class ColorGlyphSurfaceData extends SurfaceData {
    ColorGlyphSurfaceData() {
        super(State.UNTRACKABLE);
        initOps();
    }

    private native void initOps();

    native void setCurrentGlyph(long imgPtr);

    @Override
    public SurfaceData getReplacement() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Raster getRaster(int x, int y, int w, int h) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getDestination() {
        throw new UnsupportedOperationException();
    }
}
