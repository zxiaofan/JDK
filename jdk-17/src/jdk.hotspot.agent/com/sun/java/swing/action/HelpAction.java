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

public class HelpAction extends DelegateAction
{

    public HelpAction()
    {
        this("general/Help16.gif");
    }

    public HelpAction(String iconPath)
    {
        super("Help", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "help-command");
        putValue("ShortDescription", "Help...");
        putValue("LongDescription", "Provide information which may aid the user.");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "help-command";
    public static final String VALUE_NAME = "Help";
    public static final String VALUE_SMALL_ICON = "general/Help16.gif";
    public static final String VALUE_LARGE_ICON = "general/Help24.gif";
    public static final Integer VALUE_MNEMONIC = 72;
    public static final KeyStroke VALUE_ACCELERATOR = KeyStroke.getKeyStroke(112, 0);
    public static final String VALUE_SHORT_DESCRIPTION = "Help...";
    public static final String VALUE_LONG_DESCRIPTION = "Provide information which may aid the user.";

}
