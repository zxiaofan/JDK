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

import java.nio.file.OpenOption;
import jdk.internal.misc.FileSystemOption;

/**
 * Defines <em>extended</em> open options supported on some platforms
 * by Sun's provider implementation.
 *
 * @since 1.7
 */

public enum ExtendedOpenOption implements OpenOption {
    /**
     * Prevent operations on the file that request read access.
     */
    NOSHARE_READ(FileSystemOption.NOSHARE_READ),
    /**
     * Prevent operations on the file that request write access.
     */
    NOSHARE_WRITE(FileSystemOption.NOSHARE_WRITE),
    /**
     * Prevent operations on the file that request delete access.
     */
    NOSHARE_DELETE(FileSystemOption.NOSHARE_DELETE),

    /**
     * Requires that direct I/O be used for read or write access.
     * Attempting to open a file with this option set will result in
     * an {@code UnsupportedOperationException} if the operating system or
     * file system does not support Direct I/O or a sufficient equivalent.
     *
     * @apiNote
     * The DIRECT option enables performing file I/O directly between user
     * buffers and the file thereby circumventing the operating system page
     * cache and possibly avoiding the thrashing which could otherwise occur
     * in I/O-intensive applications. This option may be of benefit to
     * applications which do their own caching or do random I/O operations
     * on large data sets. It is likely to provide the most benefit when
     * the file is stored on a device which has high I/O throughput capacity.
     * The option should be used with caution however as in general it is
     * likely to degrade performance. The performance effects of using it
     * should be evaluated in each particular circumstance.
     *
     * @since 10
     */
    DIRECT(FileSystemOption.DIRECT);

    ExtendedOpenOption(FileSystemOption<Void> option) {
        option.register(this);
    }
}
