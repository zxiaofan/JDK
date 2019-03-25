/*
 * Copyright (c) 2006, 2016, Oracle and/or its affiliates. All rights reserved.
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
 *
 */
package sun.awt;

import java.awt.Component;
import java.awt.event.FocusEvent.Cause;

public interface RequestFocusController
{
    public boolean acceptRequestFocus(Component from, Component to,
                                      boolean temporary, boolean focusedWindowChangeAllowed,
                                      Cause cause);
}
