/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing;

import java.awt.Graphics;
import java.awt.Component;


/**
 * A small fixed size picture, typically used to decorate components.
 *
 * @see ImageIcon
 * @since 1.2
 */

public interface Icon
{
    /**
     * Draw the icon at the specified location.  Icon implementations
     * may use the Component argument to get properties useful for
     * painting, e.g. the foreground or background color.
     *
     * @param c  a {@code Component} to get properties useful for painting
     * @param g  the graphics context
     * @param x  the X coordinate of the icon's top-left corner
     * @param y  the Y coordinate of the icon's top-left corner
     */
    void paintIcon(Component c, Graphics g, int x, int y);

    /**
     * Returns the icon's width.
     *
     * @return an int specifying the fixed width of the icon.
     */
    int getIconWidth();

    /**
     * Returns the icon's height.
     *
     * @return an int specifying the fixed height of the icon.
     */
    int getIconHeight();
}
