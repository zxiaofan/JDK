/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
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
import sun.nio.fs.ExtendedOptions;

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
    FILE_TREE(ExtendedOptions.FILE_TREE);

    ExtendedWatchEventModifier(ExtendedOptions.InternalOption<Void> option) {
        option.register(this);
    }
}
