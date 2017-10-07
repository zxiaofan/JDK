/*
 * Copyright (c) 2008, 2009, Oracle and/or its affiliates. All rights reserved.
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
 * Creates default provider on Windows
 */
public class DefaultFileSystemProvider {
    private DefaultFileSystemProvider() { }
    public static FileSystemProvider create() {
        return new WindowsFileSystemProvider();
    }
}
