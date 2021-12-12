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
import javax.swing.plaf.basic.BasicTextAreaUI;
import javax.swing.text.Caret;

/**
 * Provides the look and feel for a plain text editor.  In this
 * implementation the default UI is extended to act as a simple
 * view factory.
 *
 * @author  Timothy Prinzing
 */
public class MotifTextAreaUI extends BasicTextAreaUI {

    /**
     * Creates a UI for a JTextArea.
     *
     * @param ta a text area
     * @return the UI
     */
    public static ComponentUI createUI(JComponent ta) {
        return new MotifTextAreaUI();
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
