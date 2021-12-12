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

package javax.swing.plaf;

import javax.swing.JSplitPane;
import java.awt.Graphics;

/**
 * Pluggable look and feel interface for JSplitPane.
 *
 * @author Scott Violet
 */
public abstract class SplitPaneUI extends ComponentUI
{
    /**
     * Constructor for subclasses to call.
     */
    protected SplitPaneUI() {}

    /**
     * Messaged to relayout the JSplitPane based on the preferred size
     * of the children components.
     *
     * @param jc a {@code JSplitPane}
     */
    public abstract void resetToPreferredSizes(JSplitPane jc);

    /**
     * Sets the location of the divider to location.
     *
     * @param jc a {@code JSplitPane}
     * @param location an integer specifying the location of the divider
     */
    public abstract void setDividerLocation(JSplitPane jc, int location);

    /**
     * Returns the location of the divider.
     *
     * @param jc a {@code JSplitPane}
     * @return an integer specifying the location of the divider
     */
    public abstract int getDividerLocation(JSplitPane jc);

    /**
     * Returns the minimum possible location of the divider.
     *
     * @param jc a {@code JSplitPane}
     * @return and integer specifying the minimum location of the divider
     */
    public abstract int getMinimumDividerLocation(JSplitPane jc);

    /**
     * Returns the maximum possible location of the divider.
     *
     * @param jc a {@code JSplitPane}
     * @return an integer specifying the maximum location of the divider
     */
    public abstract int getMaximumDividerLocation(JSplitPane jc);

    /**
     * Messaged after the JSplitPane the receiver is providing the look
     * and feel for paints its children.
     *
     * @param jc a {@code JSplitPane}
     * @param g the {@code Graphics} context
     */
    public abstract void finishedPaintingChildren(JSplitPane jc, Graphics g);
}
