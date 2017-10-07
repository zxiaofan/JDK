/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.mac;

import com.sun.glass.ui.Clipboard;
import com.sun.glass.ui.delegate.ClipboardDelegate;

final class MacClipboardDelegate implements ClipboardDelegate {

    public Clipboard createClipboard(String clipboardName) {
        if (Clipboard.SYSTEM.equals(clipboardName)) {
            return new MacSystemClipboard(clipboardName);
        } else if (Clipboard.DND.equals(clipboardName)) {
            return new MacDnDClipboard(clipboardName);
        }
        return null;
    }
}
