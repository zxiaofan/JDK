/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.file.FileSystems;
import java.nio.file.spi.FileTypeDetector;
import java.nio.file.spi.FileSystemProvider;

public class DefaultFileTypeDetector {
    private DefaultFileTypeDetector() { }

    public static FileTypeDetector create() {
        FileSystemProvider provider = FileSystems.getDefault().provider();
        return ((UnixFileSystemProvider)provider).getFileTypeDetector();
    }
}
