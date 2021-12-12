/*
 * Copyright (c) 1994, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.io;


/**
 * Signals that an attempt to open the file denoted by a specified pathname
 * has failed.
 *
 * <p> This exception will be thrown by the {@link FileInputStream}, {@link
 * FileOutputStream}, and {@link RandomAccessFile} constructors when a file
 * with the specified pathname does not exist.  It will also be thrown by these
 * constructors if the file does exist but for some reason is inaccessible, for
 * example when an attempt is made to open a read-only file for writing.
 *
 * @since   1.0
 */

public class FileNotFoundException extends IOException {
    @java.io.Serial
    private static final long serialVersionUID = -897856973823710492L;

    /**
     * Constructs a {@code FileNotFoundException} with
     * {@code null} as its error detail message.
     */
    public FileNotFoundException() {
        super();
    }

    /**
     * Constructs a {@code FileNotFoundException} with the
     * specified detail message. The string {@code s} can be
     * retrieved later by the
     * {@link java.lang.Throwable#getMessage}
     * method of class {@code java.lang.Throwable}.
     *
     * @param   s   the detail message.
     */
    public FileNotFoundException(String s) {
        super(s);
    }

    /**
     * Constructs a {@code FileNotFoundException} with a detail message
     * consisting of the given pathname string followed by the given reason
     * string.  If the {@code reason} argument is {@code null} then
     * it will be omitted.  This private constructor is invoked only by native
     * I/O methods.
     *
     * @since 1.2
     */
    private FileNotFoundException(String path, String reason) {
        super(path + ((reason == null)
                      ? ""
                      : " (" + reason + ")"));
    }

}
