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
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.Caret;

/**
 * Provides the Motif look and feel for a text field.
 *
 * @author  Timothy Prinzing
 */
public class MotifTextFieldUI extends BasicTextFieldUI {

    /**
     * Creates a UI for a JTextField.
     *
     * @param c the text field
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) {
        return new MotifTextFieldUI();
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
