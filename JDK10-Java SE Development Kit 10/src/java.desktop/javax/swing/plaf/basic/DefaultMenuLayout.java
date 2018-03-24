/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.basic;

import javax.swing.*;
import javax.swing.plaf.UIResource;

import java.awt.Container;
import java.awt.Dimension;

/**
 * The default layout manager for Popup menus and menubars.  This
 * class is an extension of BoxLayout which adds the UIResource tag
 * so that pluggable L&amp;Fs can distinguish it from user-installed
 * layout managers on menus.
 *
 * @author Georges Saab
 */
@SuppressWarnings("serial") // Superclass is not serializable across versions
public class DefaultMenuLayout extends BoxLayout implements UIResource {

    /**
     * Constructs a new instance of {@code DefaultMenuLayout}.
     *
     * @param target the container that needs to be laid out
     * @param axis the axis to lay out components along. Can be one of:
     *              {@code BoxLayout.X_AXIS},
     *              {@code BoxLayout.Y_AXIS},
     *              {@code BoxLayout.LINE_AXIS} or
     *              {@code BoxLayout.PAGE_AXIS}
     */
    public DefaultMenuLayout(Container target, int axis) {
        super(target, axis);
    }

    public Dimension preferredLayoutSize(Container target) {
        if (target instanceof JPopupMenu) {
            JPopupMenu popupMenu = (JPopupMenu) target;
            sun.swing.MenuItemLayoutHelper.clearUsedClientProperties(popupMenu);
            if (popupMenu.getComponentCount() == 0) {
                return new Dimension(0, 0);
            }
        }

        // Make BoxLayout recalculate cached preferred sizes
        super.invalidateLayout(target);

        return super.preferredLayoutSize(target);
    }
}
