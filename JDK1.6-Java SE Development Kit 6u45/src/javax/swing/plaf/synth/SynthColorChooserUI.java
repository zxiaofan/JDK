/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.plaf.synth;


import javax.swing.*;
import javax.swing.colorchooser.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicColorChooserUI;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import sun.swing.plaf.synth.SynthUI;


/**
 * Synth's ColorChooserUI.
 * 
 * @version %I%, %G%
 * @author Tom Santos
 * @author Steve Wilson
 */
class SynthColorChooserUI extends BasicColorChooserUI implements
        PropertyChangeListener, SynthUI {
    private SynthStyle style;

    public static ComponentUI createUI(JComponent c) {
	return new SynthColorChooserUI();
    }

    protected AbstractColorChooserPanel[] createDefaultChoosers() {
        SynthContext context = getContext(chooser, ENABLED);
        AbstractColorChooserPanel[] panels = (AbstractColorChooserPanel[])
                     context.getStyle().get(context, "ColorChooser.panels");
        context.dispose();

        if (panels == null) {
            panels = ColorChooserComponentFactory.getDefaultChooserPanels();
        }
	return panels;
    }

    protected void installDefaults() {
        super.installDefaults();
        updateStyle(chooser);
    }

    private void updateStyle(JComponent c) {
        SynthContext context = getContext(c, ENABLED);
        style = SynthLookAndFeel.updateStyle(context, this);
        context.dispose();
    }

    protected void uninstallDefaults() {
        SynthContext context = getContext(chooser, ENABLED);

        style.uninstallDefaults(context);
        context.dispose();
        style = null;
        super.uninstallDefaults();
    }

    protected void installListeners() {
        super.installListeners();
        chooser.addPropertyChangeListener(this);
    }

    protected void uninstallListeners() {
        chooser.removePropertyChangeListener(this);
        super.uninstallListeners();
    }

    public SynthContext getContext(JComponent c) {
        return getContext(c, getComponentState(c));
    }

    private SynthContext getContext(JComponent c, int state) {
        return SynthContext.getContext(SynthContext.class, c,
                    SynthLookAndFeel.getRegion(c), style, state);
    }

    private Region getRegion(JComponent c) {
        return SynthLookAndFeel.getRegion(c);
    }

    private int getComponentState(JComponent c) {
        return SynthLookAndFeel.getComponentState(c);
    }

    public void update(Graphics g, JComponent c) {
        SynthContext context = getContext(c);

        SynthLookAndFeel.update(context, g);
        context.getPainter().paintColorChooserBackground(context, g, 0, 0,
                                                  c.getWidth(), c.getHeight());
        paint(context, g);
        context.dispose();
    }

    public void paint(Graphics g, JComponent c) {
        SynthContext context = getContext(c);

        paint(context, g);
        context.dispose();
    }

    protected void paint(SynthContext context, Graphics g) {
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintColorChooserBorder(context, g, x, y,w,h);
    }

    public void propertyChange(PropertyChangeEvent e) {
        if (SynthLookAndFeel.shouldUpdateStyle(e)) {
            updateStyle((JColorChooser)e.getSource());
        }
    }
}
