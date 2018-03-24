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

package jdk.tools.jaotc.collect.directory;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.FileSupport;
import jdk.tools.jaotc.collect.SearchPath;
import jdk.tools.jaotc.collect.SourceProvider;

import java.net.MalformedURLException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public final class DirectorySourceProvider implements SourceProvider {
    private final FileSupport fileSupport;
    private final FileSystem fileSystem;
    public final static String TYPE = "directory";

    public DirectorySourceProvider(FileSupport fileSupport) {
        this.fileSupport = fileSupport;
        fileSystem = FileSystems.getDefault();
    }

    @Override
    public ClassSource findSource(String name, SearchPath searchPath) {
        Path directoryPath = fileSystem.getPath(name);

        if (!fileSupport.exists(directoryPath)) {
            return null;
        }
        if (!fileSupport.isDirectory(directoryPath)) {
            return null;
        }

        try {
            ClassLoader classLoader = fileSupport.createClassLoader(directoryPath);
            return new DirectorySource(directoryPath, classLoader);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override
    public boolean supports(String type) {
        return TYPE.equals(type);
    }
}
