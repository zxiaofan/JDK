/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import sun.nio.fs.ExtendedOptions;

import java.nio.file.CopyOption;
import java.nio.file.OpenOption;
import java.nio.file.WatchEvent;

/**
 * Internal file system options for jdk.unsupported com.sun.nio.file API use.
 */
public final class FileSystemOption<T> {
    public static final FileSystemOption<Void> INTERRUPTIBLE =
        new FileSystemOption<>(ExtendedOptions.INTERRUPTIBLE);
    public static final FileSystemOption<Void> NOSHARE_READ =
        new FileSystemOption<>(ExtendedOptions.NOSHARE_READ);
    public static final FileSystemOption<Void> NOSHARE_WRITE =
        new FileSystemOption<>(ExtendedOptions.NOSHARE_WRITE);
    public static final FileSystemOption<Void> NOSHARE_DELETE =
        new FileSystemOption<>(ExtendedOptions.NOSHARE_DELETE);
    public static final FileSystemOption<Void> FILE_TREE =
        new FileSystemOption<>(ExtendedOptions.FILE_TREE);
    public static final FileSystemOption<Void> DIRECT =
        new FileSystemOption<>(ExtendedOptions.DIRECT);
    public static final FileSystemOption<Integer> SENSITIVITY_HIGH =
        new FileSystemOption<>(ExtendedOptions.SENSITIVITY_HIGH);
    public static final FileSystemOption<Integer> SENSITIVITY_MEDIUM =
        new FileSystemOption<>(ExtendedOptions.SENSITIVITY_MEDIUM);
    public static final FileSystemOption<Integer> SENSITIVITY_LOW =
        new FileSystemOption<>(ExtendedOptions.SENSITIVITY_LOW);

    private final ExtendedOptions.InternalOption<T> internalOption;
    private FileSystemOption(ExtendedOptions.InternalOption<T> option) {
        this.internalOption = option;
    }

    /**
     * Register this internal option as an OpenOption.
     */
    public void register(OpenOption option) {
        internalOption.register(option);
    }

    /**
     * Register this internal option as a CopyOption.
     */
    public void register(CopyOption option) {
        internalOption.register(option);
    }

    /**
     * Register this internal option as a WatchEvent.Modifier.
     */
    public void register(WatchEvent.Modifier option) {
        internalOption.register(option);
    }

    /**
     * Register this internal option as a WatchEvent.Modifier with the
     * given parameter.
     */
    public void register(WatchEvent.Modifier option, T param) {
        internalOption.register(option, param);
    }
}
