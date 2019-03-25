/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole;

import java.awt.event.*;

import javax.accessibility.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PlotterPanel extends BorderedComponent {
    Plotter plotter;

    public PlotterPanel(String labelStr, Plotter.Unit unit, boolean collapsible) {
        super(labelStr, new Plotter(unit), collapsible);

        this.plotter = (Plotter)comp;

        init();
    }

    public PlotterPanel(String labelStr) {
        super(labelStr, null);

        init();
    }

    public Plotter getPlotter() {
        return this.plotter;
    }

    public void setPlotter(Plotter plotter) {
        this.plotter = plotter;
        setComponent(plotter);
    }

    private void init() {
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
            }
        });
    }

    public JPopupMenu getComponentPopupMenu() {
        return (getPlotter() != null)? getPlotter().getComponentPopupMenu() : null;
    }

    public AccessibleContext getAccessibleContext() {
        if (accessibleContext == null) {
            accessibleContext = new AccessiblePlotterPanel();
        }
        return accessibleContext;
    }

    protected class AccessiblePlotterPanel extends AccessibleJComponent {
        public String getAccessibleName() {
            String name = null;
            if (getPlotter() != null) {
                name = getPlotter().getAccessibleContext().getAccessibleName();
            }
            if (name == null) {
                name = super.getAccessibleName();
            }
            return name;
        }
    }
}
