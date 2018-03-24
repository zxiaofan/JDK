/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.collect.module;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.FileSupport;
import jdk.tools.jaotc.collect.SearchPath;
import jdk.tools.jaotc.collect.SourceProvider;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public final class ModuleSourceProvider implements SourceProvider {
    private final FileSystem fileSystem;
    private final ClassLoader classLoader;
    private final FileSupport fileSupport;
    public final static String TYPE = "module";

    public ModuleSourceProvider() {
        this(FileSystems.getFileSystem(URI.create("jrt:/")), ClassLoader.getSystemClassLoader(), new FileSupport());
    }

    public ModuleSourceProvider(FileSystem fileSystem, ClassLoader classLoader, FileSupport fileSupport) {
        this.fileSystem = fileSystem;
        this.classLoader = classLoader;
        this.fileSupport = fileSupport;
    }

    @Override
    public ClassSource findSource(String name, SearchPath searchPath) {
        Path path = fileSystem.getPath(name);
        Path dir = fileSystem.getPath("modules");

        if (dir == null || !fileSupport.isDirectory(dir)) {
            return null;
        }

        Path found = findModuleDirectory(dir, path);

        if (found == null) {
            return null;
        }

        return new ModuleSource(found, classLoader);
    }

    private Path findModuleDirectory(Path root, Path path) {
        try {
            return fileSupport.getSubDirectory(fileSystem, root, path);
        } catch (IOException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public boolean supports(String type) {
        return TYPE.equals(type);
    }
}
