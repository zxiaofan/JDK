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
 * Defines the <em>sensitivity levels</em> when registering objects with a
 * watch service implementation that polls the file system.
 *
 * @since 1.7
 */

public enum SensitivityWatchEventModifier implements Modifier {
    /**
     * High sensitivity.
     */
    HIGH(ExtendedOptions.SENSITIVITY_HIGH, 2),
    /**
     * Medium sensitivity.
     */
    MEDIUM(ExtendedOptions.SENSITIVITY_MEDIUM, 10),
    /**
     * Low sensitivity.
     */
    LOW(ExtendedOptions.SENSITIVITY_LOW, 30);

    /**
     * Returns the sensitivity in seconds.
     */
    public int sensitivityValueInSeconds() {
        return sensitivity;
    }

    private final int sensitivity;
    private SensitivityWatchEventModifier(ExtendedOptions.InternalOption<Integer> option,
                                          int sensitivity) {
        this.sensitivity = sensitivity;
        option.register(this, sensitivity);
    }
}
