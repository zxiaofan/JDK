/*
 * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.nio.file;

import java.nio.file.WatchEvent.Modifier;
import jdk.internal.misc.FileSystemOption;

/**
 * Defines <em>extended</em> watch event modifiers supported on some platforms
 * by Sun's provider implementation.
 *
 * @since 1.7
 */

public enum ExtendedWatchEventModifier implements Modifier {

    /**
     * Register a file tree instead of a single directory.
     */
    FILE_TREE(FileSystemOption.FILE_TREE);

    ExtendedWatchEventModifier(FileSystemOption<Void> option) {
        option.register(this);
    }
}
