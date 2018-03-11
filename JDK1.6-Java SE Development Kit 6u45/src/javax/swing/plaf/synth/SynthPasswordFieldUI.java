/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.plaf.synth;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.plaf.*;

/**
 * Provides the Synth look and feel for a password field.
 * The only difference from the standard text field is that
 * the view of the text is simply a string of the echo 
 * character as specified in JPasswordField, rather than the 
 * real text contained in the field.
 *
 * @author  Shannon Hickey
 * @version %I% %G%
 */
class SynthPasswordFieldUI extends SynthTextFieldUI {

    /**
     * Creates a UI for a JPasswordField.
     *
     * @param c the JPasswordField
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) {
        return new SynthPasswordFieldUI();
    }

    /**
     * Fetches the name used as a key to look up properties through the
     * UIManager.  This is used as a prefix to all the standard
     * text properties.
     *
     * @return the name ("PasswordField")
     */
    protected String getPropertyPrefix() {
        return "PasswordField";
    }

    /**
     * Creates a view (PasswordView) for an element.
     *
     * @param elem the element
     * @return the view
     */
    public View create(Element elem) {
        return new PasswordView(elem);
    }

    void paintBackground(SynthContext context, Graphics g, JComponent c) {
        context.getPainter().paintPasswordFieldBackground(context, g, 0, 0,
                                                c.getWidth(), c.getHeight());
    }

    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h) {
        context.getPainter().paintPasswordFieldBorder(context, g, x, y, w, h);
    }

    protected void installKeyboardActions() {
        super.installKeyboardActions();
        ActionMap map = SwingUtilities.getUIActionMap(getComponent());
	if (map != null && map.get(DefaultEditorKit.selectWordAction) != null) {
	    Action a = map.get(DefaultEditorKit.selectLineAction);
	    if (a != null) {
		map.put(DefaultEditorKit.selectWordAction, a);
	    }
	}
    }
}
