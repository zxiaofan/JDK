/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Provides the implementation of the zip file system provider.
 *
 * <p> The zip file system provider treats a zip or JAR file as a file system
 * and provides the ability to manipulate the contents of the file.
 * The zip file system provider can be created by
 * {@link java.nio.file.FileSystems#newFileSystem
 * FileSystems.newFileSystem} if installed.
 *
 * @provides java.nio.file.spi.FileSystemProvider
 * @moduleGraph
 * @since 9
 */
module jdk.zipfs {
    provides java.nio.file.spi.FileSystemProvider with
        jdk.nio.zipfs.ZipFileSystemProvider;
}
