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

package com.sun.glass.ui.monocle;

import com.sun.glass.ui.Clipboard;
import com.sun.glass.ui.delegate.ClipboardDelegate;

final class MonocleClipboardDelegate implements ClipboardDelegate {

    @Override
    public Clipboard createClipboard(String clipboardName) {
        // Currently only DnD clipboards are supported.
        // System clipboards will probably will not be supported as embedded
        // platforms do not support this functionality
        // We might support Selection clipboard in the future, but other systems
        // do not seem to use it at this point
        if (Clipboard.DND.equals(clipboardName)) {
            return new MonocleDnDClipboard();
        } else if (Clipboard.SYSTEM.equals(clipboardName)) {
            return new MonocleSystemClipboard();
        } else {
            return null;
        }
    }
}
