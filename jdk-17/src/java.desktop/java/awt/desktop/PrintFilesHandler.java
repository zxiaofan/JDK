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
 * An implementor can respond to requests to print documents that the app has
 * been registered to handle.
 *
 * @see java.awt.Desktop#setPrintFileHandler(PrintFilesHandler)
 * @since 9
 */
public interface PrintFilesHandler {

    /**
     * Called when the application is asked to print a list of files.
     *
     * @param  e the request to print a list of files
     */
    public void printFiles(PrintFilesEvent e);
}
