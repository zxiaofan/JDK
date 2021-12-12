/*
 * Copyright (c) 2007, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.nio.file;

/**
 * Runtime exception thrown when an attempt is made to create a file system that
 * already exists.
 *
 * @since 1.7
 */

public class FileSystemAlreadyExistsException
    extends RuntimeException
{
    @java.io.Serial
    static final long serialVersionUID = -5438419127181131148L;

    /**
     * Constructs an instance of this class.
     */
    public FileSystemAlreadyExistsException() {
    }

    /**
     * Constructs an instance of this class.
     *
     * @param   msg
     *          the detail message
     */
    public FileSystemAlreadyExistsException(String msg) {
        super(msg);
    }
}
