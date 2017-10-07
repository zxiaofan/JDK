/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Auxiliary event containing a list of files.
 *
 * @since 9
 */
public class FilesEvent extends AppEvent {
    private static final long serialVersionUID = 5271763715462312871L;
    final List<File> files;

    /**
     * Constructs a {@code FilesEvent}
     * @param files files
     */
    FilesEvent(final List<File> files) {
        this.files = files;
    }

    /**
     * Gets the list of files
     * @return the list of files
     */
    public List<File> getFiles() {
        return files == null
                ? null
                : new ArrayList<>(files);
    }

}
