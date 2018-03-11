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
import java.io.Serializable;


/**
 * Synth's CheckBoxUI.
 *
 * @version %I%, %G%
 * @author Jeff Dinkins
 */
class SynthCheckBoxUI extends SynthRadioButtonUI {

    // ********************************
    //            Create PLAF 
    // ********************************
    public static ComponentUI createUI(JComponent b) {
        return new SynthCheckBoxUI();
    }

    protected String getPropertyPrefix() {
	return "CheckBox.";
    }

    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        context.getPainter().paintCheckBoxBackground(context, g, 0, 0,
                                                  c.getWidth(), c.getHeight());
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintCheckBoxBorder(context, g, x, y, w, h);
    }
}
