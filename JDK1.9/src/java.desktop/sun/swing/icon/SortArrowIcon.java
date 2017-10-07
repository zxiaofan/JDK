/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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
package sun.swing.icon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;

/**
 * Sorting icon.
 *
 */
@SuppressWarnings("serial") // JDK-implementation class
public class SortArrowIcon implements Icon, UIResource, Serializable {
    // Height of the arrow, the width is ARROW_HEIGHT
    private static final int ARROW_HEIGHT = 5;

    // Amount of pad to left of arrow
    private static final int X_PADDING = 7;

    // Sort direction
    private boolean ascending;

    // The Color to use, may be null indicating colorKey should be used
    private Color color;

    // If non-null indicates the color should come from the UIManager with
    // this key.
    private String colorKey;

    /**
     * Creates a <code>SortArrowIcon</code>.
     *
     * @param ascending if true, icon respresenting ascending sort, otherwise
     *        descending
     * @param color the color to render the icon
     */
    public SortArrowIcon(boolean ascending, Color color) {
        this.ascending = ascending;
        this.color = color;
        if (color == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a <code>SortArrowIcon</code>.
     *
     * @param ascending if true, icon respresenting ascending sort, otherwise
     *        descending
     * @param colorKey the key used to find color in UIManager
     */
    public SortArrowIcon(boolean ascending, String colorKey) {
        this.ascending = ascending;
        this.colorKey = colorKey;
        if (colorKey == null) {
            throw new IllegalArgumentException();
        }
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(getColor());
        int startX = X_PADDING + x + ARROW_HEIGHT / 2;
        if (ascending) {
            int startY = y;
            g.fillRect(startX, startY, 1, 1);
            for (int line = 1; line < ARROW_HEIGHT; line++) {
                g.fillRect(startX - line, startY + line,
                           line + line + 1, 1);
            }
        }
        else {
            int startY = y + ARROW_HEIGHT - 1;
            g.fillRect(startX, startY, 1, 1);
            for (int line = 1; line < ARROW_HEIGHT; line++) {
                g.fillRect(startX - line, startY - line,
                           line + line + 1, 1);
            }
        }
    }

    public int getIconWidth() {
        return X_PADDING + ARROW_HEIGHT * 2;
    }

    public int getIconHeight() {
        return ARROW_HEIGHT + 2;
    }

    private Color getColor() {
        if (color != null) {
            return color;
        }
        return UIManager.getColor(colorKey);
    }
}
