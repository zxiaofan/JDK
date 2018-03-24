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

package jdk.tools.jaotc.collect;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchPath {
    private final List<Path> searchPaths = new ArrayList<>();
    private final FileSupport fileSupport;

    public SearchPath() {
        this(new FileSupport());
    }

    public SearchPath(FileSupport fileSupport) {
        this.fileSupport = fileSupport;
    }

    public Path find(FileSystem fileSystem, Path entry, String... defaults) {
        if (isAbsolute(entry)) {
            if (exists(entry)) {
                return entry;
            }
            return null;
        }

        if (exists(entry)) {
            return entry;
        }

        for (String searchPath : defaults) {
            Path newPath = fileSystem.getPath(searchPath, entry.toString());
            if (exists(newPath)) {
                return newPath;
            }
        }

        for (Path searchPath : searchPaths) {
            Path newPath = fileSystem.getPath(searchPath.toString(), entry.toString());
            if (exists(newPath)) {
                return newPath;
            }
        }

        return null;
    }

    private boolean isAbsolute(Path entry) {
        return fileSupport.isAbsolute(entry);
    }

    private boolean exists(Path entry) {
        return fileSupport.exists(entry);
    }

    public void add(String... paths) {
        for (String name : paths) {
            Path path = Paths.get(name);
            searchPaths.add(path);
        }
    }
}
