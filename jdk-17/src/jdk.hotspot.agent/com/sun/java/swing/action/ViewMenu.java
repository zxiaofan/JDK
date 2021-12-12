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

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ViewMenu extends AbstractAction
{

    public ViewMenu()
    {
        super("View");
        putValue("ActionCommandKey", "view-menu-command");
        putValue("ShortDescription", "View operations");
        putValue("LongDescription", "View operations");
        putValue("MnemonicKey", VALUE_MNEMONIC);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    }

    public static final String VALUE_COMMAND = "view-menu-command";
    public static final String VALUE_NAME = "View";
    public static final Integer VALUE_MNEMONIC = 86;
    public static final String VALUE_SHORT_DESCRIPTION = "View operations";
    public static final String VALUE_LONG_DESCRIPTION = "View operations";

}
