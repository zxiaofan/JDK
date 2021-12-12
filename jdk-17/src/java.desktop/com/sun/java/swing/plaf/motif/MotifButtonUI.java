/*
 * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.swing.plaf.motif;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;

import sun.awt.AppContext;

/**
 * MotifButton implementation
 *
 * @author Rich Schiavi
 */
public class MotifButtonUI extends BasicButtonUI {

    protected Color selectColor;

    private boolean defaults_initialized = false;

    private static final Object MOTIF_BUTTON_UI_KEY = new Object();

    // ********************************
    //          Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent c) {
        AppContext appContext = AppContext.getAppContext();
        MotifButtonUI motifButtonUI =
                (MotifButtonUI) appContext.get(MOTIF_BUTTON_UI_KEY);
        if (motifButtonUI == null) {
            motifButtonUI = new MotifButtonUI();
            appContext.put(MOTIF_BUTTON_UI_KEY, motifButtonUI);
        }
        return motifButtonUI;
    }

    // ********************************
    //         Create Listeners
    // ********************************
    protected BasicButtonListener createButtonListener(AbstractButton b){
        return new MotifButtonListener(b);
    }

    // ********************************
    //          Install Defaults
    // ********************************
    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        if(!defaults_initialized) {
            selectColor = UIManager.getColor(getPropertyPrefix() + "select");
            defaults_initialized = true;
        }
        LookAndFeel.installProperty(b, "opaque", Boolean.FALSE);
    }

    protected void uninstallDefaults(AbstractButton b) {
        super.uninstallDefaults(b);
        defaults_initialized = false;
    }

    // ********************************
    //          Default Accessors
    // ********************************

    protected Color getSelectColor() {
        return selectColor;
    }

    // ********************************
    //          Paint Methods
    // ********************************
    public void paint(Graphics g, JComponent c) {
        fillContentArea( g, (AbstractButton)c , c.getBackground() );
        super.paint(g,c);
    }

    // Overridden to ensure we don't paint icon over button borders.
    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        Shape oldClip = g.getClip();
        Rectangle newClip =
            AbstractBorder.getInteriorRectangle(c, c.getBorder(), 0, 0,
                                                c.getWidth(), c.getHeight());

        Rectangle r = oldClip.getBounds();
        newClip =
            SwingUtilities.computeIntersection(r.x, r.y, r.width, r.height,
                                               newClip);
        g.setClip(newClip);
        super.paintIcon(g, c, iconRect);
        g.setClip(oldClip);
    }

    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect){
        // focus painting is handled by the border
    }

    protected void paintButtonPressed(Graphics g, AbstractButton b) {

        fillContentArea( g, b , selectColor );

    }

    protected void fillContentArea( Graphics g, AbstractButton b, Color fillColor) {

        if (b.isContentAreaFilled()) {
            Insets margin = b.getMargin();
            Insets insets = b.getInsets();
            Dimension size = b.getSize();
            g.setColor(fillColor);
            g.fillRect(insets.left - margin.left,
                       insets.top - margin.top,
                       size.width - (insets.left-margin.left) - (insets.right - margin.right),
                       size.height - (insets.top-margin.top) - (insets.bottom - margin.bottom));
        }
    }
}
