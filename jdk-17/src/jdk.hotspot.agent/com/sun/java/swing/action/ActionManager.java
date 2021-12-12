/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.HashMap;
import javax.swing.Action;
import javax.swing.ImageIcon;

// Referenced classes of package com.sun.java.swing.action:
//            DelegateAction, StateChangeAction, ActionUtilities

public abstract class ActionManager
{

    protected ActionManager()
    {
        actions = new HashMap<>();
        addActions();
    }

    public static ActionManager getInstance()
    {
        return manager;
    }

    protected static void setInstance(ActionManager m)
    {
        manager = m;
    }

    protected abstract void addActions();

    protected void addAction(String cmdname, Action action)
    {
        actions.put(cmdname, action);
    }

    public Action getAction(String key)
    {
        return (Action)actions.get(key);
    }

    public DelegateAction getDelegateAction(String name)
    {
        Action a = getAction(name);
        if(a instanceof DelegateAction)
            return (DelegateAction)a;
        else
            return null;
    }

    public StateChangeAction getStateChangeAction(String name)
    {
        Action a = getAction(name);
        if(a instanceof StateChangeAction)
            return (StateChangeAction)a;
        else
            return null;
    }

    public static ImageIcon getIcon(String name)
    {
        return utilities.getIcon(name);
    }

    public void setActionEnabled(String name, boolean enabled)
    {
        Action action = getAction(name);
        if(action != null)
            action.setEnabled(enabled);
    }

    private HashMap<String, Action> actions;
    private static ActionUtilities utilities = new ActionUtilities();
    private static ActionManager manager;

}
