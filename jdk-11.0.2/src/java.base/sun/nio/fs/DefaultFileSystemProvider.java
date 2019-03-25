/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

import java.nio.file.spi.FileSystemProvider;

/**
 * Creates this platform's default FileSystemProvider.
 */

public class DefaultFileSystemProvider {
    private DefaultFileSystemProvider() { }

    /**
     * Returns the default FileSystemProvider.
     */
    public static FileSystemProvider create() {
        return new LinuxFileSystemProvider();
    }
}
