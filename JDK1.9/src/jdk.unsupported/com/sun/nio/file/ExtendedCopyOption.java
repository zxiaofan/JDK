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

import java.nio.file.CopyOption;
import sun.nio.fs.ExtendedOptions;

/**
 * Defines <em>extended</em> copy options supported on some platforms
 * by Sun's provider implementation.
 *
 * @since 1.7
 */

public enum ExtendedCopyOption implements CopyOption {
    /**
     * The copy may be interrupted by the {@link Thread#interrupt interrupt}
     * method.
     */
    INTERRUPTIBLE(ExtendedOptions.INTERRUPTIBLE);

    ExtendedCopyOption(ExtendedOptions.InternalOption<Void> option) {
        option.register(this);
    }
}
