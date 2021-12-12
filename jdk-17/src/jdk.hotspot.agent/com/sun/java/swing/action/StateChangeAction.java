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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;

// Referenced classes of package com.sun.java.swing.action:
//            DelegateAction

public abstract class StateChangeAction extends DelegateAction
    implements ItemListener
{

    public StateChangeAction(String name)
    {
        super(name, null);
        selected = false;
    }

    public StateChangeAction(String name, Icon icon)
    {
        super(name, icon);
        selected = false;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public synchronized void setSelected(boolean newValue)
    {
        boolean oldValue = selected;
        if(oldValue != newValue)
        {
            selected = newValue;
            firePropertyChange("selected", Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        }
    }

    public void setItemListener(ItemListener listener)
    {
        this.listener = listener;
    }

    public ItemListener getItemListener()
    {
        return listener;
    }

    public void itemStateChanged(ItemEvent evt)
    {
        if(evt.getStateChange() == 1)
            setSelected(true);
        else
            setSelected(false);
        if(listener != null)
            listener.itemStateChanged(evt);
    }

    protected boolean selected;
    private ItemListener listener;
}
