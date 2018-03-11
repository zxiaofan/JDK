/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package javax.swing.plaf.synth;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;

/**
 * Provides the look and feel implementation for
 * <code>JFormattedTextField</code>.
 *
 * @version %I%, %G%
 */
class SynthFormattedTextFieldUI extends SynthTextFieldUI {
    /**
     * Creates a UI for a JFormattedTextField.
     *
     * @param c the formatted text field
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) {
        return new SynthFormattedTextFieldUI();
    }

    /**
     * Fetches the name used as a key to lookup properties through the
     * UIManager.  This is used as a prefix to all the standard
     * text properties.
     *
     * @return the name "FormattedTextField"
     */
    protected String getPropertyPrefix() {
	return "FormattedTextField";
    }

    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        context.getPainter().paintFormattedTextFieldBackground(context, g, 0,
                             0, c.getWidth(), c.getHeight());
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintFormattedTextFieldBorder(context, g, x, y,
                                                           w, h);
    }
}
