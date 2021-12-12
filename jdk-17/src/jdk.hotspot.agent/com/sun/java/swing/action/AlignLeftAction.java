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

public class AlignLeftAction extends StateChangeAction
{

    public AlignLeftAction()
    {
        this("text/AlignLeft16.gif");
    }

    public AlignLeftAction(String iconPath)
    {
        super("Left Align", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "align-left-command");
        putValue("ShortDescription", "Left Align");
        putValue("LongDescription", "Adjust the placement of text along the left edge");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "align-left-command";
    public static final String VALUE_NAME = "Left Align";
    public static final String VALUE_SMALL_ICON = "text/AlignLeft16.gif";
    public static final String VALUE_LARGE_ICON = "text/AlignLeft24.gif";
    public static final Integer VALUE_MNEMONIC = 76;
    public static final KeyStroke VALUE_ACCELERATOR = KeyStroke.getKeyStroke(76, 2);
    public static final String VALUE_SHORT_DESCRIPTION = "Left Align";
    public static final String VALUE_LONG_DESCRIPTION = "Adjust the placement of text along the left edge";

}
