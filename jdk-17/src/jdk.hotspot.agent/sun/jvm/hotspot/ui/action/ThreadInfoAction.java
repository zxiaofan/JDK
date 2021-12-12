/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.ui.action;

import javax.swing.Action;

import com.sun.java.swing.action.ActionManager;
import com.sun.java.swing.action.StateChangeAction;

/**
 * Callback action for ThreadInfoing the Object Type
 */
public class ThreadInfoAction extends StateChangeAction {

    public static final String VALUE_COMMAND = "thread-info-command";
    public static final String VALUE_NAME = "Show Thread Information...";
    public static final String VALUE_SMALL_ICON = "general/Information16.gif";
    public static final String VALUE_LARGE_ICON = "general/Information24.gif";
    public static final Integer VALUE_MNEMONIC = (int) 'I';
    public static final String VALUE_SHORT_DESCRIPTION = "Show Thread Informaion";
    public static final String VALUE_LONG_DESCRIPTION = "Show information about the current thread";

    public ThreadInfoAction() {
        super(VALUE_NAME, ActionManager.getIcon(VALUE_SMALL_ICON));

        putValue(Action.ACTION_COMMAND_KEY, VALUE_COMMAND);
        putValue(Action.SHORT_DESCRIPTION, VALUE_SHORT_DESCRIPTION);
        putValue(Action.LONG_DESCRIPTION, VALUE_LONG_DESCRIPTION);
        putValue(Action.MNEMONIC_KEY, VALUE_MNEMONIC);
    }
}
