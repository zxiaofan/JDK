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

public class SaveAsAction extends DelegateAction
{

    public SaveAsAction()
    {
        this("general/SaveAs16.gif");
    }

    public SaveAsAction(String iconPath)
    {
        super("Save As", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "save-as-command");
        putValue("ShortDescription", "Save as a new file");
        putValue("LongDescription", "Saves the current object as another object");
        putValue("MnemonicKey", VALUE_MNEMONIC);
    }

    public static final String VALUE_COMMAND = "save-as-command";
    public static final String VALUE_NAME = "Save As";
    public static final String VALUE_SMALL_ICON = "general/SaveAs16.gif";
    public static final String VALUE_LARGE_ICON = "general/SaveAs24.gif";
    public static final Integer VALUE_MNEMONIC = 65;
    public static final String VALUE_SHORT_DESCRIPTION = "Save as a new file";
    public static final String VALUE_LONG_DESCRIPTION = "Saves the current object as another object";

}
