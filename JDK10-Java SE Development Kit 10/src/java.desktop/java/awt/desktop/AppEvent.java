/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.desktop;

import java.awt.Desktop;
import java.util.EventObject;

/**
 * AppEvents are sent to listeners and handlers installed on the
 * {@link java.awt.Desktop}.
 *
 * @since 9
 */
public class AppEvent extends EventObject {

    private static final long serialVersionUID = -5958503993556009432L;

    AppEvent() {
        super(Desktop.getDesktop());
    }

}
