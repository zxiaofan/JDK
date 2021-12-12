/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 * An implementor is notified when the application is asked to open a list of
 * files.
 *
 * @see java.awt.Desktop#setOpenFileHandler(OpenFilesHandler)
 * @since 9
 */
public interface OpenFilesHandler {

    /**
     * Called when the application is asked to open a list of files.
     *
     * @param  e the request to open a list of files, and the search term used
     *         to find them, if any
     */
    public void openFiles(OpenFilesEvent e);
}
