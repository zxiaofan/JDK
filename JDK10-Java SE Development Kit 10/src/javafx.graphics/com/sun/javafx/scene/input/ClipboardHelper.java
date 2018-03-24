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

package com.sun.javafx.scene.input;

import com.sun.javafx.util.Utils;
import javafx.scene.input.Clipboard;

/**
 * Used to access internal methods of Clipboard.
 */
public class ClipboardHelper {

    private static ClipboardAccessor clipboardAccessor;

    static {
        Utils.forceInit(Clipboard.class);
    }

    private ClipboardHelper() {
    }

    public static boolean contentPut(Clipboard clipboard) {
        return clipboardAccessor.contentPut(clipboard);
    }

    public static void setClipboardAccessor(final ClipboardAccessor newAccessor) {
        if (clipboardAccessor != null) {
            throw new IllegalStateException();
        }

        clipboardAccessor = newAccessor;
    }

    public interface ClipboardAccessor {
        boolean contentPut(Clipboard clipboard);
    }

}
