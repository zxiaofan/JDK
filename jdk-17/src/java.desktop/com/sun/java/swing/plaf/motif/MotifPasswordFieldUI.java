/*
 * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.swing.plaf.motif;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.Caret;

/**
 * Provides the Motif look and feel for a password field.
 *
 * @author  Timothy Prinzing
 */
public class MotifPasswordFieldUI extends BasicPasswordFieldUI {

    /**
     * Creates a UI for a JPasswordField.
     *
     * @param c the JPasswordField
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) {
        return new MotifPasswordFieldUI();
    }

    /**
     * Creates the object to use for a caret.  By default an
     * instance of MotifTextUI.MotifCaret is created.  This method
     * can be redefined to provide something else that implements
     * the Caret interface.
     *
     * @return the caret object
     */
    protected Caret createCaret() {
        return MotifTextUI.createCaret();
    }

}
