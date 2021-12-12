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

import javax.swing.KeyStroke;

// Referenced classes of package com.sun.java.swing.action:
//            DelegateAction, ActionManager

public class OkAction extends DelegateAction
{

    public OkAction()
    {
        this(VALUE_SMALL_ICON);
    }

    public OkAction(String iconPath)
    {
        super("OK", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "ok-command");
        putValue("ShortDescription", "Acknowleges the action");
        putValue("LongDescription", "Acknowleges the action");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "ok-command";
    public static final String VALUE_NAME = "OK";
    public static final String VALUE_SMALL_ICON = null;
    public static final String VALUE_LARGE_ICON = null;
    public static final Integer VALUE_MNEMONIC = 79;
    public static final KeyStroke VALUE_ACCELERATOR = null;
    public static final String VALUE_SHORT_DESCRIPTION = "Acknowleges the action";
    public static final String VALUE_LONG_DESCRIPTION = "Acknowleges the action";

}
