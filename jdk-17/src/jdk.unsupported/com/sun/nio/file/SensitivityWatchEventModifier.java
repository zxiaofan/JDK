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
 * Defines the <em>sensitivity levels</em> when registering objects with a
 * watch service implementation that polls the file system.
 *
 * @since 1.7
 */

public enum SensitivityWatchEventModifier implements Modifier {
    /**
     * High sensitivity.
     */
    HIGH(FileSystemOption.SENSITIVITY_HIGH, 2),
    /**
     * Medium sensitivity.
     */
    MEDIUM(FileSystemOption.SENSITIVITY_MEDIUM, 10),
    /**
     * Low sensitivity.
     */
    LOW(FileSystemOption.SENSITIVITY_LOW, 30);

    /**
     * Returns the sensitivity in seconds.
     */
    public int sensitivityValueInSeconds() {
        return sensitivity;
    }

    private final int sensitivity;
    private SensitivityWatchEventModifier(FileSystemOption<Integer> option,
                                          int sensitivity) {
        this.sensitivity = sensitivity;
        option.register(this, sensitivity);
    }
}
