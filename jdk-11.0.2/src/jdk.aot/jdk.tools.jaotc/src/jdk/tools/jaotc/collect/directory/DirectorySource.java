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
import jdk.tools.jaotc.collect.FileSystemFinder;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public final class DirectorySource implements ClassSource {
    private final Path directoryPath;
    private final ClassLoader classLoader;

    DirectorySource(Path directoryPath, ClassLoader classLoader) {
        this.directoryPath = directoryPath;
        this.classLoader = classLoader;
    }

    @Override
    public void eachClass(BiConsumer<String, ClassLoader> consumer) {
        FileSystemFinder finder = new FileSystemFinder(directoryPath, ClassSource::pathIsClassFile);

        for (Path path : finder) {
            consumer.accept(ClassSource.makeClassName(directoryPath.relativize(path).normalize()), classLoader);
        }
    }

    @Override
    public String toString() {
        return "directory:" + directoryPath.toString();
    }
}
