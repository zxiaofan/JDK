/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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
 */


package com.sun.java.swing.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractButton;

public class ToggleActionPropertyChangeListener
    implements PropertyChangeListener
{

    public ToggleActionPropertyChangeListener(AbstractButton button)
    {
        this.button = button;
    }

    public void propertyChange(PropertyChangeEvent evt)
    {
        String propertyName = evt.getPropertyName();
        if(propertyName.equals("selected"))
        {
            Boolean selected = (Boolean)evt.getNewValue();
            button.setSelected(selected.booleanValue());
        }
    }

    private AbstractButton button;
}
