/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
 
package javax.swing.plaf.synth;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.border.*;
import java.io.Serializable;


/**
 * Synth's CheckBoxMenuItemUI.
 *
 * @version %I% %G%
 * @author Leif Samuelsson
 * @author Georges Saab
 * @author David Karlton
 * @author Arnaud Weber
 */
class SynthCheckBoxMenuItemUI extends SynthMenuItemUI {

    public static ComponentUI createUI(JComponent c) {
        return new SynthCheckBoxMenuItemUI();
    }

    protected String getPropertyPrefix() {
	return "CheckBoxMenuItem";
    }

    public void processMouseEvent(JMenuItem item, MouseEvent e,
				  MenuElement path[], MenuSelectionManager manager) {
        Point p = e.getPoint();
        if (p.x >= 0 && p.x < item.getWidth() && p.y >= 0 && p.y < item.getHeight()) {
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                manager.clearSelectedPath();
                item.doClick(0);
            } else {
                manager.setSelectedPath(path);
	    }
        } else if (item.getModel().isArmed()) {
	    int c = path.length - 1;
            MenuElement newPath[] = new MenuElement[c];
            for (int i = 0; i < c; i++) {
                newPath[i] = path[i];
	    }
            manager.setSelectedPath(newPath);
        }
    }

    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        context.getPainter().paintCheckBoxMenuItemBackground(context, g, 0, 0,
                                                  c.getWidth(), c.getHeight());
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintCheckBoxMenuItemBorder(context, g, x, y, w, h);
    }
}
