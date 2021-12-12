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

public class SaveAction extends DelegateAction
{

    public SaveAction()
    {
        this("general/Save16.gif");
    }

    public SaveAction(String iconPath)
    {
        super("Save", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "save-command");
        putValue("ShortDescription", "Commit changes to a permanent storage area");
        putValue("LongDescription", "Commit changes to a permanent storage area");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "save-command";
    public static final String VALUE_NAME = "Save";
    public static final String VALUE_SMALL_ICON = "general/Save16.gif";
    public static final String VALUE_LARGE_ICON = "general/Save24.gif";
    public static final Integer VALUE_MNEMONIC = 83;
    public static final KeyStroke VALUE_ACCELERATOR = KeyStroke.getKeyStroke(83, 2);
    public static final String VALUE_SHORT_DESCRIPTION = "Commit changes to a permanent storage area";
    public static final String VALUE_LONG_DESCRIPTION = "Commit changes to a permanent storage area";

}
