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
package com.sun.glass.ui.gtk;

import com.sun.glass.ui.CommonDialogs.ExtensionFilter;
import com.sun.glass.ui.CommonDialogs.FileChooserResult;
import com.sun.glass.ui.Window;

import java.io.File;

final class GtkCommonDialogs {

    private static native FileChooserResult _showFileChooser(
                                            long parent,
                                            String folder,
                                            String filename,
                                            String title,
                                            int type,
                                            boolean multipleMode,
                                            ExtensionFilter[] extensionFilters,
                                            int defaultFilterIndex);

    private static native String _showFolderChooser(long parent,
                                                    String folder,
                                                    String title);

    static FileChooserResult showFileChooser(Window owner,
                                    String folder,
                                    String filename,
                                    String title,
                                    int type,
                                    boolean multipleMode,
                                    ExtensionFilter[] extensionFilters, int defaultFilterIndex) {

        if (owner != null) owner.setEnabled(false);
        FileChooserResult result = _showFileChooser(owner == null? 0L : owner.getNativeHandle(),
                folder, filename, title, type, multipleMode, extensionFilters, defaultFilterIndex);
        if (owner != null) owner.setEnabled(true);
        return result;
    }

    static File showFolderChooser(Window owner, String folder, String title) {
        if (owner != null) {
            owner.setEnabled(false);
        }
        try {
            String filename = _showFolderChooser((owner != null) ? owner.getNativeHandle() : 0, folder, title);
            return filename != null ? new File(filename) : null;

        } finally {
            if (owner != null) {
                owner.setEnabled(true);
            }
        }

    }
}
