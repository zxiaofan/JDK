/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.Clipboard;
import com.sun.glass.ui.delegate.ClipboardDelegate;

final class IosClipboardDelegate implements ClipboardDelegate {
    /**
     * @inheritDoc
     */
    @Override
    public Clipboard createClipboard(String clipboardName) {
        if (Clipboard.SYSTEM.equals(clipboardName)) {
            return new IosSystemClipboard(clipboardName);
        } else if (Clipboard.DND.equals(clipboardName)) {
            return new IosDnDClipboard(clipboardName);
        }
        return null;
    }
}
