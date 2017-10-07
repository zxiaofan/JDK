/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.lens;

import com.sun.glass.ui.Clipboard;
import com.sun.glass.ui.delegate.ClipboardDelegate;

import sun.util.logging.PlatformLogger.Level;

final class LensClipboardDelegate implements ClipboardDelegate {

    @Override
    public Clipboard createClipboard(String clipboardName) {
        // Currently only DnD clipboards are supported.
        //System clipboards will probably will not be supported as embedded
        //platforms do not support this functionality
        //We may support Selection clipboard in the future, but others systems
        //are not seem to use it at this point

        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("LensClipboardDelegate::createClipboard("+clipboardName+")");
        }
        if (Clipboard.DND.equals(clipboardName)) {
            return new LensDnDClipboard();
        } else if (Clipboard.SYSTEM.equals(clipboardName)) {
            return new LensSystemClipboard();
        } else {
            LensLogger.getLogger().warning("LensClipboardDelegate doesn't support " +
                                           clipboardName + " clipboard");
            return null;
        }
    }
}
