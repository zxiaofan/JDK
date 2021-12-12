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

public class FinishAction extends DelegateAction
{

    public FinishAction()
    {
        this(VALUE_SMALL_ICON);
    }

    public FinishAction(String iconPath)
    {
        super("Finish", ActionManager.getIcon(iconPath));
        putValue("ActionCommandKey", "finish-command");
        putValue("ShortDescription", "Finish the activity");
        putValue("LongDescription", "Finish the activity");
        putValue("MnemonicKey", VALUE_MNEMONIC);
        putValue("AcceleratorKey", VALUE_ACCELERATOR);
    }

    public static final String VALUE_COMMAND = "finish-command";
    public static final String VALUE_NAME = "Finish";
    public static final String VALUE_SMALL_ICON = null;
    public static final String VALUE_LARGE_ICON = null;
    public static final Integer VALUE_MNEMONIC = 70;
    public static final KeyStroke VALUE_ACCELERATOR = null;
    public static final String VALUE_SHORT_DESCRIPTION = "Finish the activity";
    public static final String VALUE_LONG_DESCRIPTION = "Finish the activity";

}
