/*
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.File;
import java.io.Serial;
import java.util.List;

/**
 * Event sent when the app is asked to open a list of files.
 *
 * @see OpenFilesHandler#openFiles
 * @since 9
 */
public final class OpenFilesEvent extends FilesEvent {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -3982871005867718956L;

    /**
     * The search term used to find the files.
     */
    final String searchTerm;

    /**
     * Constructs an {@code OpenFilesEvent}.
     *
     * @param  files the list of files
     * @param  searchTerm the search term
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public OpenFilesEvent(final List<File> files, final String searchTerm) {
        super(files);
        this.searchTerm = searchTerm == null
                            ? ""
                            : searchTerm;
    }

    /**
     * Gets the search term. The platform may optionally provide the search term
     * that was used to find the files. This is for example the case on MacOS,
     * when the files were opened using the Spotlight search menu or a Finder
     * search window.
     * <p>
     * This is useful for highlighting the search term in the documents when
     * they are opened.
     *
     * @return the search term used to find the files
     */
    public String getSearchTerm() {
        return searchTerm;
    }
}
