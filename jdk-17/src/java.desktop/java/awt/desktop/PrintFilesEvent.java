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
 * Event sent when the app is asked to print a list of files.
 *
 * @see PrintFilesHandler#printFiles(PrintFilesEvent)
 * @since 9
 */
public final class PrintFilesEvent extends FilesEvent {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -5752560876153618618L;

    /**
     * Constructs a {@code PrintFilesEvent}.
     *
     * @param  files the list of files
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public PrintFilesEvent(final List<File> files) {
        super(files);
    }
}
