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

import java.nio.file.OpenOption;
import sun.nio.fs.ExtendedOptions;

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
    NOSHARE_READ(ExtendedOptions.NOSHARE_READ),
    /**
     * Prevent operations on the file that request write access.
     */
    NOSHARE_WRITE(ExtendedOptions.NOSHARE_WRITE),
    /**
     * Prevent operations on the file that request delete access.
     */
    NOSHARE_DELETE(ExtendedOptions.NOSHARE_DELETE);

    ExtendedOpenOption(ExtendedOptions.InternalOption<Void> option) {
        option.register(this);
    }
}
