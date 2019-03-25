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

import jdk.tools.jaotc.collect.SearchPath;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import static jdk.tools.jaotc.test.collect.Utils.set;

public class FakeSearchPath extends SearchPath {
    private Path path = null;
    public Set<String> entries = set();

    public FakeSearchPath(String name) {
        if (name != null) {
            path = Paths.get(name);
        }
    }

    @Override
    public Path find(FileSystem fileSystem, Path entry, String... defaults) {
        entries.add(entry.toString());
        return path;
    }
}
