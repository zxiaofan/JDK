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

public class FileMenu extends AbstractAction
{

    public FileMenu()
    {
        super("File");
        putValue("ActionCommandKey", "file-menu-command");
        putValue("ShortDescription", "File operations");
        putValue("LongDescription", "File operations");
        putValue("MnemonicKey", VALUE_MNEMONIC);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    }

    public static final String VALUE_COMMAND = "file-menu-command";
    public static final String VALUE_NAME = "File";
    public static final Integer VALUE_MNEMONIC = 70;
    public static final String VALUE_SHORT_DESCRIPTION = "File operations";
    public static final String VALUE_LONG_DESCRIPTION = "File operations";

}
