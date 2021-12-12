/*
 * Copyright (c) 2008, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.file.FileSystem;

/**
 * Creates this platform's default FileSystemProvider.
 */
public class DefaultFileSystemProvider {
    private static final WindowsFileSystemProvider INSTANCE
        = new WindowsFileSystemProvider();

    private DefaultFileSystemProvider() { }

    /**
     * Returns the platform's default file system provider.
     */
    public static WindowsFileSystemProvider instance() {
        return INSTANCE;
    }

    /**
     * Returns the platform's default file system.
     */
    public static FileSystem theFileSystem() {
        return INSTANCE.theFileSystem();
    }
}
