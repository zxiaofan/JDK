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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;

import sun.swing.SwingUtilities2;

/**
 * A Motif {@literal L&F} implementation of PopupMenuUI.
 *
 * @author Georges Saab
 * @author Rich Schiavi
 */
public class MotifPopupMenuUI extends BasicPopupMenuUI {
    private static Border border = null;
    private Font titleFont = null;

    public static ComponentUI createUI(JComponent x) {
        return new MotifPopupMenuUI();
    }

    /* This has to deal with the fact that the title may be wider than
       the widest child component.
       */
    public Dimension getPreferredSize(JComponent c) {
        LayoutManager layout = c.getLayout();
        Dimension d = layout.preferredLayoutSize(c);
        String title = ((JPopupMenu)c).getLabel();
        if (titleFont == null) {
            UIDefaults table = UIManager.getLookAndFeelDefaults();
            titleFont = table.getFont("PopupMenu.font");
        }
        FontMetrics fm = c.getFontMetrics(titleFont);
        int         stringWidth = 0;

        if (title!=null) {
            stringWidth += SwingUtilities2.stringWidth(c, fm, title);
        }

        if (d.width < stringWidth) {
            d.width = stringWidth + 8;
            Insets i = c.getInsets();
            if (i!=null) {
                d.width += i.left + i.right;
            }
            if (border != null) {
                i = border.getBorderInsets(c);
                d.width += i.left + i.right;
            }

            return d;
        }
        return null;
    }

    protected ChangeListener createChangeListener(JPopupMenu m) {
        return new ChangeListener() {
            public void stateChanged(ChangeEvent e) {}
        };
    }

    @SuppressWarnings("deprecation")
    public boolean isPopupTrigger(MouseEvent e) {
        return ((e.getID()==MouseEvent.MOUSE_PRESSED)
                && ((e.getModifiers() & MouseEvent.BUTTON3_MASK)!=0));
    }
}
