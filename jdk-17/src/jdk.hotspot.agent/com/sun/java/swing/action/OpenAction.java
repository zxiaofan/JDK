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

public class OpenAction extends DelegateAction
{

    public OpenAction()
    {
        this("general/Open16.gif");
    }

    public OpenAction(String iconPath)
    {
        super("Open...", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "open-command");
        putValue("ShortDescription", "Open the specified object.");
        putValue("LongDescription", "Open the specified object.");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "open-command";
    public static final String VALUE_NAME = "Open...";
    public static final String VALUE_SMALL_ICON = "general/Open16.gif";
    public static final String VALUE_LARGE_ICON = "general/Open24.gif";
    public static final Integer VALUE_MNEMONIC = 79;
    public static final KeyStroke VALUE_ACCELERATOR = KeyStroke.getKeyStroke(79, 2);
    public static final String VALUE_SHORT_DESCRIPTION = "Open the specified object.";
    public static final String VALUE_LONG_DESCRIPTION = "Open the specified object.";

}
