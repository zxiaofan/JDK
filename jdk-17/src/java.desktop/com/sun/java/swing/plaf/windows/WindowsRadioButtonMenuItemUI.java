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

package com.sun.java.swing.plaf.windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import com.sun.java.swing.plaf.windows.TMSchema.Part;
import com.sun.java.swing.plaf.windows.TMSchema.State;

/**
 * Windows rendition of the component.
 */
public class WindowsRadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI {

    final WindowsMenuItemUIAccessor accessor =
        new WindowsMenuItemUIAccessor() {

           public JMenuItem getMenuItem() {
               return menuItem;
           }

           public State getState(JMenuItem menuItem) {
               return WindowsMenuItemUI.getState(this, menuItem);
           }

           public Part getPart(JMenuItem menuItem) {
               return WindowsMenuItemUI.getPart(this, menuItem);
           }
    };
    public static ComponentUI createUI(JComponent b) {
        return new WindowsRadioButtonMenuItemUI();
    }

    @Override
    protected  void paintBackground(Graphics g, JMenuItem menuItem,
            Color bgColor) {
        if (WindowsMenuItemUI.isVistaPainting()) {
            WindowsMenuItemUI.paintBackground(accessor, g, menuItem, bgColor);
            return;
        }
        super.paintBackground(g, menuItem, bgColor);
    }

    /**
     * Method which renders the text of the current menu item.
     *
     * @param g Graphics context
     * @param menuItem Current menu item to render
     * @param textRect Bounding rectangle to render the text.
     * @param text String to render
     * @since 1.4
     */
    protected void paintText(Graphics g, JMenuItem menuItem,
            Rectangle textRect, String text) {
        if (WindowsMenuItemUI.isVistaPainting()) {
            WindowsMenuItemUI.paintText(accessor, g, menuItem, textRect, text);
            return;
        }
        ButtonModel model = menuItem.getModel();
        Color oldColor = g.getColor();

        if(model.isEnabled() && model.isArmed()) {
            g.setColor(selectionForeground); // Uses protected field.
        }

        WindowsGraphicsUtils.paintText(g, menuItem, textRect, text, 0);

        g.setColor(oldColor);
    }
}
