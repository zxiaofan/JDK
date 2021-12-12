/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import javax.swing.JOptionPane;

/**
 * Pluggable look and feel interface for JOptionPane.
 *
 * @author Scott Violet
 */

public abstract class OptionPaneUI extends ComponentUI
{
    /**
     * Constructor for subclasses to call.
     */
    protected OptionPaneUI() {}

    /**
     * Requests the component representing the default value to have
     * focus.
     *
     * @param op a {@code JOptionPane}
     */
    public abstract void selectInitialValue(JOptionPane op);

    /**
     * Returns true if the user has supplied instances of Component for
     * either the options or message.
     *
     * @param op a {@code JOptionPane}
     * @return {@code true} if the given {@code JOptionPane} contains user
     *         created {@code Component}s
     */
    public abstract boolean containsCustomComponents(JOptionPane op);
}
