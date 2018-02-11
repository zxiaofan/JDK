/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.CommonDialogs.Type;
import com.sun.glass.ui.CommonDialogs.ExtensionFilter;
import com.sun.glass.ui.CommonDialogs.FileChooserResult;
import com.sun.glass.ui.Window;
import java.security.AccessController;
import java.security.PrivilegedAction;

import java.io.File;

/**
 * MacOSX platform implementation class for CommonDialogs.
 */
final class MacCommonDialogs {

    private native static void _initIDs();
    static {
        _initIDs();
    }

    private static native FileChooserResult _showFileOpenChooser(long owner, String folder, String title,
                                                    boolean multipleMode, ExtensionFilter[] extensionFilters, int defaultFilterIndex);
    private static native FileChooserResult _showFileSaveChooser(long owner, String folder, String filename, String title,
                                                                 ExtensionFilter[] extensionFilters, int defaultFilterIndex);

    private static native File _showFolderChooser(long owner, String folder, String title);

    static FileChooserResult showFileChooser_impl(Window owner, String folder, String filename, String title, int type,
                                         boolean multipleMode, ExtensionFilter[] extensionFilters, int defaultFilterIndex) {

        final long ownerPtr = owner != null ? owner.getNativeWindow() : 0L;

        if (type == Type.OPEN) {
            return _showFileOpenChooser(ownerPtr, folder, title, multipleMode, extensionFilters, defaultFilterIndex);
        } else if (type == Type.SAVE) {
            return _showFileSaveChooser(ownerPtr, folder, filename, title, extensionFilters, defaultFilterIndex);
        } else {
            return null;
        }
    }

    static File showFolderChooser_impl(Window owner, String folder, String title) {
        final long ownerPtr = owner != null ? owner.getNativeWindow() : 0L;
        return _showFolderChooser(ownerPtr, folder, title);
    }

    static boolean isFileNSURLEnabled() {
        // The check is dynamic since an app may want to toggle it dynamically.
        // The performance is not critical for FileChoosers.
        return AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> Boolean.getBoolean("glass.macosx.enableFileNSURL"));
    }
}
