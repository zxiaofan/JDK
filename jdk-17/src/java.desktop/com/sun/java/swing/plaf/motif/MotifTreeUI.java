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
import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreeCellRenderer;

/**
 * Motif rendition of the tree component.
 *
 * @author Jeff Dinkins
 */
public class MotifTreeUI extends BasicTreeUI
{
    static final int HALF_SIZE = 7;
    static final int SIZE = 14;

    /**
     * creates a UI object to represent a Motif Tree widget
     */
    public MotifTreeUI() {
        super();
    }

    public void installUI(JComponent c) {
        super.installUI(c);
    }

    // BasicTreeUI overrides

    protected void paintVerticalLine( Graphics g, JComponent c, int x, int top, int bottom )
      {
          if (tree.getComponentOrientation().isLeftToRight()) {
              g.fillRect( x, top, 2, bottom - top + 2 );
          } else {
              g.fillRect( x - 1, top, 2, bottom - top + 2 );
          }
      }

    protected void paintHorizontalLine( Graphics g, JComponent c, int y, int left, int right )
      {
          g.fillRect( left, y, right - left + 1, 2 );
      }


    /**
     * The minus sign button icon.
     */
    @SuppressWarnings("serial") // Same-version serialization only
    public static class MotifExpandedIcon implements Icon, Serializable {
        static Color bg;
        static Color fg;
        static Color highlight;
        static Color shadow;

        public MotifExpandedIcon() {
            bg = UIManager.getColor("Tree.iconBackground");
            fg = UIManager.getColor("Tree.iconForeground");
            highlight = UIManager.getColor("Tree.iconHighlight");
            shadow = UIManager.getColor("Tree.iconShadow");
        }

        public static Icon createExpandedIcon() {
            return new MotifExpandedIcon();
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(highlight);
            g.drawLine(x, y, x+SIZE-1, y);
            g.drawLine(x, y+1, x, y+SIZE-1);

            g.setColor(shadow);
            g.drawLine(x+SIZE-1, y+1, x+SIZE-1, y+SIZE-1);
            g.drawLine(x+1, y+SIZE-1, x+SIZE-1, y+SIZE-1);

            g.setColor(bg);
            g.fillRect(x+1, y+1, SIZE-2, SIZE-2);

            g.setColor(fg);
            g.drawLine(x+3, y+HALF_SIZE-1, x+SIZE-4, y+HALF_SIZE-1);
            g.drawLine(x+3, y+HALF_SIZE, x+SIZE-4, y+HALF_SIZE);
        }

        public int getIconWidth() { return SIZE; }
        public int getIconHeight() { return SIZE; }
    }

    /**
     * The plus sign button icon.
     */
    @SuppressWarnings("serial") // Same-version serialization only
    public static class MotifCollapsedIcon extends MotifExpandedIcon {
        public static Icon createCollapsedIcon() {
            return new MotifCollapsedIcon();
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            super.paintIcon(c, g, x, y);
            g.drawLine(x + HALF_SIZE-1, y + 3, x + HALF_SIZE-1, y + (SIZE - 4));
            g.drawLine(x + HALF_SIZE, y + 3, x + HALF_SIZE, y + (SIZE - 4));
        }
    }

    public static ComponentUI createUI(JComponent x) {
        return new MotifTreeUI();
    }

    /**
     * Returns the default cell renderer that is used to do the
     * stamping of each node.
     */
    public TreeCellRenderer createDefaultCellRenderer() {
        return new MotifTreeCellRenderer();
    }

}
