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

import com.sun.java.swing.action.ActionManager;
import com.sun.java.swing.action.StateChangeAction;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.*;

// Referenced classes of package com.sun.java.swing.ui:
//            ToggleActionPropertyChangeListener, StatusBar, CommonUI

public abstract class CommonToolBar extends JToolBar
{

    protected CommonToolBar(ActionManager manager)
    {
        this(manager, StatusBar.getInstance());
    }

    protected CommonToolBar(ActionManager manager, StatusBar status)
    {
        this.manager = manager;
        statusBar = status;
        buttonSize = new Dimension(CommonUI.getButtconPrefSize());
        buttonInsets = new Insets(0, 0, 0, 0);
        addComponents();
    }

    protected abstract void addComponents();

    protected void addButton(Action action)
    {
        javax.swing.JButton button = add(action);
        configureButton(button, action);
    }

    protected void addToggleButton(StateChangeAction a)
    {
        addToggleButton(a, null);
    }

    protected void addToggleButton(StateChangeAction a, ButtonGroup group)
    {
        JToggleButton button = new JToggleButton(a);
        button.addItemListener(a);
        button.setSelected(a.isSelected());
        if(group != null)
            group.add(button);
        add(button);
        configureToggleButton(button, a);
    }

    protected void configureToggleButton(JToggleButton button, Action action)
    {
        configureButton(button, action);
        action.addPropertyChangeListener(new ToggleActionPropertyChangeListener(button));
    }

    protected void configureButton(AbstractButton button, Action action)
    {
        button.setToolTipText((String)action.getValue("Name"));
        button.setText("");
        button.addMouseListener(statusBar);
    }

    protected ActionManager manager;
    private Dimension buttonSize;
    private Insets buttonInsets;
    private StatusBar statusBar;
}
