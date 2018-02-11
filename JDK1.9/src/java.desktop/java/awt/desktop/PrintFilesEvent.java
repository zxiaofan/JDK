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
 * Event sent when the app is asked to print a list of files.
 *
 * @see PrintFilesHandler#printFiles(PrintFilesEvent)
 * @since 9
 */
public final class PrintFilesEvent extends FilesEvent {
    private static final long serialVersionUID = -5752560876153618618L;

    /**
     * Constructs a {@code PrintFilesEvent}
     * @param files files
     */
    public PrintFilesEvent(final List<File> files) {
        super(files);
    }

}
