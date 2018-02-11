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
package com.sun.glass.ui.win;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.CommonDialogs.ExtensionFilter;
import com.sun.glass.ui.CommonDialogs.FileChooserResult;
import com.sun.glass.ui.Window;

import java.io.File;
import java.util.List;

/**
 * MS Windows platform implementation class for CommonDialogs.
 */
final class WinCommonDialogs {

    private native static void _initIDs();
    static {
        _initIDs();
    }

    private static native FileChooserResult _showFileChooser(long owner, String folder, String filename, String title, int type,
                                                    boolean multipleMode, ExtensionFilter[] extensionFilters, int defaultFilterIndex);

    private static native String _showFolderChooser(long owner, String folder, String title);

    static FileChooserResult showFileChooser_impl(Window owner, String folder, String filename, String title, int type,
                                         boolean multipleMode, ExtensionFilter[] extensionFilters, int defaultFilterIndex) {
        if (owner != null) {
            ((WinWindow)owner).setDeferredClosing(true);
        }
        try {
            return _showFileChooser(owner != null ? owner.getNativeWindow() : 0L,
                    folder, filename, title, type, multipleMode, extensionFilters, defaultFilterIndex);
        } finally {
            if (owner != null) {
                ((WinWindow)owner).setDeferredClosing(false);
            }
        }
    }

    static File showFolderChooser_impl(Window owner, String folder, String title) {
        if (owner != null) {
            ((WinWindow)owner).setDeferredClosing(true);
        }
        try {
            String filename = _showFolderChooser(owner != null ? owner.getNativeWindow() : 0L, folder, title);
            return filename != null ? new File(filename) : null;
        } finally {
            if (owner != null) {
                ((WinWindow)owner).setDeferredClosing(false);
            }
        }
    }
}
