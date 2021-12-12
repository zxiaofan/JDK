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

public class CancelAction extends DelegateAction
{

    public CancelAction()
    {
        this(VALUE_SMALL_ICON);
    }

    public CancelAction(String iconPath)
    {
        super("Cancel", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "cancel-command");
        putValue("ShortDescription", "Cancels the action");
        putValue("LongDescription", "Cancels the action");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "cancel-command";
    public static final String VALUE_NAME = "Cancel";
    public static final String VALUE_SMALL_ICON = null;
    public static final String VALUE_LARGE_ICON = null;
    public static final Integer VALUE_MNEMONIC = 67;
    public static final KeyStroke VALUE_ACCELERATOR = null;
    public static final String VALUE_SHORT_DESCRIPTION = "Cancels the action";
    public static final String VALUE_LONG_DESCRIPTION = "Cancels the action";

}
