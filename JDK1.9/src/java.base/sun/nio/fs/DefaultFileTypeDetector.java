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

import java.nio.file.spi.FileTypeDetector;

public class DefaultFileTypeDetector {
    private DefaultFileTypeDetector() { }

    public static FileTypeDetector create() {
        return new RegistryFileTypeDetector();
    }
}
