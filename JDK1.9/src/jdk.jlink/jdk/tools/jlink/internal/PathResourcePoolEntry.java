/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jlink.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * A ResourcePoolEntry backed by a given nio Path.
 */
public class PathResourcePoolEntry extends AbstractResourcePoolEntry {
    private final Path file;

    /**
     * Create a new PathResourcePoolEntry.
     *
     * @param module The module name.
     * @param path The path for the resource content.
     * @param type The data type.
     * @param file The data file identifier.
     */
    public PathResourcePoolEntry(String module, String path, Type type, Path file) {
        super(module, path, type);
        this.file = Objects.requireNonNull(file);
        if (!Files.isRegularFile(file)) {
            throw new IllegalArgumentException(file + " not a file");
        }
    }

    @Override
    public final InputStream content() {
        try {
            return Files.newInputStream(file);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public final long contentLength() {
        try {
            return Files.size(file);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
