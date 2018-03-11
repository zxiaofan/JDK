/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.plaf.synth;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicTextAreaUI;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import sun.swing.plaf.synth.SynthUI;

/**
 * Provides the look and feel for a plain text editor in the
 * Synth look and feel. In this implementation the default UI
 * is extended to act as a simple view factory.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans<sup><font size="-2">TM</font></sup>
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author  Shannon Hickey
 * @version %I% %G%
 */
class SynthTextAreaUI extends BasicTextAreaUI implements SynthUI, FocusListener {
    private SynthStyle style;

    /**
     * Creates a UI for a JTextArea.
     *
     * @param ta a text area
     * @return the UI
     */
    public static ComponentUI createUI(JComponent ta) {
        return new SynthTextAreaUI();
    }

    public void focusGained(FocusEvent e) {
        getComponent().repaint();
    }

    public void focusLost(FocusEvent e) {
        getComponent().repaint();
    }
    
    protected void installDefaults() {
        // Installs the text cursor on the component
        super.installDefaults();
        updateStyle((JTextComponent)getComponent());
        getComponent().addFocusListener(this);
    }

    protected void uninstallDefaults() {
        SynthContext context = getContext(getComponent(), ENABLED);

        getComponent().putClientProperty("caretAspectRatio", null);
        getComponent().removeFocusListener(this);

        style.uninstallDefaults(context);
        context.dispose();
        style = null;
        super.uninstallDefaults();
    }

    public void installUI(JComponent c) {
        super.installUI(c);
    }

    private void updateStyle(JTextComponent comp) {
        SynthContext context = getContext(comp, ENABLED);
        SynthStyle oldStyle = style;

        style = SynthLookAndFeel.updateStyle(context, this);

        if (style != oldStyle) {
            SynthTextFieldUI.updateStyle(comp, context, getPropertyPrefix());

            if (oldStyle != null) {
                uninstallKeyboardActions();
                installKeyboardActions();
            }
        }
        context.dispose();
    }

    public SynthContext getContext(JComponent c) {
        return getContext(c, getComponentState(c));
    }

    private SynthContext getContext(JComponent c, int state) {
        return SynthContext.getContext(SynthContext.class, c,
                    SynthLookAndFeel.getRegion(c), style, state);
    }

    private int getComponentState(JComponent c) {
        return SynthLookAndFeel.getComponentState(c);
    }

    public void update(Graphics g, JComponent c) {
        SynthContext context = getContext(c);

        SynthLookAndFeel.update(context, g);
        context.getPainter().paintTextAreaBackground(context,
                          g, 0, 0, c.getWidth(), c.getHeight());
        paint(context, g);
        context.dispose();
    }

    protected void paint(SynthContext context, Graphics g) {
        super.paint(g, getComponent());
    }

    protected void paintBackground(Graphics g) {
        // Overriden to do nothing, all our painting is done from update/paint.
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintTextAreaBorder(context, g, x, y, w, h);
    }

    /**
     * This method gets called when a bound property is changed
     * on the associated JTextComponent.  This is a hook
     * which UI implementations may change to reflect how the
     * UI displays bound properties of JTextComponent subclasses.
     * This is implemented to rebuild the View when the
     * <em>WrapLine</em> or the <em>WrapStyleWord</em> property changes.
     *
     * @param evt the property change event
     */
    protected void propertyChange(PropertyChangeEvent evt) {
        if (SynthLookAndFeel.shouldUpdateStyle(evt)) {
            updateStyle((JTextComponent)evt.getSource());
        }
        super.propertyChange(evt);
    }
}
