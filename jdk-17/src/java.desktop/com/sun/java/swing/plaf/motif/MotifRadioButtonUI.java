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
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;

import sun.awt.AppContext;

/**
 * RadioButtonUI implementation for MotifRadioButtonUI
 *
 * @author Rich Schiavi
 */
public class MotifRadioButtonUI extends BasicRadioButtonUI {

    private static final Object MOTIF_RADIO_BUTTON_UI_KEY = new Object();

    protected Color focusColor;

    private boolean defaults_initialized = false;

    // ********************************
    //         Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent c) {
        AppContext appContext = AppContext.getAppContext();
        MotifRadioButtonUI motifRadioButtonUI =
                (MotifRadioButtonUI) appContext.get(MOTIF_RADIO_BUTTON_UI_KEY);
        if (motifRadioButtonUI == null) {
            motifRadioButtonUI = new MotifRadioButtonUI();
            appContext.put(MOTIF_RADIO_BUTTON_UI_KEY, motifRadioButtonUI);
        }
        return motifRadioButtonUI;
    }

    // ********************************
    //          Install Defaults
    // ********************************
    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        if(!defaults_initialized) {
            focusColor = UIManager.getColor(getPropertyPrefix() + "focus");
            defaults_initialized = true;
        }
    }

    protected void uninstallDefaults(AbstractButton b) {
        super.uninstallDefaults(b);
        defaults_initialized = false;
    }

    // ********************************
    //          Default Accessors
    // ********************************

    protected Color getFocusColor() {
        return focusColor;
    }

    // ********************************
    //         Paint Methods
    // ********************************
    protected void paintFocus(Graphics g, Rectangle t, Dimension d){
        g.setColor(getFocusColor());
        g.drawRect(0,0,d.width-1,d.height-1);
    }

}
