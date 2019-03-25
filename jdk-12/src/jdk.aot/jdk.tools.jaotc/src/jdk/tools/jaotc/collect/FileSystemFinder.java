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



package jdk.tools.jaotc.collect;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * {@link FileVisitor} implementation to find class files recursively.
 */
public final class FileSystemFinder extends SimpleFileVisitor<Path> implements Iterable<Path> {
    private final ArrayList<Path> fileNames = new ArrayList<>();
    private final PathMatcher filter;

    public FileSystemFinder(Path combinedPath, PathMatcher filter) {
        this.filter = filter;
        try {
            Files.walkFileTree(combinedPath, this);
        } catch (IOException e) {
            throw new InternalError(e);
        }
    }

    /**
     * Compares the glob pattern against the file name.
     */
    private void find(Path file) {
        Path name = file.getFileName();
        if (name != null && filter.matches(name)) {
            fileNames.add(file);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        find(file);
        return CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE;
    }

    @Override
    public Iterator<Path> iterator() {
        return fileNames.iterator();
    }
}
