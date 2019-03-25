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


package com.sun.java.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Icon;

public abstract class DelegateAction extends AbstractAction
{

    public DelegateAction(String name, Icon icon)
    {
        super(name, icon);
    }

    public void addActionListener(ActionListener listener)
    {
        this.listener = listener;
    }

    public void removeActionListener(ActionListener listener)
    {
        this.listener = null;
    }

    public ActionListener[] getActionListeners()
    {
        return (new ActionListener[] {
            listener
        });
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(listener != null)
            listener.actionPerformed(evt);
    }

    private ActionListener listener;
}
