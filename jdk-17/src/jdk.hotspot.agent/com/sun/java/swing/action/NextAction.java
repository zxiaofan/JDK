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

public class NextAction extends DelegateAction
{

    public NextAction()
    {
        this(VALUE_SMALL_ICON);
    }

    public NextAction(String iconPath)
    {
        super("Next >", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "next-command");
        putValue("ShortDescription", "Select next item");
        putValue("LongDescription", "Select next item");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "next-command";
    public static final String VALUE_NAME = "Next >";
    public static final String VALUE_SMALL_ICON = null;
    public static final String VALUE_LARGE_ICON = null;
    public static final Integer VALUE_MNEMONIC = 78;
    public static final KeyStroke VALUE_ACCELERATOR = null;
    public static final String VALUE_SHORT_DESCRIPTION = "Select next item";
    public static final String VALUE_LONG_DESCRIPTION = "Select next item";

}
