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
//            StateChangeAction, ActionManager

public class AlignCenterAction extends StateChangeAction
{

    public AlignCenterAction()
    {
        this("text/AlignCenter16.gif");
    }

    public AlignCenterAction(String iconPath)
    {
        super("Center", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "align-center-command");
        putValue("ShortDescription", "Center");
        putValue("LongDescription", "Adjust the placement of text to the center of the line");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "align-center-command";
    public static final String VALUE_NAME = "Center";
    public static final String VALUE_SMALL_ICON = "text/AlignCenter16.gif";
    public static final String VALUE_LARGE_ICON = "text/AlignCenter24.gif";
    public static final Integer VALUE_MNEMONIC = 78;
    public static final KeyStroke VALUE_ACCELERATOR = KeyStroke.getKeyStroke(69, 2);
    public static final String VALUE_SHORT_DESCRIPTION = "Center";
    public static final String VALUE_LONG_DESCRIPTION = "Adjust the placement of text to the center of the line";

}
