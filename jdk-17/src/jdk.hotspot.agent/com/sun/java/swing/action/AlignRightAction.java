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

public class AlignRightAction extends StateChangeAction
{

    public AlignRightAction()
    {
        this("text/AlignRight16.gif");
    }

    public AlignRightAction(String iconPath)
    {
        super("Right Align", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "align-right-command");
        putValue("ShortDescription", "Right Align");
        putValue("LongDescription", "Adjust the placement of text along the right edge");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "align-right-command";
    public static final String VALUE_NAME = "Right Align";
    public static final String VALUE_SMALL_ICON = "text/AlignRight16.gif";
    public static final String VALUE_LARGE_ICON = "text/AlignRight24.gif";
    public static final Integer VALUE_MNEMONIC = 82;
    public static final KeyStroke VALUE_ACCELERATOR = KeyStroke.getKeyStroke(82, 2);
    public static final String VALUE_SHORT_DESCRIPTION = "Right Align";
    public static final String VALUE_LONG_DESCRIPTION = "Adjust the placement of text along the right edge";

}
