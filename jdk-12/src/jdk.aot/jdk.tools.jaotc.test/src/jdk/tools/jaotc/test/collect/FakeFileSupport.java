/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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


package jdk.tools.jaotc.test.collect;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import jdk.tools.jaotc.collect.FileSupport;

public class FakeFileSupport extends FileSupport {
    private final Set<String> exists = new HashSet<>();
    private final Set<String> directories = new HashSet<>();

    private final Set<String> checkedExists = new HashSet<>();
    private final Set<String> checkedDirectory = new HashSet<>();
    private final Set<String> checkedJarFileSystemRoots = new HashSet<>();
    private final Set<String> classloaderPaths = new HashSet<>();

    private Path jarFileSystemRoot = null;
    private final ClassLoader classLoader;

    public FakeFileSupport(Set<String> existing, Set<String> directories) {
        this.exists.addAll(existing);
        this.directories.addAll(directories);

        classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return null;
            }
        };
    }

    public void setJarFileSystemRoot(Path path) {
        jarFileSystemRoot = path;
    }

    @Override
    public boolean exists(Path path) {
        checkedExists.add(path.toString());
        return exists.contains(path.toString());
    }

    @Override
    public boolean isDirectory(Path path) {
        checkedDirectory.add(path.toString());
        return directories.contains(path.toString());
    }

    @Override
    public ClassLoader createClassLoader(Path path) throws MalformedURLException {
        classloaderPaths.add(path.toString());
        return classLoader;
    }

    @Override
    public Path getJarFileSystemRoot(Path jarFile) {
        checkedJarFileSystemRoots.add(jarFile.toString());
        return jarFileSystemRoot;
    }

    @Override
    public boolean isAbsolute(Path entry) {
        return entry.toString().startsWith("/");
    }

    public void addExist(String name) {
        exists.add(name);
    }

    public void addDirectory(String name) {
        directories.add(name);
    }

    public Set<String> getCheckedExists() {
        return checkedExists;
    }

    public Set<String> getCheckedDirectory() {
        return checkedDirectory;
    }

    public Set<String> getCheckedJarFileSystemRoots() {
        return checkedJarFileSystemRoots;
    }

    public Set<String> getClassloaderPaths() {
        return classloaderPaths;
    }
}
