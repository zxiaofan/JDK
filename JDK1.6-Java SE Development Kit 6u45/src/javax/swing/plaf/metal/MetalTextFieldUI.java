/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package javax.swing.plaf.metal;

import java.awt.*;
import java.beans.*;

import javax.swing.*;

import javax.swing.text.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

/**
 * Basis of a look and feel for a JTextField.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans<sup><font size="-2">TM</font></sup>
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author  Steve Wilson
 * @version %I% %G%
 */
public class MetalTextFieldUI extends BasicTextFieldUI {

    public static ComponentUI createUI(JComponent c) {
        return new MetalTextFieldUI();
    }

    /**
     * This method gets called when a bound property is changed
     * on the associated JTextComponent.  This is a hook
     * which UI implementations may change to reflect how the
     * UI displays bound properties of JTextComponent subclasses.
     *
     * @param evt the property change event
     */
    public void propertyChange(PropertyChangeEvent evt) {
	super.propertyChange(evt);
    }

 }
