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

package jdk.tools.jaotc.collect.jar;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.FileSupport;
import jdk.tools.jaotc.collect.SearchPath;
import jdk.tools.jaotc.collect.SourceProvider;

import java.net.MalformedURLException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.ProviderNotFoundException;

public final class JarSourceProvider implements SourceProvider {
    private final FileSystem fileSystem;
    private final FileSupport fileSupport;
    public final static String TYPE = "jar";

    public JarSourceProvider() {
        this(new FileSupport());
    }

    public JarSourceProvider(FileSupport fileSupport) {
        this.fileSupport = fileSupport;
        fileSystem = FileSystems.getDefault();
    }

    @Override
    public ClassSource findSource(String name, SearchPath searchPath) {
        Path fileName = fileSystem.getPath(name);
        Path jarFile = searchPath.find(fileSystem, fileName);

        if (!validPath(jarFile)) {
            return null;
        }

        return createSource(jarFile);
    }

    private ClassSource createSource(Path jarFile) {
        try {
            Path jarRootPath = fileSupport.getJarFileSystemRoot(jarFile);
            if (jarRootPath == null) {
                return null;
            }
            ClassLoader classLoader = fileSupport.createClassLoader(jarFile);
            return new JarFileSource(jarFile, jarRootPath, classLoader);
        } catch (ProviderNotFoundException | MalformedURLException e) {
        }
        return null;
    }

    @Override
    public boolean supports(String type) {
        return TYPE.equals(type);
    }

    private boolean validPath(Path jarFile) {
        return jarFile != null && !fileSupport.isDirectory(jarFile);
    }
}
