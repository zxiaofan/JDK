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
import com.sun.java.swing.action.DelegateAction;

/**
 * Callback action for Finding the Object Type
 */
public class FindAction extends DelegateAction {

    // XXX - Constants should be static if not in inner class
    public static final String VALUE_COMMAND = "find-command";
    public static final String VALUE_NAME = "Find Objects";
    public static final String VALUE_SMALL_ICON = "general/Find16.gif";
    public static final Integer VALUE_MNEMONIC = (int) 'F';
    public static final String VALUE_SHORT_DESCRIPTION = "Find Objects of this Type";
    public static final String VALUE_LONG_DESCRIPTION = VALUE_SHORT_DESCRIPTION;

    public FindAction() {
        super(VALUE_NAME, ActionManager.getIcon(VALUE_SMALL_ICON));

        putValue(Action.ACTION_COMMAND_KEY, VALUE_COMMAND);
        putValue(Action.SHORT_DESCRIPTION, VALUE_SHORT_DESCRIPTION);
        putValue(Action.LONG_DESCRIPTION, VALUE_LONG_DESCRIPTION);
        putValue(Action.MNEMONIC_KEY, VALUE_MNEMONIC);
    }
}
