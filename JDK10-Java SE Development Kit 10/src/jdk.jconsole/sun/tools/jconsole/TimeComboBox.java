/*
 * Copyright (c) 2004, 2006, Oracle and/or its affiliates. All rights reserved.
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
import java.beans.*;
import java.util.*;

import javax.swing.*;

/**
 * A combo box to control the visible time range for one or more Plotter components.
 * When used with two or more Plotters, it also acts to coordinate the range between
 * them.
 */
@SuppressWarnings("serial")
public class TimeComboBox extends JComboBox<String> implements ItemListener, PropertyChangeListener {
    private ArrayList<Plotter> plotters = new ArrayList<Plotter>();

    public TimeComboBox(Plotter... plotterArray) {
        super(Plotter.rangeNames);

        addItemListener(this);

        if (plotterArray != null && plotterArray.length > 0) {
            plotters.addAll(Arrays.asList(plotterArray));
            selectValue(plotterArray[0].getViewRange());
            for (Plotter plotter : plotters) {
                plotter.addPropertyChangeListener(this);
            }
        }
    }

    public void addPlotter(Plotter plotter) {
        plotters.add(plotter);
        if (plotters.size() == 1) {
            selectValue(plotter.getViewRange());
        }
        plotter.addPropertyChangeListener(this);
    }

    public void itemStateChanged(ItemEvent ev) {
        for (Plotter plotter : plotters) {
            plotter.setViewRange(Plotter.rangeValues[getSelectedIndex()]);
        }
    }

    private void selectValue(int value) {
        // Set the selected value
        for (int i = 0; i < Plotter.rangeValues.length; i++) {
            if (Plotter.rangeValues[i] == value) {
                setSelectedItem(Plotter.rangeNames[i]);
            }
        }
        // Make sure all plotters show this value
        if (plotters.size() > 1) {
            for (Plotter plotter : plotters) {
                plotter.setViewRange(value);
            }
        }
    }

    public void propertyChange(PropertyChangeEvent ev) {
        if (ev.getPropertyName() == "viewRange") {
            selectValue((Integer)ev.getNewValue());
        }
    }
}
