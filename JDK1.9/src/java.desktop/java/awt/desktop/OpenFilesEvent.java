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

import java.io.File;
import java.util.List;


/**
 * Event sent when the app is asked to open a list of files.
 *
 * @see OpenFilesHandler#openFiles
 *
 * @since 9
 */
public final class OpenFilesEvent extends FilesEvent {
    private static final long serialVersionUID = -3982871005867718956L;
    final String searchTerm;

    /**
     * Constructs an {@code OpenFilesEvent}
     * @param files files
     * @param searchTerm searchTerm
     */
    public OpenFilesEvent(final List<File> files, final String searchTerm) {
        super(files);
        this.searchTerm = searchTerm == null
                            ? ""
                            : searchTerm;
    }

    /**
     * Gets the search term. The platform may optionally provide the search
     * term that was used to find the files. This is for example the case
     * on Mac OS X, when the files were opened using the Spotlight search
     * menu or a Finder search window.
     *
     * This is useful for highlighting the search term in the documents when
     * they are opened.
     *
     * @return the search term used to find the files
     */
    public String getSearchTerm() {
        return searchTerm;
    }

}
