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
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.text.View;

/**
 * Synth's RadioButtonUI.
 *
 * @version %I%, %G%
 * @author Jeff Dinkins
 */
class SynthRadioButtonUI extends SynthToggleButtonUI {

    // ********************************
    //        Create PLAF 
    // ********************************
    public static ComponentUI createUI(JComponent b) {
        return new SynthRadioButtonUI();
    }

    protected String getPropertyPrefix() {
        return "RadioButton.";
    }

    /**
     * Returns the Icon used in calculating the pref/min/max size.
     */
    protected Icon getSizingIcon(AbstractButton b) {
        return getIcon(b);
    }

    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        context.getPainter().paintRadioButtonBackground(context, g, 0, 0,
                                                c.getWidth(), c.getHeight());
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintRadioButtonBorder(context, g, x, y, w, h);
    }
}
