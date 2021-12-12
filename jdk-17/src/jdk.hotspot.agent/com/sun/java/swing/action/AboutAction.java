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


// Referenced classes of package com.sun.java.swing.action:
//            DelegateAction, ActionManager

public class AboutAction extends DelegateAction
{

    public AboutAction()
    {
        this("general/About16.gif");
    }

    public AboutAction(String iconPath)
    {
        super("About...", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "about-command");
        putValue("ShortDescription", "About...");
        putValue("LongDescription", "System information and version of the application.");
        putValue("MnemonicKey", VALUE_MNEMONIC);
    }

    public static final String VALUE_COMMAND = "about-command";
    public static final String VALUE_NAME = "About...";
    public static final String VALUE_SMALL_ICON = "general/About16.gif";
    public static final String VALUE_LARGE_ICON = "general/About24.gif";
    public static final Integer VALUE_MNEMONIC = 65;
    public static final String VALUE_SHORT_DESCRIPTION = "About...";
    public static final String VALUE_LONG_DESCRIPTION = "System information and version of the application.";

}
