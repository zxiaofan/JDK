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
import java.util.ArrayList;
import java.util.List;

/**
 * Auxiliary event containing a list of files.
 *
 * @since 9
 */
public class FilesEvent extends AppEvent {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 5271763715462312871L;

    /**
     * The list of files.
     */
    @SuppressWarnings("serial") // Not statically typed as Serializable
    final List<File> files;

    /**
     * Constructs a {@code FilesEvent}.
     *
     * @param  files the list of files
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    FilesEvent(final List<File> files) {
        this.files = files;
    }

    /**
     * Gets the list of files.
     *
     * @return the list of files
     */
    public List<File> getFiles() {
        return files == null
                ? null
                : new ArrayList<>(files);
    }
}
