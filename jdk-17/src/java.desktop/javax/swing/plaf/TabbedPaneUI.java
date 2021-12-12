/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import java.awt.Rectangle;
import javax.swing.JTabbedPane;

/**
 * Pluggable look and feel interface for JTabbedPane.
 *
 * @author Dave Moore
 * @author Amy Fowler
 */
public abstract class TabbedPaneUI extends ComponentUI {
    /**
     * Constructor for subclasses to call.
     */
    protected TabbedPaneUI() {}

    /**
     * Returns the tab for the coordinate.
     * @param pane the pane
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the tab for the coordinate
     */
    public abstract int tabForCoordinate(JTabbedPane pane, int x, int y);
    /**
     * Returns the rectangle for the tab bounds.
     * @param pane the pane
     * @param index the index
     * @return the rectangle for the tab bounds
     */
    public abstract Rectangle getTabBounds(JTabbedPane pane, int index);
    /**
     * Returns the tab run count.
     * @param pane the pane
     * @return the tab run count
     */
    public abstract int getTabRunCount(JTabbedPane pane);
}
