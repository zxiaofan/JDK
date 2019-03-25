/*
 * Copyright (c) 2006, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;


@SuppressWarnings("serial")
class OverviewTab extends Tab {
    JPanel gridPanel;
    TimeComboBox timeComboBox;

    public static String getTabName() {
        return Messages.OVERVIEW;
    }

    public OverviewTab(VMPanel vmPanel) {
        super(vmPanel, getTabName());

        setBorder(new EmptyBorder(4, 4, 3, 4));
        setLayout(new BorderLayout());

        JPanel topPanel     = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        topPanel.add(controlPanel, BorderLayout.CENTER);

        timeComboBox = new TimeComboBox();
        LabeledComponent lc = new LabeledComponent(Messages.TIME_RANGE_COLON,
                                                   Resources.getMnemonicInt(Messages.TIME_RANGE_COLON),
                                                   timeComboBox);
        controlPanel.add(lc);

        gridPanel = new JPanel(new AutoGridLayout(10, 6));
        gridPanel.setBorder(null);
        JScrollPane sp = new JScrollPane(gridPanel);
        sp.setBorder(null);
        sp.setViewportBorder(null);
        add(sp, BorderLayout.CENTER);

        // Note that panels are added on first update
    }


    public SwingWorker<?, ?> newSwingWorker() {
        return new SwingWorker<Object, Object>() {
            public Object doInBackground() {
                return null;
            }

            protected void done() {
                if (gridPanel.getComponentCount() == 0) {
                    final ArrayList<Plotter> plotters = new ArrayList<Plotter>();
                    for (Tab tab : vmPanel.getTabs()) {
                        OverviewPanel[] ops = tab.getOverviewPanels();
                        if (ops != null) {
                            for (OverviewPanel op : ops) {
                                gridPanel.add(op);
                                Plotter plotter = op.getPlotter();
                                if (plotter != null) {
                                    plotters.add(plotter);
                                    timeComboBox.addPlotter(plotter);
                                }
                            }
                        }
                    }
                    if (plotters.size() > 0) {
                        workerAdd(new Runnable() {
                            public void run() {
                                ProxyClient proxyClient = vmPanel.getProxyClient();
                                for (Plotter plotter : plotters) {
                                    proxyClient.addWeakPropertyChangeListener(plotter);
                                }
                            }
                        });
                    }
                    if (getParent() instanceof JTabbedPane) {
                        Utilities.updateTransparency((JTabbedPane)getParent());
                    }
                }
            }
        };
    }



    private class AutoGridLayout extends GridLayout {
        public AutoGridLayout(int hGap, int vGap) {
            super(0, 1, hGap, vGap);
        }

        public Dimension preferredLayoutSize(Container parent) {
            return minimumLayoutSize(parent);
        }

        public Dimension minimumLayoutSize(Container parent) {
            updateColumns(parent);
            return super.minimumLayoutSize(parent);
        }

        private void updateColumns(Container parent) {
            // Use the outer panel width, not the scrolling gridPanel
            int parentWidth = OverviewTab.this.getWidth();

            int columnWidth = 1;

            for (Component c : parent.getComponents()) {
                columnWidth = Math.max(columnWidth, c.getPreferredSize().width);
            }

            int n = parent.getComponentCount();
            int maxCols = Math.min(n, parentWidth / columnWidth);

            for (int columns = maxCols; columns >= 1; columns--) {
                if (columns == 1) {
                    setColumns(maxCols);
                } else if ((n % columns) == 0) {
                    setColumns(columns);
                    break;
                }
            }
        }
    }
}
