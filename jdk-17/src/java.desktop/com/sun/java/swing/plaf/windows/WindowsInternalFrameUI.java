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

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.DesktopManager;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import static com.sun.java.swing.plaf.windows.TMSchema.Part;
import static com.sun.java.swing.plaf.windows.TMSchema.State;
import static com.sun.java.swing.plaf.windows.XPStyle.Skin;

/**
 * Windows rendition of the component.
 */
public class WindowsInternalFrameUI extends BasicInternalFrameUI
{
    XPStyle xp = XPStyle.getXP();

    public void installDefaults() {
        super.installDefaults();

        if (xp != null) {
            frame.setBorder(new XPBorder());
        } else {
            frame.setBorder(UIManager.getBorder("InternalFrame.border"));
        }
    }

    public void installUI(JComponent c)   {
        super.installUI(c);

        LookAndFeel.installProperty(c, "opaque",
                                    xp == null? Boolean.TRUE : Boolean.FALSE);
    }

    public void uninstallDefaults() {
        frame.setBorder(null);
        super.uninstallDefaults();
    }

    public static ComponentUI createUI(JComponent b)    {
        return new WindowsInternalFrameUI((JInternalFrame)b);
    }

    public WindowsInternalFrameUI(JInternalFrame w){
        super(w);
    }

    protected DesktopManager createDesktopManager(){
        return new WindowsDesktopManager();
    }

    protected JComponent createNorthPane(JInternalFrame w) {
        titlePane = new WindowsInternalFrameTitlePane(w);
        return titlePane;
    }

    @SuppressWarnings("serial") // Superclass is not serializable across versions
    private class XPBorder extends AbstractBorder {
        private Skin leftSkin   = xp.getSkin(frame, Part.WP_FRAMELEFT);
        private Skin rightSkin  = xp.getSkin(frame, Part.WP_FRAMERIGHT);
        private Skin bottomSkin = xp.getSkin(frame, Part.WP_FRAMEBOTTOM);

        /**
         * @param x the x position of the painted border
         * @param y the y position of the painted border
         * @param width the width of the painted border
         * @param height the height of the painted border
         */
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            State state = ((JInternalFrame)c).isSelected() ? State.ACTIVE : State.INACTIVE;
            int topBorderHeight  = (titlePane != null) ? titlePane.getSize().height : 0;

            bottomSkin.paintSkin(g, 0, height-bottomSkin.getHeight(),
                                 width, bottomSkin.getHeight(),
                                 state);

            leftSkin.paintSkin(g, 0, topBorderHeight-1,
                               leftSkin.getWidth(), height-topBorderHeight-bottomSkin.getHeight()+2,
                               state);

            rightSkin.paintSkin(g, width-rightSkin.getWidth(), topBorderHeight-1,
                                rightSkin.getWidth(), height-topBorderHeight-bottomSkin.getHeight()+2,
                                state);

        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.top    = 4;
            insets.left   = leftSkin.getWidth();
            insets.right  = rightSkin.getWidth();
            insets.bottom = bottomSkin.getHeight();

            return insets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    }

}
