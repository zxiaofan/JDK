/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.plaf.synth;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicToolTipUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.text.View;
import sun.swing.plaf.synth.SynthUI;


/**
 * Synth's ToolTipUI.
 *
 * @version %I%, %G%
 * @author Joshua Outwater
 */
class SynthToolTipUI extends BasicToolTipUI implements PropertyChangeListener,
               SynthUI {
    private SynthStyle style;


    public static ComponentUI createUI(JComponent c) {
        return new SynthToolTipUI();
    }

    protected void installDefaults(JComponent c) {
        updateStyle(c);
    }

    private void updateStyle(JComponent c) {
        SynthContext context = getContext(c, ENABLED);
        style = SynthLookAndFeel.updateStyle(context, this);
        context.dispose();
    }
    
    protected void uninstallDefaults(JComponent c) {
        SynthContext context = getContext(c, ENABLED);
        style.uninstallDefaults(context);
        context.dispose();
        style = null;
    }

    protected void installListeners(JComponent c) {
        c.addPropertyChangeListener(this);
    }

    protected void uninstallListeners(JComponent c) {
        c.removePropertyChangeListener(this);
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
        JComponent comp = ((JToolTip)c).getComponent();

        if (comp != null && !comp.isEnabled()) {
            return DISABLED;
        }
        return SynthLookAndFeel.getComponentState(c);
    }

    public void update(Graphics g, JComponent c) {
        SynthContext context = getContext(c);

        SynthLookAndFeel.update(context, g);
        context.getPainter().paintToolTipBackground(context,
                          g, 0, 0, c.getWidth(), c.getHeight());
        paint(context, g);
        context.dispose();
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintToolTipBorder(context, g, x, y, w, h);
    }

    public void paint(Graphics g, JComponent c) {
        SynthContext context = getContext(c);

        paint(context, g);
        context.dispose();
    }

    protected void paint(SynthContext context, Graphics g) {
        JToolTip tip = (JToolTip)context.getComponent();
	String tipText = tip.getToolTipText();

        Insets insets = tip.getInsets();
	View v = (View)tip.getClientProperty(BasicHTML.propertyKey);
	if (v != null) {
            Rectangle paintTextR = new Rectangle(insets.left, insets.top,
                  tip.getWidth() - (insets.left + insets.right),
                  tip.getHeight() - (insets.top + insets.bottom));
	    v.paint(g, paintTextR);
	} else {
            g.setColor(context.getStyle().getColor(context,
                                                   ColorType.TEXT_FOREGROUND));
            g.setFont(style.getFont(context));
            context.getStyle().getGraphicsUtils(context).paintText(
                context, g, tip.getTipText(), insets.left, insets.top, -1);
	}
    }

    public Dimension getPreferredSize(JComponent c) {
        SynthContext context = getContext(c);
	Insets insets = c.getInsets();
	Dimension prefSize = new Dimension(insets.left+insets.right,
					   insets.top+insets.bottom);
	String text = ((JToolTip)c).getTipText();

	if (text != null) {
	    View v = (c != null) ? (View) c.getClientProperty("html") : null;
	    if (v != null) {
		prefSize.width += (int) v.getPreferredSpan(View.X_AXIS);
		prefSize.height += (int) v.getPreferredSpan(View.Y_AXIS);
	    } else {
                Font font = context.getStyle().getFont(context);
                FontMetrics fm = c.getFontMetrics(font);
		prefSize.width += context.getStyle().getGraphicsUtils(context).
                                  computeStringWidth(context, font, fm, text);
		prefSize.height += fm.getHeight();
	    }
        }
        context.dispose();
	return prefSize;
    }

    public void propertyChange(PropertyChangeEvent e) {
        if (SynthLookAndFeel.shouldUpdateStyle(e)) {
            updateStyle((JToolTip)e.getSource());
        }
        String name = e.getPropertyName();
        if (name.equals("tiptext") || "font".equals(name) ||
                "foreground".equals(name)) {
            // remove the old html view client property if one
            // existed, and install a new one if the text installed
            // into the JLabel is html source.
            JToolTip tip = ((JToolTip) e.getSource());
            String text = tip.getTipText();
            BasicHTML.updateRenderer(tip, text);
        }
    }
}
