/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.plaf.synth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*;
import javax.swing.border.*;

/**
 * Synth's RadioButtonMenuItemUI.
 *
 * @version %I%, %G%
 * @author Georges Saab
 * @author David Karlton
 */
class SynthRadioButtonMenuItemUI extends SynthMenuItemUI {
    public static ComponentUI createUI(JComponent b) {
        return new SynthRadioButtonMenuItemUI();
    }

    protected String getPropertyPrefix() {
	return "RadioButtonMenuItem";
    }
    
    public void processMouseEvent(JMenuItem item,MouseEvent e,MenuElement path[],MenuSelectionManager manager) {
        Point p = e.getPoint();
        if(p.x >= 0 && p.x < item.getWidth() &&
           p.y >= 0 && p.y < item.getHeight()) {
            if(e.getID() == MouseEvent.MOUSE_RELEASED) {
                manager.clearSelectedPath();
                item.doClick(0);
                item.setArmed(false);
            } else
                manager.setSelectedPath(path);
        } else if(item.getModel().isArmed()) {
            MenuElement newPath[] = new MenuElement[path.length-1];
            int i,c;
            for(i=0,c=path.length-1;i<c;i++)
                newPath[i] = path[i];
            manager.setSelectedPath(newPath);
        }
    }

    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        context.getPainter().paintRadioButtonMenuItemBackground(context, g, 0,
                             0, c.getWidth(), c.getHeight());
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintRadioButtonMenuItemBorder(context, g, x,
                                                            y, w, h);
    }
}
