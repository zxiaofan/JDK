/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
 
package javax.swing.plaf.synth;

import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

/**
 * Synth's ToggleButtonUI.
 * <p>
 * @version %I%, %G%
 * @author Jeff Dinkins
 */
class SynthToggleButtonUI extends SynthButtonUI {
    // ********************************
    //          Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent b) {
        return new SynthToggleButtonUI();
    }

    @Override
    protected String getPropertyPrefix() {
        return "ToggleButton.";
    }

    @Override
    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        if (((AbstractButton) c).isContentAreaFilled()) {
            int x = 0, y = 0, w = c.getWidth(), h = c.getHeight();
            SynthPainter painter = context.getPainter();
            painter.paintToggleButtonBackground(context, g, x, y, w, h);
        }
    }

    @Override
    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintToggleButtonBorder(context, g, x, y, w, h);
    }
}
