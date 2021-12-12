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

public class BackAction extends DelegateAction
{

    public BackAction()
    {
        this(VALUE_SMALL_ICON);
    }

    public BackAction(String iconPath)
    {
        super("< Back", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "back-command");
        putValue("ShortDescription", "Select previous item");
        putValue("LongDescription", "Select previous item");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "back-command";
    public static final String VALUE_NAME = "< Back";
    public static final String VALUE_SMALL_ICON = null;
    public static final String VALUE_LARGE_ICON = null;
    public static final Integer VALUE_MNEMONIC = 66;
    public static final KeyStroke VALUE_ACCELERATOR = null;
    public static final String VALUE_SHORT_DESCRIPTION = "Select previous item";
    public static final String VALUE_LONG_DESCRIPTION = "Select previous item";

}
