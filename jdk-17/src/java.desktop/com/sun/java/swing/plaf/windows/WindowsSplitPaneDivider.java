/*
 * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * Divider used for Windows split pane.
 *
 * @author Jeff Dinkins
 */
@SuppressWarnings("serial") // Superclass is not serializable across versions
public class WindowsSplitPaneDivider extends BasicSplitPaneDivider
{

    /**
     * Creates a new Windows SplitPaneDivider
     */
    public WindowsSplitPaneDivider(BasicSplitPaneUI ui) {
        super(ui);
    }

    /**
      * Paints the divider.
      */
    public void paint(Graphics g) {
        Color bgColor = (splitPane.hasFocus()) ?
                            UIManager.getColor("SplitPane.shadow") :
                            getBackground();
        Dimension size = getSize();

        if(bgColor != null) {
            g.setColor(bgColor);
            g.fillRect(0, 0, size.width, size.height);
        }
        super.paint(g);
    }
}
