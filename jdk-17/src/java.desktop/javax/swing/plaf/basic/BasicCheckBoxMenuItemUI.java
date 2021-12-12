/*
 * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

/**
 * BasicCheckboxMenuItem implementation
 *
 * @author Georges Saab
 * @author David Karlton
 * @author Arnaud Weber
 */
public class BasicCheckBoxMenuItemUI extends BasicMenuItemUI {

    /**
     * Constructs a {@code BasicCheckBoxMenuItemUI}.
     */
    public BasicCheckBoxMenuItemUI() {}

    /**
     * Constructs a new instance of {@code BasicCheckBoxMenuItemUI}.
     *
     * @param c a component
     * @return a new instance of {@code BasicCheckBoxMenuItemUI}
     */
    public static ComponentUI createUI(JComponent c) {
        return new BasicCheckBoxMenuItemUI();
    }

    protected String getPropertyPrefix() {
        return "CheckBoxMenuItem";
    }

    /**
     * Invoked when mouse event occurs.
     *
     * @param item a menu item
     * @param e a mouse event
     * @param path an array of {@code MenuElement}
     * @param manager an instance of {@code MenuSelectionManager}
     */
    public void processMouseEvent(JMenuItem item,MouseEvent e,MenuElement[] path,MenuSelectionManager manager) {
        Point p = e.getPoint();
        if(p.x >= 0 && p.x < item.getWidth() &&
           p.y >= 0 && p.y < item.getHeight()) {
            if(e.getID() == MouseEvent.MOUSE_RELEASED) {
                manager.clearSelectedPath();
                item.doClick(0);
            } else
                manager.setSelectedPath(path);
        } else if(item.getModel().isArmed()) {
            MenuElement[] newPath = new MenuElement[path.length-1];
            int i,c;
            for(i=0,c=path.length-1;i<c;i++)
                newPath[i] = path[i];
            manager.setSelectedPath(newPath);
        }
    }
}
