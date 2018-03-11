/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.gtk;

import javax.swing.plaf.synth.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import com.sun.java.swing.plaf.gtk.GTKConstants.ArrowType;
import com.sun.java.swing.plaf.gtk.GTKConstants.ExpanderStyle;
import com.sun.java.swing.plaf.gtk.GTKConstants.Orientation;
import com.sun.java.swing.plaf.gtk.GTKConstants.PositionType;
import com.sun.java.swing.plaf.gtk.GTKConstants.ShadowType;
import sun.awt.UNIXToolkit;
import java.util.*;

/**
 * GTKEngine mirrors that of a a GtkStyleClass.
 *
 * @version %I%, %G%
 * @author Josh Outwater
 * @author Scott Violet
 */
public abstract class GTKEngine {
    final static GTKEngine INSTANCE;
    
    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        if (toolkit instanceof UNIXToolkit && UNIXToolkit.checkGTK()) {
            INSTANCE = new GTKNativeEngine();
        } else {
            INSTANCE = new GTKDefaultEngine();
        }
    }

    /** Representation of GtkSettings properties
     *  When we need more settings we can add them here and
     *  to all implementations of getGTKSetting
     */
    static enum Settings {
        GTK_FONT_NAME, 
        GTK_ICON_SIZES
    }
    
    /**
     * Paint a cached image identified by its size and a set of additional
     * arguments (usually include Region and state). If there's no such image
     * in the cache, or the engine does not do caching, return false.
     *
     * @return true if a cached image has been painted, false otherwise
     */
    public boolean paintCachedImage(Graphics g,
            int x, int y, int w, int h, Object... args) {
        return false;
    }

    /**
     * Notify engine that an object, identified by size and a set of additional
     * arguments, is about to be painted at specified location. Arguments
     * usually include Region and state.
     */
    public void startPainting(Graphics g,
            int x, int y, int w, int h, Object... args) {
    }

    /**
     * Notifies engine that a painting operation is complete.
     */ 
    public void finishPainting() {
    }

    public abstract void paintArrow(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType, ArrowType direction,
            String info, int x, int y, int w, int h);

    public abstract void paintBox(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String info, int x, int y, int w, int h);

    public abstract void paintBoxGap(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String info, int x, int y, int w, int h, PositionType boxGapType,
            int tabBegin, int size);

    public abstract void paintCheck(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String info, int x, int y, int w, int h);

    public abstract void paintExtension(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String info, int x, int y, int w, int h, PositionType placement,
            int tabIndex);

    public abstract void paintFlatBox(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String key, int x, int y, int w, int h, ColorType colorType);

    public abstract void paintFocus(Graphics g, SynthContext context,
            Region id, int state, String key, int x, int y, int w, int h);

    public abstract void paintHandle(Graphics g, SynthContext context,
            Region id, int paintState, ShadowType shadowType,
            String info, int x, int y, int w, int h, Orientation orientation);

    public abstract void paintOption(Graphics g, SynthContext context,
            Region id, int paintState, ShadowType shadowType,
            String info, int x, int y, int w, int h);

    public abstract void paintShadow(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String info, int x, int y, int w, int h);

    public abstract void paintExpander(Graphics g, SynthContext context,
            Region id, int state, ExpanderStyle expanderStyle,
            String info, int x, int y, int w, int h);

    public abstract void paintSlider(Graphics g, SynthContext context,
            Region id, int state, ShadowType shadowType,
            String info, int x, int y, int w, int h, Orientation orientation);

    public abstract void paintHline(Graphics g, SynthContext context,
            Region id, int state, String info, int x, int y, int w, int h);

    public abstract void paintVline(Graphics g, SynthContext context,
            Region id, int state, String info, int x, int y, int w, int h);

    public abstract void paintBackground(Graphics g, SynthContext context,
            Region id, int state, Color color, int x, int y, int w, int h);

    /**
     * Called when GTK theme is changed on the desktop
     */
    public void themeChanged() {
    }
    
    public Object getSetting(Settings property) {
        return null;
    }
}
