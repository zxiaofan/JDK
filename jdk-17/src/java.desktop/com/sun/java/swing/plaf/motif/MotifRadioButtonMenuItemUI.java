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

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import sun.swing.SwingUtilities2;

/**
 * MotifRadioButtonMenuItem implementation
 *
 * @author Georges Saab
 * @author Rich Schiavi
 */
public class MotifRadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI
{
    protected ChangeListener changeListener;

    public static ComponentUI createUI(JComponent b) {
        return new MotifRadioButtonMenuItemUI();
    }

    protected void installListeners() {
        super.installListeners();
        changeListener = createChangeListener(menuItem);
        menuItem.addChangeListener(changeListener);
    }

    protected void uninstallListeners() {
        super.uninstallListeners();
        menuItem.removeChangeListener(changeListener);
    }

    protected ChangeListener createChangeListener(JComponent c) {
        return new ChangeHandler();
    }

    @SuppressWarnings("serial") // Same-version serialization only
    protected class ChangeHandler implements ChangeListener, Serializable {
        public void stateChanged(ChangeEvent e) {
            JMenuItem c = (JMenuItem)e.getSource();
            LookAndFeel.installProperty(c, "borderPainted", c.isArmed());
        }
    }

    protected MouseInputListener createMouseInputListener(JComponent c) {
        return new MouseInputHandler();
    }


    protected class MouseInputHandler implements MouseInputListener {
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {
            MenuSelectionManager manager = MenuSelectionManager.defaultManager();
            manager.setSelectedPath(getPath());
        }
        public void mouseReleased(MouseEvent e) {
            MenuSelectionManager manager =
                MenuSelectionManager.defaultManager();
            JMenuItem menuItem = (JMenuItem)e.getComponent();
            Point p = e.getPoint();
            if(p.x >= 0 && p.x < menuItem.getWidth() &&
               p.y >= 0 && p.y < menuItem.getHeight()) {
                String property = "RadioButtonMenuItem.doNotCloseOnMouseClick";
                if (!SwingUtilities2.getBoolean(menuItem, property)) {
                    manager.clearSelectedPath();
                }
                menuItem.doClick(0);
            } else {
                manager.processMouseEvent(e);
            }
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseDragged(MouseEvent e) {
            MenuSelectionManager.defaultManager().processMouseEvent(e);
        }
        public void mouseMoved(MouseEvent e) { }
    }

}
